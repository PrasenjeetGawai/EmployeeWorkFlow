package com.tka.DatabaseDemo2.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String status;
	private String department;
	private String mobileNo;
	private String emailId;
	
	private String createdBy;
	private Date createdDate;
	private String udatedBy;
	private Date updatedDate;
	private double salary;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	private Country country;

}
