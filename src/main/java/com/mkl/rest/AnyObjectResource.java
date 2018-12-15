package com.mkl.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkl.data.JPAConnection;
import com.mkl.data.entities.AnyObject;
import com.mkl.logic.facades.AnyObjectFacade;
import com.mkl.rest.dto.AnyObjectDTO;
import com.mkl.rest.genericRest.BaseRest;

//import javax.ws.rs.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Path("anyObject2")
public class AnyObjectResource
{
	private static Gson                              gson     = new GsonBuilder().setPrettyPrinting().create();
	private        BaseRest<AnyObject, AnyObjectDTO> baseRest =
			new BaseRest<AnyObject, AnyObjectDTO>(
					AnyObject.class,
					new AnyObjectDTO(),
					new AnyObjectFacade(JPAConnection.getEntityManagerFactory())
			);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnyObjects()
	{
		return baseRest.get();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAnyObject(String content)
	{
		return baseRest.post(content);
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response anyObjectById(@PathParam("id") int id)
	{
		return baseRest.getByPK(id);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response deleteAnyObjectById(@PathParam("id") int id)
	{
		return baseRest.delete(id);
	}





	/* normal way:
		AnyObject anyObject = gson.fromJson(content, AnyObject.class);
		AnyObject anyObjectCreated = anyObjectFacade.createAnyObject(anyObject);
		return Response.ok(gson.toJson(AnyObjectDTO.basic(anyObjectCreated))).build(); */

}
