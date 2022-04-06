package npci_assgns_assgn1;

import java.util.Objects;

public class Bank {

	private int accountNo;
	private String fName;
	private String lName;
	private String branchName;
	private String address;

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Bank(int accountNo, String fName, String lName, String branchName, String address) {
		super();
		this.accountNo = accountNo;
		this.fName = fName;
		this.lName = lName;
		this.branchName = branchName;
		this.address = address;
	}

	public Bank() {
	}

	@Override
	public String toString() {
		return "Bank [accountNo=" + accountNo + ", fName=" + fName + ", lName=" + lName + ", branchName=" + branchName
				+ ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNo, address, branchName, fName, lName);
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
		return accountNo == other.accountNo && Objects.equals(address, other.address)
				&& Objects.equals(branchName, other.branchName) && Objects.equals(fName, other.fName)
				&& Objects.equals(lName, other.lName);
	}

}
