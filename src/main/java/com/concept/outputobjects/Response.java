package com.concept.outputobjects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;

@JacksonXmlRootElement(localName="root")
public class Response {

	@Getter @Setter
	@JsonProperty("users")
	@JacksonXmlElementWrapper(localName="Users")
	@JacksonXmlProperty(localName="User")
	private List<Users> userList;

	@Getter @Setter
	@JsonProperty("firstuser")
	@JacksonXmlProperty(localName="FirstUser")
	private Users user;
	
}
