package org.rp.assignment23;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
	
	int id;
	String name;
	String branch;
	String department;
	
	
	
	
	public Employee(int id, String name, String branch, String department) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.department = department;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(branch, department, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(branch, other.branch) && Objects.equals(department, other.department) && id == other.id
				&& Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", branch=" + branch + ", department=" + department + "]";
	}


	@Override
	public int compareTo(Employee o) {
		
		String name = this.getName();
		String name1 = o.getName();
		return name.compareTo(name1);
	}

}
