package com.ewh.shop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ewh.shop.exception.EwhException;

public class BaseDao {
	@Autowired
SessionFactory sessionFactory;
	private Session currentSession;
	private Transaction currentTransaction;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	public Session openCurrentSession() {
		currentSession=getSessionFactory().openSession();
		return currentSession;
	}
	
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public Session openCurrentSessionWithTransaction() {
		currentTransaction= openCurrentSession().beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSessionWithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	
	
	
	
	
	
	
	
	
	public Object getById(int id) throws EwhException {
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		/*Query query=session.createQuery("from student where id="+id);
		if(query.list().size()==0) {
			throw new EwhException("No entries found");
		}
		return query.list().get(0);*/
		return null;
	}

}
