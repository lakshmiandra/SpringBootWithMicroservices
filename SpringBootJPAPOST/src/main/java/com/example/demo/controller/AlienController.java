package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo alienRepo;
	
	@GetMapping("/")
	public String home() {
		
		return "home.jsp";
	}

	/*@RequestMapping("/addAlien")
	public String addAlien(Alien a) {
		alienRepo.save(a);
		
		return "home.jsp";
	}
	*/
/*	@RequestMapping("/getAlien")
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
	}*/

/*	@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens() {
		
	
		return alienRepo.findAll();
	}*/
	
	
	@GetMapping(path="/aliens", produces= {"application/xml"})
	public List<Alien> getAliens() {
		
	
		return alienRepo.findAll();
	}
	
/*	@RequestMapping("/alien/102")
	@ResponseBody
	public String getAlien() {
		
	
		return alienRepo.findById(102).toString();
	}*/
	
	@GetMapping("/aliens/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
	
		return alienRepo.findById(aid);

	}
	
/*	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien a) {
		alienRepo.save(a);
		
		return a;
	}*/
	
	@PostMapping(path="/alien",consumes= {"application/json"})
	public Alien addAlien(@RequestBody Alien a) {
		alienRepo.save(a);
		
		return a;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		
		Alien a = alienRepo.getOne(aid);
		alienRepo.delete(a);
		
		return "deleted";
		
	}
	

	@PutMapping(path="/alien",consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien a) {
		alienRepo.save(a);
		
		return a;
	}
}

