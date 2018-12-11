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

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


//@Path("anyObject") I HAVE NO IDEA WHY THIS WORKS
public class AnyObjectResource
{
	private static Gson            gson            = new GsonBuilder().setPrettyPrinting().create();
	private        BaseRest<AnyObject, AnyObjectDTO> baseRest        = new BaseRest<AnyObject, AnyObjectDTO>(AnyObject.class, new AnyObjectDTO());
	private        AnyObjectFacade anyObjectFacade = new AnyObjectFacade(JPAConnection.getEntityManagerFactory());

	@GET
	@Produces(APPLICATION_JSON)
	public Response getAnyObjects()
	{
		return Response.ok(gson.toJson(new String("hi"))).build();
	}

	@POST
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public Response createAnyObject(String content)
	{
		return baseRest.post(content);
		/*
		AnyObject anyObject = gson.fromJson(content, AnyObject.class);
		AnyObject anyObjectCreated = anyObjectFacade.createAnyObject(anyObject);
		return Response.ok(gson.toJson(AnyObjectDTO.basic(anyObjectCreated))).build(); */
	}


}
