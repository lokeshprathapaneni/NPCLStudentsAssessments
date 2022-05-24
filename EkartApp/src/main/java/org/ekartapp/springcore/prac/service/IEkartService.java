package org.ekartapp.springcore.prac.service;

import org.ekartapp.springcore.prac.model.OrderTable;


public interface IEkartService {
	
	OrderTable getProduct(Integer orderId);
	
	String createProduct(OrderTable orderTable);

}
