package com.paypal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
}
