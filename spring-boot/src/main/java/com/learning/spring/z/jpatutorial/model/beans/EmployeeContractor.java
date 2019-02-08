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
//--UNCOMMENT TO ACTIVATE @DiscriminatorValue("contract_employee")
/*
mysql> select * from employee;
+--------------------+-----+------------------------------+------------+-----------+--------------------+--------------+--------+--------+--------------------------+
| type               | id  | email                        | first_name | last_name | duration_in_months | pay_per_hour | bonus  | salary | department_department_id |
+--------------------+-----+------------------------------+------------+-----------+--------------------+--------------+--------+--------+--------------------------+
| contract_employee  | 917 | anurag.punia@company.com     | Anurag     | Punia     |                 12 |        10000 |   NULL |   NULL |                      701 |
| contract_employee  | 918 | parag.banerjee@company.com   | Parag      | Banerjee  |                 24 |        10000 |   NULL |   NULL |                      702 |
| contract_employee  | 919 | nitin.agarwal@company.com    | Nitin      | Agarwal   |                  6 |        20000 |   NULL |   NULL |                      703 |
+--------------------+-----+------------------------------+------------+-----------+--------------------+--------------+--------+--------+--------------------------+
*/

/******************************************************************TABLE PER CONCRETE CLASS STRATEGY******************************************************************/

/*
 * No discriminator column/value not needed as three tables will be created for
 * each class: Subclass tables will have their specific attributes along with
 * the general attributes
 */

/*mysql> desc employee_contractor;
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
 * */


/******************************************************************TABLE PER SUB CLASS STRATEGY******************************************************************/
/*
 * mysql> desc employee_contractor;
+--------------------+---------+------+-----+---------+-------+
| Field              | Type    | Null | Key | Default | Extra |
+--------------------+---------+------+-----+---------+-------+
| duration_in_months | int(11) | NO   |     | NULL    |       |
| pay_per_hour       | int(11) | NO   |     | NULL    |       |
| id                 | int(11) | NO   | PRI | NULL    |       |
+--------------------+---------+------+-----+---------+-------+

Hibernate: alter table employee_contractor add constraint FKb51h9abmt8x3d38rbql1vj685 foreign key (id) references employee (id)
 * */
//--UNCOMMENT TO ACTIVATE @PrimaryKeyJoinColumn(name="id")

public class EmployeeContractor extends Employee {
	
	private int pay_per_hour;
	
	private int duration_in_months;

	public int getPay_per_hour() {
		return pay_per_hour;
	}

	public void setPay_per_hour(int pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}

	public int getDuration_in_months() {
		return duration_in_months;
	}

	public void setDuration_in_months(int duration_in_months) {
		this.duration_in_months = duration_in_months;
	}
}
