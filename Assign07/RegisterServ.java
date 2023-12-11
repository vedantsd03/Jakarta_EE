
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.Register;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class RegisterServ
 */
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Configuration confg;
	private SessionFactory factory;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		confg = new Configuration();
		confg.configure("hibernate.cfg.xml");
		factory = confg.buildSessionFactory();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		Register register = new Register();
		
		register.setName(request.getParameter("name"));
		register.setAddress(request.getParameter("address"));
		register.setEmail_id(request.getParameter("email"));
		register.setLogin(request.getParameter("login"));
		register.setPassword(request.getParameter("password"));
			
        session.persist(register);
        tr.commit(); 
        factory.close();
	}

}
