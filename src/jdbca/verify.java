package jdbca;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "register",urlPatterns = "/register")
public class verify extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String username=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try
		{
			//Mention SQL software
			Class.forName("com.mysql.jdbc.Driver");
			//Mention Database url, username and password
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tejas","root","root");
			PreparedStatement ps=con.prepareStatement("insert into detail values(?,?,?)");
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.executeUpdate();
			
			resp.sendRedirect("index.jsp");
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}

		
		
	}
}
