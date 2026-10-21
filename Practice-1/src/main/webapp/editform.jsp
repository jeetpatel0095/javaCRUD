

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
</head>

<body>


    <h2>Edit Employee</h2>

    <form action="${pageContext.request.contextPath}/EditServlet2"
          method="post">

        <input type="hidden" name="id"
               value="${employee.id}">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name"
               value="${employee.name}" required>
               
         <br></br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email"
               value="${employee.email}" required>
               
                        <br></br>
               

        <label for="department">Department:</label>
        <input type="text" id="department" name="department"
               value="${employee.department}" required>
               
                        <br></br>
               

        <label for="salary">Salary:</label>
        <input type="text" id="salary" name="salary"
               value="${employee.salary}" required>
               
                        <br></br>
               

        <input type="submit" value="Update Employee">

    </form>



</body>
</html>
