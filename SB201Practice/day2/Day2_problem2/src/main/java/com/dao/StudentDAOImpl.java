package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dto.Student;


public class StudentDAOImpl implements StudentDAO{

	
	public Student findStudentById(int id) {
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
		  EntityManager em=emf.createEntityManager();
		  Student pd=em.find(Student.class, id);
		  em.close();
		  return pd;
	}

	public String saveStudent(Student s) {
		String ss="Somthing is Wrong";
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		ss="Save Successfully";
		 em.close();
		 return ss;
	}

	public String deleteStudentById(int id) {
		String ss="Somthing is Wrong";
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
		EntityManager em=emf.createEntityManager();
		 Student pd=em.find(Student.class, id);
		em.getTransaction().begin();
		em.remove(pd);
		em.getTransaction().commit();
		ss="Deleted Successfully";
		 em.close();
		 return ss;
	}

	
	
	public String updateStudentLevel(int id, int level) {
        String msg = "Student doesn't exist!";
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
		EntityManager em=emf.createEntityManager();

		Student stu = em.find(Student.class, id);
		if(stu != null) {
			em.getTransaction().begin();
			stu.setLevel(level);
			em.getTransaction().commit();
			msg = "Level updated";
			em.close();
		}

		return msg;
	}
//	public String updateStudentLevel(int id, int level) {
//		String ss="Somthing is Wrong";
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("PersistenceUnit");
//		EntityManager em=emf.createEntityManager();
//		 Student pd=em.find(Student.class, id);
//		em.getTransaction().begin();
//		pd.setLevel(level);
//		em.getTransaction().commit();
//		ss="Updated Successfully";
//		 em.close();
//		 return ss;
//	}
	
}
