package com.student.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Service;

import com.student.entity.Address;
import com.student.entity.Student;
import com.student.model.StudentDTO;
import com.student.repository.AddressRepository;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import com.student.util.Converter;

@Service
public class StudentServiceImpl  implements StudentService{
	
	@Autowired
	private StudentRepository  studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private Converter converter;

	//SAve details  method
	
	@Override
	public String createStudent(Student student) {
		String message = null;
		studentRepository.save(student);
		if(student!=null)
		{
			message= "Student details saved successfully";
		}
		return message;
	}

	//updating details student
	@Override
	public StudentDTO updateStudent(int id, Student student) {
		Student existingStudent=studentRepository.findById(id).get();
			existingStudent.setStudentName(student.getStudentName());
			existingStudent.setPhone(student.getPhone());
			existingStudent.setEmail(student.getEmail());
			
			studentRepository.save(existingStudent);
			
			System.out.println("Updated successfully");
			
			return converter.convertToStudentDTO(existingStudent);
	}

	@Override
	public StudentDTO getStudentByID(int id) {
		
		Student getStudent=studentRepository.findById(id).get();
	
		return converter.convertToStudentDTO(getStudent);
	}

	// Deletion of Student details
	@Override
	public String deleteStudentByID(int id) {
		String message = null;
		Optional<Student> deleteStudent = studentRepository.findById(id);
		// if it is present or not ..
		if(deleteStudent.isPresent())
		{
			studentRepository.deleteById(id);
			message = "Student Deleted Successfully ";
		}
		else
			message = "Student Detail not found";
						
		return message;
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> students=studentRepository.findAll();
		
		List<StudentDTO> sDTO=new ArrayList<>();
		for(Student s: students)
		{
			sDTO.add(converter.convertToStudentDTO(s));
		}
		
		return sDTO;
	}

	@Override
	public void deleteAllStudents() {
		
		studentRepository.deleteAll();
		
	}

	//getting details by using studentnames 
	@Override
	public List<StudentDTO> getStudentByName(String studentName) {
		List<Student> students=studentRepository.getStudentByName(studentName);
		List<StudentDTO> studentDTO = new ArrayList<>();
		for(Student s: students)
		{
			studentDTO.add(converter.convertToStudentDTO(s));
		}
		return studentDTO;
	}

	@Override
	public List<StudentDTO> getStudentByEmail(String email) {
		List<Student> students=studentRepository.getStudentByEmail(email);
		List<StudentDTO> studentDTO=new ArrayList<>();
		for(Student e: students)
		{
			studentDTO.add(converter.convertToStudentDTO(e));
		}
		
		return studentDTO;
	}

	@Override
	public StudentDTO assignAddressToStudent(int id, int addressId) {
		
	Student student=	studentRepository.findById(id).get();
	Address address =addressRepository.findById(addressId).get();
	student.setAddress(address);
	studentRepository.save(student);
		
	return converter.convertToStudentDTO(student);
	}
	
}
	
	

