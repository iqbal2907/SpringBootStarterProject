package com.concept.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.concept.dbobjects.UsersDB;
import com.concept.inputobjects.UsersInputJson;
import com.concept.outputobjects.Response;
import com.concept.outputobjects.Users;
import com.concept.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	UsersRepository userRepo;
	
	ResponseEntity<Response> response;
	public ResponseEntity<Response> getUserList() {
		
		List<Users> usersList = new ArrayList<>();
		Users u1=null;
		Iterator<UsersDB> itr = userRepo.findAll().iterator();
		boolean flag = true;
		Users first_user=null;
		while (itr.hasNext()) {
			UsersDB usersDB = (UsersDB) itr.next();
			u1 = new Users();
			u1.setId(usersDB.getId());
			u1.setName(usersDB.getName());
			if (flag) {
				first_user = u1;
				flag = false;
			}
			usersList.add(u1);
		}
		
		Response resp = new Response();
		resp.setUserList(usersList);
		resp.setUser(first_user);
		response = new ResponseEntity<Response>(resp, HttpStatus.OK);
		return response;
	}
	
	public ResponseEntity<Response> postUser(@RequestBody UsersInputJson user) {
		
		UsersDB usersDB = new UsersDB();
		usersDB.setId(user.getId());
		usersDB.setName(user.getName());
		userRepo.save(usersDB);
		return null;
	}
}
