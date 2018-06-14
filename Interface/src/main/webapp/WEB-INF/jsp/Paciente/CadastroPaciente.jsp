<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AMA</title>
        <link rel="stylesheet"  href="${cp}/resources/css/bootstrap.min.css" />
        <link rel="stylesheet"  href="${cp}/resources/css/cadastroPaciente.css" />                 
    </head>
    <body>
        <div >
            <form  id="formulario"action="adicionarPaciente" method="POST" >
                <div class="form-group col-md-12">
                    <label >Nome</label>
                    <input type="text" class="form-control"  name="nome" placeholder="Digite seu nome">
                </div>
                <div class="form-group col-md-6">
                    <label >CPF</label>
                    <input type="text" class="form-control"  id="cpf" name="cpf" placeholder="Digite seu cpf">
                </div>
                <div class="form-group col-md-6">
                    <label >Data Nascimento</label>
                    <input type="date" class="form-control"  id= "data"name="dataNascimento" >
                </div>
                <div class="form-group col-md-6">
                    <label >Email</label>
                    <input type="email" class="form-control"  name="email" placeholder="Digite seu email">
                </div>
                <div class="form-group col-md-6">
                    <label >Senha</label>
                    <input type="password" class="form-control"  placeholder="Digite sua senha" name="senha">
                </div>
                <div class="form-group col-md-12">
                    <input type="radio" name="enum_sexo" value="1"> Male<br>
                    <input type="radio" name="enum_sexo" value="2"> Female<br>
                    <input name="enum_usuario" type="hidden" value="1">
                </div>
                <div class="col-md-12">                
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </form>
        </div>
        
       <script type="text/javascript" src="${cp}/resources/js/jquery-2.2.4.js"></script>                
        <script type="text/javascript" src="${cp}/resources/js/jquery.mask.js"></script>        
        <script>
            var cpf = $("#cpf");
            $(document).ready(function () {
                cpf.mask("000.000.000-00");
            });
            
            $("#formulario").submit(function(){
                cpf.unmask();
                alert(cpf.val());
            });
            
                
            
        </script>
    </body>
</html>
