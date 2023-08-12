package com.masai.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.masai.dto.Product;


public class ProductDaoImpl implements ProductDao{
	
	

	public Product findProduct(int id) {
		  EntityManagerFactory emf=Persistence.createEntityManagerFactory("Product");
		  EntityManager em=emf.createEntityManager();
		  Product pd=em.find(Product.class, id);
		  em.close();
		  return pd;
	}

	public void update(Product p) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Product");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("done");
		 em.close();
		
	}
	
}
