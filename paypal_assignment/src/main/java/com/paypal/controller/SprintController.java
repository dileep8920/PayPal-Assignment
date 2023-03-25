package com.paypal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<List<Task>> getAllTasks(@PathVariable("sprintId") Integer sprintId){
		List<Task> task=sService.getAllTasks(sprintId);
		
		return new ResponseEntity<List<Task>>(task,HttpStatus.OK);
	}
	
	
	@GetMapping("/getSprintById/{sprintId}")
	public ResponseEntity<Sprint> getSprintById(@PathVariable("sprintId") Integer sprintId)  {
		
		Sprint s =  sService.getSprintById(sprintId);
		
		return new ResponseEntity<Sprint>(s,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteSprint")
	public ResponseEntity<Sprint> removeSprint(@PathVariable("sprintId") Integer sprintId){
		
		Sprint s= sService.removeSprintById(sprintId);
		
		return new ResponseEntity<Sprint>(s,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/addTask/{tId}/{sId}")
	public ResponseEntity<String> taskAdd(@PathVariable("tId") Integer tId, @PathVariable("sId") Integer sId){
		String add=sService.taskAdd(sId, tId);
		
		return new ResponseEntity<String>(add,HttpStatus.OK);
	}
	
	@GetMapping("/getallsprint")
	public ResponseEntity<List<Sprint>> getAllSprint(){
		List<Sprint> lst=sService.getAllSprints();
		
		return new ResponseEntity<List<Sprint>>(lst,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<List<Task>> getAllTask(){
		List<Task> lst=sService.getAllTasks();
		
		return new ResponseEntity<List<Task>>(lst,HttpStatus.ACCEPTED);
	}
}
