<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogOut</title>
</head>
<body>
	<% 
	//retrieve session object
	HttpSession session3=request.getSession(false);
		if(session3!=null){
			session3.invalidate();
		}
	
		response.sendRedirect("index.html");
	
	
%>
</body>
</html>