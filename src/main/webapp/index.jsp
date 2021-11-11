<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Cadastro</title>
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" type="text/css" href="styles/style2.css">
</head>
<body>
	<header>
		<h1>&#x1F436; <a href="http://localhost:8080/FORM-JSP-SERVLET/login.jsp">DOG LAB</a></h1>
		<p id="login"><a href="http://localhost:8080/FORM-JSP-SERVLET/login.jsp">&#x1F64E; Iniciar sessão</a></p>
	</header>
	<main>
		<form method='POST' action="Index">
			<div>
				<h1 id="title">Cadastro</h1>
				<p id="subtitle">Preencha as informações abaixo</p>
			</div>
			<%
				if(request.getParameter("msg") != null) {
					if(request.getParameter("msg").equals("created")) {
			%>
						<p id="msgtrue"><strong>Conta criada com sucesso!</strong></p>
			<%	
					}else if(request.getParameter("msg").equals("password")){
			%>
						<p id="msgfalse"><strong>A senha deve conter pelo menos 7 digitos!</strong></p>
			<%	
					}
				}
			%>
			
			<!-- 
			EL (Expression Language) 
			<p>${param.id}</p>
			-->
			
			<fieldset>
				<div>
					<input type="text" name="iptName" placeholder="Nome" class="lighter" required>
				</div>
				<div>
					<input type="text" name="iptSurname" placeholder="Sobrenome" class="lighter" required>
				</div>
				<div>
					<input type="email" name="iptEmail" placeholder="Email" class="light" required>
				</div>
				<div>
					<input type="password" name="iptPassword" placeholder="senha" class="light" required>
				</div>
			</fieldset>
			
			<div>
				<div>
					<input type="text" name="iptAdress" placeholder="Endereço" class="normal">
				</div>
				<div>
					<select class="dark" name="slctCountry">
						<option selected disabled>País</option>
						<option>Brasil</option>
						<option>Canadá</option>
						<option>Alemanha</option>
					</select>
				</div>
			</div>
			<div id="buttonDiv">
				<input type="submit" value="&#x2714; Cadastrar">
			</div>
		</form>
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