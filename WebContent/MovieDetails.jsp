<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.Random" %>
<%@ page import="edu.txstate.cs3320.toman.weaver.data.film.Film, edu.txstate.cs3320.toman.weaver.CyberFlixServlet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Details</title>
</head>
<body>
<div style="height: 150px">
<button>Home</button><button>Rent</button><button>Login</button><button>Support</button><img style="float: right; width: 150px; height: 150px; box-shadow: none" src="images/logo.png"/><br>
<h1>Movie Details</h1>
</div>
<p>
<p>
<%! Random rand = new Random(); %>
<%! int  n = rand.nextInt(4) + 0; %>
<%! String[] images = {"images/bambo.jpg", "images/homealone.png", "images/homewardbound.jpg", "images/sodaban.jpg", "images/toystory.jpg"}; %>
<div>
<img src="<%=images[n] %>" />
<p><% out.println(request.getAttribute("film")); %></p>
<button>Add to Cart</button>
</div>
</body>
</html>