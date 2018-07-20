package com.concept.inputobjects;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Scope(value = "prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
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
