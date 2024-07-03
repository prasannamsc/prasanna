package com.example.Student.Service;

import java.util.List;

import com.example.Student.Model.StudentDTO;

public interface StudentService {
	
	public void addNewStudents(StudentDTO Studentdto) throws Exception;
	public String validateStudent(StudentDTO Studentdto)  throws Exception;
	public void deleteStudent(String emailId) throws Exception;
	public void deleteAllStudent () throws Exception;
	public void updateStudent(StudentDTO studentdto , String emailId) throws Exception;
	public StudentDTO getStudent(String emailId) throws Exception;
	public List<StudentDTO> getAllStudent ( ) throws Exception;
	

}
