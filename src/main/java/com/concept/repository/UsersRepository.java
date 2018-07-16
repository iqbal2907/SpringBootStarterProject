package com.concept.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concept.dbobjects.UsersDB;
import com.concept.outputobjects.Users;


@Repository
public interface UsersRepository extends CrudRepository<UsersDB, String>{

}
