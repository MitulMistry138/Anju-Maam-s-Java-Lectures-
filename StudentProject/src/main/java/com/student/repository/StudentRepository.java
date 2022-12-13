package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.student.entity.Student;
import com.student.model.StudentDTO;


public interface StudentRepository extends JpaRepository<Student, Integer> {

	// custom finder or getter
	
	@Query("from Student where lower(studentName) like :s%")	
	List<Student> getStudentByName(@Param("s") String studentName);  
		@Query("from Student where email=:e")
	List<Student> getStudentByEmail(@Param("e") String email);
}
