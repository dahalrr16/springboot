package com.ewh.shop.dao;

import com.ewh.shop.exception.EwhException;
import com.ewh.shop.model.Student;

public interface StudentDao {
	public Student getStudentById(int id) throws EwhException;
	public Student addStudent(Student student) throws EwhException;

}
