<%-- 
    Document   : arithmeticCalc
    Created on : May 26, 2021, 12:54:22 PM
    Author     : 846582
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calc</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="aritmetic">
            <label>First:</label>
            <input type="text" name="fir" value="${firstNum}" placeholder="12">
            <br>
                        <label>Second:</label>
            <input type="text" name="sec" value="${secondNum}" placeholder="12">
            <br>
            <input type="submit" name="calcButton" value="+">
                        <input type="submit" name="calcButton" value="-">
                                    <input type="submit" name="calcButton" value="*">
                                                <input type="submit" name="calcButton" value="%">
            <br>
            <p>Result:</p>
            <p>${message}</p>
            <a href="age">Age Calculator</a>
        </form>
    </body>
</html>
