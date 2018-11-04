package com.ewh.shop.dao;

import com.ewh.shop.exception.EwhException;
import com.ewh.shop.model.Student;

public class StudentDaoImpl extends BaseDao implements StudentDao{

	@Override
	public Student getStudentById(int id) throws EwhException {
		return getStudentById(id);
	}

	@Override
	public Student addStudent(Student student) throws EwhException {
		return addStudent(student);
	}
	

}
