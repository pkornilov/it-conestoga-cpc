<%-- 
    Document   : ANPKAdmin
    Created on : Feb 11, 2015, 2:40:29 PM
    Author     : pkornilov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="ANPKBanner.jsp"/>
    <body>
        <section>
            <h2>Admin : Data Maintenance</h2>
            <p><a href="<c:url value='ANPKDisplayBooks'/>">
                    Maintain Books</a></p>
            <p><a href="<c:url
                value='ANPKMemberAdmin?action=displayMembers'/>">
                    Display Members</a></p>
        </section>
    </body>
<jsp:include page="ANPKFooter.jsp"/>
