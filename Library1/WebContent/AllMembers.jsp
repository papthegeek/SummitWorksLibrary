<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="pack.Member"%>
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
<div align="center" style="height: 20px; width: 1100px"></div>

	<div align="center"  >
 		<h4 align="center"  style="height: 50px; width:1100px;color: highlighttext;font:xx-large;font-size:xx-large; color:maroon; font-style:oblique; font-family:cursive;"><big>SUMMITWORK LIBRARY</big></h4>
	</div>

          
            
	<div align="center" style=" height: 50px;width: 1250px" >
		<form name="Form" method="post" >
		<input type="hidden" name="caller" value="GeneralSearch.jsp" style="height: 0cm; width: 0cm;">
        	<INPUT align="left" type="text" placeholder="Title/Author/Theme" name="search" style= "width:10cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;">
       		<INPUT onclick="Form.action='SearchBookServlet';" align="left" TYPE="submit" VALUE="SEARCH" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >
       		
        	<INPUT onclick="Form.action='login.jsp';" align="right" TYPE="submit" VALUE="LOGIN"  style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" > 
        </form>
    </div>
	
	<div align="center" style=" height: 50px;width: 1250px" ></div>


<%
	ArrayList<Member> memberList=(ArrayList<Member>)request.getAttribute("memberList");
%>	
<table style=" background-color: highlight;" align="center" border="1" cellspacing="2" cellpadding="2" width="100%" >
<!-- <caption><h2>Member List </h2>(Total Members: <%=memberList.size()%>) : <%=session.getId() %></caption> -->

<tr >
<th>Edit </th> 
<th>Member ID</th>
<th>LastName</th>
<th>FirstName</th>
<th>Address</th>
<th>Number Of Books</th>
</tr>

<form action = "DeleteMemberServlet" method = "post" > 
<%
for(Member member:memberList){
%>
<tr>
<td><input type = "radio" name = "id" value = <%=member.getId()%>></td>
<td><%=member.getId()%></td>
<td><%=member.getLastname()%></td>
<td><%=member.getFirstname()%></td>
<td><%=member.getAddress() %></td>
<td><%=member.getNbBooks() %></td>
</tr>
<%} %>


</table>
<div align="center" style=" height: 20px;width: 1250px"></div>
<div align="center" style=" height: 10px;width: 1250px">
	<INPUT align="center" TYPE="submit" VALUE="Delete" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >
	
</div>
</form >
</body>
</html>