package com.example.usermanagement.service;

import java.text.ParseException;
import java.util.List;

import com.example.usermanagement.entity.User;

public interface IUserManagementService {

 User setdetails(User user) throws ParseException;
 User updatedetails(User user);
 User updatedob(User user);
 String deletedetails(Integer id);
 User fetchdetails(Integer id);
 List<User> allusersby(String firstName, String company);
List<User> sortbyfname(String firstName);


}
