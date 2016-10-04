<%-- 
    Document   : ANPKAddBook
    Created on : Feb 23, 2015, 3:04:49 PM
    Author     : pkornilov
--%>

<jsp:include page="ANPKBanner.jsp"/>
    <body>
        
        <section>
            <h2>Add a Book</h2>
            <form method="post" action="ANPKAddBook">

<p style="color: red"><i>${errorMessage}</i></p>
            <label>Code:</label>
            <input type="text" name="code" value="${code}"/></br>
            <label>Description:</label><input type="text" style="width: 350px" name="description" value="${description}"/></br>
            <label>Quantity:</label><input type="text" style="width: 50px" name="quantity" value="${quantity}"/></br>
            <input type="submit" value="Save"/>
            <input type="reset" value="Cancel" onclick="window.location='ANPKDisplayBooks'"/>
        </form>
        </section>
    </body>
<jsp:include page="ANPKFooter.jsp"/>
