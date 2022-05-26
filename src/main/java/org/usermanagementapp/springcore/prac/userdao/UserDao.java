package org.usermanagementapp.springcore.prac.userdao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.usermanagementapp.springcore.prac.usermagnementmodel.User;


public interface UserDao extends JpaRepository<User,Integer> {
	
	public void deleteByUserId(Integer n1);
	
	public List<User> findByFirstNameAndUserCompany(String n2, String n3);
	
	
	


}
