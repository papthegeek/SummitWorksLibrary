package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;
import java.sql.PreparedStatement;
import pack.Member;
/**
 * Servlet implementation class MemberRegistrationServlet
 */
@WebServlet("/MemberRegistrationServlet")
public class MemberRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("get there....");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		int nbBooks = Integer.parseInt(request.getParameter("nbBooks"));
		int memberId = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY?useSSL=false","root", "pass");
			String query = "insert into members (lastName, firstName, address, NumberOfBooks) values('"+lastName+"','"+firstName+"','"+address+"','"+nbBooks+"')";
			PreparedStatement st  = (PreparedStatement) con.prepareStatement(query);
      	    st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
      	    ResultSet rs = st.getGeneratedKeys();
  	       
      	  System.out.println("get there2....");
      	    if (rs != null && rs.next()) {
	       memberId = rs.getInt(1);
	      }
  	      st.close();
		  con.close();
			Member member = new Member();
			member.setId(memberId);
			member.setLastname(lastName);
			member.setFirstname(firstName);
			member.setAddress(address);
			member.setNbBooks(nbBooks);
			
			request.setAttribute("member", member);
			RequestDispatcher rd=request.getRequestDispatcher("/RegistrationConfirmation.jsp");
			rd.forward(request, response);

		
		}
		catch (Exception e)
		{
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
