package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String transactionId = request.getParameter("transactionId");
		//int memId = Integer.parseInt(request.getParameter("memId"));
		
		System.out.println("ReturnBookServlet Prints transactionID: " + transactionId);
		//System.out.println("ReturnBookServlet Prints memberID: " + memId);	
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY?useSSL=false","root", "pass");
			con.setAutoCommit(false);
		
			
			PreparedStatement pst = con.prepareStatement("select ReferenceId, memberId  from record where transactionId= ?"); 
			pst.setInt(1, Integer.parseInt(transactionId));
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();
			
	
			if(rs.next()){
				con.commit();
				int refId = rs.getInt(1);
				int memberId = rs.getInt(2);
				//memId = memberId;
				System.out.println("The Reference Id is : " + rs.getInt(1));
				System.out.println("The MemberId Id is : " + rs.getInt(2));
				pst = con.prepareStatement("delete from record where transactionId= ? ");
				pst.setInt(1, Integer.parseInt(transactionId));
				int x = pst.executeUpdate();
				if (x > 0 ){
					con.commit();
					System.out.println("The Record has been successfully Deleted");
					pst = con.prepareStatement("update books set Available = Available+1 where book_Id=?");
					pst.setInt(1, refId);
					x = pst.executeUpdate();
					if (x > 0 ){
						con.commit();
						System.out.println("The Book Availability Record has been successfully Updated");
					}
					pst = con.prepareStatement("update members set numberofbooks = numberofbooks-1 where memberId=?");
					pst.setInt(1, memberId);
					x = pst.executeUpdate();
					if (x > 0 ){
						con.commit();
						System.out.println("The Member NumberOfBooks Record has been successfully Updated");
					}	
					
				}
				
				
				System.out.println("Hello from ReturnBookSrvlet Ending");
				request.setAttribute("memberId",memberId);
			RequestDispatcher r =	request.getRequestDispatcher("/DisplayTransactionServlet");
			r.forward(request, response);
				
			}
			
			
			else {
				System.out.println("Retrieving Member Id and Reference Id is uncessful");
			}	
			
			
			
			
		} catch (Exception e) {
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
