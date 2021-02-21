<html>
	<head>
		<title>Welcome</title>
		<link rel="stylesheet" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"  />
	</head>
	<body>
		<div class="container">
			<P class="text-info bg-dark p-3" style="text-align:center;">Welcome ${ name } to Spring Boot by JSP</P>
			<p>Click <a type="button" class="btn btn-success" href="/list-todo">here</a> to manage Todo</p>
		</div>
		<%@ include file="common/footer.jspf" %>	