<%-- 
    Document   : ANPKBanner
    Created on : Jan 14, 2015, 2:57:44 PM
    Author     : pkornilov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/main.css">
        <title>ANPK Computer Programming Club</title>
    </head>
    <body>
    <header>
        <img src="images/anpk-icon.png" alt="ANPK Computer Programming Club" 
        style="width: 60px">
        <h1>ANPK Computer Programming Club</h1>
        <h2>IT@Conestoga</h2>
    </header>
        <nav id="nav_bar">
            <ul>
                <li><a href="ANPKIndex.jsp">Home</a></li>
                <li><a href="ANPKRegister.jsp">Register</a></li>
                <li><a href="ANPKLoan">eLoan</a></li>
                <li><a href="ANPKECart.jsp">eCart</a></li>
                <li><a href="<c:url value='ANPKDisplayBooks'/>">Manage Books</a></li>
            </ul> 
        </nav>

    </body>
</html>
