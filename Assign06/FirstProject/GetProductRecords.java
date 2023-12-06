
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class GetProductRecords
 */
public class GetProductRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> pnamelist;
	Connection con;

	@Override
	public void init() throws ServletException {
		String ss = "jdbc:mysql://localhost:3306/bit";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(ss, "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PreparedStatement pst=con.prepareStatement("select pname from products");
			ResultSet rs = pst.executeQuery();
			pnamelist = new ArrayList<String>();
			while(rs.next()) {
				pnamelist.add(rs.getString(1));
			}
			request.setAttribute("plist", pnamelist);
			RequestDispatcher rd= request.getRequestDispatcher("Shop.jsp");
			rd.forward(request, response);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
