<%-- 
    Document   : ANPKIndex
    Created on : Jan 21, 2015, 1:12:50 PM
    Author     : pkornilov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="ANPKBanner.jsp"/>
    </head>
    <body>
        <section>
        <h2>Java Web Technologies: Section 3</h2>
        <br>
        <p>Pair Programming Team:</p>
        <p style="font-weight: bold">Assignment 4</p>
        <p style="font-weight: bold">Driver: Philippe Kornilov</p>
        <p style="font-weight: bold">Observer: Anton Nepsha</p>
        <br>
        <p>Current Date and Time</p>
        <p style="font-weight: bold"><%=new java.util.Date()%></p>
        </section>
    </body>
    <jsp:include page="ANPKFooter.jsp"/>
</html>
