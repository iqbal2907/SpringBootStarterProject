package com.concept.outputobjects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="root")
public class Response {

	@JsonProperty("users")
	@JacksonXmlElementWrapper(localName="Users")
	@JacksonXmlProperty(localName="User")
	private List<Users> userList;
	@JsonProperty("firstuser")
	@JacksonXmlProperty(localName="FirstUser")
	private Users user;
	
	public List<Users> getUserList() {
		return userList;
	}
	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
}
