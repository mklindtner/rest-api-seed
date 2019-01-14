package com.mkl.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkl.logic.producerConsumer.fetchDataMultiThread.FetchResults;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ArrayBlockingQueue;

@Path("webdata")
public class DataFromWeb
{
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@GET
	@Path("swapi/{idStart}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDataFromSwap(@PathParam("idStart") int idStart) throws InterruptedException
	{
		ArrayBlockingQueue<String> inputList  = new ArrayBlockingQueue<>(5);
		ArrayBlockingQueue<String> outputList = new ArrayBlockingQueue<>(5);

		inputList.add("https://swapi.co/api/people/" + idStart);
		inputList.add("https://swapi.co/api/planets/" + idStart);
		inputList.add("https://swapi.co/api/species/" + idStart);
		inputList.add("https://swapi.co/api/vehicles/" + idStart);

		FetchResults fetchResults = new FetchResults();
		StringBuffer sb = fetchResults.getResultsFromBlockingQueue(inputList, outputList);

		return sb.toString();
	}
}
