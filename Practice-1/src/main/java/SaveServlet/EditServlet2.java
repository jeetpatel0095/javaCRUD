
package SaveServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.sendError(405, "Please submit the update form");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String sid = request.getParameter("id");

        if (sid == null || sid.trim().isEmpty()) {
            response.sendError(400, "Employee ID is required");
            return;
        }

        int id;

        try {
            id = Integer.parseInt(sid);
        } catch (NumberFormatException ex) {
            response.sendError(400, "Invalid employee ID");
            return;
        }

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String salary = request.getParameter("salary");

        if (name == null || name.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || department == null || department.trim().isEmpty()
                || salary == null || salary.trim().isEmpty()) {

            response.sendError(400, "All fields are required");
            return;
        }

        Emp e = new Emp();

        e.setId(id);
        e.setName(name.trim());
        e.setEmail(email.trim());
        e.setDepartment(department.trim());
        e.setSalary(salary.trim());

        int status = EmpDao.update(e);

        if (status > 0) {

            response.sendRedirect(
                request.getContextPath() + "/View"
            );

        } else {

            response.setContentType("text/html;charset=UTF-8");

            response.getWriter().println(
                "<h3>Unable to update employee.</h3>"
                + "<a href='"
                + request.getContextPath()
                + "/EditServlet?id="
                + id
                + "'>Try Again</a>"
            );
        }
    }
}
