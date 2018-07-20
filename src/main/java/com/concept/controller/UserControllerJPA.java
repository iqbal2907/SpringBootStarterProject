package com.concept.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.concept.inputobjects.UsersInputJson;
import com.concept.outputobjects.Response;
import com.concept.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/jpausers")
public class UserControllerJPA {

	@Autowired
	UserService userService;

	@POST
	@Path(value = "/queryparam")
	public ResponseEntity<Response> postUsersQueryParam(@QueryParam(value="id") int id, @QueryParam(value="name") String name) {
		System.out.println("****************** queryparam  ******************");
		System.out.println("Id :"+id+" Name"+name);
		UsersInputJson user = new UsersInputJson();
		user.setId(id);
		user.setName(name);
		log.info("Input User in postUsersQueryParam ---------------- : "+user);
		return userService.postUser(user);
	}
	
	@POST
	@Path(value = "/pathparam/{id}/{name}")
	public ResponseEntity<Response> postUsersPathParam(@PathParam(value="id") Integer id, @PathParam(value="name") String name) {
		System.out.println("****************** pathparam  ******************");
		System.out.println("Id :"+id+" Name"+name);
		UsersInputJson user = new UsersInputJson();
		user.setId(id);
		user.setName(name);
		log.info("Input User in postUsersPathParam ---------------- : "+user);
		return userService.postUser(user);
	}

}
