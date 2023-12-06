

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterServ
 */
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String ss = "jdbc:mysql://localhost:3306/bit";
			con = DriverManager.getConnection(ss,"root", "root");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		try {
			PreparedStatement pst = con.prepareStatement("insert into person (name,address,email,password) values(?,?,?,?)");
			String name =request.getParameter("name");
			String address =request.getParameter("address");			
			String password =request.getParameter("password");
			String email =request.getParameter("email");
			
			pst.setString(1, name);
			pst.setString(2, address);
			pst.setString(3, email);
			pst.setString(4, password);
			
			pst.executeUpdate();
			
			RequestDispatcher disp = request.getRequestDispatcher("Home.html");
	        disp.forward(request, response);
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
