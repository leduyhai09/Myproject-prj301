<%-- 
    Document   : timeofinstructor
    Created on : Feb 26, 2024, 10:20:52 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Timetable</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }
        .container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        form {
            margin-bottom: 20px;
            text-align: center;
        }
        form input[type="date"] {
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #ccc;
            margin: 0 5px;
        }
        input[type="submit"] {
            padding: 8px 20px;
            border: none;
            background-color: #007bff;
            color: #fff;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        td {
            background-color: #fff;
        }
        tr:nth-child(even) td {
            background-color: #f2f2f2;
        }
        a {
            text-decoration: none;
            color: #007bff;
            transition: color 0.3s;
        }
        a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Timetable</h1>
        <form action="instructor" method="GET">
            <input type="hidden" name="id" value="${param.username}"/>
            From: <input type="date" name="from" value="${requestScope.from}" /> -
            To: <input type="date" name="to" value="${requestScope.to}"/>
            <input type="submit" value="View"/>
        </form>
        <table>
            <thead>
                <tr>
                     <th> </th>
                        <th>Monday</th>
                        <th>Tuesday</th>
                        <th>wednesday</th>
                        <th>Thursday </th>
                        <th>Friday </th>
                        <th>Saturday </th>
                        <th>Sunday </th>

                </tr>
                <tr>
                    <th>Time/Class</th>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <th>${d}</th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.timeSlots}" var="slot">
                    <tr>
                        <td>${slot.tname}</td>
                        <c:forEach items="${requestScope.dates}" var="d">
                            <td>                  
                                <c:forEach items="${requestScope.sessions}" var="ses">
                                    <c:if test="${(ses.date eq d) and (ses.slotId.tid eq slot.tid)}">
                                        ${ses.classId.className}<br> 
                                        ${ses.classId.courseId.courseName} <br> 
                                        ${ses.roomId.roomName} <br>
                                        (${ses.attentId.status}) 
                                        <a href="att?id=${ses.sessionId}">Take</a>
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
    </div>
</body>
</html>

