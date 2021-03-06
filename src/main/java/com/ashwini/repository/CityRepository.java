package com.ashwini.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwini.entity.City;

public interface CityRepository extends JpaRepository<City , Serializable> {
     
	List<City> findByStateId(Integer stateId);
}
