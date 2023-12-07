
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles.Lookup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * Servlet implementation class StudentServ
 */
public class StudentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private List<Integer> mylist = new ArrayList<Integer>();

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String ss = "jdbc:mysql://localhost:3306/bit";
			con = DriverManager.getConnection(ss, "root", "root");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			int rollno = Integer.parseInt(request.getParameter("rollno"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String address = request.getParameter("address");

			PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?,?)");
			pst.setInt(1, rollno);
			pst.setString(2, name);
			pst.setInt(3, age);
			pst.setString(4, address);

			int k = pst.executeUpdate();
			if (k > 0)
				out.print(k + " record inserted");
			else
				out.print("no record inserted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		try {
			PreparedStatement pst = con.prepareStatement("select rollno from student");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				mylist.add(rs.getInt(1));
			}
			request.setAttribute("list",mylist);
			RequestDispatcher rd = request.getRequestDispatcher("Report.jsp");
			rd.forward(request, responce);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
