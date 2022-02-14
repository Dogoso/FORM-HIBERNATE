<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.doglab.form.dao.UserDAO" %>
<%@ page import="com.doglab.form.users.User" %>
<%@ page import="com.doglab.form.JPAUtil.JPAUtil" %>
<%@ page import="javax.persistence.EntityManager" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>All Users</title>
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" type="text/css" href="styles/style.css">
	<link rel="stylesheet" type="text/css" href="styles/users.css">
</head>
<body>
	<header>
		<h1>&#x1F436; <a href="http://localhost:8080/FORM-JSP-SERVLET/users.jsp">DOG LAB</a></h1>
		<div class="dropdown">
			<p id="login">&#x1F64E; <%=request.getSession().getAttribute("user") %></p>
			<div class="dropdown-menu">
				<p onclick="invalidateSession()">Deslogar</p>
			</div>
		</div>
	</header>
	
	<main id="usersCadastro">
		<div id="header">
			<h1>Cadastros: </h1>
			<p>Abaixo, todos os usuários cadastrados no servidor: </p>
		</div>
		<div id="users">
			<%
				EntityManager em = JPAUtil.getEntityManager();
				UserDAO userDao = new UserDAO(em);
				em.getTransaction().begin();
				List<User> users = userDao.readUsers();
				em.getTransaction().commit();
				em.close();
				for(User u : users) {
			%>
					<div class="user">
						<h1><%=u.getName()+" "+u.getSurname() %></h1>
						<p><%=u.getEmail() %></p>
						<p><%=u.getAdress()+", "+u.getCountry() %></p>
					</div>
			<%
				}
			%>
		</div>
	</main>
	
	<footer>
		<div>
			<h1>Contact us:</h1>
			<ul>
				<li><a href="https://github.com/Dogoso" target="_blank">Github</a></li>
				<li><a href="https://twitter.com/SilasDogoso" target="_blank">Twitter</a></li>
				<li><a href="https://www.instagram.com/silasdogoso/" target="_blank">Instagram</a></li>
			</ul>
		</div>
		<div>
			<h1 class=>Created by: </h1>
			<p class="created">&copy; Dog Lab, inc</p>
			<p class="created">Silas Juan</p>
		</div>
	</footer>
	
	<%
		if(request.getMethod().equals("GET")) {
			if(request.getSession().getAttribute("user") == null) {
				response.sendRedirect("http://localhost:8080/FORM-JSP-SERVLET/login.jsp");
			}
		}
	%>
	<script type="text/javascript" src="JS/users.js"></script>
</body>
</html>