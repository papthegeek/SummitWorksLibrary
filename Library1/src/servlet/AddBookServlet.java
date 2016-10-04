package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//	int bookId = Integer.parseInt(request.getParameter("bookId"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String publishedDate = request.getParameter("publishedDate");
		String theme = request.getParameter("theme");
		int nbPages = Integer.parseInt(request.getParameter("nbPages"));
		int total = Integer.parseInt(request.getParameter("total"));
		int available = Integer.parseInt(request.getParameter("nbAvailable"));
		int bookId = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY?useSSL=false","root", "pass");
			String query = "insert into Books (title, author, publisher, publishedDate, theme, numberOfPages, total, available) "
					+"values('"+title+"','"+author+"','"+publisher+"','"+publishedDate+"','"+theme+"',"+nbPages+","+total+","+available+")";
			System.out.println(query);
			PreparedStatement st  = (PreparedStatement) con.prepareStatement(query);
			System.out.println("test11");
      	    st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
      	  System.out.println("test22");
      	    ResultSet rs = st.getGeneratedKeys();
  	       
      	    if (rs != null && rs.next()) {
	       bookId = rs.getInt(1);
	      }
  	      st.close();
		  con.close();
			Book book = new Book();
			book.setId(bookId);
			book.setAuthor(author);
			book.setAvailable(available);
			book.setNbAvailable(available);
			book.setNbExample(total);
			book.setTheme(theme);
			book.setNbPages(nbPages);
			book.setPublishedDate(publishedDate);
			book.setPublisher(publisher);
			
			request.setAttribute("book", book);
			RequestDispatcher rd=request.getRequestDispatcher("/AddBookConfirmation.jsp");
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
