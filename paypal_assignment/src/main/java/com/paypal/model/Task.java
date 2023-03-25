package com.paypal.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.paypal.enums.StatusOfTask;
import com.paypal.enums.TypeOfTask;

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
	
	@Enumerated(EnumType.STRING)
	    private TypeOfTask typeOfTask;

	    @ManyToOne
	    private Sprint sprint;

	    @ManyToOne
	    private User user;

	    @Enumerated(EnumType.STRING)
	    private StatusOfTask statusOfTask;
	
}
