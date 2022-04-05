
package org.rp.assignment23;

import java.util.Objects;

public class Bank {

	long accountNo;
	String fname;
	String lname;
	String branchName;
	String address;
	String bankName;
	
	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	public Bank(long accountNo, String fname, String lname,String bankName, String branchName, String address) {
		this.accountNo = accountNo;
		this.fname = fname;
		this.lname = lname;
		this.bankName = bankName;
		this.branchName = branchName;
		this.address = address;
	}
	
	

	public String getBranchName() {
		return branchName;
	}



	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}




	@Override
	public int hashCode() {
		return Objects.hash(accountNo);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return accountNo == other.accountNo;
	}



	@Override
	public String toString() {
		return "Bank [accountNo=" + accountNo + ", fname=" + fname + ", lname=" + lname + ", branchName=" + branchName
				+ ", address=" + address + "]";
	}
	
	
}
