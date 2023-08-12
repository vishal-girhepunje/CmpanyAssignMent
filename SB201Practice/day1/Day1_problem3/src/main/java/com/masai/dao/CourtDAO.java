package com.masai.dao;

import com.masai.dto.Lawyer;

public interface CourtDAO {
	public Lawyer findLawyerById(int id);
	public String saveLawyer(Lawyer lawyer);
	public String deleteLawyerById(int id);
	public String updateLawyerExperience(int id, int experience);
}
