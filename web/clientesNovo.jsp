<%-- 
    Document   : clientesNovo
    Created on : 17/09/2018, 15:15:42
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
            <form action="ClientesServlet?action=new" method="POST">
                <tr>
                    <td>cpf</td><td><input type="text" name="cpf" value="" placeholder=""></td>
                </tr>
                <br>
                <tr>
                    <td>nome</td><td><input type="text" name="nome" value=""></td>
                </tr>
                <br>
                <tr>
                    <td>email</td><td><input type="text" name="email" value=""></td>
                </tr>
                <br>
                <tr>
                    <td>date</td><td><input type="date" name="date" value=""></td>
                </tr>
                <br>
                <tr>
                    <td>rua</td><td><input type="text" name="rua" value=""></td>
                </tr>
                <br>
                <tr>
                    <td>nr</td><td><input type="text" name="nr" value=""></td>
                </tr>
                <br>
                <tr>
                    <td>cep</td><td><input type="text" name="cep" value=""></td>
                </tr>
                <br>
                <tr>
                    <td>cidade</td><td><input type="text" name="cidade" value=""></td>
                    </tr>
                <br>
                <tr>
                    <td>uf</td><td><input type="text" name="uf" value=""></td>
                    </tr>
                <br>
                <tr>
                    <td><input type="submit" value="SALVAR"></td>
            </form>
            <form action="ClientesServlet">
                    <td><input type='submit' value='CANCELAR'></td>
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
