<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="pack.Book"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Books</title>



</head>
<body>

<div align="center" style="height: 50px; width: 1100px">

	<h3 align="right" style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">${LibInCharge.getFirstname()} ${LibInCharge.getLastname()}</h3>
	<form align="right" name="form1" method="post" action="${pageContext.request.contextPath}/login.jsp">
  		<label>
  				<input name="submit2" type="submit" id="submit2" value="log out" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;">
  		</label>
	</form>
</div>

	<div align="center"  >
 		<h4 align="center"  style="height: 50px; width:1100px;color: highlighttext;font:xx-large;font-size:xx-large; color:maroon; font-style:oblique; font-family:cursive;"><big>SUMMITWORK LIBRARY</big></h4>
	</div>
      
            
	<div align="center" style=" height: 50px;width: 1250px" >
		<form name="Form" method="post" >
		
        	<INPUT align="left" type="text" placeholder="Title/Author/Theme" name="search" style= "width:10cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;">
       		<INPUT onclick="Form.action='SearchBookServlet?caller=AllBooks.jsp';" align="left" TYPE="submit" VALUE="SEARCH" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >
       		
        	<INPUT onclick="Form.action='login.jsp?'caller=AllBooks.jsp;" align="right" TYPE="submit" VALUE="LOGIN"  style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" > 
        </form>
    </div>
	
	<div align="center" style=" height: 50px;width: 1250px" ></div>
	


<%
	ArrayList<Book> bookList=(ArrayList<Book>)request.getAttribute("bookList");
%>	

<div align="center"  height: 50px;width: 1250px" >
<table style=" background-color: highlight;" align="center" border="1" cellspacing="2" cellpadding="2" width="100%" >

<tr >

<th style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Edit </th> 
<th style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Book ID</th>
<th style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Title</th>
<th style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Author</th>
<th style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Editor</th>
<th style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Published Date</th>
<th style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Theme</th>
<th style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Number of Pages</th>
<th style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Total</th>
<th style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Total Available</th>


</tr>

<!-- JSP  Scriptlet Code -->
<form action = "AllBooks.jsp" method = "get" > 
<%

request.setAttribute("search" ,request.getParameter("search"));
System.out.println("The Search Item in AllBook.jsp is: " +request.getParameter("search"));
for(Book book:bookList){

%>

<tr>
	<td><input type = "radio" name = "select" value = <%=book.getId()%>></td>
	<td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%=book.getId()%></td>
	<td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">
	 	<a href=<%= "\"BookDisplay.jsp?link=" + book.getTitle() + "&author=" + book.getAuthor() + "&editor=" + book.getPublisher() + "&published=" + book.getPublishedDate() + "&theme=" + book.getTheme() + "&dispatcher=" + request.getRequestURL().substring(31) + "&search=" + request.getParameter("search") + "\"" %> ><%=book.getTitle()%></a></td>
	<td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%=book.getAuthor() %></td>
	<td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%=book.getPublisher() %></td>
	<td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%=book.getPublishedDate() %></td>
	<td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%=book.getTheme() %></td>
	<td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%=book.getNbPages() %></td>
	<td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%=book.getTotal() %></td>
	<td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%=book.getAvailable() %></td>
</tr>
<%} %>


</table>

<br><br>

<INPUT onclick="Form.action='SearchBookServlet';" align="left" TYPE="submit" VALUE="DELETE" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >
<INPUT onclick="Form.action='SearchBookServlet';" align="left" TYPE="submit" VALUE="EDIT" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >
</form >
</div>
</body>
</html>