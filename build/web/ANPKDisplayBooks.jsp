<%-- 
    Document   : ANPKDisplayBooks
    Created on : Feb 23, 2015, 1:59:31 PM
    Author     : pkornilov
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="ANPKBanner.jsp"/>
    <body>
        <section>
            <h2>List of Books</h2>
        <table border="1" >
            <tr>
                <th>Code</th>
                <th style="text-align: center">Description</th>
                <th>Quantity</th>
            </tr>
        <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.code}</td>
            <td>${book.description}</td>
            <td>${book.quantity}</td>
        </tr>
        </c:forEach>
        </table>
    <input type="submit" value="Add Book" onclick="window.location='ANPKAddBook.jsp'"/>  
        </section>
        
    </body>
<jsp:include page="ANPKFooter.jsp"/>
