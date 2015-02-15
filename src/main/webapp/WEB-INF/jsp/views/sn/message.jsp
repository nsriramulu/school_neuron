<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<h5 style="margin-left: 10px; margin-right: 10px;">PRIVATE MESSAGE</h5>
<div class="row" style="margin-left: 10px; margin-right: 10px;">
		<div id="div-new-message"
			class="col-sm-3 col-md-3 neuron-tab neuron-div text-center neuron-div-hover neuron-div-active pointerCursor">
			<span>Compose</span>
		</div>
		<div id="div-message-inbox"
			class="col-sm-3 col-md-3 neuron-tab neuron-div text-center neuron-div-hover pointerCursor">
			<span>Inbox</span>
		</div>
</div>
<div id="div-new-message-content" class="neuron-div neuron-tab-content"
		style="margin-left: 10px; margin-right: 10px;">
<p>
	<em>Send message to specific student/parent of a specific class</em>
</p>
<div id="body-private-message" class="neuron-div">
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="className" class="col-md-4 control-label">Class
					Name</label>
				<div class="col-md-8">
					<select class="form-control neuron-select" id="messageClassName">
						<option id="0">- Select Class -</option>
					<c:forEach items="${classSubjectTeachers}" var ="classSubjectTeacher">
								<option id="${classSubjectTeacher.classesByClassId.id}">${classSubjectTeacher.classesBySubjectId.subjectName} - ${classSubjectTeacher.classesByClassId.className}</option>
							</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="col-md-6"></div>
	</div>
	</br>
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="student" class="col-md-4 control-label">Student</label>
				<div class="col-md-8">
					<select class="form-control neuron-select" id="messageStudent" >
						<option>- Select Student -</option>
					</select>
				</div>
			</div>
		</div>
		<div class="col-md-6"></div>
	</div>
	</br>
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label for="parentName" class="col-md-4 control-label">Parent
					Name</label>
				<div class="col-md-8">
					<input type="text" class="form-control neuron-text"
						id="parentName" disabled="disabled"/>
						<input type="hidden" id="parentId" name="parentId"/>
				</div>
			</div>
		</div>
		<div class="col-md-6"></div>
	</div>
	<hr>
	<div class="row" style="padding:10px;">
		<!-- <div class="form-group">
			<div class="col-md-12" style="margin-top: 2px; margin-bottom: 2px;">
				<input type="text" class="form-control neuron-text" placeholder="To"
					id="toEmail">
			</div>
		</div> -->
		<div class="form-group">
			<div class="col-md-12" style="margin-top: 2px; margin-bottom: 2px;">
				<input type="text" class="form-control neuron-text" placeholder="Subject" id="messageSubject">
			</div>
		</div>
		<div class="form-group">

			<div class="col-md-12" style="margin-top: 2px; margin-bottom: 2px;">
				<textarea rows="3" class="form-control" id="messageText"
					style="background: #e9eaec;" placeholder="Message"></textarea>
			</div>
		</div>
		</br>
		<div class="form-group">
			<div class="col-sm-1 col-md-1" style="margin-top: 2px; margin-bottom: 2px;">
				<span class="btn btn-default btn-file"> <img
					src="${imageURL}/attachment.png" class="img-rounded" width="20"
					height="20" /><input name="updateAtachment" id="updateAtachment"
					type="file">
				</span>
			</div>
			<div class="col-sm-9 col-md-9"></div>
			<div class="col-sm-2 col-md-2" style="margin-top: 2px; margin-bottom: 2px;">
				<button type="button" class="btn neuron-btn btn-block btn-sm" id="sendMessage">Send</button>
			</div>
		</div>
	</div>
</div>
</div>

<div id="div-message-inbox-content" class="neuron-div neuron-tab-content" style="margin-left: 10px; margin-right: 10px;padding: 10px;display: none;">
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
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
				</tr>
				<tr class="trEvents pointerCursor" data-toggle="modal" data-target="#exampleModal">
					<td>Kuldeep</td>
					<td>I invite you all to join my 7th Graduation Day at
						Cambridge</td>
					<td>13th January</td>
				</tr>
				<tr class="trEvents pointerCursor" data-toggle="modal" data-target="#exampleModal">
					<td>Kuldeep</td>
					<td>I invite you all to join my 8th Graduation Day at
						Cambridge</td>
					<td>13th Feb</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">New message</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="recipient-name" class="control-label">From:</label> <input
								type="text" readonly class="form-control"
								style="border-radius: 10px; background: #e9eaec;"
								id="recipient-name">
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">Message:</label>
							<textarea class="form-control"
								style="border-radius: 10px; background: #e9eaec;" readonly
								id="message-text"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary neuron-btn"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary neuron-btn">Reply</button>
				</div>
			</div>
		</div>
	</div>
</div>