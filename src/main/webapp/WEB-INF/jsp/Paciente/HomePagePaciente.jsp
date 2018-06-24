<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <a class="btn btn-info btn-md pull-right logoutbutton" href="LogoutPaciente">Sair</a><br><br>         
        
        <div class="container"> 
            <hr class="prettyline">
            <br>
            <center>
                <h2 class="titulo-ama"><b>Seja bem vindo,${paciente.nome}</b></h2><br>
                <a class="btn btn-primary btn-md" href="#">Agendar uma consulta</a><br><br>                     
                <a class="btn btn-primary btn-md" href="#">Minhas Consultas</a><br><br>
                <a class="btn btn-primary btn-md" href="#">Opções</a><br><br>
            </center>
            <br>
        </div>        
    </body>
</html>
