
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/login.css" />
</head>
<body>

<%@include file="header.jsp"%>

<section>
    <h2>Welcome to LapZone!Please login.</h2>
    <div>
        <form action="user-logins" method="post">
            <label for="email">Username</label> <br>
            <input placeholder="Your Username" type="text" id="email" name="login-username" class="form" required><br>
            <label for="password">Password</label><br>
            <input placeholder="Your password" type="password" id="password" name="login-password" class="form" required><br>
            <button type="submit" id="login"> LOGIN</button>
        </form>
    </div>
</section>

<%@include file="footer.jsp"%>
</body>
</html>