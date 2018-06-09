<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1" http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Area do Paciente</title>
        <link rel="stylesheet"  href="${cp}/resources/css/Paciente/LoginPaciente.css"/>
        <link rel="stylesheet"  href="${cp}/resources/css/Bootstrap/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <div class="card card-container">
                <h3 style="text-align: center;">Paciente</h3><hr>
                <img id="profile-img" class="profile-img-card" src="${cp}/resources/images/avatarlogin.png" />
                <p id="profile-name" class="profile-name-card"></p>
                <form class="form-signin">
                    <span id="reauth-email" class="reauth-email"></span>
                    <input type="email" id="email" class="form-control" placeholder="CPF" required autofocus>
                    <input type="password" id="senha" class="form-control" placeholder="Senha" required>
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Entrar</button>
                </form><!-- /form -->
                <a href="CadastrarPaciente" class="forgot-password">
                    Ainda não é cadastrado? 
                </a>
            </div><!-- /card-container -->
        </div><!-- /container -->
        <script src="${cp}/resources/js/jquery-2.2.4.js"></script>
        <script src="${cp}/resources/js/Bootstrap/bootstrap.min.js" /></script>
</body>
</html> 
