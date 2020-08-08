<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.myclass
	{
		margin:0 auto;
	}
</style>
</head>
<body>
		<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		
		<form action='register' method='post' class="myclass col-lg-6 col-md-9 col-sm-12 col-xs-12">
			
			<div class="form-group">
				<input type="button" value="Register Page" class="btn btn-secondary btn-block"/>
			</div>
			<div class="form-group">
				<label>Enter Username</label>
				<input type="text" name="username" placeholder="Enter Username" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Enter Email</label>
				<input type="email" name="email" placeholder="Enter Email" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Enter Password</label>
				<input type="password" name="password" placeholder="Enter Password" class="form-control"/>
			</div>
			<div class="form-group">
				<input type="submit" value="Register" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</form>
		
		<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>
</html>