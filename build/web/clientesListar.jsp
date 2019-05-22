<%-- 
    Document   : clientesListar
    Created on : 17/09/2018, 13:56:16
    Author     : leand
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page import="com.ufpr.tads.web2.beans.ErroBean"%>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>clienteListar</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            LoginBean log = new LoginBean();
            log = (LoginBean) pageContext.getSession().getAttribute("login");
            if (log == null) {
                ErroBean erro = new ErroBean();
                erro.setMsg("Usuário deve se atutenticar para acessar o sistema");
                erro.setPage("index.jsp");
                //String pag = ("index.jsp");
                //String mensage = "Usuário deve se atutenticar para acessar o sistema";
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                //request.setAttribute("page",pag);
                //request.setAttribute("erro",mensage);
                request.setAttribute("erro", erro);
                rd.forward(request, response);
            }
        %>

        <%
            //ArrayList<Cliente> lista = new ArrayList<>();
            //lista = (ArrayList<Cliente>) request.getAttribute("clientes");%>

        <table style="width:100%">
            <tr>
                <th>CPF</th><th>Nome</th><th>E-mail</th><th>Visualizar</th><th>Alterar</th><th>Remover</th>
            </tr>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.email}</td>
                    <td><a href="ClientesServlet?action=show&id=${cliente.id}"><img src='imagens/lupa.JPG' style="width:25px;height:25px;border:0;">visualizar</a></td>
                    <td><a href="ClientesServlet?action=formUpdate&id=${cliente.id}"><img src='imagens/lapis.JPG' style="width:25px;height:25px;border:0;">alterar</a></td>
                    <td><a href="ClientesServlet?action=remove&id=${cliente.id}"/><img src='imagens/lixeira.JPG' style="width:25px;height:25px;border:0;">remove</a></td>
                </tr>
            </c:forEach>
        </table>

        <br>
        <!--<a href='FormNovoClienteServlet'>novo cadastro</a>-->
        <a href='ClientesServlet?action=formNew'>novo cadastro</a>
        <br>

    </body>
    <footer>
        <jsp:useBean id="conf" class="com.ufpr.tads.web2.beans.ConfigBean" scope="application"/>
        Em caso de problemas contate o adm do server:<jsp:getProperty name="conf" property="email"></jsp:getProperty>
    </footer>
</html>
