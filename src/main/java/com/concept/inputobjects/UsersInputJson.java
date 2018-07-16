package com.concept.inputobjects;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@XmlRootElement(name="Root")
public class UsersInputJson {
	
    @JsonProperty("userid")
	@JacksonXmlProperty(localName="UserId")
	private int id;
    @JsonProperty("username")
	@JacksonXmlProperty(localName="UserName")
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
		return "UsersInputJson [id=" + id + ", name=" + name + "]";
	}  
}
