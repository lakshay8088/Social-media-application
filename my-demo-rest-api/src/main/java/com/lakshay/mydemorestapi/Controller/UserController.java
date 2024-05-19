package com.lakshay.mydemorestapi.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lakshay.mydemorestapi.Bean.Users;
import com.lakshay.mydemorestapi.exception.UserNotFoundException;
import com.lakshay.mydemorestapi.repository.UserRepository;
import com.lakshay.mydemorestapi.service.UserServiceImpl;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl impl;

	@GetMapping("/user-name")
	public String name() {
		return "John";
	}
	
	@GetMapping("/users")
	public List<Users> findAll(){
		return impl.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<Users> findById(@PathVariable int id) throws UserNotFoundException {
		  Users users = impl.getById(id);
		  
		  EntityModel<Users> entityModel = EntityModel.of(users);
		  WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());
		  entityModel.add(link.withRel("all-users"));
		  return entityModel;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> addById(@Valid @RequestBody Users users) {
		Users insert = impl.insert(users);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insert).toUri();
		return ResponseEntity.created(location).build();
	
	}
	
	@PutMapping("/users/{id}")
	public Users UpdateById(@PathVariable int id, @RequestBody Users users) {
		return impl.update(users);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		impl.delete(id);
		
	}
	
}
