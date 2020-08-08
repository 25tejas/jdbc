

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


@WebServlet("/verifyLogin")
public class verifyLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    public verifyLogin() 
    {
        super();
    } 
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String username=request.getParameter("username"); 
		String password=request.getParameter("password");
    	
    	try 
    	{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tejas","root","root");
			
			PreparedStatement pt= con.prepareStatement("select userName,password from detail where userName=?");

          
            pt.setString(1, username);
            ResultSet rs = pt.executeQuery();
            String orgUname = "", orPass = "";
            while (rs.next()) 
            {
                orgUname = rs.getString("username");
                orPass = rs.getString("password");
            } 
            if (orPass.equals("admin"))
            {
            	 
            	response.sendRedirect("AdminData.jsp");
                rs.close();
            	
            } 
            else if(orPass.equals(password))
            {
            	response.sendRedirect("index.jsp");
                rs.close();
            }
            else 
            {
            	response.sendRedirect("login.jsp");
            }
			
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
