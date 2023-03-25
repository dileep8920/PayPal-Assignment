package com.paypal.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sprintId;
	
	@NotNull
	private String sprintName;
	
	@NotNull
	private LocalDate statingDate;
	
	@NotNull
	private LocalDate lastDate;

	
	@JsonIgnore
	@OneToMany(mappedBy = "sprint")
	private List<Task> tasksList;
	
}
