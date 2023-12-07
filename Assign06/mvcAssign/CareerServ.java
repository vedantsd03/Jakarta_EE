

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.CareerExpert;

import java.io.IOException;

/**
 * Servlet implementation class CareerServ
 */
public class CareerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 CareerExpert obj = new CareerExpert();
		 String qualifaction= request.getParameter("text_field");
		 System.out.println(qualifaction);
		 String op=obj.getAdvice(qualifaction);
		 System.out.println(op);
		 request.setAttribute("qual", op);
		 RequestDispatcher rd = request.getRequestDispatcher("CareerDetails.jsp");
		 rd.forward(request, response);
	}

}
