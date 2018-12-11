package com.mkl.data.repositories.genericRepositories;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//idea: extends Transaction and uses getEntityManager instead of new entityManager for each crud operation
public class BaseRepository<E, PK> implements CRUDOperations<E, PK>
{

	private   Class<E>             entityClass;
	protected EntityManagerFactory emf;

	public BaseRepository(Class<E> entity, EntityManagerFactory emf)
	{
		entityClass = entity;
		this.emf = emf;
	}

	//untested
	/*
	public List<E> searchByItem(String field, Object value)
	{
		beginEntityManager();
		TypedQuery query = em.createQuery(String.format("SELECT e FROM `%s` WHERE `%s`=:value", entityClass.getSimpleName(), field), entityClass);
		query.setParameter("value", value);
		List<E> results = query.getResultList();
		return results;
	} */

	@Override public Set<E> get()
	{
		EntityManager em      = emf.createEntityManager();
		List<E>       results = null;
		try {
			results = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
						.getResultList();
		} finally {
			em.close();
			return new HashSet<E>(results);
		}
	}

	@Override public E getEntity(PK primaryKey)
	{
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(entityClass, primaryKey);
		} finally {
			em.close();
		}
	}

	@Override public E put(E entity)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		if (em.contains(entity))
			return entity;
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
		return entity;
		//return em.contains(entity) ? entity : em.merge(entity); //unsure if htis works
	}

	@Override public E delete(PK primaryKey)
	{
		EntityManager em     = emf.createEntityManager();
		E             entity = em.find(entityClass, primaryKey);
		if (entity == null) {
			return null;
		}
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
			return entity;
		}
	}

	@Override public E post(E entity)
	{
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
			return entity;
		}
	}
}
