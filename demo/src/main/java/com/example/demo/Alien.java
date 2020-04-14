package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {
	
	private int aid;
	private String anmae;
	private String tech;
	@Autowired
	@Qualifier("lap1")
	private Laptop laptop;
	
	
	
	public Alien() {
		super();
		System.out.println("Object created");
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAnmae() {
		return anmae;
	}
	public void setAnmae(String anmae) {
		this.anmae = anmae;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public void Show() {
		System.out.println("In show");
		laptop.compile();
	}
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", anmae=" + anmae + ", tech=" + tech + "]";
	}
	
	

}
