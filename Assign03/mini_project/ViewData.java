

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class ViewData
 */
public class ViewData extends HttpServlet {
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
		out.print(" <a href=\"Home.html\">Home Page</a><br><br>");
		try {
			PreparedStatement pst = con.prepareStatement("select * from person");

			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				out.println(rs.getObject(1));
				out.print("<br><br>");
				out.println(rs.getObject(2));
				out.print("<br><br>");
				out.println(rs.getObject(3));
				out.print("<br><br>");
				out.println(rs.getObject(4));
				out.print("<br><br>");
				out.print("<br><br>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
