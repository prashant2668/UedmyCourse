package com.prashant.test.webservices.restwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResourceController {

	@Autowired
	private UserDaoService service;


	@GetMapping("/users")
	public List allUserr() {

		return service.findAll();	
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id) {
		User user=service.findOne(id);
		if (user==null) {
			throw new UserNotFoundException("For id- "+id);
		}

		//return all user link by using HATEOAS
		EntityModel<User> resource = EntityModel.of(user);

		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).allUserr());

		resource.add(linkTo.withRel("all-users"));

		return resource;

	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {		
		User saveuser=service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(saveuser.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user=service.deleteOne(id);
		if (user==null) {
			throw new UserNotFoundException("For id- "+id);
		}

	}

}
