package com.mkl.logic.facades;

import com.mkl.data.entities.AnyObject;
import com.mkl.data.repositories.AnyObjectRepository;

import javax.persistence.EntityManagerFactory;
import java.util.Set;

public class AnyObjectFacade implements Facade<AnyObject>
{
	private AnyObjectRepository anyObjectRepository;

	public AnyObjectFacade(EntityManagerFactory emf)
	{
		anyObjectRepository = new AnyObjectRepository(emf);
	}

	public AnyObject createAnyObject(AnyObject anyObject) {
		return anyObjectRepository.createAnyObject(anyObject.getNameString());
	}

	@Override public Set<AnyObject> get()
	{
		return anyObjectRepository.getAllAnyObject();
	}

	@Override public AnyObject get(int id)
	{
		return anyObjectRepository.getAnyObject(id);
	}

	@Override public AnyObject put(AnyObject anyObject)
	{
		return anyObjectRepository.updateAnyObject(anyObject);
	}

	@Override public AnyObject post(AnyObject object)
	{
		return anyObjectRepository.createAnyObject(object.getNameString());
	}

	@Override public AnyObject delete(int id)
	{
		return anyObjectRepository.deleteAnyObject(id);
	}

/*
	public AnyObject getAnyObject(int id) {
		return anyObjectRepository.getAnyObject(id);
	}

	public Set<AnyObject> getAllAnyObject() {
		return anyObjectRepository.getAllAnyObject();
	} */
}
