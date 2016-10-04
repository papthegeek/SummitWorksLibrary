package pack;

import java.sql.Connection;

public class Member extends PersonBean{
	
	private String username;
	private String password;
	private int nbBooks;
	
/*	public Member(String id, String ssn, String firstname, String lastname, String email, String phoneNumber,
			String address) {
		super(id, ssn, firstname, lastname, email, phoneNumber, address);
	}*/

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getNbBooks() {
		return nbBooks;
	}
	public void incNbBooks(Connection con) {
		this.nbBooks++;
	}
	
	public void setNbBooks(int nbBooks)
	{
		this.nbBooks = nbBooks;
	}
	
	 
	 public void borrowBook(String title)
	 {
		 
	 }
	 
	 public void returnBook(String title)
	 {
		 
	 }
	 

}
