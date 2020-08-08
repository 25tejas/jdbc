<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Data</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	</head>
<body>
		<div class="container">
			<jsp:include page="AdminHeader.jsp"></jsp:include>
			
			<h1 class="text-center">User Data</h1>
			<div class="row">
				
				
<%
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tejas","root","root");
	PreparedStatement pt= con.prepareStatement("select * from detail");
	ResultSet rs= pt.executeQuery();

	while(rs.next())
	{
	%>
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center border">
			 
			<button class="btn btn-light"><%=rs.getString("username") %></button>
			<button class="btn btn-light"><%=rs.getString("email") %></button>
			<button class="btn btn-light"><%=rs.getString("password") %></button> 		
			
		</div>
		<br>
		 
	<%
	}
	con.close();
} 
catch (Exception e) 
{
	System.out.println(e);	
}
%>
 
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
</body>
</html>