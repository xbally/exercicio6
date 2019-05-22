<%-- 
    Document   : clientesAlterar
    Created on : 17/09/2018, 19:42:35
    Author     : leand
--%>

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
        <title>JSP Page</title>
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
            }%>
            
        <div class="container-fluid">
            <table>
                <form action="ClientesServlet?action=update" method="POST">
                <input type="hidden" name="id" value="${alterar.id}">
                <tr>
                    <td>cpf</td><td><input type="text" name="cpf" value="${alterar.cpf}"></td>
                </tr>
                <br>
                <tr>
                    <td>nome</td><td><input type="text" name="nome" value="${alterar.nome}"></td>
                </tr>
                <br>
                <tr>
                    <td>email</td><td><input type="text" name="email" value="${alterar.email}"></td>
                </tr>
                <br>
                <tr>
                    <td>date</td><td><input type="date" name="date" value="${alterar.date}"></td>
                </tr>
                <br>
                <tr>
                    <td>rua</td><td><input type="text" name="rua" value="${alterar.rua}"></td>
                </tr>
                <br>
                <tr>
                    <td>nr</td><td><input type="text" name="nr" value="${alterar.nr}"></td>
                </tr>
                <br>
                <tr>
                    <td>cep</td><td><input type="text" name="cep" value="${alterar.cep}"></td>
                </tr>
                <br>
                <tr>
                    <td>cidade</td><td><input type="text" name="cidade" value="${alterar.cidade}"></td>
                    </tr>
                <br>
                    <tr>
                    <td>uf</td><td><input type="text" name="uf" value="${alterar.uf}"></td>
                    </tr>
                <br>
                <tr>
                    <td><input type="submit" value="ALTERAR"></td>
            </form>
            <form action="ClientesServlet">
                    <td><input type='submit' value='CANCELAR'></td>
                </tr>
            </form>
            </table>
        </div>
    </body>
</html>
