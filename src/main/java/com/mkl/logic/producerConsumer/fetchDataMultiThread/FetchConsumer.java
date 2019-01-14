package com.mkl.logic.producerConsumer.fetchDataMultiThread;

import com.mkl.logic.producerConsumer.Consumer;

import java.util.concurrent.ArrayBlockingQueue;

public class FetchConsumer extends Consumer<String>
{
	public StringBuffer jsonResult;

	public FetchConsumer(ArrayBlockingQueue<String> arrayBlockingQueue, StringBuffer jsonResult)
	{
		super(arrayBlockingQueue);
		this.jsonResult = jsonResult;
	}

	@Override public void task(String json)
	{
		if (json != null) {
			if(jsonResult.length() != 1) //NOT FIRST
				jsonResult.append(",");
			jsonResult.append(json);
			jsonResult.append("\n");
		}
	}
}

