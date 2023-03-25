package com.paypal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
