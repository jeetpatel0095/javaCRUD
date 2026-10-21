
package SaveServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

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

        Emp employee = EmpDao.getEmployeeById(id);

        if (employee == null) {
            response.sendError(404, "Employee not found");
            return;
        }

        request.setAttribute("employee", employee);

        RequestDispatcher rd =
            request.getRequestDispatcher("/editform.jsp");

        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
