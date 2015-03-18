<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<c:url value="/resources/img" var="imageURL" />
	<div class="row" style="margin-left: 10px; margin-right: 10px; mar">
		<div id="div-update" class="neuron-tab neuron-div text-center neuron-div-hover neuron-div-active pointerCursor" style="width:20%; float:left">
			<span>Update</span>
		</div>
		<security:authorize access="hasAnyRole('Principal,Teacher')">
		<div id="div-event"
			class="neuron-tab neuron-div neuron-tab-border text-center neuron-div-hover pointerCursor" style="width:20%; float:left">
			<span>Event</span>
		</div>
		<div id="div-assignment"
			class="neuron-tab neuron-div neuron-tab-border text-center neuron-div-hover pointerCursor" style="width:20%; float:left">
			<span>Assignment</span>
		</div>
		<div id="div-poll"
			class="neuron-tab neuron-div neuron-tab-border text-center neuron-div-hover pointerCursor" style="width:20%; float:left">
			<span>Poll</span>
		</div>
		<div id="div-quiz"
			class="neuron-tab neuron-div neuron-tab-border text-center neuron-div-hover pointerCursor" style="width:20%; float:left">
			<span>Quiz</span>
		</div>
		</security:authorize>
	</div>
	
	<div id="div-update-content" class="neuron-div neuron-tab-content"
		style="margin-left: 10px; margin-right: 10px;">
		
			<div style="padding: 10px;">
				<textarea rows="2" class="form-control" id="updateComments"
					style="background: #e9eaec;" placeholder="What you want to update?"></textarea>
			</div>
		
		<div class="row" id="attachmentsList"></div>
		
		<div class="row">
			<div class="col-sm-1 col-md-1">
				
			</div>
			<div class="col-sm-1 col-md-1" id="updateAtachmentDiv">
				<span class="btn btn-default btn-file"> <img
					src="${imageURL}/attachment.png" class="img-rounded" width="20"
					height="20" /><input name="updateAtachment1" id="updateAtachment1"
					type="file">
				</span>
			</div>
			<security:authorize access="hasAnyRole('Principal,Teacher')">
			<div class="col-sm-3 col-md-3">
				<select class="form-control neuron-select" id="postClass">
					<option id="0">- Select Class -</option>
					<c:forEach items="${classSubjectTeachers}" var ="classSubjectTeacher">
								<option id="${classSubjectTeacher.classesByClassId.id}">${classSubjectTeacher.classesBySubjectId.subjectName} - ${classSubjectTeacher.classesByClassId.className}</option>
							</c:forEach>
				</select>
			</div>
			</security:authorize>
			<div class="col-sm-1 col-md-1">
				<span class="glyphicon glyphicon-globe"
					style="color: #4ca4c7; font-size: 24px;"></span>
			</div>
			<div class="col-sm-2 col-md-2">
				
			</div>
			<div class="col-sm-2 col-md-2" style="padding:10px;">
				<a id="schedule_post-btn" href="#">Schedule</a>
			</div>
			<div class="col-sm-2 col-md-2 centered">
				<button type="button" id="submit-post-btn" class="btn neuron-btn btn-block btn-sm">Send</button>
			</div>
		</div>
	</div>
	<div id="div-event-content" class="neuron-div neuron-tab-content"
		style="margin-left: 10px; margin-right: 10px; display: none;">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputTitle">Title</label>
				<div class="col-sm-10">
					<input type="text" class="form-control neuron-text" id="inputTitle" placeholder="Title">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputDesc">Description</label>
				<div class="col-sm-10">
					<input type="text" class="form-control neuron-text" id="inputDesc" placeholder="Description">
				</div>
			</div>
			<div class="form-group">
				<label for="dateEventTime" class="col-sm-2 control-label">Event Date</label>
				<div class="col-sm-3">
					<input type="date" class="form-control neuron-text" id="dateEventTime">
				</div>
				<label for="timeEventTime" class="col-sm-1 control-label">Time</label>
				<div class="col-sm-2">
					<input type="time" class="form-control neuron-text" id="timeEventTime">
				</div>
				<div class="col-sm-4"></div>
			</div>
		</form>
		<hr class="neuron-Hline">
		<div class="row">
			<div class="col-sm-1 col-md-1">
				
			</div>
			<div class="col-sm-1 col-md-1">
				<img src="${imageURL}/attachment.png" class="img-rounded" width="20"
					height="20" />
			</div>
			<security:authorize access="hasAnyRole('Principal,Teacher')">
			<div class="col-sm-3 col-md-3">
				<select id="eventClass" class="form-control neuron-select">
					<option id="0">- Select Class -</option>
					<c:forEach items="${classSubjectTeachers}" var ="classSubjectTeacher">
								<option id="${classSubjectTeacher.classesByClassId.id}">${classSubjectTeacher.classesBySubjectId.subjectName} - ${classSubjectTeacher.classesByClassId.className}</option>
							</c:forEach>
				</select>
			</div>
			</security:authorize>
			<div class="col-sm-1 col-md-1">
				<span class="glyphicon glyphicon-globe"
					style="color: #4ca4c7; font-size: 24px;"></span>
			</div>
			<div class="col-sm-2 col-md-2">
				
			</div>
			<div class="col-sm-2 col-md-2" style="padding:10px;">
				<a id="schedule_event-btn" href="#">Schedule</a>
			</div>
			<div class="col-sm-2 col-md-2">
				<button id="submit-event-btn" type="button" class="btn neuron-btn btn-block btn-sm">Send</button>
			</div>
		</div>
	</div>
	
	<div id="div-assignment-content" class="neuron-div neuron-tab-content"
		style="margin-left: 10px; margin-right: 10px; display: none;">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputTitle">Title</label>
				<div class="col-sm-10">
					<input type="text" class="form-control neuron-text" id="assignmentTitle" placeholder="Title">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputDesc">Description</label>
				<div class="col-sm-10">
					<input type="text" class="form-control neuron-text" id="assignmentDesc" placeholder="Description">
				</div>
			</div>
			<div class="form-group">
				<label for="dateEventTime" class="col-sm-2 control-label">Due Date</label>
				<div class="col-sm-3">
					<input type="date" class="form-control neuron-text" id="assignmentDate">
				</div>
				
				<div class="col-sm-7"></div>
			</div>
		</form>
		<hr class="neuron-Hline">
		<div class="row">
			<div class="col-sm-1 col-md-1">
				
			</div>
			<div class="col-sm-1 col-md-1">
					<span class="btn btn-default btn-file"> 
					<a data-toggle="modal" data-target="#document-upload-modal"><img src="${imageURL}/attachment.png" class="img-rounded" width="20" height="20" /></a>
					</span>
			</div>
			<security:authorize access="hasAnyRole('Principal,Teacher')">
			<div class="col-sm-3 col-md-3">
				<select class="form-control neuron-select" id="assignmentClass">
					<option id="0">- Select Class -</option>
					<c:forEach items="${classSubjectTeachers}" var ="classSubjectTeacher">
								<option id="${classSubjectTeacher.classesByClassId.id}">${classSubjectTeacher.classesBySubjectId.subjectName} - ${classSubjectTeacher.classesByClassId.className}</option>
							</c:forEach>
				</select>
			</div>
			</security:authorize>
			<div class="col-sm-1 col-md-1">
				<span class="glyphicon glyphicon-globe"
					style="color: #4ca4c7; font-size: 24px;"></span>
			</div>
			<div class="col-sm-2 col-md-2">
				
			</div>
			<div class="col-sm-2 col-md-2" style="padding:10px;">
				<a id="schedule_assignment_btn" href="#">Schedule</a>
			</div>
			<div class="col-sm-2 col-md-2">
				<button type="button" id="submit-assignment-btn" class="btn neuron-btn btn-block btn-sm">Send</button>
			</div>
		</div>
	</div>
	
	<div id="div-poll-content" class="neuron-div neuron-tab-content"
		style="margin-left: 10px; margin-right: 10px; display: none;">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputTitle">Question</label>
				<div class="col-sm-10">
					<input type="text" class="form-control neuron-text" id="inputTitle" placeholder="Enter your question here...">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputDesc">Answer1: </label>
				<div class="col-sm-8">
					<input type="text" class="form-control neuron-text" id="inputDesc" placeholder="Enter your answer...">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputDesc">Answer2: </label>
				<div class="col-sm-8">
					<input type="text" class="form-control neuron-text" id="inputDesc" placeholder="Enter your answer...">
				</div>
			</div>
		</form>
		<div class="row">
			<div class="col-sm-9 col-md-9">
			</div>
			<div class="col-sm-3 col-md-3">
				<a id="add_poll_ans" class="text-right" href="#">Add more ans.</a>
			</div>
		</div>
		<hr class="neuron-Hline">
		<div class="row">
			<div class="col-sm-1 col-md-1">
				
			</div>
			<div class="col-sm-1 col-md-1">
				<img src="${imageURL}/attachment.png" class="img-rounded" width="20" height="20" />
			</div>
			<security:authorize access="hasAnyRole('Principal,Teacher')">
			<div class="col-sm-3 col-md-3">
				<select class="form-control neuron-select">
					<option id="0">- Select Class -</option>
					<c:forEach items="${classSubjectTeachers}" var ="classSubjectTeacher">
								<option id="${classSubjectTeacher.classesByClassId.id}">${classSubjectTeacher.classesBySubjectId.subjectName} - ${classSubjectTeacher.classesByClassId.className}</option>
							</c:forEach>
				</select>
			</div>
			</security:authorize>
			<div class="col-sm-1 col-md-1">
				<span class="glyphicon glyphicon-globe"
					style="color: #4ca4c7; font-size: 24px;"></span>
			</div>
			<div class="col-sm-4 col-md-4">
				
			</div>
			<div class="col-sm-2 col-md-2">
				<button type="button" class="btn neuron-btn btn-block btn-sm">Send</button>
			</div>
		</div>
	</div>
	
	
	<div id="div-quiz-content" class="neuron-div neuron-tab-content" style="margin-left: 10px; margin-right: 10px; display: none;">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-3 control-label" for="queType">Select Type: </label>
				<div class="col-sm-7">
					<select class="form-control neuron-select" id="queType">
						<option value="multiple">Multiple Choice</option>
						<option value="boolean">True or False</option>
					</select>
				</div>
				<div class="col-sm-2"></div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="quizTitle">Quiz Title: </label>
				<div class="col-sm-7">
					<input type="text" class="form-control neuron-text" id="quizTitle" placeholder="Enter your Quiz title here...">
				</div>
				<div class="col-sm-2"></div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="pointPerQue">Points per Que: </label>
				<div class="col-sm-2">
					<input type="text" class="form-control neuron-text" id="pointPerQue">
				</div>
				<label class="col-sm-2 control-label" for="dueDate">Due Date: </label>
				<div class="col-sm-3">
					<input type="date" class="form-control neuron-text" id="dueDate">
				</div>
				<div class="col-sm-2"></div>
			</div>
			
			<fieldset>
			<legend>Que1: </legend>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputTitle">Question</label>
				<div class="col-sm-10">
					<input type="text" class="form-control neuron-text" id="inputTitle" placeholder="Enter your question here...">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputDesc">Answer: </label>
				<div class="col-sm-8">
					<input type="text" class="form-control neuron-text" id="inputDesc" placeholder="Enter your answer...">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8 col-md-8">
				</div>
				<div class="col-sm-2 col-md-2 text-right">
					<a class="add_que_ans" href="#">Add more ans.</a>
				</div>
				<div class="col-sm-2 col-md-2">
				</div>
			</div>
			</fieldset>
			</br>
			<div class="row">
				<div class="col-sm-9 col-md-9">
				</div>
				<div class="col-sm-3 col-md-3 text-right" >
					<a id="add_more_que" href="#">Add more Que.</a>
				</div>
			</div>
			
			</br>
			<div class="row">
				<div class="col-sm-10 col-md-10">
				</div>
				<div class="col-sm-2 col-md-2 text-right" >
					<button type="button" class="btn neuron-btn btn-block btn-sm">Submit</button>
				</div>
			</div>
		</form>
		
		<hr class="neuron-Hline">
		<div class="row">
			<div class="col-sm-1 col-md-1">
				
			</div>
			<div class="col-sm-1 col-md-1">
				<img src="${imageURL}/attachment.png" class="img-rounded" width="20" height="20" />
			</div>
			<security:authorize access="hasAnyRole('Principal,Teacher')">
			<div class="col-sm-3 col-md-3">
				<select class="form-control neuron-select">
					<option id="0">- Select Class -</option>
					<c:forEach items="${classSubjectTeachers}" var ="classSubjectTeacher">
								<option id="${classSubjectTeacher.classesByClassId.id}">${classSubjectTeacher.classesBySubjectId.subjectName} - ${classSubjectTeacher.classesByClassId.className}</option>
							</c:forEach>
				</select>
			</div>
			</security:authorize>
			<div class="col-sm-1 col-md-1">
				<span class="glyphicon glyphicon-globe"
					style="color: #4ca4c7; font-size: 24px;"></span>
			</div>
			<div class="col-sm-4 col-md-4">
				
			</div>
			<div class="col-sm-2 col-md-2">
				<button type="button" class="btn neuron-btn btn-block btn-sm">Send</button>
			</div>
		</div>
	</div>
	</br>
