package com.mkl.logic.facades;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mkl.data.entities.User;
import com.mkl.rest.exceptions.specificResponseExceptions.AuthenticationException;
import com.mkl.rest.security.SharedSecret;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Date;

public class UserFacade
{
	private EntityManagerFactory emf;

	public UserFacade(EntityManagerFactory emf)
	{
		this.emf = emf;
	}

	public void setEntityManagerFactory(EntityManagerFactory emf)
	{
		this.emf = emf;
	}


	public String authLogin(String username, String password, int TOKEN_EXPIRE_TIME) throws AuthenticationException, JOSEException
	{
		User       user         = getVeryfiedUser(username, password);
		String     token        = createToken(username, user.getRolesAsStrings(), TOKEN_EXPIRE_TIME);
		return token;
	}

	private String createToken(String userName, List<String> roles, int TOKEN_EXPIRE_TIME) throws JOSEException
	{
		StringBuilder res = new StringBuilder();
		for (String string : roles) {
			res.append(string);
			res.append(",");
		}
		String rolesAsString = res.length() > 0 ? res.substring(0, res.length() - 1) : "";
		String issuer = "semesterdemo_security_course";

		JWSSigner signer = new MACSigner(SharedSecret.getSharedKey());
		Date      date   = new Date();
		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				.subject(userName)
				.claim("username", userName)
				.claim("roles", rolesAsString)
				.claim("issuer", issuer)
				.issueTime(date)
				.expirationTime(new Date(date.getTime() + TOKEN_EXPIRE_TIME))
				.build();
		SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
		signedJWT.sign(signer);
		return signedJWT.serialize();

	}

	public User getVeryfiedUser(String username, String password) throws AuthenticationException
	{
		EntityManager em = emf.createEntityManager();
		User          user;
		try {
			user = em.find(User.class, username);
			if (user == null || !user.verifyPassword(password)) {
				throw new AuthenticationException("Invalid user name or password");
			}
		} finally {
			em.close();
		}
		return user;
	}
}
