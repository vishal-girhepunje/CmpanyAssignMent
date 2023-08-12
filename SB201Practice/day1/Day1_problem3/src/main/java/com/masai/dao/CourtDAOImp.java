package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.dto.Lawyer;
import com.masai.utils.DBUtils;

public class CourtDAOImp implements CourtDAO {

	@Override
	public Lawyer findLawyerById(int id) {
		Lawyer low = null;
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "select * from lawyer where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				low = new Lawyer(id, rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return low;
	}

	@Override
	public String saveLawyer(Lawyer lawyer) {
		String msg = "Unable to save lawyer";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "insert into lawyer values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, lawyer.getId());
			ps.setString(2, lawyer.getName());
			ps.setString(3, lawyer.getEmail());
			ps.setString(4, lawyer.getAddress());
			ps.setInt(5, lawyer.getExperience());
			
			if(ps.executeUpdate()>0) msg = "Lawyer save successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public String deleteLawyerById(int id) {
		String msg = "Unable to save lawyer";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "delete from lawyer where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			if(ps.executeUpdate()>0) msg = "Lawyer save successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public String updateLawyerExperience(int id, int experience) {
		String msg = "Unable to update experience";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "update lawyer set experience = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, experience);
			ps.setInt(2, id);
			
			if(ps.executeUpdate() > 0) msg = "Experience updated successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

}
