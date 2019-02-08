package com.learning.spring.z.jpatutorial.model.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*
 * mysql> desc address;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| id           | int(11)      | NO   | PRI | NULL    |       |
| address_line | varchar(255) | YES  |     | NULL    |       |
| employee_id  | int(11)      | YES  | MUL | NULL    |       |
+--------------+--------------+------+-----+---------+-------+

Automatically detects employee primary key id and creates foreign key employee_id in address table
*/

@Entity
public class Address {
	
	@Id
	private int id;
	
	private String addressLine;
	
	@OneToOne
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public Employee getEmmployee() {
		return employee;
	}

	public void setEmmployee(Employee emmployee) {
		this.employee = emmployee;
	}
	
	

}
