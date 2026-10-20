package aryan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class save
 */
@WebServlet("/save")
public class save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name1= request.getParameter("name");
		String email1 = request.getParameter("email");
		String department1 = request.getParameter("department");
		String salary1 = request.getParameter("salary");
		
		emp_detail e1 = new emp_detail();
		e1.setName(name1);
		e1.setEmail(email1);
		e1.setDepartment(department1);
		e1.setSalary(Float.parseFloat(salary1));
		
		int status = empdao.insert(e1);
		
		if(status > 0)
		{
			response.sendRedirect("view");
		}
		else
		{
			response.getWriter().println("Sorry for inconvenince");
		}
	}

}
