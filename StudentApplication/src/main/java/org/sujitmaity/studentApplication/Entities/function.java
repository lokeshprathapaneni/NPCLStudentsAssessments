package org.sujitmaity.studentApplication.Entities;

public class function {
	private long id;
	private String name;
	private String dept;
	public function(long id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	public function() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "function [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	

}
