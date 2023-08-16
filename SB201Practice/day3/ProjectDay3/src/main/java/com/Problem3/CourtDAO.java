package com.Problem3;

public interface CourtDAO {
	Lawyer findLawyerById(int id);
	void saveLawyer(Lawyer lawyer);
	boolean deleteLawyerById(int id);
	String updateLawyerExperience(int id, int experience);
}
