<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Check Attendance</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    form {
        max-width: 800px;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #333;
        margin-top: 0;
    }
    a {
        text-decoration: none;
        color: #007bff;
    }
    a:hover {
        text-decoration: underline;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
        font-weight: bold;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    td input[type="radio"] {
        margin-right: 10px;
    }
    input[type="text"], input[type="radio"] {
        width: 100%;
        padding: 8px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        display: block;
        margin: 20px auto;
        padding: 10px 20px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <h1><a href="instructor">Back</a></h1>
    <form action="att" method="post">
        <input type="hidden" value="${requestScope.slotid}" name="slotid"/>
        <input type="hidden" value="${requestScope.date}" name="date"/>
        <input type="hidden" value="${requestScope.sessionid}" name="sessionid"/>
        <h2 style="text-align: center;">Check attendance</h2>
        <table>
            <tr>
                <th>No.</th>
                <th>Class</th>
                <th>Student ID</th>
                <th>Name</th>
                <th>Attendance Status</th>
                <th>Description</th>
            </tr>
            <c:forEach items="${requestScope.lista}" var="s" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${s.sessionId.classId.className}</td>
                    <td>${s.studentId.studentId}</td>
                    <td>${s.studentId.studentName}</td>
                    <td>
                        <label><input type="radio" name="att${s.studentId.studentId}" value="absent" <c:if test="${s.status eq 'absent'}">checked</c:if>> Absent</label>
                        <label><input type="radio" name="att${s.studentId.studentId}" value="present" <c:if test="${s.status eq 'present'}">checked</c:if>> Present</label>
                    </td>
                    <td><input name="comment${s.studentId.studentId}" type="text" value ="${s.comment}" placeholder="Enter description"/></td>
                </tr> 
            </c:forEach>
        </table>
        <input type="submit" value="SAVE"/>
    </form>
</body>
</html>
