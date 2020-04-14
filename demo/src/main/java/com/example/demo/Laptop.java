package com.example.demo;

import org.springframework.stereotype.Component;

@Component("lap1")
public class Laptop {

	private int lId;
	private String bName;
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	@Override
	public String toString() {
		return "Laptop [lId=" + lId + ", bName=" + bName + "]";
	}
	
	public void compile() {
		System.out.println("compiling.....");
	}
}
