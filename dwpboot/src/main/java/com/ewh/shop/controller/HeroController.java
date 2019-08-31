package com.ewh.shop.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import com.ewh.shop.model.Hero;
import com.ewh.shop.service.HeroService;
import com.ewh.shop.user.Status;

@CrossOrigin
@RestController
@RequestMapping("/")
public class HeroController {
	private static Log log=LogFactory.getLog(HeroController.class);
	

@Value("${base.package}")
private String basePackage;

//@Autowired
@Resource
HeroService heroService;


@RequestMapping(value= {"/get/hero/{id}"},params = {"textArea", "localKey", "localFile"}, method= {org.springframework.web.bind.annotation.RequestMethod.GET},headers= {"Accept=application/json"})
public ResponseEntity<Hero> getHeroById(@PathVariable("id") int id) throws EwhException {
	log.info("calling get/Hero/id");
	Hero s=heroService.getHeroById(id);
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/get/hero"},params = {"name"}, method= {org.springframework.web.bind.annotation.RequestMethod.GET},headers= {"Accept=application/json"})
public ResponseEntity<List<Hero>> getHeroesByName(@RequestParam(value="name") String name) throws EwhException {
	log.info("calling get/Heroes by name");
	List<Hero> s=heroService.getHeroesByName(name);
	return new ResponseEntity(s, HttpStatus.OK);
	
}


@RequestMapping(value= {"/add/hero"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> addHero(@RequestBody Hero Hero) throws EwhException {
	log.info("calling add/Hero");
	if( Hero!=null) {
		log.info("Hero to be added with id "+Hero.getId()+" and Name  "+Hero.getName());
	}
	heroService.addHero(Hero);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Hero   "+Hero.getName()+" added successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/delete/hero"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> deleteHero(@RequestBody Hero Hero) throws EwhException {
	log.info("calling delete/Hero");
	heroService.deleteHero(Hero);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Hero   "+Hero.getName()+" deleted successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/update/hero"},method= {org.springframework.web.bind.annotation.RequestMethod.PUT},headers= {"Accept=application/json"})
public ResponseEntity<Status> updateHero(@RequestBody Hero Hero) throws EwhException {
	log.info("calling update/Hero");
	heroService.updateHero(Hero);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Hero   "+Hero.getName()+" updated successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/get/all/heroes"},method= {org.springframework.web.bind.annotation.RequestMethod.GET},headers= {"Accept=application/json"})
public ResponseEntity<List<Hero>> getAllHeros() throws EwhException {
	log.info("calling get/all/Heros");
	List<Hero> s=heroService.getAllHeros();
	return new ResponseEntity(s, HttpStatus.OK);
	
}


@RequestMapping(value= {"/add/heroes"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> addHeros(@RequestBody List<Hero> listToAdd) throws EwhException {
	log.info("calling add/Heros");
	heroService.addHeros(listToAdd);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Heros   "+listToAdd.toString()+" added successfully");
	return new ResponseEntity(s, HttpStatus.OK);
	
}

@RequestMapping(value= {"/delete/heroes"},method= {org.springframework.web.bind.annotation.RequestMethod.POST},headers= {"Accept=application/json"})
public ResponseEntity<Status> deleteHeros(@RequestBody List<Hero> listToDelete) throws EwhException {
	log.info("calling delete/Heros");
	heroService.deleteHeros(listToDelete);
	Status s =new Status();
	s.setCode(00000);
	s.setMessage("Heros   "+listToDelete.toString()+" deleted successfully");
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