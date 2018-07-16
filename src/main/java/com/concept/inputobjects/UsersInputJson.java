package com.concept.inputobjects;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(name="Root")
@ToString @Getter @Setter @EqualsAndHashCode //@Data equivalent to all
public class UsersInputJson {

    @JsonProperty("userid")
	@JacksonXmlProperty(localName="UserId")
	private int id;
	
    @JsonProperty("username")
	@JacksonXmlProperty(localName="UserName")
	private String name;
	
 
}
