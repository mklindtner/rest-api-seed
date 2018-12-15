package com.mkl.data.repositories;

import com.mkl.data.entities.AnyObject;
import com.mkl.data.repositories.genericRepositories.BaseRepository;
import org.omg.CORBA.Any;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManagerFactory;

public class AnyObjectRepository
{
	private EntityManagerFactory               emf;
	private BaseRepository<AnyObject, Integer> repo;

	public AnyObjectRepository(EntityManagerFactory emf)
	{
		this.emf = emf;
		this.repo = new BaseRepository<>(AnyObject.class, emf);
	}

	public AnyObject createAnyObject(String name)
	{
		return repo.post(new AnyObject(name));
	}

	public AnyObject getAnyObject(int id)
	{
		return repo.getEntity(id);
	}

	public Set<AnyObject> getAllAnyObject()
	{
		return repo.get();
	}

	public AnyObject updateAnyObject(AnyObject anyObject)
	{
		return repo.put(anyObject);
	}

	public AnyObject deleteAnyObject(int id) {
		return repo.delete(id);
	}


}
