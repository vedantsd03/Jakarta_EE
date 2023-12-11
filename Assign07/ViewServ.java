

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.Register;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Servlet implementation class ViewServ
 */
public class ViewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Configuration confg;
	private SessionFactory factory;
	private List<?> mylist;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		confg = new Configuration();
		confg.configure("hibernate.cfg.xml");
		factory = confg.buildSessionFactory();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session=factory.openSession();
		Query<?> query=session.createQuery("from Register",Register.class);
		mylist=(List<?>) query.list();
		request.setAttribute("list",mylist);
		RequestDispatcher rd = request.getRequestDispatcher("ViewServ.jsp");
		rd.forward(request, response);
		factory.close();
	}

}
