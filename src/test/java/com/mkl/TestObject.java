package com.mkl;

import org.junit.Before;

import javax.persistence.EntityManagerFactory;

public class TestObject
{
	private EntityManagerFactory emf;
	@Before public void initialize() {


	}

	//add item to param
	private void persistenItem() {
		this.emf = TestJPAConnector.getEntityManagerFactory();
	}

}
