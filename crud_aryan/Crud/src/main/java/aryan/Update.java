package aryan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name1 = request.getParameter("name");
		String email1 = request.getParameter("email");
		String department1 = request.getParameter("department");
		String salary1 = request.getParameter("salary");
		
		emp_detail e = new emp_detail();
		e.setId(id);
		e.setName(name1);
		e.setEmail(email1);
		e.setDepartment(department1);
		e.setSalary(Float.parseFloat(salary1));
		int status = empdao.update(e);
		
		if (status > 0)
		{
			response.sendRedirect("view");
		}
		else
		{
			response.getWriter().println("Sorry for inconvenience");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
