package com.ewh.shop.dao;

import java.io.Serializable;
import java.util.List;

import com.ewh.shop.model.Hero;

public class HeroDaoImpl extends BaseDao implements HeroDaoInterface<Hero, java.io.Serializable> {

	@Override
	public void persist(Hero entity) {
		openCurrentSessionWithTransaction().save(entity);
		closeCurrentSessionWithTransaction();
		
	}

	@Override
	public void update(Hero entity) {
		openCurrentSessionWithTransaction().update(entity);
		closeCurrentSessionWithTransaction();
		
	}

	@Override
	public Hero findById(Serializable id) {
		Hero student=openCurrentSession().get(Hero.class, id);
		closeCurrentSession();		
		return student;
	}

	@Override
	public void delete(Hero entity) {
		openCurrentSessionWithTransaction().delete(entity);
		closeCurrentSessionWithTransaction();
		
		
	}

	@Override
	public List<Hero> findAll() {
	@SuppressWarnings("unchecked")
	List<Hero> studentList=	openCurrentSession().createQuery("from Hero").list();
		return studentList;
	}
	
	
	public List<Hero> findAllByName(String givenName) {
	@SuppressWarnings("unchecked")
	List<Hero> studentList=	openCurrentSession().createQuery("from Hero where name="+"'"+givenName+"'").list();
		return studentList;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteList(List<Hero> listToDelete) {
	for (Hero student : listToDelete) {
		delete(student);
	}
		
	}

	@Override
	public void addList(List<Hero> listToAdd) {
	for (Hero student : listToAdd) {
		persist(student);
	}
		
	}

	public List<Hero> findHeroesByName(String name) {
	return	findAllByName(name);
	}

}
