package com.masai.dao;

import java.util.List;

import com.masai.dto.Student;
import com.masai.exception.StudentException;

public interface StudentDao {

	public Student getStudentByRollNo(int rollNo)throws StudentException;

	public List<Student> getAllStudent();

	public String saveStudentDetails(Student student);

	public boolean deleteStudentByRollNo(int rollNo)throws StudentException;

	public String graceStudentMarks(int rollNo, int marks)throws StudentException;

	public List<Student> getStudentsByName(String name)throws StudentException;
}
