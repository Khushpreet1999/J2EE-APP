package Midterm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Step7b_Khushpreet
 */
@WebServlet("/Step7b_Khushpreet")
public class Step7b_Khushpreet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Step7b_Khushpreet() {
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
		String dob=request.getParameter("dob");
		String title =request.getParameter("title");
		
		String status=request.getParameter("status");
		try {
			Class.forName("com.mysql.jdbc.Driver"); }
			catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
			}
		//Step 2: Connect to the DB server (using connection string)
		try {
			String dbURL =
			"jdbc:mysql://localhost:3306/HumberEvents"; 
			String username = "root";
			String password = "Khush@1999";
			Connection connection = DriverManager.getConnection(dbURL, username, password);
			PreparedStatement ps=connection.prepareStatement("insert into Member values(?,?,?,?,?,?)");  
			
			ps.setString(1, email);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, dob);
			ps.setString(5, title);
			ps.setString(6, status);
			
			ps.executeUpdate();
			
			//Step 3: Formulate Query and run
			
			
			}
			catch(SQLException e) {
			  for (Throwable t : e) t.printStackTrace();
			}
		response.getWriter().append("Database Updated!!!");
		
	}
	
		
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
