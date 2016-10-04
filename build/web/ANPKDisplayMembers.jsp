<%-- 
    Document   : ANPKDisplayMembers
    Created on : Feb 23, 2015, 1:59:31 PM
    Author     : pkornilov
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="ANPKBanner.jsp"/>
    <body>
        <section>
            <h2>List of Members</h2>
        <table>
            <tr>
                <th>Email</th>
                <th>Program</th>
                <th>Year</th>
                <th></th>
                <th></th>
            </tr>
        <c:forEach var="member" items="${members}">
        <tr>
            <td>${member.emailAddress}</td>
            <td>${member.programName}</td>
            <td>${member.yearLevel}</td>
            <td><a href="ANPKMemberAdmin?action=displayMember&email=${member.emailAddress}">Update</a></td>
            <td><a href="#">Delete</a></td>
        </tr>
        </c:forEach>
        </table>
    <input type="submit" value="Add Member"
           onclick="window.location='ANPKMemberAdmin?action=addMember'"/>  
        </section>
        
    </body>
<jsp:include page="ANPKFooter.jsp"/>
