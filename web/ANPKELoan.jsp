<%-- 
    Document   : ANPKLoan
    Created on : Mar 24, 2015, 1:18:33 PM
    Author     : pkornilov
--%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="ANPKBanner.jsp"/>
<body>
    <section>
        <table>
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>QQH</th>
                <th>Action</th>
            </tr>
            <c:forEach var="loanItem" items="${applicationScope.loanItems}">
            <tr>
                <td>${loanItem.code}</td>
                <td>${loanItem.description}</td>
                <td>${loanItem.quantity}</td>
                
                <c:choose>
                    <c:when test="${loanItem.quantity > 0}">
                        <td style="border: 0px;"><a href="<c:url value='ANPKCart?action=reserve&amp;code=${loanItem.code}'/>">Reserve</a></td>
                    </c:when>                            
                    <c:otherwise>
                        <td style="border: 0px;">N/A</td>
                    </c:otherwise>
                </c:choose>

            </tr>
            </c:forEach>
        </table>
    </section>
</body>
<jsp:include page="ANPKFooter.jsp"/>
