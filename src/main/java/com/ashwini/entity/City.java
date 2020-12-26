package com.ashwini.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="STATE_INFO")


public class City {

	@Id
	@GeneratedValue
	
	@Column(name="CITY_ID")
	private Integer cityId;

	
	@Column(name="CITY_NAME")
	private String cityName;
	
	@Column(name="STATE_ID")
	private Integer stateId;
	
	
		
}
