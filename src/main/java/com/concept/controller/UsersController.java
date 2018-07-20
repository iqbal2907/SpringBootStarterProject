package com.concept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.concept.inputobjects.UsersInputJson;
import com.concept.outputobjects.Response;
import com.concept.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/users")
public class UsersController {
	
	@Autowired
	UserService userService;


	
	@GetMapping
//	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public ResponseEntity<Response> getUsers() {
		return userService.getUserList();
	}

	/**
	 * 
	 	@RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization 
	 	of the inbound HttpRequest body onto a Java object.
		
		Spring automatically deserializes the JSON into a Java type assuming an appropriate one is specified. 
		By default, the type we annotate with the @RequestBody annotation must correspond to the JSON sent from our client-side 	 
	 * 
	 */
	@PostMapping
	@RequestMapping(value = "/requestbody")
	public ResponseEntity<Response> postUsers(@RequestBody UsersInputJson user) {
		log.info("Input User ---------------- : "+user);
		return userService.postUser(user);
	}

	/**
	 * 
	@RequestParam annotation used for accessing the query parameter values from the request. Look at the following request URL:

	http://localhost:9200/users/requestparam?id=101&name=ashrafi
	In the above URL request, the values for id and name can be accessed as below:	 
	
	*/
	@PostMapping
	@RequestMapping(value = "/requestparam")
	public ResponseEntity<Response> postUsersRequestParam(@RequestParam(value="id", required=true) int id, @RequestParam(value="name", required=true) String name) {
		System.out.println("****************** requestparam  ******************");
		UsersInputJson user = new UsersInputJson();
		user.setId(id);
		user.setName(name);
		return userService.postUser(user);
	}
	
	
	/**
	 * 
		PathVariable identifies the pattern that is used in the URI for the incoming request. 
		Let’s look at the below request URL	
		http://localhost:9200/users/pathvariable/101/ashrafi
	 * 
	 */
	@PostMapping
	@RequestMapping(value = "/pathvariable/{id}/{name}")
	public ResponseEntity<Response> postUsersPathVariable(@PathVariable(value="id") int id, @PathVariable(value="name") String name) {
		System.out.println("****************** pathvariable  ******************");
		UsersInputJson user = new UsersInputJson();
		user.setId(id);
		user.setName(name);
		return userService.postUser(user);
	}

	/**
	 * 
		@PathParam vs @QueryParam
		If you want to understand the difference between @PathParam and @QueryParam, 
		the above two annotations are defined in JAX-RS implementations for the exact purpose of @PathVariable and @RequestParam 
		which is defined in spring’s REST implementations. But, you could use either of the annotations without any difference in 
		the behavior.
	 * 
	 */
	
}
