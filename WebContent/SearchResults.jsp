<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<%@ page import="edu.txstate.cs3320.toman.weaver.data.film.Film, edu.txstate.cs3320.toman.weaver.CyberFlixServlet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
<div style="height: 150px">
<button>Home</button><button>Rent</button><button>Login</button><button>Support</button><img style="float: right; width: 150px; height: 150px; box-shadow: none" src="images/logo.png"/><br>
<h1>Search Results</h1>
</div>
<p>
<p>

<%! String[] images = {"images/bambo.jpg", "images/homealone.png", "images/homewardbound.jpg", "images/sodaban.jpg", "images/toystory.jpg"}; %>
<%! List<Film> film = CyberFlixServlet.sr;%>

<% for(int i = 0; i < film.size(); i++) { %>
	<div>
	<img src="<%= images[i % 5] %>" />
	<br>
	<h1><% out.println(film.get(i).getTitle()); %></h1>
	<p> Release Year: <% out.println(film.get(i).getReleaseYear()); %></p>
	<p> Rated: <% out.println(film.get(i).getRating()); %></p>
	<p> Running Time: <% out.println(film.get(i).getLength()); %></p>
	<p> Premise: <% out.println(film.get(i).getDescription()); %></p>
<a href="<% out.println(film.get(i).getLink()); %>"><button>Details</button></a>
<button>Rent</button>
	</div>
	<br>
<% } %>
</body>
</html>