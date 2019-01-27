<%-- 
    Document   : Words Counter
    Created on : 20.01.2019, 22:18:29
    Author     : Havok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Words counter page</title>
    </head>
    <body>
        <h1>You print this count of words: </h1>
        <%
            out.println("<p>Count of words: " + request.getAttribute("count") + "</p>");
        %>
        <div>
            <button onclick="location.href = '/lab-1/StartPage'">Back to StartPage</button>
        </div>
    </body>
</html>
