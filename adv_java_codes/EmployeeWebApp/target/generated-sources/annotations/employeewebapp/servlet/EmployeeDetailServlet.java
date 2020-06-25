package employeewebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import jdbc.Employee;
import jdbc.JdbcRepository;

/**
 * Servlet implementation class EmployeeDetailServlet
 */
public class EmployeeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		List<String> empList = JdbcRepository.getEmployee();

		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("<h3>Employees List</h3>");
		writer.println("<table border=1 width=25% height=50%>");
		writer.println("<tr><th>EmpId</th><th>EmpName</th><tr>");
		ObjectMapper mapper = new ObjectMapper();

		for (String string : empList) {
			Employee emp = mapper.readValue(string, Employee.class);
			writer.println("<tr align='center'><td>" + emp.getEmpId() + "</td><td>" + emp.getEmpName() + "</td></tr>");
		}

		writer.println("</table>");
		writer.println("</html></body>");
		writer.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
