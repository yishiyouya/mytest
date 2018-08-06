package imageBinary;


import java.io.Serializable;

public class IdCardBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -390772398080594756L;
	private String name;//	姓名		
	private String gender;//	性别	0女 1 男
	private String birthDate;//	生日		
	private String idNo; //身份证号
	private String issuedBy;//	签发机关		
	private String validThru;//	有效日期
	public IdCardBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public IdCardBean(String name, String gender, String birthDate, String idNo, String issuedBy, String validThru) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.idNo = idNo;
		this.issuedBy = issuedBy;
		this.validThru = validThru;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getIssuedBy() {
		return issuedBy;
	}


	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}


	public String getValidThru() {
		return validThru;
	}


	public void setValidThru(String validThru) {
		this.validThru = validThru;
	}


	@Override
	public String toString() {
		return "IdCardBean [name=" + name + ", gender=" + gender + ", birthDate=" + birthDate + ", idNo=" + idNo
				+ ", issuedBy=" + issuedBy + ", validThru=" + validThru + "]";
	}

	public boolean equals(IdCardBean icb) {
		return  this.name.equals(icb.getName()) && 
				this.gender.equals(icb.getGender()) && 
				this.birthDate.equals(icb.getBirthDate()) && 
				this.idNo.equals(icb.getIdNo());
	}
}
