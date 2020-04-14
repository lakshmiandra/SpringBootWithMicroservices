package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo alienRepo;
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien a) {
		alienRepo.save(a);
		
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView addAlien(int aid) {
		ModelAndView mv =new ModelAndView("showAlien.jsp");
		Alien alien = alienRepo.findById(aid).orElse(new Alien());
		
		System.out.println(alienRepo.findByTech("java"));
		
		System.out.println(alienRepo.findByAid(102));
		
		System.out.println(alienRepo.findByAname("lakshmi"));
		
		System.out.println(alienRepo.findByAidGreaterThan(102));
		
		System.out.println(alienRepo.findByTechSorted("java"));
		
		mv.addObject(alien); 
		return mv;
	}

	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens() {
		
	
		return alienRepo.findAll().toString();
	}
	
	
/*	@RequestMapping("/alien/102")
	@ResponseBody
	public String getAlien() {
		
	
		return alienRepo.findById(102).toString();
	}*/
	
	@RequestMapping("/aliens/{aid}")
	@ResponseBody
	public String getAlien(@PathVariable("aid") int aid) {
		
	
		return alienRepo.findById(aid).toString();
	}
}

