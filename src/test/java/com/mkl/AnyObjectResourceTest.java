package com.mkl;

import com.mkl.data.entities.AnyObject;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class AnyObjectResourceTest
{

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