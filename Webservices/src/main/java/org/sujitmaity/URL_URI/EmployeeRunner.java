package org.sujitmaity.URL_URI;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRunner implements ApplicationRunner{
private Map<Integer,String> emp = new HashMap<>();

public Map<Integer, String> getEmp() {
	return emp;
}

public void setEmp(Map<Integer, String> emp) {
	this.emp = emp;
}

@Override
public void run(ApplicationArguments args) throws Exception {
	emp.put(101, "Sujit");
	emp.put(102, "Saif");
	emp.put(103, "Ram");
}



}
