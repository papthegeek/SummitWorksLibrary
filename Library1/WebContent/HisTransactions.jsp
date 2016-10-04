<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="pack.Transaction"%>
<%@page import="java.util.ArrayList"%>
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
<%
	ArrayList<Transaction> transactionList=(ArrayList<Transaction>)request.getAttribute("transactionList");
%>	
<table align="center" border="1" cellspacing="2" cellpadding="2" width="100%">
<caption><h2>Transaction List </h2>(Total Transactions: <%=transactionList.size()%>) : <%=session.getId() %></caption>

<tr >
<th>Edit </th> 
<th>MemberId </th> 
<th>Title </th> 
<th>Borrowed Date</th>
<th>Due Date</th>

</tr>

<form name = "Form" method = "get" > 
<%
//System.out.println("HisTransaction.jsp prints ...."+id);
for(Transaction transaction:transactionList){
%>
<tr>

<td><input type = "radio" name = "transactionId" value = <%=transaction.getId()%>></td>
<td><%=transaction.getMemberId()%></td>
<td><%=transaction.getTitle()%></td>
<td><%=transaction.getBorrowedDate()%></td>
<td><%=transaction.getDueDate() %></td>
</tr>
<%} %>
           <input type="hidden" name="memberId" value="<%=request.getAttribute("memberId")%>" style="height: 0cm; width: 0cm;">
       		<INPUT onclick="Form.action='ReturnBook';" align="buttom" TYPE="submit" VALUE="Return" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >
        	<INPUT onclick="Form.action='ExtendView.jsp';" align="right" TYPE="submit" VALUE="Extend"  style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" > 
        	<INPUT onclick="Form.action='GetInfoBorrow.jsp';" align="right" TYPE="submit" VALUE="Borrow"  style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >
<% System.out.println("HisTransaction prints memberID :"+request.getAttribute("memberId")); %>
</form >
</table>
<div align="center" style="height: 30px; width: 1150px; "></div>

	<div align="center" style="height: 30px; width: 1150px; ">
		<form action="EmployeeHome.jsp"  method = "post">
			<INPUT align="center" TYPE="submit" VALUE="Home" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >
		</form>	
	</div>
</body>
</html>