package org.ekartapp.springcore.prac.dao;

import org.ekartapp.springcore.prac.model.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EkartDao extends JpaRepository<OrderTable,Integer> {

}
