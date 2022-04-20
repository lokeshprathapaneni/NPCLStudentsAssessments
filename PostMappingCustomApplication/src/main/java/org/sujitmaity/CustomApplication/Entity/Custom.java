package org.sujitmaity.CustomApplication.Entity;

import java.util.List;

public class Custom {
	Integer cusId;
	String cusName;
	String cusDept;
	
	public Custom() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Custom [cusId=" + cusId + ", cusName=" + cusName + ", cusDept=" + cusDept + "]";
	}
	public Custom(Integer cusId, String cusName, String cusDept) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusDept = cusDept;
	}
	public Integer getCusId() {
		return cusId;
	}
	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusDept() {
		return cusDept;
	}
	public void setCusDept(String cusDept) {
		this.cusDept = cusDept;
	}
	
	

	

}
