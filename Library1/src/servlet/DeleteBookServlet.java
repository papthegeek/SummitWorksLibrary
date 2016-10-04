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

import pack.Book;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		String id = request.getParameter("id");
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY?useSSL=false","root", "pass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM BOOKS WHERE BOOK_ID="+id);

		if(rs.next())
		{
			book.setId(Integer.parseInt(id));
			book.setTitle(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setPublisher(rs.getString(4));
			book.setPublishedDate(rs.getString(5));
			book.setTheme(rs.getString(6));
			book.setNbPages(rs.getInt(7));
			book.setTotal(rs.getInt(8));
			book.setAvailable(rs.getInt(9));
		}
		else{
			// handle that case
		}
	
		}
		catch (Exception e)
		{
		}
		request.setAttribute("book", book);
		RequestDispatcher rd=request.getRequestDispatcher("/DeleteBookConfirmation.jsp");
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
