<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<form action="/Library1/ExtendServlet" method="get" onsubmit="return validateForm()">
<input type="hidden" name="transactionId" value="<%=request.getParameter("transactionId")%>" style="height: 0cm; width: 0cm;">
<input type="hidden" name="memberId" value="<%=request.getParameter("memberId")%>" style="height: 0cm; width: 0cm;">

<table align="center" border="2" cellspacing="2" cellpadding="2" width="40%">

<tr align="center"><td colspan="2" ><h2>Extending Due Date</h2></td></tr>

<tr><td width="10%">New Due Date :</td><td width="30%"><input type="text" name="dueDate" id="id"></td></tr>


<tr align="center"><td colspan="2" ><input type="submit" value="Extend"></td></tr>

</table>
</form>
</body>
</html>