<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login</title>
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" type="text/css" href="styles/style2.css">
	<link rel="stylesheet" type="text/css" href="styles/login.css">
</head>
<body>
	<header>
		<h1>&#x1F436; <a href="http://localhost:8080/FORM-JSP-SERVLET/login.jsp">DOG LAB</a></h1>
		<p id="login"><a href="http://localhost:8080/FORM-JSP-SERVLET/login.jsp">&#x1F64E; Iniciar sessão</a></p>
	</header>
	<main>
		<form method="POST" action="Login">
			<div>
				<h1>Login</h1>
				<%
					if(request.getParameter("msg") != null) {
						if(request.getParameter("msg").equals("error")) {
				%>
							<p id="msgfalse">Email e/ou senha incorreto.</p>
				<%		
						}
				%>	
				<%	
					}else {
				%>
						<p>Informe os dados da sua conta</p>
				<%
					}
				%>
			</div>
			<div>
				<input type="email" placeholder="Email" name="iptEmail" class="lighter" value="" required>
			</div>
			<div>
				<input type="password" placeholder="senha" name="iptPassword" class="light" required>
			</div>
			<div class="registry">
				<p>Registre-se clicando <a href="http://localhost:8080/FORM-JSP-SERVLET/index.jsp">aqui.</a></p>
			</div>
			<div id="buttonDiv">
				<input type="submit" value="Iniciar sessão">
			</div>
		</form>
		<div>
			<img alt="Dogoso" src="resources/dog lul.png">
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
			if(request.getSession().getAttribute("user") != null) {
				response.sendRedirect("http://localhost:8080/FORM-JSP-SERVLET/users.jsp");
			}
		}
	%>
	
</body>
</html>