package com.paypal.service;

import java.time.LocalDate;
import java.util.List;

import com.paypal.enums.StatusOfTask;
import com.paypal.exception.SprintException;
import com.paypal.exception.TaskException;
import com.paypal.exception.UserException;
import com.paypal.model.Sprint;
import com.paypal.model.Task;
import com.paypal.model.User;

public interface SprintService {

public Sprint createSprint(Sprint sprint) throws SprintException;
	
	public List<Task> getAllTasks(Integer sprintId) throws SprintException;
	
	public Sprint getSprintById(Integer sprintId) throws SprintException;
	
	
	public Sprint removeSprintById (Integer sprintId) throws SprintException;
	
	public String addTask (Integer taskId, Integer sprintId) throws SprintException, TaskException;
	
	public  List<Sprint> getAllSprints();

    public List<Task> getAllTasks();
}
