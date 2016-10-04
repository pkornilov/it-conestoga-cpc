<%-- 
    Document   : ANPKRegister
    Created on : Jan 21, 2015, 3:15:02 PM
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
        <section>
            <h1>New Member Registration Form</h1>
            <form action="ANPKDisplayMember.jsp" method="post">
                <label for="fullName">Full Name:</label> 
                <input type="text" style="width: 200px" name="fullName"><br>
                <label for="email">Email:</label> 
                <input type="email" style="width: 300px" name="email"><br>
                <label>Phone:</label> 
                <input type="phone" style="width: 100px" name="phone"><br>
                <label>IT Program:</label>
                <select name="program">
                    <option>CPA</option>
                    <option>CP</option>
                    <option>ITID</option>
                    <option>CAD</option>
                    <option>ITSS</option>
                    <option>Others</option>
                </select><br>
                <label>Year Level</label>
                <select name="year">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select><br>
                <label></label>
                <input type="submit" value="Register Now!">
                <input type="reset" value="Reset">
                
            </form>
        </section>
    </body>
    
    <jsp:include page="ANPKFooter.jsp"/>
</html>
