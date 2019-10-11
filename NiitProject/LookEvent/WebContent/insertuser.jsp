<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.Login.UserLoginDetails, com.Login.UserLoginDetailsDao1,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="e" class="com.Login.UserLoginDetails"></jsp:useBean>
<jsp:setProperty property="*" name="e" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This Is User SignUp</title>
</head>
<body>
	<%
		int i = UserLoginDetailsDao1.insertdetails(e);
		if (i > 0) {
			response.sendRedirect("UserAdded.jsp");
		} else {
			response.sendRedirect("UserAdding_error.jsp");
		}
	%>
</body>
</html>
