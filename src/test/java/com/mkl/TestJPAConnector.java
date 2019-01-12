package com.mkl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPAConnector
{
	private static EntityManagerFactory emf;
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("rest-api-test-pu");
		return emf;
	}
}
