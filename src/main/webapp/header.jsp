<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/header.css" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
</head>
<body>
<header>
    <div class="container">
        <div class="nav-part">
            <div id="leftsh">
                <h1><a href="index.jsp">LapZone</a></h1>
            </div>
          
            <div id="middlesh">
                <form id="searchForm">
                    <input type="text" placeholder="Search in Lapzone" name="search" id="searchInput"/>
                    <button type="submit">Search</button>
                </form>
            </div>

            <div class="rightsh">
                <div id="userf">
                    <a href="login.jsp">
                        <i class="fa-regular fa-user" ></i>
                        <p id="ln">Login</p>
                    </a>
                </div>
                <div id="lsc">
                    <a href="signup.jsp">
                        <p id="sup">Sign up</p>
                    </a>
                    <a href="cart.jsp">
                    <i class="fa-solid fa-cart-shopping" ></i>
                    </a>
                </div>
            </div>
        </div>
        <div id="tcont">
            <ul>
                <li>
                    <a href="#">HOME</a>
                </li>
                <li>
                    <a href="#">ABOUT US</a>
                </li>
            </ul>
        </div>
    </div>
</header>

<script src="https://kit.fontawesome.com/1be6f8ccbb.js" crossorigin="anonymous"></script>
<script>
        document.getElementById("searchForm").addEventListener("submit", function(event) {
            event.preventDefault();
            var searchValue = document.getElementById("searchInput").value;
            var baseUrl = window.location.origin + window.location.pathname; // Get base URL dynamically without query parameters
            window.location.href = baseUrl + "?s=" + encodeURIComponent(searchValue);
        });
    </script>
</body>
</html>
