<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import= "java.util.List , jeet.emp_detail" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Employee List</h1>
<a href="Index.html">Add New Employee</a>
<table border="5"  width="100%"  cellpadding="5">
  <tr>
    <td>ID</td>
    <td>Name</td>
    <td>Email</td>
    <td>Department</td>
    <td>Salary</td>
    <td>Edit</td>
    <td>Delete</td>
  </tr>
 <% 
   List<emp_detail> list =(List<emp_detail>)request.getAttribute("employeeList");
   if (list != null)
   {
	   for (emp_detail e: list)
	   {
 %>
 <tr>
   <td><%=e.getId() %></td>
   <td><%=e.getName() %></td>
   <td><%=e.getEmail() %></td>
   <td><%=e.getDepartment() %></td>
   <td><%=e.getSalary() %></td>
   <td><a href="edit?id=<%=e.getId() %>">Edit</a></td>
   <td><a href="Delete?id=<%=e.getId() %>" onclick="return confirm('Delete this employee?');">Delete</a></td>
 </tr>
 <% 
      }
   }
 %>
</table>
</body>
</html>