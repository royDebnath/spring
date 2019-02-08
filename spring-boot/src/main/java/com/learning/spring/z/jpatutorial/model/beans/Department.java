package com.learning.spring.z.jpatutorial.model.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	private int id;
	
	private String name;
	
	private String location;
	
	@OneToMany(mappedBy="department")
	private Set<Employee> employees;

	public int getDepartmentId() {
		return id;
	}

	public void setDepartmentId(int departmentId) {
		this.id = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	

}
