package com.example.demo.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import java.net.URI;
import java.util.List;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userService;
	
	@GetMapping(path="/users")
	public List<User> getUsers() {
		return userService.findAll();
		
	}
	
/*	@GetMapping(path="/users/{id}")
	public User getUsers(@PathVariable int id) {
		
		// If user is not found then explicitly throw exception
		User user = userService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id - " + id);
		}
		
		return user;
		
	}*/
	
/*	// HATEOAS
	@GetMapping(path="/users/{id}")
	public EntityModel<User> getUsers(@PathVariable int id) {
		
		// If user is not found then explicitly throw exception
		User user = userService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id - " + id);
		}
		
		EntityModel<User> model = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
		model.add(linkTo.withRel("all-users"));
		return model;
		
	}*/
	
	// HATEOAS
	@GetMapping(path="/users/{id}")
	public Resource<User> getUsers(@PathVariable int id) {
		
		// If user is not found then explicitly throw exception
		User user = userService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id - " + id);
		}
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
		
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User save = userService.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(save.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path="/users/{id}")
	public User deleteUser(@PathVariable int id) {
		
		// If user is not found then explicitly throw exception
		User user = userService.delteById(id);
		if (user == null) {
			throw new UserNotFoundException("id - " + id);
		}
		
		return user;
		
	}
	
}
