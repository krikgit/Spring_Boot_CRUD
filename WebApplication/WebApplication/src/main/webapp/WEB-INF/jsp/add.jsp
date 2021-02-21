<%@ include file="common/header.jspf"  %>
<%@ include file="common/navigation.jspf"  %>
		<div class="container">
		<form:form method="post" modelAttribute="todo">
		<form:hidden path="id"/>
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
				<form:input path="desc" type="text" class="form-control" required="required"/>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">Description</form:label>
				<form:input path="targetDate" type="text" class="form-control" required="required"/>
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
			<form:errors path="desc" cssClass="text-info" />
			<form:errors path="targetDate" cssClass="text-info" />
		</form:form>
		</div>
<%@ include file="common/footer.jspf" %>		
		