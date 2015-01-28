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
					<th>From</th>
					<th>Message</th>
					<th>Time</th>
					<th>From</th>
					<th>Message</th>
					<th>Time</th>
				</tr>
			</thead>
			<tbody>
				<tr class="trEvents pointerCursor" data-toggle="modal" data-target="#exampleModal">
					<td>Naveen</td>
					<td>I invite you all to join my 6th Graduation Day at 
						Cambridge</td>
					<td>13th January</td>
					<td>Naveen</td>
					<td>I invite you all to join my 6th Graduation Day at
						Cambridge</td>
					<td>13th January</td>
				</tr>
				<tr class="trEvents pointerCursor" data-toggle="modal" data-target="#exampleModal">
					<td>Kuldeep</td>
					<td>I invite you all to join my 7th Graduation Day at
						Cambridge</td>
					<td>13th January</td>
					<td>Naveen</td>
					<td>I invite you all to join my 6th Graduation Day at
						Cambridge</td>
					<td>13th January</td>
				</tr>
				<tr class="trEvents pointerCursor" data-toggle="modal" data-target="#exampleModal">
					<td>Kuldeep</td>
					<td>I invite you all to join my 8th Graduation Day at
						Cambridge</td>
					<td>13th Feb</td>
					<td>Naveen</td>
					<td>I invite you all to join my 6th Graduation Day at
						Cambridge</td>
					<td>13th January</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>