package com.ashwini.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER_INFO")

public class User {
	
	@Id
	@GeneratedValue
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="Email_ID")
	private String emailId;
	
	@Column(name="PHONE_NO")
	private Long phoneNo;
	
	@Column(name="DATE_OF_BIRTH")
	private String dateofBirth;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="CITY")
	private String city;
	
	
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ACC_STATUS")
	private String accStatus;
	
}
