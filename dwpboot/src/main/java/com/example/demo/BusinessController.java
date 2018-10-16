package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ewh.shop.user.Status;
import com.ewh.shop.user.User;

@Controller
public class BusinessController {
	private static Log log=LogFactory.getLog(BusinessController.class);
	@Autowired
	private User user1;
@RequestMapping("/home")
public String  home() {
	System.out.println("Inside home");
	return "index.jsp";
}

@Value("${base.package}")
private String basePackage;
@RequestMapping(value= {"/get/user"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> getStatus(@RequestBody User user) {
	log.info("calling /get/anything");
	log.info("base package "+basePackage);
	log.info("Name of user requesting "+user.getFirstName());
	Status s=new Status();
	if(user1.getFirstName().equalsIgnoreCase(user.getFirstName())) {
	
	s.setCode(00000);
	s.setMessage("success");
	}
	else {
		s.setCode(99999);
		s.setMessage("failure");
	}
	return new ResponseEntity(s, HttpStatus.OK);
	
}


}
