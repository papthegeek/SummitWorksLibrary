package pack;



public class PersonBean {
	private int id;
	private String lastname;
	private String phonenumber;
	private String email;
	private String address;
	private String firstname;
    private String ssn;
    
/*	
    public PersonBean(String id,String ssn,String firstname,String lastname,String email,String phoneNumber,String address)
	{
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.phonenumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.ssn = ssn;
		
	}*/
    
    public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String display() {
		return "PersonBean [Id=" + id + ", firstname=" + firstname + ", ssn=" + ssn + "]";//to be completed
	}



}
