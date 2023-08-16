package com.masai.usecase;

import com.masai.modul.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQL");
        EntityManager em = emf.createEntityManager();

        //1. Find All Employee
        Query q1 = em.createNamedQuery("Find All Employee");
        List<Employee> list = q1.getResultList();
        list.forEach(employee -> System.out.println(employee));
        System.out.println();

        //2. Find Employee By Name
        Query q2 = em.createNamedQuery("Find Employee By Name");
        q2.setParameter(1, "Ankit");
        List<Employee> list1 = q2.getResultList();
        list1.forEach(employee -> System.out.println(employee));
    }
}
