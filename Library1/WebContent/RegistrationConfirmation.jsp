<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="pack.Member"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SummitWorks Library</title>
</head>
<body>
<%
	Member member=(Member)request.getAttribute("member");
	System.out.println("get there2 the confirmation jsp ....");
%>

	<div align="center" style="height: 50px; width: 1100px">

	<h3 align="right" style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">${LibInCharge.getFirstname()} ${LibInCharge.getLastname()}</h3>
	<form align="right" name="form1" method="post" action="${pageContext.request.contextPath}/login.jsp">
  		<label>
  				<input name="submit2" type="submit" id="submit2" value="log out" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;">
  		</label>
	</form>
</div><form align="right" name="form1" method="post" action="login.jsp">
  		<label>
  				<input name="submit2" type="submit" id="submit2" value="log out" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;">
  		</label>
	</form>	
	


</br>
<form action="/Library1/EmployeeHome.jsp" method="post">

	<table style=" background-color: highlight;" align="center" border="2" cellspacing="2" cellpadding="2" width="40%">

		<tr align="center"><td colspan="2" ><h2 style="color: highlighttext; color:maroon; font-style:oblique;">Registration Succesful</h2></td></tr>
		<tr><td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Member ID :</td><td style="color: highlighttext; color:maroon; font-style:oblique;"><%=member.getId()%></td></tr>
		<tr><td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Last Name :</td><td style="color: highlighttext; color:maroon; font-style:oblique;"><%=member.getLastname()%></td></tr>
		<tr><td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">First Name :</td><td style="color: highlighttext; color:maroon; font-style:oblique;"><%=member.getFirstname()%></td></tr>
		<tr><td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Address :</td><td style="color: highlighttext; color:maroon; font-style:oblique;"><%=member.getAddress()%></td></tr>
		<tr><td style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Number of Books :</td><td style="color: highlighttext; color:maroon; font-style:oblique;"><%=member.getNbBooks()%></td></tr>
		<tr align="center"><td colspan="2" >
		<br><br>
		<INPUT align="left" TYPE="submit" VALUE="HOME" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >

	</table>
</form>


</body>
</html>