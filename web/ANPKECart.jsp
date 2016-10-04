<%-- 
    Document   : ANPKCart
    Created on : Mar 24, 2015, 1:19:54 PM
    Author     : pkornilov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="ANPKBanner.jsp" />
<c:set var="total" value="0" scope="page"/>
<body>
        <section>
            <h2>Your Loan Cart</h2>
        <table>
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Quantity</th>
            </tr>
            <c:forEach var="book" items="${sessionScope.cart.items}">
                <tr>
                    <td>${book.code}</td>
                    <td>${book.description}</td>
                    <td align="right">${book.quantity}</td>
                    <c:set var="total" value="${total+book.quantity}" scope="page" />
                </tr>
            </c:forEach>
                <tr>
                    <td></td>
                    <td align="right"> Total: </td>
                    <td align="right">${total}</td>
                </tr>
        </table>
        <a href="<c:url value='ANPKClearCart?action=clear'/>">Clear the cart</a>
          </br>
        <a href="<c:url value='ANPKLoan'/>">Return to eLoan</a>
    </section>
</body>
<jsp:include page="ANPKFooter.jsp" />