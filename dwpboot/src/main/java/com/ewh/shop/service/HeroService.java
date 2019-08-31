package com.ewh.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ewh.shop.dao.HeroDaoImpl;
import com.ewh.shop.exception.EwhException;
import com.ewh.shop.model.Hero;

public class HeroService extends ServiceBase{
	@Autowired
	HeroDaoImpl heroDaoImpl;
	
	public Hero getHeroById(int id) throws EwhException{
		return heroDaoImpl.findById(id);
	}
	
	public void addHero(Hero Hero) {
		heroDaoImpl.persist(Hero);
	}
	
	public void deleteHero(Hero Hero) {
		heroDaoImpl.delete(Hero);
	}
	
	public void updateHero(Hero Hero) {
		heroDaoImpl.update(Hero);
	}
	
	public List<Hero> getAllHeros(){
	return	heroDaoImpl.findAll();
	}

	public void addHeros(List<Hero> listToAdd) {
		heroDaoImpl.addList(listToAdd);
		
	}

	public void deleteHeros(List<Hero> listToDelete) {
		heroDaoImpl.deleteList(listToDelete);
		
	}

	public List<Hero> getHeroesByName(String name) {
		return heroDaoImpl.findHeroesByName(name);
	}
}
