<%-- 
    Document   : ErrorPage
    Created on : 20.01.2019, 22:15:10
    Author     : Havok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>You enter wrong string, repeat your input</h1>
        <p>Input new string here :</p>
                <form method="post">
            <label>Text:
                <input type="text" name="userText"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
        
    </body>
</html>
