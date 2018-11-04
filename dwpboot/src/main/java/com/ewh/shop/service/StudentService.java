package com.ewh.shop.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ewh.shop.dao.StudentDaoImpl2;
import com.ewh.shop.exception.EwhException;
import com.ewh.shop.model.Student;

public class StudentService extends ServiceBase{
	@Autowired
	StudentDaoImpl2 studentDaoImpl2;
	
	public Student getStudentById(int id) throws EwhException{
		return studentDaoImpl2.findById(id);
	}
	
	public void addStudent(Student student) {
		studentDaoImpl2.persist(student);
	}
	
	public void deleteStudent(Student student) {
		studentDaoImpl2.delete(student);
	}
	
	public void updateStudent(Student student) {
		studentDaoImpl2.update(student);
	}
	

}
