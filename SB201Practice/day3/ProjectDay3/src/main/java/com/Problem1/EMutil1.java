package com.Problem1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMutil1 {
	private static EntityManagerFactory emf;
	static {
		emf=Persistence.createEntityManagerFactory("PersistenceUnit-day3");
	}
	public static EntityManager getConnection() {
		return emf.createEntityManager();
	}
}
