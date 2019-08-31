package com.ewh.shop.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ewh.shop.error.ErrorResponse;
import com.ewh.shop.exception.EwhException;
import com.ewh.shop.model.Multitest;
import com.ewh.shop.model.Student;
import com.ewh.shop.service.MultitestService;
import com.ewh.shop.service.StudentService;
import com.ewh.shop.user.Status;
@CrossOrigin
@RestController
@RequestMapping("/")
public class MultipleOptionController {
	private static Log log=LogFactory.getLog(MultipleOptionController.class);
	

@Value("${base.package}")
private String basePackage;

@Autowired
StudentService studentService;
@Autowired
MultitestService multitestService;

@RequestMapping(value= {"/get/multitest/{id}"},method= {org.springframework.web.bind.annotation.RequestMethod.GET},headers= {"Accept=application/json"})
public ResponseEntity<Multitest> getMultitestById(@PathVariable("id") int id) throws EwhException {
	log.info("calling get/Multitest/id");
	Multitest s=multitestService.getMultitestById(id);
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/add/multitest"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> addMultitest(@RequestBody Multitest multitest) throws EwhException {
	log.info("calling add/student");
	multitestService.addMultitest(multitest);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Multitest   "+multitest.getId()+" added successfully with 201");
	return new ResponseEntity(s, HttpStatus.CREATED);
	
}

@RequestMapping(value= {"/update/multitest"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> updateMultitest(@RequestBody Multitest multitest) throws EwhException {
	log.info("calling update/student");
	multitestService.updateMultitest(multitest);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Multitest   "+multitest.getId()+" added successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}


@RequestMapping(value= {"/get/multitests/random"},method= {org.springframework.web.bind.annotation.RequestMethod.GET},headers= {"Accept=application/json"})
public ResponseEntity<List<Multitest>> getMultitestsRandom(@RequestParam ("number") int number) throws EwhException {
	log.info("calling get/multitests/random");
	List<Multitest> s=multitestService.getMultitestsRandom(number);
	return new ResponseEntity(s, HttpStatus.OK);
	
}



@RequestMapping(value= {"/get/all/multitests"},method= {org.springframework.web.bind.annotation.RequestMethod.GET},headers= {"Accept=application/json"})
public ResponseEntity<List<Multitest>> getAllMultitests() throws EwhException {
	log.info("calling get/all/multitests");
	List<Multitest> s=multitestService.getAllMultitests();
	return new ResponseEntity(s, HttpStatus.OK);
	
}










@RequestMapping(value= {"/delete/multitest"},method= {org.springframework.web.bind.annotation.RequestMethod.PUT},headers= {"Accept=application/json"})
public ResponseEntity<Status> deleteStudent(@RequestBody Student student) throws EwhException {
	log.info("calling delete/student");
	studentService.deleteStudent(student);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Student   "+student.getName()+" deleted successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/update/multitest"},method= {org.springframework.web.bind.annotation.RequestMethod.PUT},headers= {"Accept=application/json"})
public ResponseEntity<Status> updateStudent(@RequestBody Student student) throws EwhException {
	log.info("calling update/student");
	studentService.updateStudent(student);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Student   "+student.getName()+" updated successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}






@RequestMapping(value= {"/add/multitests"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> addStudents(@RequestBody List<Student> listToAdd) throws EwhException {
	log.info("calling add/students");
	studentService.addStudents(listToAdd);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Students   "+listToAdd.toString()+" added successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/delete/multitests"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> deleteStudents(@RequestBody List<Student> listToDelete) throws EwhException {
	log.info("calling delete/students");
	studentService.deleteStudents(listToDelete);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Students   "+listToDelete.toString()+" deleted successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@ExceptionHandler({RuntimeException.class})
public ResponseEntity<ErrorResponse> exceptionHandler(Exception e){
	ErrorResponse errorResponse=new ErrorResponse();
	errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
	errorResponse.setErrorMessage(e.getMessage());
	return new ResponseEntity(errorResponse, HttpStatus.OK);
}

}
