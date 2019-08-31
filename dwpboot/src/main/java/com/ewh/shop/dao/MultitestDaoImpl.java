package com.ewh.shop.dao;

import java.io.Serializable;
import java.util.List;

import com.ewh.shop.model.Multitest;
import com.ewh.shop.model.Student;

public class MultitestDaoImpl extends BaseDao implements MultitestDaoInterface<Multitest, Serializable>{

	@Override
	public void persist(Multitest entity) {
		openCurrentSessionWithTransaction().save(entity);
		closeCurrentSessionWithTransaction();
		
	}

	@Override
	public void update(Multitest entity) {
		openCurrentSessionWithTransaction().update(entity);
		closeCurrentSessionWithTransaction();
		
	}

	@Override
	public Multitest findById(Serializable id) {
		Multitest multitest=openCurrentSession().get(Multitest.class, id);
		closeCurrentSession();		
		return multitest;
	}

	@Override
	public void delete(Multitest entity) {
		openCurrentSessionWithTransaction().delete(entity);
		closeCurrentSessionWithTransaction();
		
		
	}

	@Override
	public List<Multitest> findAll() {
	List<Multitest> multitestList=	openCurrentSession().createQuery("from Multitest").list();
		return multitestList;
	}
	
	
	public List<Multitest> findAllByQuery(String query) {
	List<Multitest> multitestList=	openCurrentSession().createQuery(query).list();
		return multitestList;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteList(List<Multitest> listToDelete) {
	for (Multitest multitest : listToDelete) {
		delete(multitest);
	}
		
	}

	@Override
	public void addList(List<Multitest> listToAdd) {
	for (Multitest multitest : listToAdd) {
		persist(multitest);
	}
		
	}

	public List<Multitest> findMultitestRandom(int number) {
		String query="from Multitest order by rand()";
		List<Multitest> multitestList=	openCurrentSession().createQuery(query).setMaxResults(number).list();
	//	return findAllByQuery(query);
		return multitestList;
	}

}
