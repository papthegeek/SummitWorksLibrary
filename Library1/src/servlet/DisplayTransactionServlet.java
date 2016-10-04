package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.Transaction;

/**
 * Servlet implementation class DisplayTransactionServlet
 */
@WebServlet("/DisplayTransactionServlet")
public class DisplayTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memberId = Integer.parseInt(request.getParameter("memberId"));
		System.out.println("DisplayTransactionServlet prints ...."+memberId);
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY?useSSL=false","root", "pass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM RECORD WHERE MEMBERID ="+memberId);
			while (rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setId(Integer.parseInt(rs.getString(1)));
				transaction.setReferenceId(Integer.parseInt(rs.getString(2)));
				transaction.setMemberId(Integer.parseInt(rs.getString(3)));
				transaction.setBorrowedDate(rs.getDate(4));
				transaction.setDueDate(rs.getDate(5));
				transaction.setTitle(rs.getString(6));
				
				
				transactionList.add(transaction);
			}
			rs.close();
			st.close();
			con.close();
			request.setAttribute("transactionList", transactionList);
			request.setAttribute("memberId", memberId);
			RequestDispatcher rd=request.getRequestDispatcher("/HisTransactions.jsp");
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
