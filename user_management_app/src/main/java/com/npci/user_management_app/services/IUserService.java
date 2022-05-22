package com.npci.user_management_app.services;

import java.text.ParseException;
import java.util.List;

import com.npci.user_management_app.entity.User;

public interface IUserService {

	public String saveUserDetails(User user) throws ParseException;

	public User updateUserDetails(User user);

	public User updateDateOfBith(User user);

	public void deleteUser(Integer userId);

	public User getUserDetailsById(Integer userId);

	public List<User> getUserByNameCompany(String firstName, String company);

	public List<User> getAllUsers();

}
