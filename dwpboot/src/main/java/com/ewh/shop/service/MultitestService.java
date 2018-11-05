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
	
	public Multitest getStudentById(int id) throws EwhException{
		return multitestDaoImpl.findById(id);
	}
	
	public void addStudent(Multitest student) {
		multitestDaoImpl.persist(student);
	}
	
	public void deleteStudent(Multitest student) {
		multitestDaoImpl.delete(student);
	}
	
	public void updateStudent(Multitest student) {
		multitestDaoImpl.update(student);
	}
	
	public List<Multitest> getAllStudents(){
	return	multitestDaoImpl.findAll();
	}

	public void addStudents(List<Multitest> listToAdd) {
		multitestDaoImpl.addList(listToAdd);
		
	}

	public void deleteStudents(List<Multitest> listToDelete) {
		multitestDaoImpl.deleteList(listToDelete);
		
	}

}
