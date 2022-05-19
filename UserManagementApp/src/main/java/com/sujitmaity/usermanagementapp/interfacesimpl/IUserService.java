package com.sujitmaity.usermanagementapp.interfacesimpl;

import java.util.List;

import com.sujitmaity.usermanagementapp.userentity.User;

public interface IUserService {

	User getUser(Integer userId);

	String creatUser(User user1);

	String updateUser(User user2);

	String updateDateOfBirth(User user3);

	List<User> getfirstNameAndCompany(String firstName, String company);

	List<User> getAllUser(User user4);

	String deleteUserId(Integer userId);

}
