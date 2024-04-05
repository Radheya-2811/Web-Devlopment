<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>HomePage</title>
</head>

<body>
<% 
	//retrieve session object
	HttpSession session2=request.getSession(false);

	if(session2!=null && session2.getAttribute("username")!=null){
		String username=(String) session2.getAttribute("username");
	
%>
    <div class="cont">
         <h1>Welcome, <%= username%> !</h1>
         <p>We are glad to have you on our platform.</p>
         <h3>Thanks for connecting with us. Now you can enjoy our services</h3>
         <a href="logout.jsp">LOGOUT</a>
    </div>
<%
	} else{
		response.sendRedirect("login.jsp");
	}
%>    
</body>
</html>