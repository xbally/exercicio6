<%-- 
    Document   : index
    Created on : 14/09/2018, 15:49:47
    Author     : leand
--%>

<%@page import="com.ufpr.tads.web2.beans.ErroBean"%>
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
            //ErroBean erro = new ErroBean();
            //erro = (ErroBean) request.getAttribute("erro");
            //if (erro != null) {
        %>
        <jsp:useBean class="com.ufpr.tads.web2.beans.ErroBean" id="erro" scope="session"/>
       <font color="red">
             <%//out.print(erro.getMsg());%>
             ${erro.msg}
             </font>
            <%
               //}
            %>
            
        <%
            
            //String error = request.getParameter("erro");
            //if (error != null) {
        %>
       <font color="red">
             <%//out.print(erro);%>
             ${erro}
       </font>
            <%
                //}
            %>
            
            
        <div class="container-fluid">
            <form action="LoginServlet" method="POST">
                Login <input type="text" name="login" value=""><br>
                Senha <input type="password" name="senha" value=""><br>
                <input type="submit" value="Login">
            </form> 
        </div>
    </body>
</html>
