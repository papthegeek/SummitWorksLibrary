<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Infos Borrow</title>
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
</br>
<form action="BorrowBookServlet" method="post" >

<table align="center" border="2" cellspacing="2" cellpadding="2" width="40%">

<tr align="center"><td colspan="2" ><h2>Get Infos Borrow</h2></td></tr>
<tr><td>Member Id :</td><td><input value = "<%=request.getParameter("memberId") %>" type="text" name="memberId"></td></tr>


<tr><td>Scann Book Id :</td><td><input type="text" name="bookId"></td></tr>

<tr><td>Borrowed Date :</td><td><input type="text" name="borrowedDate"> </td></tr>

<tr><td>Due Date :</td><td> <input type="text" name="dueDate"></td></tr>
<tr><td>Title :</td><td> <input type="text" name="title"></td></tr>


<tr align="center"><td colspan="2" ><input type="submit" value="Borrow"></td></tr>

</table>
</form>
</body>
</html>