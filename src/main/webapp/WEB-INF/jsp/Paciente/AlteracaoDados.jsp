<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1" http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Area do Paciente</title>
        <link rel="stylesheet"  href="${cp}/resources/css/Paciente/CadastrarPaciente.css"/>
        <link rel="stylesheet"  href="${cp}/resources/css/Bootstrap/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <div class="card card-container">
                <h3 style="text-align: center;">Digite seus novos dados</h3><hr>
                <p id="profile-name" class="profile-name-card"></p>
                <form class="form-signin" action="alterarDados" id="formulario" method="POST">
                    <span id="reauth-email" class="reauth-email"></span>
                    <input type="text" id="email" name="cpf" class="form-control" placeholder="CPF" required autofocus>
                    <input type="email" id="senha" name="email" class="form-control" placeholder="Email" required>
                    <input type="password" id="senhaNova" name="senha" class="form-control" placeholder="Nova Senha" required>                    
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Alterar</button>
                </form><!-- /form -->        
            </div><!-- /card-container -->
        </div><!-- /container -->
        <script src="${cp}/resources/js/jquery-2.2.4.js"></script>
        <script src="${cp}/resources/js/Bootstrap/bootstrap.min.js" /></script>
        <script type="text/javascript" src="${cp}/resources/js/jquery.mask.js"></script>
        <script>
            
            var cpf = $('#cpf');
            $(document).ready(function () {
                cpf.mask("000.000.000-00");
            });

            $("#formulario").submit(function () {
                cpf.unmask();                                
            });
                        
        </script>
</body>
</html> 
