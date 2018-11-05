package com.ewh.shop.dao;

import java.util.List;

public interface StudentDaoInterface<T, Id extends java.io.Serializable> {
public void persist(T entity);
public void update(T entity);
public T findById(Id id);
public void delete(T entity);
public List<T> findAll();
public void deleteAll();
public void deleteList(List<T> listToDelete);
public void addList(List<T> listToAdd);

}
