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

	<div align="center" style="height: 20px; width: 1100px"></div>
	<%
		String disp = "SearchBookServlet?search=" +request.getParameter("search") + "&caller=" + request.getParameter("dispatcher") +";\"";
		
		System.out.println("The request dispatcher is: " +request.getParameter("dispatcher"));
		System.out.println("The Search Item in BookDisplay is: " +request.getParameter("search"));
	%>

	<form action =<%=disp%>  method = "post">
		<INPUT align="left" TYPE="submit" VALUE="BACK" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >
	</form>		


	<div align="center" style="height: 20px; width: 1100px"></div>



	<div style="height: 520px; width: 1100px">
		<img align="left" style=" height: 500px ; width:350px"  src=<%=  "\"Images/" +request.getParameter("link") + ".jpg" + "\""  %> />
		
		
		<div align="justify"  > <p>&#160;</p>
			
			<h2 align="justify" style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%= request.getParameter("link") %> </h2>
			<p>&#160;</p>
			<h2  style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%= request.getParameter("author") %> </h2>
			<p>&nbsp;</p>
			<h2  style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%= request.getParameter("editor") %> </h2>
			<p>&nbsp;</p>
			<h2  style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%= request.getParameter("published") %> </h2>
			<p>&nbsp;</p>
			<h2  style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%= request.getParameter("theme") %> </h2>
			<p>&nbsp;</p>
			<h2  style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;"><%= request.getParameter("link") %> </h2>
		</div>


	</div>


</body>
</html>