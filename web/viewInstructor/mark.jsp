<%-- 
    Document   : mark
    Created on : Mar 6, 2024, 7:36:46 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 10px;
        }
        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }
        ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }
        li {
            margin-bottom: 10px;
        }
        a {
            text-decoration: none;
            color: #007bff;
        }
        ul.sublist {
            margin-left: 20px;
        }
        ul.sublist li {
            color: #555;
            margin-bottom: 5px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        .weight {
            text-align: center;
        }
    </style>
    <script>
        window.onload = function() {
            var weightCells = document.querySelectorAll('.weight');
            weightCells.forEach(function(cell) {
                var weight = parseFloat(cell.textContent);
                cell.textContent = (weight * 100).toFixed(1) + '%';
            });
        };
    </script>
</head>
<body>

<div class="container">
    <h1>Mark Report</h1>
    <ul>
        <c:forEach items="${requestScope.listterm}" var="term">
            <li>
                <a href="mark?termId=${term.termId}">${term.termName}</a>
                <ul class="sublist">
                    <c:forEach items="${requestScope.tc}" var="t">
                        <c:if test="${t.termId.termId eq term.termId}">
                            <li><a href="mark?courseId=${t.coureId.courseId}">${t.coureId.courseName}</a></li>
                        </c:if>
                    </c:forEach>
                </ul>
            </li>
        </c:forEach>
    </ul>
    <table>
        <tr>
            <th>GRADE ITEM</th>
            <th>WEIGHT</th>
            <th>VALUE</th>
            <th>COMMENT</th>
        </tr>
        <c:forEach items="${requestScope.cgs}" var="cgs">
            <tr>
                <td>${cgs.gradeId.gradeName}</td>
                <td class="weight">${cgs.weight}</td>
                <td>${cgs.gradeId.value}</td>
                <td>${cgs.comment}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>

