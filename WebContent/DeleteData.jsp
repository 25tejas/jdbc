<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Data</title>
<style>
	.myclass
	{
		margin:0 auto;
	}
</style>
</head>
<body>
		<div class="container">
		<jsp:include page="AdminHeader.jsp"></jsp:include>
		
		<form action='verifyDelete' method='post' class="myclass col-lg-6 col-md-9 col-sm-12 col-xs-12">
			
			<div class="form-group">
				<input type="button" value="Delete Data Page" class="btn btn-secondary btn-block"/>
			</div>
			<div class="form-group">
				<label>Enter Username</label>
				<input type="text" name="username" placeholder="Enter Username" class="form-control"/>
			 </div>
			<div class="form-group">
				<input type="submit" value="Delete" class="btn btn-success btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</form>
		
		<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>
</html>