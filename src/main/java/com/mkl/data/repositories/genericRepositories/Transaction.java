package com.mkl.data.repositories.genericRepositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Transaction implements AutoCloseable
{
	private EntityManager     em;
	private EntityTransaction entityTransaction;


	public Transaction(EntityManager em)
	{
		this.em = em;
		entityTransaction = em.getTransaction();
	}


	public Transaction(EntityManagerFactory emf)
	{
		this(emf.createEntityManager());
	}

	public EntityManager getEntityManager()
	{
		return em;
	}

	public void begin()
	{
		if (!entityTransaction.isActive() && em.isOpen())
			entityTransaction.begin();
	}

	public void commit()
	{
		if (entityTransaction.isActive())
			entityTransaction.commit();
	}

	public void rollback()
	{
		if (entityTransaction.isActive())
			entityTransaction.rollback();
	}

	@Override public void close() throws Exception
	{
		em.close();
	}
}
