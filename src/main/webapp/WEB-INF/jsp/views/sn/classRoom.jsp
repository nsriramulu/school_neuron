<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<div id="myClassRoomDiv" class="neuron-div" style="margin-left: 10px; margin-right: 10px;padding: 10px;">
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Gender</th>
					<th>Birthday</th>
					<th>Email</th>
				</tr>
			</thead>
			
			<tbody>
			  	<c:forEach var="student" items="${students}">
			  	<tr class="trEvents pointerCursor" data-toggle="modal" data-target="#exampleModal">
					<td>${student.firstName} ${student.lastName}</td>
					<td>${student.gender}</td>
					<td>${student.birthday}</td>
					<td>${student.email}</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
</div>