package org.npci.usermanagement.service;

import java.util.List;

import org.npci.usermanagement.entity.User;

public interface IUserManagementService {

	User setDetails(User user);
	
	User allUpdate(User user);
	
	User updateDOB(User user);
	
	void delete(Integer id);
	
	User retrieve(Integer id);
	
	List<User> search(String fname, String company);
	
	List<User> byFName(String name);

}
