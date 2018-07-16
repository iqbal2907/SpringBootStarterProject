package com.concept.outputobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="user")
public class Users {

    @JsonProperty("user_id")
	@JacksonXmlProperty(localName="User_Id")
	private int id;
    @JsonProperty("user_name")
	@JacksonXmlProperty(localName="User_Name")
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
}
