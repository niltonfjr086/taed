<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de Projeto</title>

	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>	    
		<script type="text/javascript">
		
			// http://maozinhadaweb.blogspot.com.br/2014/01/mascara-generica-para-campos-numericos.html
			function mascaraGenerica(evt, campo, padrao) {
			    var charCode = (evt.which) ? evt.which : evt.keyCode;
			    
			    if (charCode == 8) return true;
			    if (charCode != 46 && (charCode < 48 || charCode > 57)) return false;        
			    campo.maxLength = padrao.length;
			    entrada = campo.value;  
			    if (padrao.length > entrada.length && padrao.charAt(entrada.length) != '#') {
			         campo.value = entrada + padrao.charAt(entrada.length);
			    }
			    return true;
			};
			    
			function capitalizar(v){
				retorno = v.value
				v.value=retorno.replace( /(^|\s)([a-z])/g , function(m,p1,p2){ return p1+p2.toUpperCase(); } )
			}

		</script>

	</head>
	<body>

		<fieldset class="container">
			<legend>Formulário de Cadastro de Projeto</legend>
			
			<s:form method="POST" action="/taed_portfolio/addProjeto">
				
				<div class="form-row col-lg-10 col-xl-10">
					<div class="col-sm-12 col-md-8 col-lg-7 col-xl-7">
						<s:label for="nome" path="nome">Nome:</s:label>
						<s:input id="nome" path="nome" class="form-control" onkeypress="capitalizar(this);" />
					</div>
				   
					<div class="col-sm-12 col-md-4 col-lg-5 col-xl-5">
						<s:label path="data_inicio">Data Inicio:</s:label>
						<s:input path="data_inicio" class="form-control" onkeypress="return mascaraGenerica(event, this, '##/##/####');" />
					</div>
				</div>
				
				<div class="form-row col-lg-10 col-xl-10">
					<div class="col-sm-12 col-md-5 col-lg-5 col-xl-5">
						<s:label path="data_previsao_fim">Data Previsao Fim:</s:label>
						<s:input path="data_previsao_fim" class="form-control" onkeypress="return mascaraGenerica(event, this, '##/##/####');" />
					</div>
					  
					<div class="col-sm-12 col-md-7 col-lg-7 col-xl-7">
						<s:label path="status">Status:</s:label>
						<s:select path="status" class="form-control">
						  <s:option value="Em Analise">Em Análise</s:option>
						  <s:option value="Analise Realizada">Análise Realizada</s:option>
						  <s:option value="Analise Aprovada">Análise Aprovada</s:option>
						  <s:option value="Iniciado">Iniciado</s:option>
						  <s:option value="Planejado">Planejado</s:option>
						  <s:option value="Em Andamento">Em Andamento</s:option>
						  <s:option value="Encerrado">Encerrado</s:option>
						  <s:option value="Cancelado">Cancelado</s:option>
						</s:select>
					</div>
					
				</div>
				
				<div class="form-row col-lg-10 col-xl-10">
					<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<s:label path="descricao">Descrição:</s:label>
						<s:textarea path="descricao" class="form-control" onkeypress="capitalizar(this);" />
					</div>
				</div>
				
				<div class="form-row col-lg-10 col-xl-10">
					<div class="col-sm-12 col-md-7 col-lg-6 col-xl-6">
						<s:label path="orcamento">Orcamento:</s:label>
						<s:input path="orcamento" class="form-control" onkeypress="return mascaraGenerica(event, this, '######');" />
					</div>
					<div class="col-sm-12 col-md-5 col-lg-6 col-xl-6">
						<s:label path="risco">Risco:</s:label>
						<s:select path="risco" class="form-control">
						  <s:option value="Baixo">Baixo</s:option>
						  <s:option value="Medio">Medio</s:option>
						  <s:option value="Alto">Alto</s:option>
						</s:select>
					</div>				  
				</div>
				
				<div class="form-row col-lg-10 col-xl-10">
					<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<s:label path="idgerente">Gerente:</s:label>
						<s:select path="idgerente" class="form-control">
							<c:forEach var="listValue" items="${funcionarios}">
								<s:option value="${listValue.id}">${listValue.nome}</s:option>
							</c:forEach>
						</s:select>
					</div>
				</div>

				
				<br/>
				
				<div class="form-row col-lg-10 col-xl-10">
					<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<input type="submit" class="btn btn-primary" value="Salvar"/>
						<a href="/taed_portfolio/listaProjetos" class="btn btn-primary">Lista</a>
					</div>
				</div>
				
			
			</s:form>

		</fieldset>
	
	</body>
</html>