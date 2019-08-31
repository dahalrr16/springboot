package com.ewh.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ewh.shop.dao.MultitestDaoImpl;
import com.ewh.shop.exception.EwhException;
import com.ewh.shop.model.Multitest;
import com.ewh.shop.model.Student;

public class MultitestService extends ServiceBase{
	@Autowired
	MultitestDaoImpl multitestDaoImpl;
	
	public void updateMultitest(Multitest multitest) {
		multitestDaoImpl.update(multitest);
		
	}
	
	public Multitest getMultitestById(int id) throws EwhException{
		return multitestDaoImpl.findById(id);
	}
	
	public void addMultitest(Multitest student) {
		multitestDaoImpl.persist(student);
	}
	
	public void deleteStudent(Multitest student) {
		multitestDaoImpl.delete(student);
	}
	
	
	
	public List<Multitest> getAllMultitests(){
	return	multitestDaoImpl.findAll();
	}

	public void addStudents(List<Multitest> listToAdd) {
		multitestDaoImpl.addList(listToAdd);
		
	}

	public void deleteStudents(List<Multitest> listToDelete) {
		multitestDaoImpl.deleteList(listToDelete);
		
	}

	public List<Multitest> getMultitestsRandom(int number) {
		return	multitestDaoImpl.findMultitestRandom(number);
	}

	

	

}
