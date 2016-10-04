package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;

/**
 * Servlet implementation class ExtendServlet
 */
@WebServlet("/ExtendServlet")
public class ExtendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int transactionId = Integer.parseInt(request.getParameter("transactionId"));
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		System.out.println("ExtendServlet prints member id..."+memberId);
		System.out.println("ExtendServlet prints Transaction id..."+transactionId);
		String date = request.getParameter("dueDate");
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY?useSSL=false","root", "pass");
		con.setAutoCommit(false);
		PreparedStatement pst =(PreparedStatement) con.prepareStatement("UPDATE RECORD SET DUEDATE ='"+date+"' WHERE TRANSACTIONID="+transactionId);
		int r = pst.executeUpdate();
		con.commit();

		}
		catch (Exception e)
		{
		}
		request.setAttribute("memberId",memberId);
		RequestDispatcher rd=request.getRequestDispatcher("/DisplayTransactionServlet");
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
