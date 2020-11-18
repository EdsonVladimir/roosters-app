package util.core.api;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;


//Register at JAX-RS Client:  client.register(ClientFilter.class);
public class ClientFilter implements ClientRequestFilter  {


	public void filter(ClientRequestContext clientRequestContext) throws IOException {
		clientRequestContext.getHeaders().add("x-a360-client", "Asterisk360 EE");
		clientRequestContext.getHeaders().add("x-a360-email", "root@asterisk360.com");
		clientRequestContext.getHeaders().add("x-a360-apikey", "P21AMZKM9X8");
		clientRequestContext.getHeaders().add("content-type", "application/json");
		clientRequestContext.getHeaders().add("accept-encoding", "gzip");
		System.out.println("JAX-RS ClientRequestFilter: Headers:" + clientRequestContext.getHeaders());
		
		System.out.println("xxx");
		
		System.err.println();
		
	}


	
}






