<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1" http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet"  href="${cp}/resources/css/Paciente/HomePagePaciente.css"/>
        <link rel="stylesheet"  href="${cp}/resources/css/Bootstrap/bootstrap.min.css"/>
    </head>
    <body>
        <div class="dropdown pull-right dropopcoes">
            <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                Opções
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><a href="LogoutPaciente">Sair</a></li>
                <li><a href="AlteracaoDados">Alterar Dados</a></li>                    
            </ul>
        </div>
        <div class="container"> 
            <hr class="prettyline linha">
            <br>
            <center>
                <h2 class="titulo-ama"><b>Seja bem vindo,${paciente.nome}!</b></h2><br>
                <a class="btn btn-primary btn-md" href="#">Agendar uma consulta</a><br><br>                     
                <a class="btn btn-primary btn-md" href="#">Minhas Consultas</a><br><br>
                <button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#minhasInformacoes">
                    Informações
                </button>
            </center>
            <br>
            <!-- Modal -->
            <div class="modal fade" id="minhasInformacoes" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog model-md" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Minha informações</h4>
                        </div>
                        <div class="modal-body">
                            <ul class="list-group">
                                <li class="list-group-item"><label>Nome: </label> ${paciente.nome}</li>
                                <li class="list-group-item"><label>Data de Nascimento: </label> <fmt:formatDate pattern="dd/MM/yyyy" value="${paciente.dataNascimento}" /></li>
                                <li class="list-group-item"><label>Email: </label> ${paciente.email}</li>
                                <li class="list-group-item"><label>CPF: </label> ${paciente.cpf}</li>
                                    <c:choose>
                                        <c:when test="${paciente.enum_sexo == 1 }">
                                        <li class="list-group-item"><label>Sexo: </label> Masculino</li>                                        
                                        </c:when>
                                        <c:otherwise>
                                        <li class="list-group-item"><label>Sexo: </label> Feminino</li>
                                        </c:otherwise>
                                    </c:choose>
                            </ul>
                        </div>
                    </div>
                </div> 
            </div>            
        </div>
        <script src="${cp}/resources/js/jquery-2.2.4.js"></script>
        <script src="${cp}/resources/js/Bootstrap/bootstrap.min.js" /></script>
</body>
</html>

