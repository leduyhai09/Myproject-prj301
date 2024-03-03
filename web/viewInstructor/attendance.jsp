<%-- 
    Document   : attendance
    Created on : Mar 3, 2024, 11:24:22 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Check attendent</h1>
        <table border="">
            <tr>
                <th>Class</th>
                <th>StudentID</th>
                <th>Name</th>
                <th>Attendance Status</th>
                <th>Description</th>
            </tr>
            <tr>
                <c:forEach items="${requestScope.list}" var="s">
                <td>${s.classId.className}</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </c:forEach>
            
               </tr> 
    </body>
</html>
