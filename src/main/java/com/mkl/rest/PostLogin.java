package com.mkl.rest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

@Path("info")
public class PostLogin
{
	@Context
	private UriInfo context;

	@Context
	SecurityContext securityContext;

	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public String test() {
		return "endpoint wokrs";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("user")
	@RolesAllowed("user")
	public String getFromUser(){
		String user = securityContext.getUserPrincipal().getName();
		return "\"This message if from the server (requires the user role): Hello from USER: "+ user+"\"";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("admin")
	@RolesAllowed("admin")
	public String getFromAdmin() {
		String admin = securityContext.getUserPrincipal().getName();
		return "\"This message if from the server (requires the admin role):Hello from ADMIN"+ admin+"\"";
	}

	/*
	a.if i wanted to hashPasswords with bCrypt this works
	b. uncomment hashPassword and verifyPassword bcrypt

	 @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(String json) throws Exception {
        User user = gson.fromJson(json, User.class);
        user.addRole(new Role("user"));
        user.hashPassword();

        UserDTO userDTO = um.create(user);

        if (userDTO == null) {
            throw new Exception();

        }

        String userJSON = gson.toJson(userDTO, UserDTO.class);

        return Response.status(Response.Status.CREATED).entity(userJSON).build();

    }
	 */
}
