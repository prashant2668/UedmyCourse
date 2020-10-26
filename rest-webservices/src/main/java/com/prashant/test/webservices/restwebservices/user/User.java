package com.prashant.test.webservices.restwebservices.user;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.ModelAttribute;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("User details manual description")

@Entity
public class User {

	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2,message = "Name Should have atleast 2 characters")
	@ApiModelProperty(notes = "Name should be equal or more than 2 character ")
	private String name;
	
	@Past
	@ApiModelProperty(notes = "Birth date should be in past")
	private Date birthDate;
	
	@OneToMany(mappedBy = "user")
	private List<Posts> posts;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public User() {
		
	}
	
	
	
	public User(String name, Integer id, Date birthDate) {
		super();
		this.name = name;
		this.id = id;
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", birthDate=" + birthDate + "]";
	}
	
	
	
	
}
