<%-- 
    Document   : Number
    Created on : 20.01.2019, 22:19:17
    Author     : Havok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Number bage</title>
    </head>
    <body>
        <h1>Number</h1>

        <%
            out.println("<p>Your number is: " + request.getAttribute("text") +", i riddle this number: " + request.getAttribute("number") + " , i win :D</p>");
        %>
        <div>
            <button onclick="location.href = '/lab-1/StartPage'">Back to StartPage</button>
        </div>

    </body>
</html>
