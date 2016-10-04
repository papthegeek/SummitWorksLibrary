package pack;

import java.sql.Connection;
import java.util.Date;

public class Librarian extends PersonBean{
	private String username;
	private String password;
	
/*	public Librarian(String id, String ssn, String firstname, String lastname, String email, String phoneNumber,
			String address, String username, String password) {
		super(id, ssn, firstname, lastname, email, phoneNumber, address);
		this.password = password;
		this.username = username;
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
	public void addBook(Book book, Connection con)
	{
		
	}
	
	public void deleteBook(Book book, Connection con)
	{
		
	}

   public void addMember(Member m, Connection con)
   {
	   
   }
   public void deleteMember(String id, Connection con)
   {
	   
   }
   public void editMember(Member m, Connection con)
   {
	   
   }
   public int searchByTitle(String title, Connection con)
   {
	   return 0;// to be changed
   }
   public void booksDisplay(Connection con)
   {
	   
   }
   
}
