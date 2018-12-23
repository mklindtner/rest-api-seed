package com.mkl.rest.exceptions.mapperExceptions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkl.rest.exceptions.ExceptionResponse;
import com.mkl.rest.exceptions.specificResponseExceptions.TestException;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.HashMap;
import java.util.Map;

public class TestExceptionMapper implements ExceptionMapper<TestException>
{
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private static Map<Class, Integer> errorCodes = new HashMap<>();

	static {
		errorCodes.put(TestException.class, 408);
	}


	@Context
	private ServletContext context;

	/**
	 * Map an exception to a {@link Response}. Returning
	 * {@code null} results in a {@link Response.Status#NO_CONTENT}
	 * response. Throwing a runtime exception results in a
	 * {@link Response.Status#INTERNAL_SERVER_ERROR} response.
	 *
	 * @param exception the exception to map to a response.
	 * @return a response mapped from the supplied exception.
	 */
	@Override public Response toResponse(TestException exception)
	{
		boolean           isDebug           = true;
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.errorName = exception.getClass().getSimpleName();
		exceptionResponse.message = "TestException executing";
		exceptionResponse.debug = isDebug;
		exceptionResponse.responseCode = errorCodes.getOrDefault(exception.getClass(), 500);
		if (isDebug) {
			exceptionResponse.cause = exception;
		}

		return Response.status(exceptionResponse.responseCode).entity(gson.toJson(exceptionResponse)).build();
	}
}
