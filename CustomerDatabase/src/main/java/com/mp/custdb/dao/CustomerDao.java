package com.mp.custdb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mp.custdb.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
