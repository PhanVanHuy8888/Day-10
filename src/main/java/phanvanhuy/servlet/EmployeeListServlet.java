package phanvanhuy.servlet;


import phanvanhuy.dao.EmployeDAO;
import phanvanhuy.dao.EmployeeDaoImpl;
import phanvanhuy.entity.Employee;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;



/**
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/employeeList")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = new EmployeeDaoImpl().getAllEmployee();
        
        // Truyền danh sách Employee tới trang JSP
        request.setAttribute("employeeList", employeeList);
        
        // Chuyển hướng tới trang JSP
        request.getRequestDispatcher("/WEB-INF/views/employeeList.jsp").forward(request, response);
   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
