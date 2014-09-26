package uk.ac.cam.cl.dtg.teaching.docker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.ws.rs.WebApplicationException;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;

import uk.ac.cam.cl.dtg.teaching.docker.api.DockerApi;

public class Docker {

	private static final int MAX_CONNECTIONS = 10;
	private ResteasyWebTarget webTarget;

	public Docker(String hostname, int port) {
		PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
		cm.setDefaultMaxPerRoute(MAX_CONNECTIONS);
		cm.setMaxTotal(MAX_CONNECTIONS);
		HttpClient httpClient = new DefaultHttpClient(cm);
		ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);
		ResteasyClient c = new ResteasyClientBuilder()
				.maxPooledPerRoute(MAX_CONNECTIONS).httpEngine(engine).build();
		webTarget = c.target("http://" + hostname + ":" + port + "/v1.10");
	}

	public DockerApi api() {
		final DockerApi dockerProxy = webTarget.proxy(DockerApi.class);
		return (DockerApi) Proxy.newProxyInstance(this.getClass()
				.getClassLoader(), new Class<?>[] { DockerApi.class },
				new InvocationHandler() {
					@SuppressWarnings("unused")
					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						try {
							long time = 0;
							if (false) {
								StringBuffer call = new StringBuffer(method.getName()+"(");
								for(Object o : args) {
									call.append(o+",");
								}
								call.append(")");
								time = System.nanoTime();
								System.err.println(time+"\t"+call); }
							Object r = method.invoke(dockerProxy, args);
							if (false) {
								System.err.println(time+"\t"+r);
							}
							return r;
							
						} catch (InvocationTargetException f) {
							Throwable t = f.getCause();
							if (t instanceof WebApplicationException) {
								WebApplicationException e = (WebApplicationException) t;
								String v = e.getResponse().readEntity(
										String.class);
								throw new RuntimeException(v);
							}
							throw t;
						}
					}
				});
	}

}
