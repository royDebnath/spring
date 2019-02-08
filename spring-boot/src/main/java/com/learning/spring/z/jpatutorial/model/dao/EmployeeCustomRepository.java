package com.learning.spring.z.jpatutorial.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.spring.z.jpatutorial.model.beans.Employee;

@Repository
public interface EmployeeCustomRepository extends CrudRepository<Employee, Integer> {

	@Query(value = "SELECT email FROM Employee e, Department d WHERE e.department_id = d.id and e.last_name = :surname and d.location=:location", nativeQuery = true)
	List<String> findEmployeeBySurnameAndLocation(@Param("location") String location, @Param("surname") String surname);
}
