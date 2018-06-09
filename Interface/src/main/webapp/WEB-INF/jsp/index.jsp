<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AMA</title>
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/cadastroPaciente.css" />
        <script src="${cp}/resources/js/js.js"></script>
    </head>
    <body>
        <h4>Bem vindo ao Projeto AMA</h4>
       Area do Paciente <a href="LoginPaciente">Clique aqui</a><br>
       Area do Agente de Saude <a href="#">Clique aqui</a>        
    </body>
</html>