package com.example.Student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StudentEntity {
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer StudentID;
	private String studentName;
	private String registerNo;
	private String emailId;
	private long contactNo;

}
