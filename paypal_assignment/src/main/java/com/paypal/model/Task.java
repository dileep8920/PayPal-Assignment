package com.paypal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taskId;
	
	private String taskName;
	
	private String taskDescription;
	
	
	    private TypeOfTask type;

	    @ManyToOne
	    @JoinColumn(name = "sprint_id")
	    private Sprint sprint;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User assignee;

	    private StatusOfTask status;
	
}
