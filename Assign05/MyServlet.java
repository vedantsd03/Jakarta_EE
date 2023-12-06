

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> mylist=null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mylist = new ArrayList<String>();
		mylist.add("Vedant");
		mylist.add("Kunal");
		mylist.add("Swapnil");
		mylist.add("Obaid");
		mylist.add("Vardhaman");
		mylist.add("Yash");
		mylist.add("Mayuri");
		mylist.add("Divyanshu");
		mylist.add("Shubham");		
	
		HttpSession session = request.getSession();
		session.setAttribute("group3", mylist);
		PrintWriter out = response.getWriter();
		out.print("Session has been created");
	}

}
