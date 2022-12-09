package com.student.service;

import java.util.List;

import com.student.entity.Student;
import com.student.model.StudentDTO;

public interface StudentService {

	String createStudent(Student student);
	public StudentDTO updateStudent(int id, Student student);
	StudentDTO getStudentByID(int id );
	String deleteStudentByID(int id);
	List<StudentDTO> getAllStudents();
	 void deleteAllStudents(); 
	
}