<!-- Schedule post Popup -->
	<div class="modal fade" id="schedule-post-popup" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<span class="modal-title" id="failure-popup-title">Schedule</span>
				</div>
				<div class="modal-body">
				<div class="form-group">
					<label for="dateEventTime" class="col-sm-2 control-label">Event Date</label>
					<div class="col-sm-3">
						<input type="date" class="form-control neuron-text" id="scheduleDate">
					</div>
					<label for="timeEventTime" class="col-sm-1 control-label">Time</label>
					<div class="col-sm-2">
						<input type="time" class="form-control neuron-text" id="scheduleTime">
					</div>
					<div class="col-sm-4"></div>
				</div>
					<!-- <input id="postFailureMessage" readonly style="background: #e9eaec; height: 50px; padding: 5px;"/> -->
				</div>
				<div class="modal-footer">
					<button type="button" id="post_schedule_btn" class="btn btn-primary neuron-btn"
						data-dismiss="modal">Submit</button>
				</div>
			</div>
		</div>
	</div>
<!-- Schedule post popup end -->
<!-- Schedule event Popup -->
	<div class="modal fade" id="schedule-event-popup" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<span class="modal-title" id="failure-popup-title">Schedule</span>
				</div>
				<div class="modal-body">
				<div class="form-group">
					<label for="dateEventTime" class="col-sm-2 control-label">Event Date</label>
					<div class="col-sm-3">
						<input type="date" class="form-control neuron-text" id="eventScheduleDate">
					</div>
					<label for="timeEventTime" class="col-sm-1 control-label">Time</label>
					<div class="col-sm-2">
						<input type="time" class="form-control neuron-text" id="eventScheduleTime">
					</div>
					<div class="col-sm-4"></div>
				</div>
					<!-- <input id="postFailureMessage" readonly style="background: #e9eaec; height: 50px; padding: 5px;"/> -->
				</div>
				<div class="modal-footer">
					<button type="button" id="event_schedule_btn" class="btn btn-primary neuron-btn"
						data-dismiss="modal">Submit</button>
				</div>
			</div>
		</div>
	</div>
<!-- Schedule event popup end -->