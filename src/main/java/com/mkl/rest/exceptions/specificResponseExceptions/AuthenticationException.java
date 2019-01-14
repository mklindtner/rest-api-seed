package com.mkl.rest.exceptions.specificResponseExceptions;

public class AuthenticationException extends Exception
{
	public AuthenticationException(String message)
	{
		super(message);
	}

	public AuthenticationException()
	{
		super("Unable to authenthicate");
	}
}
