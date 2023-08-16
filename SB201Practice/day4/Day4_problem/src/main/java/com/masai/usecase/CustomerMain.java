package com.masai.usecase;

import com.masai.modul.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CustomerMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQL");
        EntityManager em = emf.createEntityManager();

        //1. Write a NamedQuery to find “customer by id” by creating NamedQuery which will return customer details.
        Query q1 = em.createNamedQuery("customer by id");
        q1.setParameter("id", 1);
        List<Customer> list = q1.getResultList();
        list.forEach(customer -> System.out.println(customer));
        System.out.println();

        //2. Write NativeQuery to get a “List of All the customers” by creating NamedQuery which will return all customer details.
        Query q2 = em.createNamedQuery("List of All the customers");
        List<Customer> list1 = q2.getResultList();
        list1.forEach(customer -> System.out.println(customer));
    }
}
