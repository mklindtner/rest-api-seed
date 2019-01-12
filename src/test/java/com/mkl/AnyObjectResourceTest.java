package com.mkl;

import com.mkl.data.entities.AnyObject;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class AnyObjectResourceTest
{
    	/* example of setup
	@Before
	public void setupData()
	{
		Customer c1 = createCustomer();
		Set<OrderExam> orderExams = createOrder(c1);
		Set<OrderLine> orderLines = createOrderLines(orderExams);
		Set<ItemType> itemTypes = createItemType(orderLines);
		setOrdersExamOrderLine(orderExams, orderLines);
		setOrderLinesItemType(orderLines, itemTypes);


		c1.setOrder(orderExams);
		persistCustomer(c1, itemTypes); //use em inside here

		this.orderLines = orderLines;
		this.orderExams = orderExams;
		this.itemTypes = itemTypes;
		this.orderRepository = new OrderRepository(emf);
	}*/
    	/*
    	    1) create first object
    	    2) Crete List
    	    3) Set Relationships
    	    4) persist 1 object
    	    5) assign to global variable
    	 */

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