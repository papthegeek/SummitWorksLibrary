<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="pack.Book"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Book book=(Book)request.getAttribute("book");
%>
<div align="center" style="height: 50px; width: 1100px">

	<h3 align="right" style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">${LibInCharge.getFirstname()} ${LibInCharge.getLastname()}</h3>
	<form align="right" name="form1" method="post" action="${pageContext.request.contextPath}/login.jsp">
  		<label>
  				<input name="submit2" type="submit" id="submit2" value="log out" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;">
  		</label>
	</form>
</div>



</br>
<form action="/Library1/EmployeeHome.jsp" method="post">

<table align="center" border="2" cellspacing="2" cellpadding="2" width="40%">

<tr align="center"><td colspan="2" ><h2>New Book Added Successfully</h2></td></tr>

<tr><td>Book ID :</td><td><%=book.getId()%></td></tr>

<tr><td>Title :</td><td><%=book.getTitle()%></td></tr>

<tr><td>Author :</td><td><%=book.getAuthor()%></td></tr>

<tr><td>Publisher :</td><td><%=book.getPublisher()%></td></tr>

<tr><td>Published Date :</td><td><%=book.getPublishedDate()%></td></tr>
<tr><td>Theme :</td><td><%=book.getTheme()%></td></tr>

<tr><td>Number Of Pages :</td><td><%=book.getNbPages()%></td></tr>

<tr><td>Total :</td><td><%=book.getNbExample()%></td></tr>

<tr><td>Nb Available :</td><td><%=book.getNbAvailable()%></td></tr>

<tr align="center"><td colspan="2" ><input type="submit" value="Home Page"></td></tr>

</table>
</form>
</body>
</html>