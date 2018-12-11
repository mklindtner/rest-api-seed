package com.mkl.logic.facades;

import com.mkl.data.entities.AnyObject;
import com.mkl.data.repositories.AnyObjectRepository;

import javax.persistence.EntityManagerFactory;

public class AnyObjectFacade
{
	private AnyObjectRepository anyObjectRepository;

	public AnyObjectFacade(EntityManagerFactory emf)
	{
		anyObjectRepository = new AnyObjectRepository(emf);
	}

	public AnyObject createAnyObject(AnyObject anyObject) {
		return anyObjectRepository.createAnyObject(anyObject.getNameString());
	}

	public AnyObject getAnyObject(int id) {
		return anyObjectRepository.getAnyObject(id);
	}

	//both repo all here
}
