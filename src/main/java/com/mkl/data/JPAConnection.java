package com.mkl.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnection
{
	private static EntityManagerFactory emf;
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("rest-api-pu");
		return emf;
	}
}
