<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JDBC Registration Example</title>
<script type="text/javascript">
	function validateForm(){
		var empId = document.getElementById("id").value;
		if(empId == ""){
			alert("Please enter the Id");
			return false;
		}


</script>

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
<form action="DeleteMemberServlet" method="get" onsubmit="return validateForm()">

<table align="center" border="2" cellspacing="2" cellpadding="2" width="40%">

<tr align="center"><td colspan="2" ><h2>Deleting a Member</h2></td></tr>

<tr><td width="10%">Member Id :</td><td width="30%"><input type="text" name="id" id="id"></td></tr>


<tr align="center"><td colspan="2" ><input type="submit" value="Display and Delete"></td></tr>

</table>
</form>
</body>
</html>