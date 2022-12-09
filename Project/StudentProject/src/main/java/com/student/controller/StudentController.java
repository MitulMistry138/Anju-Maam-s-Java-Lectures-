package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.model.StudentDTO;
import com.student.service.StudentService;
import com.student.util.Converter;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Converter converter;
	
	@PostMapping("/newStudent")
	public String createStudent(@RequestBody StudentDTO studentDTO)
	{
		final Student student= converter.convertToEntity(studentDTO);
	return studentService.createStudent(student);
	}
	
	@PutMapping("/updateStudent/{id}")
	public StudentDTO updateStudent(@PathVariable("id") int  id ,@RequestBody StudentDTO studentDTO)
	{
	Student student1	=converter.convertToEntity(studentDTO);
		return studentService.updateStudent(id, student1);
	}

	@GetMapping("/getStudent/{id}")
	public StudentDTO Student(@PathVariable("id") int  id )
	{
		return studentService.getStudentByID(id);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id )
	{
		return studentService.deleteStudentByID(id);
	}
	@GetMapping("/getAllStudents")
	public List<StudentDTO> getAllStudents()
	{
			return studentService.getAllStudents();
	}
	
	@DeleteMapping("/deleteAllStudents")
	public void deleteAllStudents()
	{
		studentService.deleteAllStudents();
	}
}
