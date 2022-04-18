package org.sujitmaity.SQLApplication.DataBase.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sujitmaity.SQLApplication.DataBase.Entitys.EmployeeEntitys;

public interface EmployeeDAO extends JpaRepository<EmployeeEntitys, Integer>{

}
