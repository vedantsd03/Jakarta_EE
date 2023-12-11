
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.Student;
import mypack.StudentDAO;
import mypack.StudentDAODataImpl;
import mypack.StudentDAOFileImpl;

import java.io.IOException;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDAO sdao;

		String name = request.getParameter("name");
		String add = request.getParameter("address");
		System.out.println(name);
		Student student = new Student();
		student.setName(name);
		student.setAddress(add);
		System.out.println(student.getName());

		if ("database".equals(request.getParameter("dropdown"))) {
			sdao = new StudentDAODataImpl();
			sdao.addStudent(student);
		}
		else if("file".equals(request.getParameter("dropdown"))) {
			sdao= new StudentDAOFileImpl();
			sdao.addStudent(student);			
		}
	}

}
