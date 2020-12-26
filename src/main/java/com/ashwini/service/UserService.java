package com.ashwini.service;


import java.util.Map;

import com.ashwini.entity.User;

public interface UserService {
	
	//Registration Page Operations
	public Map<Integer, String> findCountries();
	public Map<Integer, String> findStates(Integer countryId);
	public Map<Integer, String> findCities(Integer stateId);
	public boolean saveUser(User user);
	
    //Login page operations
	
	public String loginCheck(String email,String pwd);
	
	//Unlock Account Operations
	
	public boolean isTempPwdValid(String email, String tempPwd);
	public boolean unlockAccount(String email, String newPwd);
	
	//Forgot Password Operations
	
	public String forgotPassword(String email);
    public User get ( Integer userid);
    public Integer delete(Integer userid);
	
	public boolean isEmailUnique(String emailId);
	
}
