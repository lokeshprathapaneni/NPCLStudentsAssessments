package orgAdmin.Springcore.Prac.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	@Id
	@Column(name="aId")
	Integer aId;
	
	@Column(name="aName")
	String aName;
	
	@Column(name="adeptName")
	String adeptName;
	
	@Column(name="address")
	String address;

	public Admin(Integer aId, String aName, String adeptName, String address) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.adeptName = adeptName;
		this.address = address;
	}
	
	

	public Admin() {
		super();
	}



	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getAdeptName() {
		return adeptName;
	}

	public void setAdeptName(String adeptName) {
		this.adeptName = adeptName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
