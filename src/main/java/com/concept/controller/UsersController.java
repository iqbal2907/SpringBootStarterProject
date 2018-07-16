package com.concept.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@PostMapping
//	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public ResponseEntity<Response> postUsers(@RequestBody UsersInputJson user) {
		log.info("Input User ---------------- : "+user);
//		System.out.println("Input User ---------------- : "+user);
		return userService.postUser(user);
	}

}
