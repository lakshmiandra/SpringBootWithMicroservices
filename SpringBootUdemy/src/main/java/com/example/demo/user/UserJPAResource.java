package com.example.demo.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import java.net.URI;
import java.util.List;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import java.util.Optional;

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
public class UserJPAResource {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@GetMapping(path="/jpa/users")
	public List<User> getUsers() {
		return userRepo.findAll();
		
	}

	@GetMapping(path="/jpa/users/{id}")
	public Resource<User> getUsers(@PathVariable int id) {
		
		// If user is not found then explicitly throw exception
		Optional<User> user = userRepo.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id - " + id);
		}
		
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
		
	}
	@PostMapping(path="/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User save = userRepo.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(save.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path="/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		 userRepo.deleteById(id);
		
	}
	
	
	@GetMapping(path="/jpa/users/{id}/posts")
	public List<Post> getJpaUserPosts(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		
		if (!user.isPresent()) {
			throw new UserNotFoundException("id - " + id);
		}
		
		return user.get().getPosts();
		
	}
	
	@PostMapping(path="/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id, @RequestBody Post postData) {
		
		Optional<User> Otionaluser = userRepo.findById(id);
		
		if (!Otionaluser.isPresent()) {
			throw new UserNotFoundException("id - " + id);
		}	
		User user = Otionaluser.get();
		postData.setUser(user);
		postRepo.save(postData);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(postData.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	
}
