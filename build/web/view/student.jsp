<%-- 
    Document   : fap
    Created on : Feb 25, 2024, 8:06:54 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        #header {
            text-align: center;
            color: #333;
            margin-top: 50px;
        }
        #links {
            text-align: center;
            margin-top: 30px;
        }
        #links a {
            display: inline-block;
            text-decoration: none;
            color: #007bff;
            padding: 10px 20px;
            margin: 10px;
            border-radius: 5px;
            background-color: #fff;
            border: 1px solid #007bff;
            transition: background-color 0.3s, color 0.3s;
        }
        #links a:hover {
            background-color: #007bff;
            color: #fff;
        }
    </style>
</head>
<body>
    
    <h1 id="header">FPT University Academic Portal</h1>
    <div id="links">
        <a href="student">Time Table</a>
        <a href="#">Mark Report</a>
    </div>
</body>
</html>
