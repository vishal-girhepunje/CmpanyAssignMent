package com.Problem3;

import javax.persistence.EntityManager;

public class CourtDAOImpl implements CourtDAO{
	EntityManager em;
	Lawyer lawyer;
	public Lawyer findLawyerById(int id) {
		em=EMUtil3.getConnection();
		lawyer=new Lawyer();
		lawyer=em.find(Lawyer.class, id);

		return lawyer;
	}

	public void saveLawyer(Lawyer lawyer) {
		em=EMUtil3.getConnection();
		em.getTransaction().begin();
		em.persist(lawyer);
		System.out.println("Successfully Save");
		em.getTransaction().commit();
	}

	public boolean deleteLawyerById(int id) {
		em=EMUtil3.getConnection();
		Lawyer del=em.find(Lawyer.class,id);
		if(del!=null)
		{
			em.getTransaction().begin();
			em.remove(del);
			em.getTransaction().commit();
			return false;
		}

		return false;
	}

	 public String updateLawyerExperience(int id, int experience) {
	        String msg = "Unable to update lawyer";
	        EntityManager em = EMUtil3.getConnection();

	        Lawyer lawyer = em.find(Lawyer.class, id);
	        if(lawyer != null){
	            em.getTransaction().begin();
	            lawyer.setYear(experience);
	            em.getTransaction().commit();
	            msg = "Lawyer updated";
	        }

	        return msg;
	    }
	
}
