package org.rp.assignment23;

import java.util.Comparator;

public class EmployeeIdComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		Integer id = o1.getId();
		Integer id1 = o2.getId();
		
		return id.compareTo(id1);
	}

	
}
