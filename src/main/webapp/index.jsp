<%-- 
    Document   : index
    Created on : 26-Jan-2016, 4:16:23 PM
    Author     : c0663919
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="database.DB" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=DB.getTable()%>
    </body>
</html>
