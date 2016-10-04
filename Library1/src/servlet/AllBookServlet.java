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

import pack.Book;

/**
 * Servlet implementation class AllBookServlet
 */
@WebServlet("/AllBookServlet")
public class AllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Book> bookList = new ArrayList<Book>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY?useSSL=false","root", "pass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM BOOKS ");
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPublishedDate(rs.getString(5));
				book.setTheme(rs.getString(6));
				book.setNbPages(rs.getInt(7));
				book.setImage(rs.getString(8));
				book.setLink(rs.getString(9));
				book.setTotal(rs.getInt(10));
				book.setAvailable(rs.getInt(11));


				bookList.add(book);
			}
			rs.close();
			st.close();
			//con.close();
			request.setAttribute("bookList", bookList);
			RequestDispatcher rd=request.getRequestDispatcher("/AllBooks.jsp");
			rd.forward(request, response);
			
		}catch (Exception e) {
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
