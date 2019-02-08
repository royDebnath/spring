package com.learning.spring.z.jpatutorial.model.beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

//--UNCOMMENT TO ACTIVATE @Entity

/******************************************************************SINGLE TABLE STRATEGY******************************************************************/
/*
 * Applicable when strategy is single table so that type column can distinguish
 * between the different types(Employee, ContractEmployee, PermanentEmployee)
 * 
 * In the type column "contract_employee" value will appear to discriminate from other sub-types
 */
//--UNCOMMENT TO ACTIVATE @DiscriminatorValue("permanent_employee")
/*
 * mysql> select * from employee;
+--------------------+-----+------------------------------+------------+-----------+--------------------+--------------+--------+--------+--------------------------+
| type               | id  | email                        | first_name | last_name | duration_in_months | pay_per_hour | bonus  | salary | department_department_id |
+--------------------+-----+------------------------------+------------+-----------+--------------------+--------------+--------+--------+--------------------------+
| permanent_employee | 117 | debdeep.sarkar@company.com   | Debdeep    | Sarkar    |               NULL |         NULL | 150000 |  10000 |                      701 |
| permanent_employee | 118 | pallab.karmakar@company.com  | Pallab     | Karmakar  |               NULL |         NULL | 150000 |  10000 |                      702 |
| permanent_employee | 119 | partha.deb@company.com       | Partha     | Deb       |               NULL |         NULL | 150000 |  10000 |                      703 |
+--------------------+-----+------------------------------+------------+-----------+--------------------+--------------+--------+--------+--------------------------+
 * */

/******************************************************************TABLE PER CONCRETE CLASS STRATEGY******************************************************************/

/*
 * No discriminator column/value not needed as three tables will be created for
 * each class: Subclass tables will have their specific attributes along with
 * the general attributes
 */

/*
 * *mysql> desc employee_permanent;
+--------------------------+--------------+------+-----+---------+-------+
| Field                    | Type         | Null | Key | Default | Extra |
+--------------------------+--------------+------+-----+---------+-------+
| id                       | int(11)      | NO   | PRI | NULL    |       |
| email                    | varchar(255) | YES  |     | NULL    |       |
| first_name               | varchar(255) | YES  |     | NULL    |       |
| last_name                | varchar(255) | YES  |     | NULL    |       |
| department_department_id | int(11)      | YES  | MUL | NULL    |       |
| bonus                    | int(11)      | NO   |     | NULL    |       |
| salary                   | int(11)      | NO   |     | NULL    |       |
+--------------------------+--------------+------+-----+---------+-------+
*/

/******************************************************************TABLE PER SUB CLASS STRATEGY******************************************************************/
/*
 * *mysql> desc employee_permanent;
+--------+---------+------+-----+---------+-------+
| Field  | Type    | Null | Key | Default | Extra |
+--------+---------+------+-----+---------+-------+
| bonus  | int(11) | NO   |     | NULL    |       |
| salary | int(11) | NO   |     | NULL    |       |
| id     | int(11) | NO   | PRI | NULL    |       |
+--------+---------+------+-----+---------+-------+

Hibernate: alter table employee_permanent add constraint FKtc28btpbscb8egbbske7io9f9 foreign key (id) references employee (id)
 * */
@PrimaryKeyJoinColumn(name="id")

public class EmployeePermanent extends Employee{	
	
	private int salary;
	
	private int bonus;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
