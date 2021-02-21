<%@ include file="common/header.jspf"  %>
<%@ include file="common/navigation.jspf"  %>
	<div class="container">
		<p>Here is the list of ${ name }'s activity status.</p>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Learning Topic</th>
					<th>Tantetive Date</th>
					<th>Status</th> 
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${activities}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
						<td>${todo.done}</td>
						<td><a type="button" class="btn btn-success" href="/updateAct?id=${todo.id}">Update</a></td>
						<td><a type="button" class="btn btn-danger" href="/deleteAct?id=${todo.id}">Delete</a></td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
		</div>
		<div >
			<p><a class="button" href="/add-todo">Add Activity</a></p>
		</div>
		<%@ include file="common/footer.jspf" %>	