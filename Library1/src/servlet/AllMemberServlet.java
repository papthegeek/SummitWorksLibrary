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
import pack.Member;

/**
 * Servlet implementation class AllMemberServlet
 */
@WebServlet("/AllMemberServlet")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ici1111");
		ArrayList<Member> memberList = new ArrayList<Member>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY?useSSL=false","root", "pass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM MEMBERS ");
			while (rs.next()) {
				Member member = new Member();
				member.setId(Integer.parseInt(rs.getString(1)));
				member.setLastname(rs.getString(2));
				member.setFirstname(rs.getString(3));
				member.setAddress(rs.getString(4));
				member.setNbBooks(rs.getInt(5));
				memberList.add(member);
			}
			rs.close();
			st.close();
			con.close();
			System.out.println("I Got her!!!!!!!!");
			request.setAttribute("memberList", memberList);
			RequestDispatcher rd=request.getRequestDispatcher("/AllMembers.jsp");
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
