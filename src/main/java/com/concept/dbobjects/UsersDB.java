package com.concept.dbobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class UsersDB {

    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int id;

    @Column(name = "USER_NAME")
    @NotNull
    private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UsersDB [id=" + id + ", name=" + name + ", getId()=" + getId() + "]";
	}
	
	
}
