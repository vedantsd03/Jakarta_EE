<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f7f7f7;
        }

        h2 {
            text-align: center;
            color: #333;
            text-transform: uppercase;
            margin-bottom: 30px;
        }

        form {
            width: 60%;
            margin: 0 auto;
            background-color: #fff;
            padding: 40px;
            border-radius: 6px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 12px;
            color: #555;
            font-size: 18px;
            font-weight: bold;
        }

        input[type="text"],
        textarea,
        select {
            width: calc(100% - 20px);
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            transition: border-color 0.3s ease;
        }

        input[type="text"]:focus,
        textarea:focus,
        select:focus {
            border-color: #007bff;
            outline: none;
        }

        input[type="submit"] {
            width: 100%;
            padding: 14px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 18px;
            text-transform: uppercase;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<h2>Enter Student Information</h2>

<form id="studentForm" action="AddServlet" method="post">
    <label for="studentName">Student Name:</label>
    <input type="text" id="studentName" name="name">

    <label for="studentAddress">Student Address:</label>
    <textarea id="studentAddress" name="address"></textarea>

    <label for="persistenceStore">Select Store Type:</label>
    <select id="persistenceStore" name="dropdown">
        <option value="file">File</option>
        <option value="database">Database</option>
    </select>

    <input type="submit" value="Submit">
</form>

</body>
</html>
