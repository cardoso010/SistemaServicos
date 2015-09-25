<%-- 
    Document   : CadClientes
    Created on : 23/09/2015, 22:59:03
    Author     : cardoso
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="include/img/favicon.ico">

    <title>Sistema</title>

    <style type="text/css">
        <%@include file="../includes/css/bootstrap.min.css" %>
        <%@include file="../includes/css/signin.css" %>
    </style>

    <!-- Custom styles for this template -->
    <link href="./view/include/css/theme.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./view/include/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body role="document">

    <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
            <a class="navbar-brand" href="#">Sistema de Serviços</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="Clientes?acao=cadastrarClientes">Clientes</a></li>
            <li><a href="Servicos?acao=cadastrarServicos">Serviços</a></li>
            <li><a href="ServicosContratados?acao=cadastrarServicosContratados">Serviços Contratados</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<div class="container theme-showcase" role="main">
    <div class="jumbotron">
    
    <div align="center">
    <h3 >Cadastra Clientes</h3>
        <table>
            <form action="Clientes?acao=cadastrarClientes" method="POST">
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nome" class="form-control" placeholder="Nome" required autofocus></td>
                </tr>
                <tr>
                    <td>Endereço:</td>
                    <td><input type="text" name="endereco" class="form-control" placeholder="Endereço" required></td>
                </tr>
                <tr>
                    <td>Cep:</td>
                    <td><input type="text" name="cep" class="form-control" placeholder="CEP" required></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="telefone" class="form-control" placeholder="Telefone" required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" class="form-control" placeholder="Email" required></td>
                </tr>
                <tr>
                    <td>Cidade:</td>
                    <td><input type="text" name="cidade" class="form-control" placeholder="Cidade" required></td>
                </tr>
                <tr>
                    <td>Pais:</td>
                    <td><input type="text" name="pais" class="form-control" placeholder="Pais" required></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Cadastrar" class="btn btn-success"></td>
                    <td><input type="reset" value="Limpar" class="btn btn-warning"></td>
                </tr>
            </form>
        </table>
    </div>
</div>
<div class="jumbotron" style="width: 100%;float: left;">
    <div class="col-md-6" style="width: 100%;float: left;">
        <table class="table table-striped">
            <thead>
              <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Endereço</th>
                <th>Cep</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Cidade</th>
                <th>Pais</th>
              </tr>
            </thead>
            <tbody> 
                    <c:forEach var="clientes" items="${cliente}">
                        <tr>
                            <td>${clientes.id}</td>
                            <td>${clientes.nome}</td>
                            <td>${clientes.endereco}</td>
                            <td>${clientes.cep}</td>
                            <td>${clientes.telefone}</td>
                            <td>${clientes.email}</td>
                            <td>${clientes.cidade}</td>
                            <td>${clientes.pais}</td>
                            <td>

                                <a href="Clientes?acao=alterarCliente&id=${clientes.id}">
                                    <button class="btn btn-warning">Alterar</button>
                                </a>
                            </td>
                            <td>
                                <a href="Clientes?acao=deletarCliente&id=${clientes.id}">
                                <button class="btn btn-danger">Deletar</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
            </tbody>
          </table>
        </div>
</div>
</div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="./view/include/js/bootstrap.min.js"></script>
    <script src="./view/include/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./view/include/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
