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
                <h3 style="text-align: center;">Cadastro de Pacientes</h3><hr>
                <p id="profile-name" class="profile-name-card"></p>
                <form class="form-signin" id="formulario"action="adicionarPaciente" method="POST" >
                    <span id="reauth-email" class="reauth-email"></span>
                    <input type="text" name="nome" id="nome" class="form-control" placeholder="Nome" required autofocus>
                    <input type="text" name="cpf" id="cpf" class="form-control" placeholder="CPF" required >
                    <input type="date" name="dataNascimento" id="dataNascimento" class="form-control" placeholder="Data de Nascimento" required >
                    <input type="email"  name="email" id="email" class="form-control" placeholder="Email" required >
                    <input type="password" name="senha" id="senha" class="form-control" placeholder="Senha" required>
                    <center>
                        <div class="col-md-12">
                            <div class="input-group">
                                <div class="btn-group radio-group radio-genero">
                                    <label class="btn btn-primary not-active">Masculino <input type="radio" value="1" name="enum_sexo"></label>
                                    <label class="btn btn-primary not-active">Feminino <input type="radio" value="2" name="enum_sexo"></label>
                                </div>
                            </div>
                        </div>
                    </center>
                    <input type="hidden" name="enum_usuario" value="2">
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Cadastrar</button>
                </form>

            </div>
        </div>
        <script src="${cp}/resources/js/jquery-2.2.4.js"></script>
        <script src="${cp}/resources/js/Paciente/CadastrarPaciente.js"></script>
        <script src="${cp}/resources/js/Bootstrap/bootstrap.min.js" /></script>                       
        <script type="text/javascript" src="${cp}/resources/js/jquery.mask.js"></script>        
        <script>
            var cpf = $("#cpf");
            $(document).ready(function () {
                cpf.mask("000.000.000-00");
            });

            $("#formulario").submit(function () {
            });
        </script>
</body>
</html> 
