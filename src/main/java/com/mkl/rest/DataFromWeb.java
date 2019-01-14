package com.mkl.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkl.logic.producerConsumer.fetchDataMultiThread.FetchResults;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;

@Path("webdata")
public class DataFromWeb
{
	private final Gson         gson         = new GsonBuilder().setPrettyPrinting().create();
	private       FetchResults fetchResults = new FetchResults();

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

		StringBuffer sb = fetchResults.getResultsFromBlockingQueue(inputList, outputList);

		return sb.toString();
	}

	//unnecessary to use producer/consumer but easier than implement
	@GET
	@Path("swapi/{pageNumber}/{type}")
	@Produces
	public String getInfoFromPagination(
			@PathParam("pageNumber") int pageNumber,
			@PathParam("type") String type) throws InterruptedException
	{
		ArrayBlockingQueue<String> inputList  = new ArrayBlockingQueue<>(5);
		ArrayBlockingQueue<String> outputList = new ArrayBlockingQueue<>(5);

		inputList.add("https://swapi.co/api/" + type + "/" + pageNumber);
		return fetchResults.getResult(inputList, outputList).toString();
	}
}
