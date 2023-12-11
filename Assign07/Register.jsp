<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }
    
    h2 {
      text-align: center;
      margin-bottom: 20px;
    }
    
    form {
      width: 300px;
      margin: 0 auto;
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    
    label, input, textarea {
      display: block;
      margin-bottom: 15px;
    }
    
    input[type="text"],
    input[type="email"],
    input[type="password"],
    textarea {
      width: calc(100% - 20px);
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      font-size: 14px;
    }
    
    input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      padding: 10px 15px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
    }
    
    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>

  <h2>User Registration</h2>

  <form action="RegisterServ" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">
    
    <label for="address">Address:</label>
    <textarea id="address" name="address"></textarea>
    
    <label for="email">Email ID:</label>
    <input type="email" id="email" name="email">
    
    <label for="login">Login:</label>
    <input type="text" id="login" name="login">
    
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    
    <input type="submit" value="Submit">
  </form>

</body>
</html>