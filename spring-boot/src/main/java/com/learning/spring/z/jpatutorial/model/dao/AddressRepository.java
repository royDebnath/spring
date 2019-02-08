package com.learning.spring.z.jpatutorial.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.spring.z.jpatutorial.model.beans.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
