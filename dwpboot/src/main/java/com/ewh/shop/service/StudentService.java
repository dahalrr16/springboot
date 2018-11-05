package com.ewh.shop.service;

import java.util.List;

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
	
	public List<Student> getAllStudents(){
	return	studentDaoImpl2.findAll();
	}

	public void addStudents(List<Student> listToAdd) {
		studentDaoImpl2.addList(listToAdd);
		
	}

	public void deleteStudents(List<Student> listToDelete) {
		studentDaoImpl2.deleteList(listToDelete);
		
	}

}
