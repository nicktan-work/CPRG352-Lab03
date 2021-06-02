<%-- 
    Document   : ageCalc
    Created on : May 26, 2021, 12:54:12 PM
    Author     : 846582
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calc</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="age">
            <label>Enter your age:</label>
            <input type="text" name="age" value="${userAge}" placeholder="12">
            <br>
            <input type="submit" value="Age next birthday">
            <br>
            <p>${message}</p>
            <a href="aritmetic">Arithmetic Calculator</a>
        </form>
    </body>
</html>
