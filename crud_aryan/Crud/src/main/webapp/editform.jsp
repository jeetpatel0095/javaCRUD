<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="aryan.emp_detail" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Edit Employee</h1>
<% 
   emp_detail emp = (emp_detail) request.getAttribute("employee");
%>
<form action="Update" method="post">
   <input type="hidden" name="id" value="<%=emp.getId()%>">
   <table border="1" cellpadding = "5">
      <tr>
       <td>Name:-</td>
       <td><input type="text" name="name" value="<%=emp.getName()%>" required></td>
      </tr>
      <tr>
       <td>Email:-</td>
       <td><input type="text" name="email" value="<%=emp.getEmail()%>" required></td>
      </tr>
      <tr>
       <td>Department:-</td>
       <td><input type="text" name="department" value="<%=emp.getDepartment()%>" required></td>
      </tr>
      <tr>
       <td>Salary:-</td>
       <td><input type="text" name="salary" value="<%=emp.getSalary()%>" required></td>
      </tr>
      <tr>
      <td colspan = "2"><input type="submit" value="Update"></td>
      </tr>
   </table>
</form>
<br>
<br>
<a href="view">Updated List of Employees</a>
</body>
</html>