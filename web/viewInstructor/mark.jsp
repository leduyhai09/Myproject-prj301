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
            border-radius: 10px;
            overflow: hidden;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
            font-size: 16px;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        .weight {
            text-align: center;
        }
        .totalRow {
            background-color: #f2f2f2;
        }
        .totalRow td {
            font-weight: bold;
        }
        .statusRow {
            font-weight: bold;
        }
        .pass {
            color: green;
        }
        .notPass {
            color: red;
        }
    </style>
 <script>
    window.onload = function() {
        var weightCells = document.querySelectorAll('.weight');
        var valueCells = document.querySelectorAll('table td:nth-child(3)'); // Lấy tất cả các ô của cột VALUE
        var totalValue = 0;

        // Lặp qua từng ô trọng số và tính tổng giá trị
        weightCells.forEach(function(cell, index) {
            var weight = parseFloat(cell.textContent);
            var value = parseFloat(valueCells[index].textContent); // Lấy giá trị từ ô tương ứng trong cột VALUE
            var subtotal = weight * value;
            totalValue += subtotal;

            // Chuyển đổi trọng số sang phần trăm và cập nhật lại nội dung của ô
            cell.textContent = (weight * 100).toFixed(1) + '%';
        });

        // Tạo và hiển thị dòng tổng giá trị
        var totalRow = document.createElement('tr');
        totalRow.classList.add('totalRow');

        var totalTitleCell = document.createElement('td');
        totalTitleCell.textContent = 'Total Course';
        totalTitleCell.setAttribute('colspan', '3'); // Chỉ định ô này chiếm 3 cột
        totalRow.appendChild(totalTitleCell);

        var totalValueCell = document.createElement('td');
        totalValueCell.textContent = Math.round(totalValue * 10) / 10; // Làm tròn tổng giá trị lên với một chữ số thập phân
        totalRow.appendChild(totalValueCell);

        // Kiểm tra điều kiện và hiển thị kết quả
        var passStatusCell = document.createElement('td');
        passStatusCell.classList.add('statusRow');
        var finalExam = parseFloat("${finalExam}"); // Lấy giá trị của final exam từ biến JSP
        var totalRounded = Math.round(totalValue * 10) / 10; // Làm tròn tổng giá trị đến chữ số thập phân thứ nhất
        if (totalRounded > 5 || finalExam < 4) {
            passStatusCell.textContent = "Passed";
            passStatusCell.classList.add('pass');
        } else {
            passStatusCell.textContent = "Not Passed";
            passStatusCell.classList.add('notPass');
        }
        totalRow.appendChild(passStatusCell);

        // Thêm dòng tổng vào cuối bảng
        var table = document.querySelector('table');
        table.appendChild(totalRow);
    };
</script>
<script>
    window.onload = function() {
        var weightCells = document.querySelectorAll('.weight');
        var valueCells = document.querySelectorAll('table td:nth-child(3)'); // Lấy tất cả các ô của cột VALUE
        var totalValue = 0;

        // Lặp qua từng ô trọng số và tính tổng giá trị
        weightCells.forEach(function(cell, index) {
            var weight = parseFloat(cell.textContent);
            var value = parseFloat(valueCells[index].textContent); // Lấy giá trị từ ô tương ứng trong cột VALUE
            var subtotal = weight * value;
            totalValue += subtotal;

            // Chuyển đổi trọng số sang phần trăm và cập nhật lại nội dung của ô
            cell.textContent = (weight * 100).toFixed(1) + '%';
        });

        // Tạo và hiển thị dòng tổng giá trị
        var totalRow = document.createElement('tr');
        totalRow.classList.add('totalRow');

        var totalTitleCell = document.createElement('td');
        totalTitleCell.textContent = 'Total Course';
        totalTitleCell.setAttribute('colspan', '3'); // Chỉ định ô này chiếm 3 cột
        totalRow.appendChild(totalTitleCell);

        var totalValueCell = document.createElement('td');
        totalValueCell.textContent = Math.round(totalValue * 10) / 10; // Làm tròn tổng giá trị lên với một chữ số thập phân
        totalRow.appendChild(totalValueCell);

        // Kiểm tra điều kiện và hiển thị kết quả
        var passStatusCell = document.createElement('td');
        passStatusCell.classList.add('statusRow');
        var finalExam = parseFloat("${finalExam}"); // Lấy giá trị của final exam từ biến JSP
        var totalRounded = Math.round(totalValue * 10) / 10; // Làm tròn tổng giá trị đến chữ số thập phân thứ nhất
        if (totalRounded > 5 || finalExam < 4) {
            passStatusCell.textContent = "Passed";
            passStatusCell.classList.add('pass');
        } else {
            passStatusCell.textContent = "Not Passed";
            passStatusCell.classList.add('notPass');
        }
        totalRow.appendChild(passStatusCell);

        // Thêm dòng tổng vào cuối bảng
        var table = document.querySelector('table');
        table.appendChild(totalRow);
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
    
    <c:choose>
        <c:when test="${empty requestScope.cgs}">
        </c:when>
        <c:otherwise>
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
                        <td>${cgs.value}</td>
                        <td>${cgs.comment}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>


</body>
</html>
