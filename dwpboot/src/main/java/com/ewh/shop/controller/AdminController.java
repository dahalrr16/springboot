package com.ewh.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ewh.shop.credentials.UserCredentials;
import com.ewh.shop.error.ErrorResponse;
import com.ewh.shop.exception.EwhException;
import com.ewh.shop.user.Status;
import com.ewh.shop.user.User;

@Controller
public class AdminController {
	private static Log log=LogFactory.getLog(AdminController.class);


@Value("${base.package}")
private String basePackage;
@PostMapping
@RequestMapping(value= {"/admin/login"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> getStatus(@RequestBody UserCredentials userCredentials, HttpServletRequest hsr) throws EwhException{
	
	Status s=new Status();
	String reqAttribute=(String) hsr.getSession().getAttribute("valid");
	if(reqAttribute!=null && reqAttribute.equals("true")) {
	s.setCode(00000);
	s.setMessage("Success");
	}
	else {
		s.setCode(99999);
		s.setMessage("Failure");
	}
	return new ResponseEntity(s, HttpStatus.OK);
	
}
@ExceptionHandler({EwhException.class, RuntimeException.class})
public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex){
	ErrorResponse error=new ErrorResponse();
	error.setErrorMessage(ex.getMessage());
	error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
	return new ResponseEntity(error, HttpStatus.OK);
}

}
