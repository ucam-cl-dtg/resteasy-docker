package uk.ac.cam.cl.dtg.teaching.docker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.SocketException;
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
import uk.ac.cam.cl.dtg.teaching.docker.api.DockerWsApiImpl;

public class Docker {

  private ResteasyWebTarget webTarget;

  private DockerWsApiImpl wsApiImpl;

  public Docker(String hostname, int port, int maxConnections) {
    PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
    cm.setDefaultMaxPerRoute(maxConnections);
    cm.setMaxTotal(maxConnections);
    HttpClient httpClient = new DefaultHttpClient(cm);
    ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);
    ResteasyClient c =
        new ResteasyClientBuilder().maxPooledPerRoute(maxConnections).httpEngine(engine).build();
    webTarget = c.target("http://" + hostname + ":" + port + "/v1.21");
    wsApiImpl = new DockerWsApiImpl(hostname, port);
  }

  public DockerApi api(final APIListener listener) {
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
                    boolean apiOK = true;
                    String methodName = method.getName();
                    try {
                      if (methodName.equals("attach") || methodName.equals("close")) {
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
                          apiOK = false;
                          throw new APIUnavailableException(
                              "Unable to connect to the Docker API", t.getCause());
                        }
                      }
                      throw t;
                    } finally {
                      long duration = System.currentTimeMillis() - startTime;
                      listener.callCompleted(apiOK, duration, methodName);
                    }
                  }
                });
    return proxy;
  }
}
