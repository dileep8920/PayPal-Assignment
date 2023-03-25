package com.paypal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.exception.SprintException;
import com.paypal.model.Sprint;
import com.paypal.model.Task;
import com.paypal.service.SprintService;

@RestController
public class SprintController {

	@Autowired
	private SprintService sService;
	
	@PostMapping("/createSprint")
	public ResponseEntity<Sprint> createSprint(@RequestBody Sprint sprint){
		
		Sprint s=sService.createSprint(sprint);
		
		return new ResponseEntity<Sprint>(s,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllTask/{sprintId}")
	public ResponseEntity<List<Task>> getAllTasksInSprint(@PathVariable("sprintId") Integer sprintId){
		List<Task> task=sService.getAllTasks(sprintId);
		
		return new ResponseEntity<List<Task>>(task,HttpStatus.OK);
	}
	
	
	@GetMapping("/getSprintById/{sprintId}")
	public ResponseEntity<Sprint> getSprintById(@PathVariable("sprintId") Integer sprintId) throws SprintException {
		
		Sprint getSprint =  sService.getSprintById(sprintId);
		
		return new ResponseEntity<Sprint>(getSprint,HttpStatus.OK);
	}
	
	
}
