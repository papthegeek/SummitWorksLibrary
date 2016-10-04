package servlet;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class BorrowBookServlet
 */
@WebServlet("/BorrowBookServlet")
public class BorrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memberId =  Integer.parseInt(request.getParameter("memberId"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String borrowedDate = request.getParameter("borrowedDate");
		String dueDate = request.getParameter("dueDate");
		String title = request.getParameter("title");
		  try
          {
        	  Class.forName("com.mysql.jdbc.Driver");
        	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY?useSSL=false","root", "pass");
        	  con.setAutoCommit(false);
        	  Statement st = con.createStatement();
        	  String req = "insert into record (referenceId,memberId, borrowedDate, dueDate, referenceTitle) "
        			  +"values ("+bookId+","+memberId+","+"\'"+borrowedDate+"\',"+"\'"+dueDate+"\',"+"\'"+title+"\')";
        	  st.execute(req);
              con.commit();
              
              Statement st2 = con.createStatement();
        	  String req2 = "update members set numberOfBooks = numberOfBooks + 1 where memberId ="+memberId;
        	  st.execute(req);
              con.commit();
              
              Statement st3 = con.createStatement();
        	  String req3 = "update Books set Available = Available - 1 where book_Id ="+bookId;
        	  st.execute(req);
              con.commit();
        	  
  			st.close();
  			con.close();
  			
  			request.setAttribute("id", bookId);
  			RequestDispatcher rd = request.getRequestDispatcher("/BorrowConfirmation.jsp");
  			rd.forward(request, response);
  			
  			
        	  
          }
          catch (Exception e){
        	  e.printStackTrace();
        	  
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
