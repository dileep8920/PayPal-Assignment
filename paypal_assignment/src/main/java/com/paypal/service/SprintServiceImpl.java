package com.paypal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.enums.StatusOfTask;
import com.paypal.exception.SprintException;
import com.paypal.exception.TaskException;
import com.paypal.exception.UserException;
import com.paypal.model.Sprint;
import com.paypal.model.Task;
import com.paypal.model.User;
import com.paypal.repository.SprintRepo;
import com.paypal.repository.TaskRepo;
import com.paypal.repository.UserRepo;

@Service
public class SprintServiceImpl implements SprintService{
	
	@Autowired
	private SprintRepo sRepo;
	@Autowired
	private TaskRepo tRepo;
	
	@Autowired
	private UserRepo uRepo;

	@Override
	public Sprint createSprint(Sprint sprint) {
		// TODO Auto-generated method stub
		Sprint s=sRepo.save(sprint);
		return s;
	}

	@Override
	public List<Task> getAllTasks(Integer sprintId) throws SprintException {
		// TODO Auto-generated method stub
		return sRepo.findById(sprintId).get().getTasksList();
	}

	@Override
	public Sprint getSprintById(Integer sprintId) throws SprintException {
		// TODO Auto-generated method stub
		Sprint sprint = sRepo.findById(sprintId)
	            .orElseThrow(() -> new SprintException("Sprint is not there with this " + sprintId));
		return sprint;
	}


	@Override
	public Sprint removeSprintById(Integer sprintId) throws SprintException {
		// TODO Auto-generated method stub
		Sprint sprint = sRepo.findById(sprintId)
	            .orElseThrow(() -> new SprintException("Sprint is not there with this " + sprintId));
		
		sRepo.delete(sprint);
		return sprint;
	}

	@Override
	public String taskAdd(Integer taskId, Integer sprintId) throws SprintException, TaskException {
		// TODO Auto-generated method stub
        Sprint s = sRepo.findById(sprintId).orElseThrow(() -> new SprintException("Sprint is not there with this " + sprintId));
        Task t = tRepo.findById(taskId).orElseThrow(() -> new TaskException("Task is not there with this " + taskId));
        if(t.getSprint() != null) {
			throw new SprintException("task is Already present with this " + sprintId);
		} else {
			t.setSprint(s);
			s.getTasksList().add(t);
			sRepo.save(s);
			tRepo.save(t);
			return "Task " + taskId + " " + sprintId;	
		}
	}
	

	@Override
	public List<Sprint> getAllSprints() {
		// TODO Auto-generated method stub
		 List<Sprint> sprints = sRepo.findAll();
         return sprints;
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		 List<Task> tasks = tRepo.findAll();
	        return tasks;
	}


}
