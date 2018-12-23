package com.mkl.rest.exceptions.specificResponseExceptions;


public class TestException extends Exception
{
	private String errorMessage, errorName;


	public TestException(String errorMessage, String errorName)
	{
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorName = errorName;
	}

	public TestException(Throwable throwable, String errorMessage, String errorName) {
		super(throwable);
		this.errorMessage = errorMessage;
		this.errorName = errorName;
	}

	public String getErrorMessage()
	{
		return this.errorMessage;
	}

	public String getErrorName()
	{
		return this.errorName;
	}
}
