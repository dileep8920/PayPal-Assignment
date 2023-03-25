package com.paypal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer>{

}
