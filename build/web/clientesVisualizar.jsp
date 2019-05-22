<%-- 
    Document   : clientesVisualizar
    Created on : 11/10/2018, 21:33:28
    Author     : leand
--%>

<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page import="com.ufpr.tads.web2.beans.ErroBean"%>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/erro.jsp"%>
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
            }
        %>
        
        <h2>FORMULARIO DE NOVO CLIENTE</h2>

        <div class="container-fluid">
            <table>
            <form action="NovoClienteServlet" method="POST">
                <tr>
                    <td>cpf</td><td>${visualizar.cpf}</td>
                </tr>
                <br>
                <tr>
                    <td>nome</td><td>${visualizar.nome}</td>
                </tr>
                <br>
                <tr>
                    <td>email</td><td>${visualizar.email}</td>
                </tr>
                <br>
                <tr>
                    <td>date</td><td>${visualizar.date}</td>
                </tr>
                <br>
                <tr>
                    <td>rua</td><td>${visualizar.rua}</td>
                </tr>
                <br>
                <tr>
                    <td>nr</td><td>${visualizar.nr}</td>
                </tr>
                <br>
                <tr>
                    <td>cep</td><td>${visualizar.cep}</td>
                </tr>
                <br>
                <tr>
                    <td>cidade</td><td>${visualizar.cidade}</td>
                    </tr>
                <br>
                <tr>
                    <td>uf</td><td>${visualizar.uf}</td>
                    </tr>
                <br>
                <tr>
            </form>
            <form action="ClientesServlet">
                    <td><input type='submit' value='VOLTAR'></td>
                </tr>
            </form>
            </table>
        </div>
    </body>
        <footer>
            <jsp:useBean id="conf" class="com.ufpr.tads.web2.beans.ConfigBean" scope="application"/>
            Em caso de problemas contate o adm do server:<jsp:getProperty name="conf" property="email"></jsp:getProperty>
        </footer>
</html>