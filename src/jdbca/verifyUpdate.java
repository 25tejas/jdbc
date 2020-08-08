package jdbca;		

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "verifyUpdate",urlPatterns = "/verifyUpdate")
public class verifyUpdate extends HttpServlet 
{
	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String username=request.getParameter("username");
    	String email=request.getParameter("email");
		String password=request.getParameter("password");
    	
    	try 
    	{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tejas","root","root");
			
			PreparedStatement ps= con.prepareStatement("update detail set email=?,password=? where username=?");
			ps.setString(3, username);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.executeUpdate();
			
			response.sendRedirect("AdminData.jsp");
          
   		}
    	catch (Exception e) 
    	{
		    System.out.println(e);
		}
	}
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		doGet(request, response);
	}

}
