package com.mp.custdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mp.custdb.dao.CustomerDao;
import com.mp.custdb.entity.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerDBController {

	@Autowired
	CustomerDao custDao;
	
	@GetMapping("/cust/{custId}")
	public Customer getCustDetails(@PathVariable("custId") Integer custId) {
		Optional<Customer> custRecord = custDao.findById(custId);
		return custRecord.get();
	}
	
	@PostMapping("/save")
	public String setCustDetails(@RequestBody Customer cust) {
		Customer c = custDao.save(cust);
		return c.getCustName()+" added successfully";
	}
	
	@DeleteMapping("/delete")
	public String delCustDetails(@RequestBody Customer cust) {
		custDao.delete(cust);
		return cust.getCustName()+" deleted successfully";
	}
	
	@GetMapping("allcustomer")
	public List<Customer> getAll() {
		return custDao.findAll();
	}
}
