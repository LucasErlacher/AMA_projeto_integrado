<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1" http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>e</title>
    </head>
    <body>
        <h3>Tivemos problemas para efetuar o cadastro.</h3>
        <p>Tente novamente</p>
        <a href="CadastrarPaciente">Cadastrar Novo Usuário</a><br>                  
    </body>
</html>
