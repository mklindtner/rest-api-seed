package com.mkl.rest.security;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mkl.data.JPAConnection;
import com.mkl.data.entities.User;
import com.mkl.logic.facades.UserFacade;
import com.mkl.rest.exceptions.GeneralExceptionMapper;
import com.mkl.rest.exceptions.specificResponseExceptions.AuthenticationException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

@Path("login")
public class LoginEndpoint
{

	public static final int        TOKEN_EXPIRE_TIME = 1000 * 60 * 30; //30 min
	private             UserFacade userFacade        = new UserFacade(JPAConnection.getEntityManagerFactory());


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(String jsonString) throws AuthenticationException
	{
		JsonObject json     = new JsonParser().parse(jsonString).getAsJsonObject();
		String     username = json.get("username").getAsString();
		String     password = json.get("password").getAsString();
		try {
			String     token        = userFacade.authLogin(username, password, TOKEN_EXPIRE_TIME);
			JsonObject responseJson = new JsonObject();
			responseJson.addProperty("username", username);
			responseJson.addProperty("token", token);
			return Response.ok(new Gson().toJson(responseJson)).build();
		} catch (Exception ex) {
			if (ex instanceof javax.naming.AuthenticationException) {
				throw (AuthenticationException) ex;
			}
			Logger.getLogger(GeneralExceptionMapper.class.getName()).log(Level.SEVERE, null, ex);
		}
		throw new AuthenticationException("Invalid username or password! Please try again");
	}


}
