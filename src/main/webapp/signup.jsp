<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/signup.css" />
</head>
<body>

<%@include file="header.jsp"%>
<section>
        <h2>Create Your Account!</h2>

        <div id="data">
            <form action="user-signups" method="post">
                <div id="nm" class="fnjc">
                    <div id="ne">
                        <label for="name"> Full Name </label><br>
                        <input placeholder="Please enter your name" type="text" id="name" name="fullname" class="form" required />
                    </div>
                    <div id="pe" class="pl">
                        <label for="mobilenumber">Phone Number</label><br>
                        <input placeholder="eg.9841002000" type="text" id="mobilenumber" name="phonenumber" class="form" required />
                    </div>
                </div>
                <div id="emlun" class="fnjc">
                    <div id="em">
                        <label for="email">Email</label><br>
                        <input placeholder="Your Email" type="email" id="email" name="email" class="form" required />
                    </div>
                    <div id="un">
                        <label for="name"> Username </label><br>
                        <input placeholder="Username" type="text" id="name" name="username" class="form" required />
                    </div>
                </div>
                <div id="pd" class="fnjc">
                    <div id="pwd">
                        <label for="password">Password</label><br>
                        <input placeholder="Your password" type="password" id="password" name="password" class="form" required> 
                    </div>

                    <div id="dob">
                    <label for="dateofbirth">Date Of Birth</label><br>
                    <input type="date" id="dateofbirth" name="dateofbirth" required />
                    </div>
                </div>


                <div id="cpwdgdr" class="fnjc">
                    <div id="cpwd">
                        <label for="password">Confirm Password</label><br>
                        <input placeholder="Confirm password" type="password" id="password" name="confirmpassword" class="form" required> 
                    </div>
                    <div id="gdr">
                    
                            <label>Gender</label><br>
                            <select class="stxt" name="gender" required>
                                <option value="zero" selected>Male</option>
                                <option value="one">Female</option>
                                <option value="two">Others</option>
                            </select>
                            </div>
                </div>

                <button type="Signup" id="signup">Signup</button>
            </form>
        </div>
    </section>
<%@include file="footer.jsp"%>
</body>
</html>