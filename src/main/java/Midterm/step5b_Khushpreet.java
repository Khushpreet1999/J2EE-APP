package Midterm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class step5b_Khushpreet
 */
@WebServlet("/step5b_Khushpreet")
public class step5b_Khushpreet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public step5b_Khushpreet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email= request.getParameter("email");
		String fname= request.getParameter("fname");
		String lname=request.getParameter("lname");
		String title =request.getParameter("title");
		
		String dob=request.getParameter("dob");
		String status=request.getParameter("status");
		
		
		response.getWriter().append("Thank you, "+ title + fname + lname + "for registering in this event. We will\n" + "contact"
				+ "you via " + email + ". " + "Your DOB is "+ dob + ", and you are "+ status );
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
