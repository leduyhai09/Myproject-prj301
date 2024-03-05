<%-- 
    Document   : attendance
    Created on : Mar 3, 2024, 11:24:22 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="att" method="post">
            <input type="hidden" value="${requestScope.slotid}" name="slotid"/>
            <input type="hidden" value="${requestScope.date}" name="date"/>
            <input type="hidden" value="${requestScope.sessionid}" name="sessionid"/>
            <h1>Check attendent</h1>
            <table border="">
                <tr>
                    <th>Class</th>
                    <th>StudentID</th>
                    <th>Name</th>
                    <th>Attendance Status</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${requestScope.lista}" var="s">
                    <tr>
                        <td>${s.sessionId.classId.className}</td>
                        <td>${s.studentId.studentId}</td>
                        <td>${s.studentId.studentName}</td>
                        <td>
                         
                            absent <input type="radio" name="att${s.studentId.studentId}" value="absent"    <c:if test="${s.status eq 'absent'}">checked</c:if>/>
                            present <input type="radio" name="att${s.studentId.studentId}" value="present"  <c:if test="${s.status eq 'present'}">checked</c:if>/>
                        </td>
                        <td>${s.comment}</td>
                    </tr> 
                </c:forEach>

            </table>
            <input type="submit" value="SAVE"/>
        </form>
    </body>
</html>
