package com.mkl;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TestObject
{
	private EntityManagerFactory emf;
	@Before public void initialize() {
		persistItem();
	}

	//add item to param
	private void persistItem() {
		this.emf = TestJPAConnector.getEntityManagerFactory();
	}

	@Test
	public void checkInitialize() {
		EntityManager em = emf.createEntityManager();
	}

}
