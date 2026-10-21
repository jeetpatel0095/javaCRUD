package SaveServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/View")
public class View extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public View() {
        super();
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        List<Emp> list = EmpDao.getAllEmployees();

        out.print("<h1>Employees List</h1>");

        out.print("<a href='index.html'>Add New Employee</a><br><br>");

        out.print("<table border='1' width='100%'>");

        out.print("<tr>"
                + "<th>Id</th>"
                + "<th>Name</th>"
                + "<th>Email</th>"
                + "<th>Department</th>"
                + "<th>Salary</th>"
                + "<th>Edit</th>"
        		+ "<th>Delete</th>"
                + "</tr>");

        for (Emp e : list) {

            out.print("<tr>"
                    + "<td>" + e.getId() + "</td>"
                    + "<td>" + e.getName() + "</td>"
                    + "<td>" + e.getEmail() + "</td>"
                    + "<td>" + e.getDepartment() + "</td>"
                    + "<td>" + e.getSalary() + "</td>"
                    + "<td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>"  
                    + "<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td>"
                    + "</tr>");
        }

        out.print("</table>");

        out.close();
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}