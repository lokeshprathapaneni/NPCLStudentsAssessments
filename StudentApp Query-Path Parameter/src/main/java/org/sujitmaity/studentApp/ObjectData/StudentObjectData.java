package org.sujitmaity.studentApp.ObjectData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentObjectData {
	//@JsonProperty(value = "studentId")
	Integer stdId;
	String stdName;
	String stdDept;
	
	//Constructor with Parameters
	public StudentObjectData(Integer stdId, String stdName, String stdDept) {
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdDept = stdDept;
	}
	//Constructor without Parameters
	public StudentObjectData() {
		super();
	}

	
//Getters and Setters
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdDept() {
		return stdDept;
	}
	public void setStdDept(String stdDept) {
		this.stdDept = stdDept;
	}
	
	@Override
	public String toString() {
		return "StudentObjectData [stdId=" + stdId + ", stdName=" + stdName + ", stdDept=" + stdDept + "]";
	}
	
	
	
	
	
	

}
