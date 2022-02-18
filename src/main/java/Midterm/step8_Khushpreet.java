package Midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class step8_Khushpreet
 */
@WebServlet("/step8_Khushpreet")
public class step8_Khushpreet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public step8_Khushpreet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>"); 
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
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
			
			
			
			//Step 3: Formulate Query and run
		
			String query="select * from HumberEvents.Member";
			Statement statement =  connection.createStatement();
			ResultSet myRs = statement.executeQuery("select Email, FirstName, LastName, DOB, Title, Status from HumberEvents.Member");
			   out.println("<table border=1 width=50% height=50%>");  
	             out.println("<tr><th>Email</th><th>FirstName</th><th>LastName</th><th>DOB</th><th>Title</th><th>Status</th><tr>");  
			while(myRs.next())
			{
				String email = (myRs.getString("Email"));
				String fname = (myRs.getString("FirstName"));
				String lname = (myRs.getString("LastName"));
				String dob =(myRs.getString("DOB"));
				String title =(myRs.getString("Title"));
				String status = (myRs.getString("Status"));
				
				
			
			out.println("<tr><td>" + email+ "</td><td>" + fname + "</td><td>" + lname +"</td><td>" + dob +"</td><td>"  + title +"</td><td>" + status + "</td></tr>");   
			}
    out.println("</table>");  
    out.println("</html></body>");  
    connection.close();  
   
		}
	
    catch (Exception e) 
   {  
    out.println("error");  
}  
}  

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
