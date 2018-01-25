<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
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
		
		
		
			<table id="proj_table" class="table table-striped display">
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
							<td>${listValue.gerente.nome}</td>
							
							<td>
								<s:form method="POST" action="/taed_portfolio/cadastroProjeto">
								<button name="idProjeto" value="${listValue.id}" class="btn btn-primary">
									editar
								</button>
								</s:form>
							</td>
							<td>
								<button type="button" data-toggle="modal" data-target="#modalExcluir" data-whatever="${listValue.id}" class="btn btn-primary">
									apagar
								</button>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		<a href="/taed_portfolio/cadastroProjeto" class="btn btn-primary" >Cadastro</a>


		<s:form method="GET">
			<!-- Modal Excluir -->
			<div class="modal fade" id="modalExcluir" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
					Deseja realmente apagar o registro?
			      </div>
			      <div class="modal-footer">
			        <button id="btn-excluir" class="btn btn-primary" name="idProjeto" formaction="/taed_portfolio/delProjeto">
			        	Excluir
			        </button>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			      </div>
			    </div>
			  </div>
			</div>
		</s:form>
		
		<!-- 	JAVASCRIPT PARA O DIALOG MODAL SE COMUNICAR COM A TABLE  -->
		<script type="text/javascript">
			$(document).ready(function() {

				$('#modalExcluir').on('show.bs.modal', function (event) {
					  var button = $(event.relatedTarget) // Button that triggered the modal
					  var recipient = button.data('whatever') // Extract info from data-* attributes
					  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
					  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
					  var modal = $(this)
					  modal.find('.modal-footer #btn-excluir').val(recipient)
					})
				
				


			} );
		</script>

	</body>
</html>