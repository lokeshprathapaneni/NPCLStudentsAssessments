package org.npci.usermanagement.dao;

import java.util.List;

import org.npci.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserManagementDao extends JpaRepository<User, Integer> {

	public List<User> findByFirstNameAndCompany(String fname, String company);
}
