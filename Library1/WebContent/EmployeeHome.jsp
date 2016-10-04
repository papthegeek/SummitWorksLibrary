<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member Home Page</title>
</head>
<body>


<div align="center" style=" height: 50px;width: 1150px" >
	<h3 align="right" style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;">Welcome ${LibInCharge.getFirstname()} ${LibInCharge.getLastname()}</h3>
	<form align="right" name="form1" method="post" action="login.jsp">
  		<label>
  				<input name="submit2" type="submit" id="submit2" value="log out" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;">
  		</label>
	</form>
</div>


<div align="center" style=" height: 80px;width: 1250px" ></div>

	<form id="searhbutton" action = "/Library1/SearchBookServlet" method = "post" >
		<div align="center" style=" ; height: 50px;width: 1250px">
			<input type="hidden" name="caller" value="AllBooks.jsp" style="height: 0cm; width: 0cm;">
		
			<button type="submit" name = "button1" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;"  > Search </button>
			<input type = "text" name = "search" style= "width:10cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;">
		</div>
		<br><br>
		<div align="center" style=" ; height: 50px;width: 1250px">
			<h3><a style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;" href="MemberRegistrationForm.jsp"> Add New Member</a><br></h3>
			<h3><a style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;" href="DeleteMember.jsp"> Delete Member</a><br></h3>
			<h3><a style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;" href="AddNewBook.jsp"> Add New Book</a><br></h3>
			<h3><a style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;" href="MemberInfos.jsp"> Member Infos</a><br></h3>	
			<h3><a style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;" href="/Library1/AllMemberServlet"> All Members</a><br></h3>
			<h3><a style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;" href="Transaction.jsp"> Transactions</a><br></h3>
			<h3><a style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;" href="DeleteBookView.jsp"> Delete Book</a><br></h3>
			<h3><a style="color: highlighttext; color:maroon; font-style:oblique; font-family:cursive;" href="/Library1/AllBookServlet"> All Books</a><br></h3>
		</div>
	</form>

</body>
</html>