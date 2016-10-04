package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pack.Librarian;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// PrintWriter pw = response.getWriter();
		
		
		
		String userName = request.getParameter("user");   	//userName = "Admin2";
		String passWord = request.getParameter("pwd");		//passWord = "pass2";
		
		Librarian inCharge = new Librarian();				//System.out.println("Step1 ");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String getsomething = "CALL `LIBRARY`.`requestLogin`( ? , ?)";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "pass");
			CallableStatement cs = con.prepareCall(getsomething);
			
		
			cs.setString(1, userName);
			cs.setString(2, passWord);			//System.out.println("Step2 ");
			cs.execute();
			
			ResultSet rs = cs.getResultSet();
			
			
			
			if(rs.next()){
				System.out.println("Librarian with Id Number: " + rs.getInt(1)  + " has been successfully Logged In ");
				System.out.println("Librarian First Name: " + rs.getString(2)  + " has been successfully Logged In ");
				System.out.println("Librarian Last Name: " + rs.getString(3)  + " has been successfully Logged In ");
			
				//inCharge.setlIb(Integer.toString(rs.getInt(1)));
				inCharge.setFirstname(rs.getString(2));
				inCharge.setLastname(rs.getString(3));
				
				HttpSession session = request.getSession(true);
				
				session.setAttribute("LibInCharge", inCharge);
				
 				RequestDispatcher rd=request.getRequestDispatcher("/EmployeeHome.jsp");
				rd.forward(request, response);
				
			} else {
				System.out.println(" LOGIN FAILED: Username/Password Doesn't Exist!!!");
				RequestDispatcher rd=request.getRequestDispatcher("/LoginFailed.jsp");
				rd.forward(request, response);
			}
			cs.close();
			con.close();
			

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		doGet(request, response);
	}

}
