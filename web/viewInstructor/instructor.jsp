<%-- 
    Document   : teacher
    Created on : Feb 26, 2024, 9:09:02 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FPT University Academic Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        #header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px 0;
            margin-bottom: 20px;
        }
        #links {
            text-align: center;
        }
        #links a {
            display: inline-block;
            margin: 0 10px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        #links a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>${requestScope.t}</h1>
    <h1 id="header">FPT University Academic Portal</h1>
    <div id="links">
        <a href="instructor">Time Table</a>
        <a href="#">Teach Mark Report</a>
    </div>
</body>
</html>

