package com.example.Student.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.Entity.StudentEntity;
import com.example.Student.Model.StudentDTO;
import com.example.Student.Repositary.Studentrepositary;

@Service
public class Studentimp implements StudentService {
	@Autowired
	private Studentrepositary repo;

	@Override
	public void addNewStudents(StudentDTO Studentdto) throws Exception {
	  Optional<StudentEntity> optional=repo.findByemailId(Studentdto.getEmailId());
	   
	   if(optional.isPresent()) {
		   throw new Exception("data Already Exsits!");
	   }
	   StudentEntity entity=new StudentEntity();
	   entity.setStudentName(Studentdto.getStudentName());
	   entity.setRegisterNo(Studentdto.getRegisterNo());
	   entity.setEmailId(Studentdto.getEmailId());
	   entity.setContactNo(Studentdto.getContactNo());
	   
	   repo.save(entity);
	   
	   
	   
		
	}

	@Override
	public String validateStudent(StudentDTO studentdto) throws Exception {
		Optional<StudentEntity> optional = repo.findByemailId(studentdto.getEmailId());
		String res = null;
		StudentEntity entity = optional.get();
		if(optional.isEmpty()) {
			res= "data not found!";
			
		}
		if(entity.getEmailId().equals(studentdto.getEmailId())) {
			res="Data Exits!!";
		}
		return res;
	
		
		
		
		
		
	}

	@Override
	public void deleteStudent(String emailId) throws Exception {
		Optional<StudentEntity> optional = repo.findByemailId(emailId);
		StudentEntity entity = optional.get();
		repo.delete(entity);		
		
	}

	@Override
	public void deleteAllStudent() throws Exception {
		repo.deleteAll();
		}

	@Override
	public void updateStudent(StudentDTO studentdto , String emailId) throws Exception {
	Optional<StudentEntity> optional = repo.findByemailId(emailId);
	StudentEntity entity = optional.orElseThrow(()-> new Exception("Service_not_found!") );
	entity.setStudentName(studentdto.getStudentName());
	entity.setRegisterNo(studentdto.getRegisterNo());
	entity.setEmailId(studentdto.getEmailId());
	entity.setContactNo(studentdto.getContactNo());
	repo.save(entity);
		
	}

	@Override
	public StudentDTO getStudent(String emailId) throws Exception {
		Optional<StudentEntity> optional= repo.findByemailId(emailId);
		StudentEntity entity=optional.get();
		StudentDTO studentdto = new StudentDTO();
		studentdto.setStudentName(entity.getStudentName());
		studentdto.setRegisterNo(entity.getRegisterNo());
		studentdto.setEmailId(entity.getEmailId());
		studentdto.setContactNo(entity.getContactNo());
		return studentdto;
	}

	@Override
	public List<StudentDTO> getAllStudent() throws Exception {
		List<StudentDTO> studentdtos = new ArrayList<>();
		Iterable <StudentEntity> dataFromRepo = repo.findAll();
		for(StudentEntity entity:dataFromRepo) {
			StudentDTO studentdto = new StudentDTO();
			studentdto.setStudentName(entity.getStudentName());
			studentdto.setRegisterNo(entity.getRegisterNo());
			studentdto.setEmailId(entity.getEmailId());
			studentdto.setContactNo(entity.getContactNo());
			studentdtos.add(studentdto);
		}
		return studentdtos;
	}
 
}
