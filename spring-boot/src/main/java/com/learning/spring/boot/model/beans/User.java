package com.learning.spring.boot.model.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	
	/*@GeneratedValue(strategy= GenerationType.AUTO)*/
	@Id
	private Integer id;
	private String name;
	private Date birthDate;
	
	@OneToMany(mappedBy="user") //This means this field will be mapped by the "user" field present in Post
	private List<Post> posts;
/*
	{
		"id" : 1051,
		"name" : "John Doe",
		"birthDate" : "1986-08-12T18:30:00.000+0000"
	}*/
	/*
	 * This default no argument constructor had to be written as there is
	 * already a custom constructor present. while executing post requests
	 * spring demands a default no-arg constructor, which is automatically
	 * available if we do not write a constructor at all, but since we wrote a
	 * custom one with arguments now we will have to write one with no-args
	 * explicitly
	 */
	protected User() {
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}