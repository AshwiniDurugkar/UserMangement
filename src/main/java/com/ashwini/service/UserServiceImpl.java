package com.ashwini.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.ashwini.entity.City;
import com.ashwini.entity.Country;
import com.ashwini.entity.State;
import com.ashwini.entity.User;
import com.ashwini.repository.CityRepository;
import com.ashwini.repository.CountryRepository;
import com.ashwini.repository.StateRepository;
import com.ashwini.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Override
	public Map<Integer, String> findCountries() {
		
		Map<Integer, String> countries = new HashMap<>();
		List<Country> countriesList = countryRepo.findAll();
		countriesList.forEach(country -> {
		 countries.put(country.getCountryId(), country.getCountryName());
			});
        return countries;
        
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {
		Map<Integer, String> states = new HashMap<>();
		List<State> statesList = stateRepo.findByCountryId(countryId);
		statesList.forEach(state -> {
		 states.put(state.getStateId(), state.getStateName());
			});
        
		return states;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {
		Map<Integer, String> cities = new HashMap<>();
		List<City> citiesList = cityRepo.findByStateId(stateId);
		citiesList.forEach(city -> {
		 cities.put(city.getCityId(), city.getCityName());
			});
    
			return cities;
	}
	
	@Override
	public boolean isEmailUnique(String emailId)
	{
		User userDetails = userRepo.findByEmailId(emailId);
		return userDetails.getUserId()== null;
	}

	@Override
	public boolean saveUser(User user) {
		user.setPassword(passwordGenerator());
		user.setAccStatus("LOCKED");
		  User savedObj = userRepo.save(user);
	      return savedObj.getUserId()!= null;
	
	 }
	
	private String passwordGenerator() {
		char[] password = new char[5];
		String alphaNumeric = "ABCDEFGHabcdefgh123456789";
		Random randomPwd = new Random();
		for(int i=0; i<5; i++)
		{
			password[i] = alphaNumeric.charAt(randomPwd.nextInt(alphaNumeric.length()));
		}
	    System.out.println(password.toString());
	    return password.toString();
	}
	@Override
	public String loginCheck(String email, String pwd) {
	 User userDetails = userRepo.findByEmailIdAndPassword(email, pwd);
	 if(userDetails != null) {
		 if(userDetails.getAccStatus().equals("LOCKED")) {
			 return "ACCOUNT_LOCKED";
		 }else
		 {
			return "LOGIN_SUCCESS"; 
		 }
	 }
		return "INVALID_CREDENTIALS";
	}

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
	   User userDetails = userRepo.findByEmailIdAndPassword(email,tempPwd);
		return userDetails.getUserId() != null;
	}

	@Override
	public boolean unlockAccount(String email, String newPwd) {
	    User userDetails = userRepo.findByEmailId(email);
	    userDetails.setPassword(newPwd);
	    userDetails.setAccStatus("UNLOCK");
	    try {
	    	userRepo.save(userDetails);
	    	return true;
       }
	    catch(Exception e)
	    {
	       e.printStackTrace();
	       return false;
	    }
	}
	@Override
	public String forgotPassword(String email) {
		User userDetails = userRepo.findByEmailId(email);
		if(userDetails != null)
		{
			return userDetails.getPassword();
		}
		
		return null;
	}

	@Override
	public User get(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
