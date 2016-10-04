<%-- 
    Document   : ANPKDisplayMember
    Created on : Jan 21, 2015, 3:22:32 PM
    Author     : pkornilov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="ANPKBanner.jsp"/>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Thanks for joining our club!</h1>
        <p>Here is the information entered:</p>
        <section>
            <label>Full Name: </label><%= request.getParameter("fullName")%><br/>
            <label>Email: </label><%= request.getParameter("email")%><br/> 
            <label>Phone: </label><%= request.getParameter("phone")%> <br/>
            <label>IT Program: </label><%= request.getParameter("program")%> <br/>
            <label>Year Level: </label><%= request.getParameter("year")%> <br/>
        
        <p>To register another member, click on the back button in your browser
        or the Return button shown below</p>
        <label>
        <form action="ANPKRegister.jsp">
            <input type="submit" value="Return">
        </form>
        </label>
        </section>
    </body>
    <jsp:include page="ANPKFooter.jsp"/>
</html>
