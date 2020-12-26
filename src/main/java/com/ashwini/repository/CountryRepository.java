package com.ashwini.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwini.entity.Country;

public interface CountryRepository extends JpaRepository< Country, Serializable> {

}
