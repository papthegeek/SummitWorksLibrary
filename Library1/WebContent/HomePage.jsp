<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SubmitWorks Library</title>


</head>
<body>

<div align="center" style="height: 20px; width: 1100px"></div>



	<div align="center"  >
 		<h4 align="center"  style="height: 50px; width:1100px;color: highlighttext;font:xx-large;font-size:xx-large; color:maroon; font-style:oblique; font-family:cursive;"><big>SUMMITWORK LIBRARY</big></h4>
	</div>

	<%
      				String requestUrl = request.getRequestURI();
	         System.out.println(requestUrl);
      			%>
      			
          
            
	<div align="center" style=" height: 50px;width: 1250px" >
		<form name="Form" method="post" >
			<input type="hidden" name="caller" value="GeneralSearch.jsp" style="height: 0cm; width: 0cm;">
        	<INPUT align="left" type="text" placeholder="Title/Author/Theme" name="search" style= "width:10cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;">
       		<INPUT onclick="Form.action='SearchBookServlet';" align="left" TYPE="submit" VALUE="SEARCH" style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" >
       		
        	<INPUT onclick="Form.action='login.jsp';" align="right" TYPE="submit" VALUE="LOGIN"  style= " width:2cm; background:highlight; color:maroon; font-style:oblique; font-family:cursive;" > 
        </form>
    </div>
	
	<div align="center" style=" height: 50px;width: 1250px" ></div>
	
	<div align="center" style=" ; height: 500px;width: 1250px">
		<img style="height: 300px ; width:1100px" src="Images/banner.jpg" alt="banner"/>
	</div>

	<div align="center"  style=" position:relative; height: 500px;width: 1250px">
		
	
			<img style=" height: 320px ; width:200px"  src="Images/BraveNewWorld.jpg"/>


			<img style=" height: 320px ; width:200px"  src="Images/lolita.jpg" />

		
	
			<img style=" height: 320px ; width:200px"  src="Images/Catch-22.jpg" />
		
		
	</div>
	
	<div align="center" style="height: 400px; width: 1100px"></div>



</body>
</html>