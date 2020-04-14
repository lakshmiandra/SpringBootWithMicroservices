package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	
	
	@RequestMapping("home")
	public ModelAndView home(Alien a) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", a);
		mv.setViewName("home");
		return mv;
	}
	
/*	@RequestMapping("home")
	public ModelAndView home(@RequestParam("name") String myName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", myName);
		mv.setViewName("home");
		return mv;
	}*/
	
	
/*	@RequestMapping("home")
	public String home() {
		System.out.println("In home");
		return "home";
	}*/
	
/*	@RequestMapping("home")
	public String home(HttpServletRequest req, HttpServletResponse res) {
		
		HttpSession session = req.getSession();
		session.setAttribute("name", req.getParameter(req.getParameter("name")));
		System.out.println("hi"+ req.getParameter(req.getParameter("name")));
		return "home";
	}*/

}
