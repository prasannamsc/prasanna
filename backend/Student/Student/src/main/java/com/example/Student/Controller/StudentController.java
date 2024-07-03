package com.example.Student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.Model.StudentDTO;
import com.example.Student.Service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping("/addStudent")
	public ResponseEntity<String> addNewStudent(@RequestBody StudentDTO studentDTO) throws Exception {
		ResponseEntity<String> response = null;
		try {
			 service.addNewStudents(studentDTO);
			response = new ResponseEntity<String>( HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PostMapping("/validate")
	public ResponseEntity<String> validateStudent(@RequestBody StudentDTO studenDto) throws Exception {
		ResponseEntity<String> response = null;
		try {
			String result = service.validateStudent(studenDto);

			response = new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@DeleteMapping("/deleteStudent")
	public ResponseEntity<String> deleteStudent(@RequestParam("emailID") String emailId) throws Exception {
		ResponseEntity<String> res = null;
		try {
			service.deleteStudent(emailId);

			res = new ResponseEntity<String>( HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return res;

	}

	@DeleteMapping("/deleteAllStudent")
	public ResponseEntity<String> deleteAllStudent() throws Exception {
		ResponseEntity<String> res = null;
		try {
			service.deleteAllStudent();
			res = new ResponseEntity<String>("data Deleted Sucessfully!", HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return res;

	}

	@PutMapping("/updateStudent")
	public ResponseEntity<String> updateStudent(@RequestBody StudentDTO studentdto,
			@RequestParam("emailId") String emailId) throws Exception {
		ResponseEntity<String> res = null;
		try {
			service.updateStudent(studentdto, emailId);
			res = new ResponseEntity<String>( HttpStatus.OK);
		} catch (Exception e) {
			res = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return res;
	}

	@GetMapping("/getStudent")
	public ResponseEntity<?> getStudent(@RequestParam("emailId") String emailId) throws Exception {
		ResponseEntity<?> res = null;

		try {
			StudentDTO msg = service.getStudent(emailId);
			res = new ResponseEntity<StudentDTO>(msg, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
		return res;

	}

	@GetMapping("/getAllStudent")
	public ResponseEntity<List<StudentDTO>> getAllStudent() throws Exception {
		ResponseEntity<List<StudentDTO>> res = null;
		try {
			List<StudentDTO> msg = service.getAllStudent();
			res = new ResponseEntity<List<StudentDTO>>(msg, HttpStatus.OK);

		} catch (Exception e) {
			throw e;
		}
		return res;

	}

}
