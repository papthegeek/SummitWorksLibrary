<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>

  <div align="center" style="height: 20px; width: 1100px"></div>
  		<form action = "Homepage.jsp"  method = "post">
			<INPUT align="left" TYPE="submit" VALUE="HOME" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >
		</form>
	</div>
	
<form action = "loginServlet"  method = "get">

  <div class="container">
  <h4 align="center"  style="height: 50px; width:1100px;color: highlighttext;font:xx-large;font-size:xx-large; color:maroon; font-style:oblique; font-family:cursive;"><big>Welcome to SummitWorks Library</big></h4><br><br>
  
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="user" style= "background:highlight; color:maroon; font-style:oblique; font-family:cursive;">

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="pwd" style= "background:highlight; color:maroon; font-style:oblique; font-family:cursive;">

    <button style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;"  type="submit">Login</button>
  </div>
  

</form>
</body>
</html>