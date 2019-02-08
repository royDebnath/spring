package com.learning.spring.z.jpatutorial.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.spring.z.jpatutorial.model.beans.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
