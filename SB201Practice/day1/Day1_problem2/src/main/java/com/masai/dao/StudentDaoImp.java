package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Student;
import com.masai.exception.StudentException;
import com.masai.utils.DBUtils;

public class StudentDaoImp implements StudentDao {

	public Student getStudentByRollNo(int rollNo) throws StudentException {
		Student stu = null;
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "select * from student where rollNo = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, rollNo);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				stu = new Student(rollNo, rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return stu;
	}

	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "select * from student";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public String saveStudentDetails(Student stu) {
		String msg = "Unable to sava student";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "insert into student values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, stu.getRollNo());
			ps.setString(2, stu.getStudent());
			ps.setString(3, stu.getAddress());
			ps.setInt(4, stu.getMarks());
			
			if(ps.executeUpdate() > 0) msg = "Student save successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

	public boolean deleteStudentByRollNo(int rollNo) throws StudentException {
		boolean flag = false;
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "delete from student where rollNo = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, rollNo);
			
			if(ps.executeUpdate() > 0) flag = true;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public String graceStudentMarks(int rollNo, int marks) throws StudentException {
		String msg = "Unable to add marks to student";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "update student set marks = marks + ? where rollNo = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, marks);
			ps.setInt(2, rollNo);
			
			if(ps.executeUpdate() > 0) msg = "Add marks to student successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

	public List<Student> getStudentsByName(String name) throws StudentException {
		List<Student> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "select * from student where studentName = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
