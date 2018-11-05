package com.ewh.shop.dao;

import java.io.Serializable;
import java.util.List;

import com.ewh.shop.model.Student;

public class StudentDaoImpl2 extends BaseDao implements StudentDaoInterface<Student, Serializable>{

	@Override
	public void persist(Student entity) {
		openCurrentSessionWithTransaction().save(entity);
		closeCurrentSessionWithTransaction();
		
	}

	@Override
	public void update(Student entity) {
		openCurrentSessionWithTransaction().update(entity);
		closeCurrentSessionWithTransaction();
		
	}

	@Override
	public Student findById(Serializable id) {
		Student student=openCurrentSession().get(Student.class, id);
		closeCurrentSession();		
		return student;
	}

	@Override
	public void delete(Student entity) {
		openCurrentSessionWithTransaction().delete(entity);
		closeCurrentSessionWithTransaction();
		
		
	}

	@Override
	public List<Student> findAll() {
	List<Student> studentList=	openCurrentSession().createQuery("from Student").list();
		return studentList;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteList(List<Student> listToDelete) {
	for (Student student : listToDelete) {
		delete(student);
	}
		
	}

	@Override
	public void addList(List<Student> listToAdd) {
	for (Student student : listToAdd) {
		persist(student);
	}
		
	}

}
