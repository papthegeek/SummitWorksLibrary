package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.Member;

/**
 * Servlet implementation class DeleteMemberServlet
 */
@WebServlet("/DeleteMemberServlet")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("in there....");
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY?useSSL=false","root", "pass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM MEMBERS WHERE MEMBERID="+id);

		if(rs.next())
		{
			member.setId(id);
			member.setLastname(rs.getString(2));
			member.setFirstname(rs.getString(3));
			member.setAddress(rs.getString(4));
			member.setNbBooks(rs.getInt(5));
		}
		else{
			// handle that case
		}
	
		}
		catch (Exception e)
		{
		}
		request.setAttribute("member", member);
		RequestDispatcher rd=request.getRequestDispatcher("/DeleteConfirmation.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
