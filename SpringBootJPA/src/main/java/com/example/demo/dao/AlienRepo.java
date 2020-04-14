package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{

	List<Alien> findByTech(String tech);
	
	List<Alien> findByaname(String aname);
	
	List<Alien> findByAid(int aid);
	
	List<Alien> findByAidGreaterThan(int aid);
	
	List<Alien> findByAname(String aname);
	
	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findByTechSorted(String tech);
	
	
	
}
