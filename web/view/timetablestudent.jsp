<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<form action="student" method="GET">
    <input type="hidden" name="id" value="${param.username}"/>
    From : <input type="date" name="from" value="${requestScope.from}" /> -
    <input type="date" name="to" value="${requestScope.to}"/>
    <input type="submit" value="View"/>
</form>

<table>
    <thead>
    <tr>
        <td></td> <!-- This cell is empty -->
        <th>Monday</th>
        <th>Tuesday</th>
        <th>Wednesday</th>
        <th>Thursday</th>
        <th>Friday</th>
        <th>Saturday</th>
        <th>Sunday</th>
    </tr>
    <tr>
        <th>Time/Class</th>
        <!-- Dates will be added dynamically in the next row -->
        <c:forEach items="${requestScope.dates}" var="d">
            <th>${d}</th>
        </c:forEach>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.listsSlots}" var="slot">
        <tr>
            <td>${slot.tname}</td>
            <c:forEach items="${requestScope.dates}" var="d">
                <td>
                    <c:forEach items="${requestScope.sess}" var="ses">
                        <c:if test="${(ses.date eq d) and (ses.slotId.tid eq slot.tid)}">
                            ${ses.classId.className}<br> 
                            ${ses.classId.courseId.courseName} <br> 
                            ${ses.roomId.roomName} <br>
                            (${ses.attentId.status}) 
                            <br>
                            ${ses.slotId.time}
                        </c:if>
                    </c:forEach>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

