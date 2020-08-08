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


@WebServlet(name = "verifyDelete",urlPatterns = "/verifyDelete")
public class verifyDelete extends HttpServlet 
{
	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String username=request.getParameter("username"); 
    	try 
    	{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tejas","root","root");
			
			PreparedStatement pt= con.prepareStatement("delete from detail where username=?");

            pt.setString(1, username);
            pt.executeUpdate();
  
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
