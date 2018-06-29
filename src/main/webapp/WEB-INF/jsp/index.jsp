<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1" http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AMA</title>
        <link rel="stylesheet"  href="${cp}/resources/css/index.css"/>
        <link rel="stylesheet"  href="${cp}/resources/css/Bootstrap/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container"> 
            <hr class="prettyline">
            <br>
            <center>
                <h2 class="titulo-ama"><b>Seja bem-vindo ao AMA!</b></h2><br>
                <a class="btn btn-primary btn-md" href="Paciente/LoginPaciente">Área do Paciente</a><br><br>                     
                <a class="btn btn-primary btn-md" href="#">Área do Agente de Saúde</a><br><br>                     
            </center>
            <br>
        </div>        
        <script src="${cp}/resources/js/jquery-2.2.4.js"></script>
        <script src="${cp}/resources/js/Bootstrap/bootstrap.min.js" /></script>
    </body>
</html>