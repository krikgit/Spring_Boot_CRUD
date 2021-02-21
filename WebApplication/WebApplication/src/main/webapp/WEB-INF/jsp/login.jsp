<%@ include file="common/header.jspf"  %>
<%@ include file="common/navigation.jspf"  %>
	<div class="container">
		<P>Welcome to Spring Boot by JSP</P>
		<form method="post">
			Name : <input type="text" name="name"><br/>
			Pass : <input type="password" name="pass"><br/>
			<input type="submit" value="Submit">
		</form>
		<p style="color:red;">${ errMsg }
	</div>
<%@ include file="common/footer.jspf" %>	