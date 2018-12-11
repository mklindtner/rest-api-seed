package com.mkl.data.repositories;

import com.mkl.data.repositories.genericRepositories.Transaction;

import javax.persistence.EntityManagerFactory;

public class TransactionRepositories
{
	private Transaction transaction;

	public TransactionRepositories(EntityManagerFactory emf) {
		transaction = new Transaction(emf);
	}


	/* multiple repos needs to be used in a single transaction
	public void saveAnyObjectAndOneObject(String name, String name2) throws Exception
	{
		AnyObject anyObject = new AnyObject(name);
		Transaction transaction = new Transaction(emf);
		//OneObject oneObject = new OneObject(name2);
		try(transaction) {
			transaction.begin();
			transaction.getEntityManager().persist(anyObject);
			//transaction.getEntityManager().persist(oneObject);
		} catch (Exception e) {
			transaction.rollback();
		}
	} */
}
