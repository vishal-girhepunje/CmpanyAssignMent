package com.masai.usecase;

import com.masai.modul.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PlayerMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQL");
        EntityManager em = emf.createEntityManager();

        // 1. Write a Query That will return the list of player names in Upper case (Scalar function)
        Query q1 = em.createQuery("select upper(p.name) from Player p");
        List<String> list = q1.getResultList();
        list.forEach(s -> System.out.println(s));
        System.out.println();

        // 2. Write a Query That will give a min age of a player out of all players. (Aggregate function)
        Query q2 = em.createQuery("select max(age) from Player");
        int result = (int) q2.getSingleResult();
        System.out.println("Max player age : " + result);
        System.out.println();

        // 3. Write a Query  That will give a list of players with an age group between 18 to 25 years. (Between)
        Query q3 = em.createQuery("select p from Player p where p.age between 18 and 25");
        List<Player> list1 = q3.getResultList();
        list1.forEach(s -> System.out.println(s));
        System.out.println();

        // 4. Write a Query that will return the name of players whose names start with a particular letter. (Like)
        Query q4 = em.createQuery("select p from Player p where p.name like 'A%'");
        List<Player> list2 = q4.getResultList();
        list2.forEach(s -> System.out.println(s));
    }
}
