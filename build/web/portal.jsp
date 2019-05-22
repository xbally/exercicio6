<%-- 
    Document   : portal
    Created on : 28/08/2018, 21:03:34
    Author     : leand
--%>

<%@page import="com.ufpr.tads.web2.beans.ErroBean"%>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/erro.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
        LoginBean log = new LoginBean();    
        log = (LoginBean) pageContext.getSession().getAttribute("login");
        if (log == null){
            
        ErroBean erro = new ErroBean();
        erro.setMsg("Usuário deve se atutenticar para acessar o sistema");
        erro.setPage("index.jsp");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        request.setAttribute("erro",erro);
        rd.forward(request, response);
        
        }
        %>          
        <jsp:useBean id="login" class="com.ufpr.tads.web2.beans.LoginBean" scope="session"/>    
        ${login.nome}
        <h1>MENU</h1>
        <a href="ClientesServlet">Listar Clientes</a>
        <br>
        <a href="LogoutServlet">sair</a>
        
    </body>
    <footer>
        Em caso de problemas contate o adm do server:${conf.email}
    </footer>
</html>
