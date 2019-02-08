package com.learning.spring.boot.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.spring.boot.model.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
