package com.learning.spring.z.jpatutorial.model.beans;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity

/******************************************************************SINGLE TABLE STRATEGY******************************************************************/

/*
 * By this inheritance strategy, we can map the whole hierarchy by single table
 * only. Here, an extra column (also known as discriminator column) is created
 * in the table to identify the class.
 */

//--UNCOMMENT TO ACTIVATE @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/*
 * Applicable when strategy is single table so that type column can distinguish
 * between the different types(Employee, ContractEmployee, PermanentEmployee)
 */

//--UNCOMMENT TO ACTIVATE @DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
/*
 * In the type column "employee" value will appear to discriminate from other
 * sub-types.
 */

//--UNCOMMENT TO ACTIVATE @DiscriminatorValue(value = "employee")

/*mysql> desc employee;
+--------------------------+--------------+------+-----+---------+-------+
| Field                    | Type         | Null | Key | Default | Extra |
+--------------------------+--------------+------+-----+---------+-------+
| type                     | varchar(31)  | NO   |     | NULL    |       |
| id                       | int(11)      | NO   | PRI | NULL    |       |
| email                    | varchar(255) | YES  |     | NULL    |       |
| first_name               | varchar(255) | YES  |     | NULL    |       |
| last_name                | varchar(255) | YES  |     | NULL    |       |
| duration_in_months       | int(11)      | YES  |     | NULL    |       |
| pay_per_hour             | int(11)      | YES  |     | NULL    |       |
| bonus                    | int(11)      | YES  |     | NULL    |       |
| salary                   | int(11)      | YES  |     | NULL    |       |
| department_department_id | int(11)      | YES  | MUL | NULL    |       |
+--------------------------+--------------+------+-----+---------+-------+*/


/*
 * mysql> select * from employee;
+--------------------+-----+------------------------------+------------+-----------+--------------------+--------------+--------+--------+--------------------------+
| type               | id  | email                        | first_name | last_name | duration_in_months | pay_per_hour | bonus  | salary | department_department_id |
+--------------------+-----+------------------------------+------------+-----------+--------------------+--------------+--------+--------+--------------------------+
| employee           |  17 | debnath.roy@company.com      | Debnath    | Roy       |               NULL |         NULL |   NULL |   NULL |                      701 |
| employee           |  18 | siddharth.sharma@company.com | Siddharth  | Sharma    |               NULL |         NULL |   NULL |   NULL |                      702 |
| employee           |  19 | saurabh.jain@company.com     | Saurabh    | Jain      |               NULL |         NULL |   NULL |   NULL |                      703 |
| permanent_employee | 117 | debdeep.sarkar@company.com   | Debdeep    | Sarkar    |               NULL |         NULL | 150000 |  10000 |                      701 |
| permanent_employee | 118 | pallab.karmakar@company.com  | Pallab     | Karmakar  |               NULL |         NULL | 150000 |  10000 |                      702 |
| permanent_employee | 119 | partha.deb@company.com       | Partha     | Deb       |               NULL |         NULL | 150000 |  10000 |                      703 |
| contract_employee  | 917 | anurag.punia@company.com     | Anurag     | Punia     |                 12 |        10000 |   NULL |   NULL |                      701 |
| contract_employee  | 918 | parag.banerjee@company.com   | Parag      | Banerjee  |                 24 |        10000 |   NULL |   NULL |                      702 |
| contract_employee  | 919 | nitin.agarwal@company.com    | Nitin      | Agarwal   |                  6 |        20000 |   NULL |   NULL |                      703 |
+--------------------+-----+------------------------------+------------+-----------+--------------------+--------------+--------+--------+--------------------------+
 * 
 * */

/******************************************************************TABLE PER CONCRETE CLASS STRATEGY******************************************************************/
/*
 * No discriminator column/value not needed as three tables will be created for
 * each class: Subclass tables will have their specific attributes along with
 * the general attributes
 */
//--UNCOMMENT TO ACTIVATE  @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)


/*mysql> desc employee;
+--------------------------+--------------+------+-----+---------+-------+
| Field                    | Type         | Null | Key | Default | Extra |
+--------------------------+--------------+------+-----+---------+-------+
| id                       | int(11)      | NO   | PRI | NULL    |       |
| email                    | varchar(255) | YES  |     | NULL    |       |
| first_name               | varchar(255) | YES  |     | NULL    |       |
| last_name                | varchar(255) | YES  |     | NULL    |       |
| department_department_id | int(11)      | YES  | MUL | NULL    |       |
+--------------------------+--------------+------+-----+---------+-------+

*mysql> desc employee_permanent;
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

mysql> desc employee_contractor;
+--------------------------+--------------+------+-----+---------+-------+
| Field                    | Type         | Null | Key | Default | Extra |
+--------------------------+--------------+------+-----+---------+-------+
| id                       | int(11)      | NO   | PRI | NULL    |       |
| email                    | varchar(255) | YES  |     | NULL    |       |
| first_name               | varchar(255) | YES  |     | NULL    |       |
| last_name                | varchar(255) | YES  |     | NULL    |       |
| department_department_id | int(11)      | YES  | MUL | NULL    |       |
| duration_in_months       | int(11)      | NO   |     | NULL    |       |
| pay_per_hour             | int(11)      | NO   |     | NULL    |       |
+--------------------------+--------------+------+-----+---------+-------+
*/

/******************************************************************TABLE PER SUB CLASS STRATEGY******************************************************************/
//--UNCOMMENT TO ACTIVATE @Inheritance(strategy = InheritanceType.JOINED)

/*
 * 
mysql> desc employee;
+--------------------------+--------------+------+-----+---------+-------+
| Field                    | Type         | Null | Key | Default | Extra |
+--------------------------+--------------+------+-----+---------+-------+
| id                       | int(11)      | NO   | PRI | NULL    |       |
| email                    | varchar(255) | YES  |     | NULL    |       |
| first_name               | varchar(255) | YES  |     | NULL    |       |
| last_name                | varchar(255) | YES  |     | NULL    |       |
| department_department_id | int(11)      | YES  | MUL | NULL    |       |
+--------------------------+--------------+------+-----+---------+-------+

*mysql> desc employee_permanent;
+--------+---------+------+-----+---------+-------+
| Field  | Type    | Null | Key | Default | Extra |
+--------+---------+------+-----+---------+-------+
| bonus  | int(11) | NO   |     | NULL    |       |
| salary | int(11) | NO   |     | NULL    |       |
| id     | int(11) | NO   | PRI | NULL    |       |
+--------+---------+------+-----+---------+-------+

mysql> desc employee_contractor;
+--------------------+---------+------+-----+---------+-------+
| Field              | Type    | Null | Key | Default | Extra |
+--------------------+---------+------+-----+---------+-------+
| duration_in_months | int(11) | NO   |     | NULL    |       |
| pay_per_hour       | int(11) | NO   |     | NULL    |       |
| id                 | int(11) | NO   | PRI | NULL    |       |
+--------------------+---------+------+-----+---------+-------+

Hibernate: alter table employee add constraint FKiojsy23dwh2w9geqmvn955dqp foreign key (department_department_id) references department (department_id)
Hibernate: alter table employee_contractor add constraint FKb51h9abmt8x3d38rbql1vj685 foreign key (id) references employee (id)
Hibernate: alter table employee_permanent add constraint FKtc28btpbscb8egbbske7io9f9 foreign key (id) references employee (id)

*/
public class Employee {

	@Id
	private int id;

	private String firstName;

	private String lastName;

	private String email;

	@OneToOne(mappedBy = "employee")
	@Cascade(value = CascadeType.ALL)
	private Address address;

	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
