package com.Problem1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeDaoImpl implements EmployeeDao {
		EntityManager em;
	public void save(Employee emp){
		em=EMutil1.getConnection();
		em.getTransaction().begin();
		em.persist(emp);
		System.out.println("Successfully Save");
		em.getTransaction().commit();		
	}

	public String getAddressOfEmployee(int empId){
		em=EMutil1.getConnection();
		Employee add=em.find(Employee.class,empId);
		if(add!=null){
			return add.getAdress();
		}
		return "Employee Not Found";
	}

	public String giveBonusToEmployee(int empId, int bonus) {
		em=EMutil1.getConnection();
		Employee bon=em.find(Employee.class,empId);
		if(bon!=null) {
			return  bon.getSalary()+bonus+"";
		}
		return "Employee Not Found";
	}

	public boolean deleteEmployee(int empId) {
		em=EMutil1.getConnection();
		Employee del=em.find(Employee.class,empId);
		if(del!=null){
			em.getTransaction().begin();
			em.remove(del);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

}
