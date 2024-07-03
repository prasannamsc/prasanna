package com.example.Student.Repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Student.Entity.StudentEntity;

@Repository
public interface Studentrepositary extends JpaRepository<StudentEntity, Integer> {
	
	Optional<StudentEntity> findByemailId(String emailId) throws Exception;

}
