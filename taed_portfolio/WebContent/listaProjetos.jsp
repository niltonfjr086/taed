<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
	    <title>Lista de Projetos Cadastrados</title>
	    
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>	    
	
	</head>
	
	<body>
	
		<h2>Lista de Projetos Cadastrados</h2>
		
		
		
			<table class="table table-striped">
				<tr>
					<td>Id</td>
					<td>Nome</td>
					<td>Data Inicio</td>
					<td>Data Previsao Fim</td>
					<td>Data Fim</td>
					<td>Descrição</td>
					<td>Status</td>
					<td>Orcamento</td>
					<td>Risco</td>
					<td>Gerente</td>
					<td>Alterar</td>
					<td>Excluir</td>
					
				</tr>
	 
				<c:if test="${not empty projetos}">
					<c:forEach var="listValue" items="${projetos}">
						
						<tr>
							<td>${listValue.id}</td>
							<td>${listValue.nome}</td>
							
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${listValue.data_inicio}" /></td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${listValue.data_previsao_fim}" /></td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${listValue.data_fim}" /></td>
							
							<td>${listValue.descricao}</td>
							<td>${listValue.status}</td>
							<td>${listValue.orcamento}</td>
							<td>${listValue.risco}</td>
							<td>${listValue.idgerente}</td>
							
							<td><form><input type="submit" value="${listValue.id}" class="btn btn-primary" /></form></td>
							<td><form><input type="submit" value="${listValue.id}" class="btn btn-primary" /></form></td>
							
						</tr>
					</c:forEach>
				</c:if>
			</table>
	 
		
		<a href="/taed_portfolio/cadastroProjeto" class="btn btn-primary" >Cadastro</a>
	
	</body>
</html>