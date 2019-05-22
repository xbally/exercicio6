<%-- 
    Document   : erro
    Created on : 28/08/2018, 21:51:39
    Author     : leand
--%>
<%@page isErrorPage="true" %>
<%@page import="com.ufpr.tads.web2.beans.ConfigBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERRO</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <p>
                    ${pageContext.exception.message}
                    ${pageContext.out.flush()}
                    ${pageContext.exception.printStackTrace(pageContext.response.writer)}
        </p>
            
        <footer>
            Em caso de problemas contate o adm do server:${conf.email}
        </footer>
    </body>
</html>
