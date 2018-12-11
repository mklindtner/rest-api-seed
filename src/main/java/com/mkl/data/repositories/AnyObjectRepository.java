package com.mkl.data.repositories;

import com.mkl.data.entities.AnyObject;
import com.mkl.data.repositories.genericRepositories.BaseRepository;

import javax.persistence.EntityManagerFactory;

public class AnyObjectRepository
{
	private EntityManagerFactory emf;
	private BaseRepository<AnyObject, Integer> repo;

	public AnyObjectRepository(EntityManagerFactory emf) {
		this.emf = emf;
		this.repo = new BaseRepository<>(AnyObject.class, emf);
	}

	public AnyObject createAnyObject(String name) {
		return repo.post(new AnyObject(name));
	}

	public AnyObject getAnyObject(int id) {
		return repo.getEntity(id);
	}


}
