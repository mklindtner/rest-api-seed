package com.mkl;

import com.mkl.data.entities.AnyObject;
import com.mkl.logic.facades.AnyObjectFacade;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Set;

import static org.junit.Assert.*;

public class AnyObjectResourceTest
{
    private EntityManagerFactory emf;
    private AnyObjectFacade anyObjectFacade;
    private Set<AnyObject> anyObjects;

    @Before public void initialize()
    {
        this.emf = TestJPAConnector.getEntityManagerFactory();
        this.anyObjectFacade = new AnyObjectFacade(TestJPAConnector.getEntityManagerFactory());
        persistItem();
    }

    	/*
    	    1) create first object
    	    2) Crete List
    	    3) Set Relationships
    	    4) persist lists of objects
    	    5) assign to class lists
    	 */



    //add list to parameter and persist
    private void persistItem()
    {
        this.emf = TestJPAConnector.getEntityManagerFactory();
    }

    @Test
    public void getIt()
    {
        EntityManagerFactory emf      = Persistence.createEntityManagerFactory("rest-api-test-pu");
        EntityManager        em       = emf.createEntityManager();
        AnyObject            expected = new AnyObject("ok");

        em.getTransaction().begin();
        em.persist(expected);
        AnyObject actual = em.find(AnyObject.class, 1);
        em.getTransaction().commit();

        assertEquals(actual, expected);
    }
}