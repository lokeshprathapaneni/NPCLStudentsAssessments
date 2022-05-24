package org.ekartapp.springcore.prac.controller;

import org.ekartapp.springcore.prac.model.OrderTable;
import org.ekartapp.springcore.prac.service.IEkartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/id")
public class EkartController {
	
	@Autowired
	IEkartService iService;
	
	
	@GetMapping("/id1/{userId}")
	public ResponseEntity<OrderTable> getProduct(@PathVariable("userId") Integer orderId ) {
		OrderTable u1=iService.getProduct(orderId);
		
		return new ResponseEntity<OrderTable>(u1,HttpStatus.OK);
	}
	
	@PostMapping("uid2")
	@ResponseBody
	public ResponseEntity<String> createProduct(@RequestBody  OrderTable  orderTable) {
		  
		String u2=iService.createProduct(orderTable);
		return new ResponseEntity<String>(u2,HttpStatus.ACCEPTED);
	}

}
