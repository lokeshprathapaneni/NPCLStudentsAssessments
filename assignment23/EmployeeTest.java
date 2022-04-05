package org.rp.assignment23;

import java.util.Comparator;
import java.util.TreeSet;

public class EmployeeTest {

	public static void main(String[] args) {
//		TreeSet<Employee> hs = new TreeSet<>(new EmployeeIdComparator());
//		hs.add(new Employee(101, "Ron", "Operations", "IT"));
//		hs.add(new Employee(102, "Son", "Management", "IT"));
//		hs.add(new Employee(103, "Gon", "Production", "IT"));
//		hs.add(new Employee(104, "Non", "Testing", "IT"));
//		
//		System.out.println(hs);
		 
		
		//AIC
//		TreeSet<Employee> hs1 = new TreeSet<>(new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				Integer id = o1.getId();
//				Integer id1 = o2.getId();
//				
//				return id.compareTo(id1);
//			}
//		});
//		hs1.add(new Employee(105, "Ron", "Operations", "IT"));
//		hs1.add(new Employee(102, "Son", "Management", "IT"));
//		hs1.add(new Employee(103, "Gon", "Production", "IT"));
//		hs1.add(new Employee(104, "Non", "Testing", "IT"));
//		
//		System.out.println(hs1);
		
		//Lambda
		TreeSet<Employee> hs1 = new TreeSet<>((Employee o1, Employee o2)-> {
				Integer id = o1.getId();
				Integer id1 = o2.getId();
				return id.compareTo(id1);
		});
		hs1.add(new Employee(105, "Ron", "Operations", "IT"));
		hs1.add(new Employee(102, "Son", "Management", "IT"));
		hs1.add(new Employee(103, "Gon", "Production", "IT"));
		hs1.add(new Employee(104, "Non", "Testing", "IT"));
		
		System.out.println(hs1);
		
	}
}
