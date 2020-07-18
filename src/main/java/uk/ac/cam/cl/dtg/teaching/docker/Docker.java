package uk.ac.cam.cl.dtg.teaching.docker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;
import uk.ac.cam.cl.dtg.teaching.docker.api.DockerApi;
import uk.ac.cam.cl.dtg.teaching.docker.api.DockerRestApi;
import uk.ac.cam.cl.dtg.teaching.docker.api.DockerWsApi;
import uk.ac.cam.cl.dtg.teaching.docker.api.DockerWsApiImpl;

/** Provides access to the Docker API. */
public class Docker {

  private ResteasyWebTarget webTarget;

  private DockerWsApiImpl wsApiImpl;

  /** Construct a new instance which attempts to connect to the given host and port. */
  public Docker(String hostname, int port, int maxConnections) {
    PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
    cm.setDefaultMaxPerRoute(maxConnections);
    cm.setMaxTotal(maxConnections);
    HttpClient httpClient = new DefaultHttpClient(cm);
    ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);
    ExecutorService executorService = Executors.newCachedThreadPool();
    ResteasyClient c =
        new ResteasyClientBuilder().httpEngine(engine).asyncExecutor(executorService).build();
    webTarget = c.target("http://" + hostname + ":" + port + "/v1.21");
    wsApiImpl = new DockerWsApiImpl(hostname, port);
  }

  /**
   * Create an instance of the API object using the provided listener for performance monitoring.
   */
  public DockerApi api(final ApiListener listener) {
    final DockerRestApi dockerProxy = webTarget.proxy(DockerRestApi.class);
    DockerApi proxy =
        (DockerApi)
            Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class<?>[] {DockerApi.class},
                new InvocationHandler() {
                  @Override
                  public Object invoke(Object proxy, Method method, Object[] args)
                      throws Throwable {
                    long startTime = System.currentTimeMillis();
                    boolean apiOk = true;
                    try {
                      if (method.getDeclaringClass() == DockerWsApi.class) {
                        return method.invoke(wsApiImpl, args);
                      } else {
                        return method.invoke(dockerProxy, args);
                      }
                    } catch (InvocationTargetException f) {
                      Throwable t = f.getCause();
                      if (t instanceof WebApplicationException) {
                        WebApplicationException e = (WebApplicationException) t;
                        String v = e.getResponse().readEntity(String.class);
                        throw new RuntimeException(v);
                      }
                      if (t instanceof ProcessingException) {
                        if (t.getCause() instanceof SocketException) {
                          apiOk = false;
                          throw new ApiUnavailableException(
                              "Unable to connect to the Docker API", t.getCause());
                        }
                      }
                      throw t;
                    } finally {
                      long duration = System.currentTimeMillis() - startTime;
                      listener.callCompleted(apiOk, duration, method.getName());
                    }
                  }
                });
    return proxy;
  }
}
