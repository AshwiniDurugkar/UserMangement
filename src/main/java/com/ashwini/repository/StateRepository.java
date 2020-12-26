package com.ashwini.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwini.entity.State;

public interface StateRepository  extends JpaRepository<State , Serializable>{
  List<State> findByCountryId(Integer countryId);
}
