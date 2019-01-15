package com.mkl.rest.cors;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class CORSResponseFilter implements ContainerResponseFilter
{
	/**
	 * Filter method called after a response has been provided for a request
	 * (either by a {@link ContainerRequestFilter request filter} or by a
	 * matched resource method.
	 * <p>
	 * Filters in the filter chain are ordered according to their {@code javax.annotation.Priority}
	 * class-level annotation value.
	 * </p>
	 *
	 * @param requestContext  request context.
	 * @param responseContext response context.
	 * @throws IOException if an I/O exception occurs.
	 */
	@Override public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException
	{
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*" );
		responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true" );
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
		responseContext.getHeaders().add("Access-Control-Allow-Headers", "Origin, Accept, Content-Type, " +
																		 "Authorization, x-access-token");
	}
}
