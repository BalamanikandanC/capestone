package com.example.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Citizen {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String address;
	private String email;
	private String mobileNo;
	private String gender;
	private String aadhaarNo;
	private String citizenId;
	private String passportNo;
	@Temporal(TemporalType.DATE)
	private Date applicationDate;
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	private String approvalStatus;
	private Boolean duplicate;
	private Boolean isDeleted;
}
