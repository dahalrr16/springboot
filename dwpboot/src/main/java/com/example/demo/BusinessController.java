package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ewh.shop.user.Status;
import com.ewh.shop.user.User;

@Controller
public class BusinessController {
@RequestMapping("/home")
public String  home() {
	System.out.println("Inside home");
	return "index.jsp";
}


@RequestMapping(value= {"/get/anything"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> getStatus(@RequestBody User user) {
	Status s=new Status();
	if(user.getFirstName().equalsIgnoreCase("raj")) {
	
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
