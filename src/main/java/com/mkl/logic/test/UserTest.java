package com.mkl.logic.test;

import com.mkl.data.entities.Role;
import com.mkl.data.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class UserTest
{

	public static void main(String[] args)
	{
		EntityManager em = Persistence.createEntityManagerFactory("rest-api-pu").createEntityManager();

		em.getTransaction().begin();
		Role userRole  = new Role("user");
		Role adminRole = new Role("admin");
		User user      = new User("user", "test");
		user.addRole(userRole);
		User admin = new User("admin", "test");
		admin.addRole(adminRole);
		User both = new User("user_admin", "test");
		both.addRole(userRole);
		both.addRole(adminRole);
		em.persist(userRole);
		em.persist(adminRole);
		em.persist(user);
		em.persist(admin);
		em.persist(both);
		em.getTransaction().commit();
		System.out.println("PW: " + user.getUserPass());
		System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
		System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
		System.out.println("Created TEST Users");

	}
}
