<%-- 
    Document   : ANPKMember
    Created on : Jan 21, 2015, 3:15:02 PM
    Author     : pkornilov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="ANPKBanner.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        <section>
            <h1>New Member Registration Form</h1>
            <form action="ANPKMemberAdmin" method="post">
                <p style="color:red"><i>${errorMessage}</i></p>

                <label for="fullName">Full Name:</label>
                <input type="text" style="width: 200px" name="fullName" value="${fullName}"><br>
                <label for="email">Email:</label> 
                <input type="email" style="width: 300px" name="email" value="${email}"><br>
                <label>Phone:</label> 
                <input type="phone" style="width: 100px" name="phone" value="${phone}"><br>
                <label>IT Program:</label>
                <select name="program" >
                    <c:forEach var="selectedProgram" items="${programs}">
                        <option value="${selectedProgram}" ${selectedProgram==program?'selected="selected"':''}>${selectedProgram}</option>
                    </c:forEach>
                </select><br>
                <label>Year Level</label>
                <select name="year" selected="${year}">
                    <c:forEach var="selectedYear" items="${years}">
                        <option value="${selectedYear}" ${selectedYear==year?'selected="selected"':''}>${selectedYear}</option>
                    </c:forEach>
                </select><br>
                <label></label>
                <input type="submit" value="Update Member">
                
            </form>
        </section>
    </body>
    
    <jsp:include page="ANPKFooter.jsp"/>
</html>
