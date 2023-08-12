package com.masai.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.masai.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

//	public Employee registerEmployee(Employee employee) {
//		Employee ss="Somthing is Wrong";
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Employee");
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(ss);
//		em.getTransaction().commit();
//		ss="Save Successfully";
//		 em.close();
//		 return ss;
//	}

	
	public String registerEmployee(Employee employee) {
		String msg = "Unable to register employee";
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("Employee");
		  EntityManager em=emf.createEntityManager();
//		EntityManager em = EMUtils.getEntityManager();
		
		Employee emp = new Employee(employee.getEmpId(), employee.getName(), employee.getAddress(), employee.getSalary());
		
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		msg = "Registration successfully";
		em.close();
		
		return msg;
	}
	public Employee getEmployeeById(int empId) {
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("Employee");
		  EntityManager em=emf.createEntityManager();
		  Employee eid=em.find(Employee.class, empId);
		  em.close();
		  return eid;
	}

	public String deleteEmployeeById(int empId) {
		String ss="Somthing is Wrong";
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Employee");
		EntityManager em=emf.createEntityManager();
		 Employee pd=em.find(Employee.class, empId);
		em.getTransaction().begin();
		em.remove(pd);
		em.getTransaction().commit();
		ss="Deleted Successfully";
		 em.close();
		 return ss;
	}

	public String updateEmployeeSalary(int empId, int amount) {
		String ss="Somthing is Wrong";
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Employee");
		EntityManager em=emf.createEntityManager();
		 Employee pd=em.find(Employee.class, empId);
		em.getTransaction().begin();
		pd.setSalary(amount);
		em.getTransaction().commit();
		ss="Updated Successfully";
		 em.close();
		 return ss;
	}

}
