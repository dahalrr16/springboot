package com.ewh.shop.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ewh.shop.exception.EwhException;
import com.ewh.shop.model.Student;
import com.ewh.shop.service.StudentService;
import com.ewh.shop.user.Status;

@Controller
@RequestMapping("/")
public class StudentController {
	private static Log log=LogFactory.getLog(StudentController.class);
	

@Value("${base.package}")
private String basePackage;

@Autowired
StudentService studentService;

@RequestMapping(value= {"/get/student/{id}"},method= {org.springframework.web.bind.annotation.RequestMethod.GET},headers= {"Accept=application/json"})
public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) throws EwhException {
	log.info("calling get/student/id");
	Student s=studentService.getStudentById(id);
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/add/student"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> addStudent(@RequestBody Student student) throws EwhException {
	log.info("calling add/student");
	studentService.addStudent(student);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Student   "+student.getName()+" added successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/delete/student"},method= {org.springframework.web.bind.annotation.RequestMethod.PUT},headers= {"Accept=application/json"})
public ResponseEntity<Status> deleteStudent(@RequestBody Student student) throws EwhException {
	log.info("calling delete/student");
	studentService.deleteStudent(student);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Student   "+student.getName()+" deleted successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/update/student"},method= {org.springframework.web.bind.annotation.RequestMethod.PUT},headers= {"Accept=application/json"})
public ResponseEntity<Status> updateStudent(@RequestBody Student student) throws EwhException {
	log.info("calling update/student");
	studentService.updateStudent(student);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Student   "+student.getName()+" updated successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/get/all/students"},method= {org.springframework.web.bind.annotation.RequestMethod.GET},headers= {"Accept=application/json"})
public ResponseEntity<List<Student>> getAllStudents() throws EwhException {
	log.info("calling get/all/students");
	List<Student> s=studentService.getAllStudents();
	return new ResponseEntity(s, HttpStatus.OK);
	
}

}
