package com.example.demo.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	/*@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public String hello() {
		return "Hello World";
	}*/

	@GetMapping(path="/hello-world")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello-world");
	} // Exception with this code No converter found for return value of type: class com.example.demo.HelloWorldBean
	//org.springframework.http.converter.HttpMessageNotWritableException: No converter found for return value of type: class com.example.demo.HelloWorldBean
	// Because we dont have Get method
	
	
	// what is the internal implementation
	
	//what is dispatcher servlet?
	//who is configuering dispatcher servlet?
	//what does dispatcher servlet do?
	// How does the helloWorlfBean converted get converted to JSON?
	//Whos is configuring the Error Mapping?
	
	@GetMapping(path="/hello-world-path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world, %s", name));
	}
	
	@GetMapping(path="/hello-world-internationalization")
	public String helloInternalization() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
