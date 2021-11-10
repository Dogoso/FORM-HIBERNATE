<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Cadastro</title>
	<link rel="icon" href="favicon.ico">
	<link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
	<main>
		<div>
			<h1 id="title">Cadastro</h1>
			<p id="subtitle">Preencha as informações abaixo</p>
		</div>
		
		<form method='POST' action="Index">
			<fieldset>
				<div >
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
					<select class="dark">
						<option selected disabled>País</option>
						<option>&#x1F1E7; Brasil</option>
						<option>&#x1F1E9; Canadá</option>
						<option>&#x1F1E8; Alemanha</option>
					</select>
				</div>
			</div>
			<input type="submit" value="&#x2714; Cadastrar">
		</form>
	</main>
</body>
</html>