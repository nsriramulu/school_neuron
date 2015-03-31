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
				<label for="dateEventTime" class="col-sm-2 control-label">Due Date</label>
				<div class="col-sm-3">
					<input type="date" class="form-control neuron-text" id="dateEventTime">
				</div>
				
				<div class="col-sm-7"></div>
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
			<div class="col-sm-2 col-md-2">
				
			</div>
			<div class="col-sm-2 col-md-2" style="padding:10px;">
				<a id="schedule_post-btn" href="#">Schedule</a>
			</div>
			<div class="col-sm-2 col-md-2">
				<button type="button" class="btn neuron-btn btn-block btn-sm">Send</button>
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
		<hr class=0"neuron-Hline">
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
				<label class="col-sm-3 control-label" for="pointPerQue">Points for per Que: </label>
				<div class="col-sm-2">
					<input type="text" class="form-control neuron-text" id="pointPerQue">
				</div>
				<label class="col-sm-2 control-label" for="dueDate">Due Date: </label>
				<div class="col-sm-3">
					<input type="date" class="form-control neuron-text" id="dueDate">
				</div>
				<div class="col-sm-2"></div>
			</div>
			
			<br>
			<div id="quizQuestionsDiv" class="commentSectionBorder">
			<div class="questionDiv">
				<div class="form-group">
					<label class="col-sm-2 control-label" for="inputTitle">
						<span class="label label-info" style="float:left;font-size:11px;">1</span>Question
					</label>
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
			</div>
			</br>
			</div>
			<div class="row">
				<div class="col-sm-9 col-md-9">
				</div>
				<div class="col-sm-3 col-md-3 text-right" >
					<a id="add_more_que" href="#">Add more Que.</a>
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
				<button type="button" id="submit-quiz-btn" class="btn neuron-btn btn-block btn-sm">Send</button>
			</div>
		</div>
	</div>
	</br>
	

<!-- 
<div class="tabGroup">
	<ul class="nav nav-tabs attribute-tab-items">
		<li class="active col-md-2 text-center"><a href="#update"
			data-toggle="tab">Update</a></option>
		<li class="col-md-2 text-center"><a href="#event"
			data-toggle="tab">Event</a></option>
		<li class="col-md-2 text-center"><a href="#poll"
			data-toggle="tab">Poll</a></option>
		<li class="col-md-2 text-center"><a href="#quiz"
			data-toggle="tab">Quiz</a></option>
	</ul>
</div>
<div class="tab-content darkGreyBg">
	<div class="tab-pane active" id="update">
		<div>
			<textarea id="updateText"
				placeholder="Send an Update to Parents and Students"></textarea>
		</div>
			<div class="col-sm-12 paddingTop5">
		<div class="col-sm-6">
			<span class="whiteText"></span> 
				<select class="dropdown_module"	id="postClass">
					<option id="0">Class</option>
					<c:forEach items="${classSubjectTeachers}" var ="classSubjectTeacher">
						<option id="${classSubjectTeacher.classesByClassId.id}">${classSubjectTeacher.classesByClassId.className}
							<c:choose> <c:when test="${not empty classSubjectTeacher.classesByClassId.section}">- ${classSubjectTeacher.classesByClassId.section}</c:when></c:choose>
						</option>
					</c:forEach>
				</select> 
				<i class="icon-large icon-attach pointerCursor" id="upload_post" title="Attach File"></i>
		</div>
		<div class="col-sm-3">
			<button type="button" id="schedule_post-btn" class="continue-button">Schedule</button>
		</div>
		<div class="col-sm-3">
			<button type="button" id="submit-post-btn" class="continue-button">Send</button>
		</div>
	</div>
	<div class="buttons_module"></div>
	<div class="row"></div>
	</div>
	<div class="tab-pane whiteBg divBorder" id="event">
		<div class="row need-padding-bottom need-padding-top">
			<div class="col-sm-2 paddingLeft50">Title</div>
			<div class="col-sm-5">
				<input type="text" id="event_title" placeholder="Title" value=""
					class="">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2 paddingLeft50">Description</div>
			<div class="col-sm-5">
				<input type="text" id="event_desc" placeholder="Description"
					value="" class="">
			</div>
		</div>
		<div class="row paddingBottom10">
			<div class="col-sm-2 paddingLeft50">Date</div>
			<div class="col-sm-5">
				<div class="form-group">
					<div class='input-group date' id='datePickerForEvent'>
						<input type='text' class="form-control" data-date-format="YYYY/MM/DD"/>
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
				</div>
			</div>
		</div>
			<div class="col-sm-12 paddingTop5 darkGreyBg">
		<div class="col-sm-6">
			<span class="whiteText"></span> 
				<select class="dropdown_module"	id="eventClass">
					<option id="0">Class</option>
					<option id="1">6th 'D'</option>
					<option id="2">7th 'A'</option>
					<option id="3">10th 'C'</option>
				</select> 
				<i class="icon-large icon-attach pointerCursor" id="upload_post" title="Attach File"></i>
		</div>
		<div class="col-sm-3">
			<button type="button" id="schedule_event-btn" class="continue-button">Schedule</button>
		</div>
		<div class="col-sm-3">
			<button type="button" id="submit-event-btn" class="continue-button">Send</button>
		</div>
	</div>
	<div class="buttons_module"></div>
	<div class="row"></div>
	</div>
</div>
  <div class="modal fade" id="schedule-options-popup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="popup-header">
        <span class="modal-title">Schedule</span>
        <span class="close" data-dismiss="modal" aria-hidden="true"><img src="${imageURL}/close_icon.png"/></span>
      </div>
      <div class="modal-body container-fluid">
<div class="row">
<div class="popup-text col-sm-8  padding-bottom-required check-option">
	<div class="row">
			<div class="col-sm-2">Date</div>
			<div class="col-sm-5">
				<div class="form-group">
					<div class='input-group date' id='datePickerForScheduler'>
						<input type='text' class="form-control" data-date-format="YYYY/MM/DD"/>
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">Time</div>
             <div class="form-group">
             <div class="col-sm-5">
                <div class='input-group date' id='timePickerForScheduler'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span>
                    </span>
                </div>
                </div>
            </div>
		</div>
</div>  
</div>
</div>
<div class="row">
<div class="col-sm-offset-4 col-xs-8">
<div class="col-xs-6">
<button type="button" id="post_schedule_btn" data-dismiss="modal" class="continue-button1">Submit</button>
</div>
<div class="col-xs-6">
<button type="button" class="cancel-button2" data-dismiss="modal">Cancel</button></div>
</div>
</div>
</div>
    </div>
  </div>
<div class="modal fade" id="success-post-popup" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="popup-header">
				<span class="modal-title">Success</span> <span class="close post_success_btn"
					data-dismiss="modal" aria-hidden="true"><img
					src="${imageURL}/close_icon.png" /></span>
			</div>
			<div class="modal-body container-fluid">
				<div class="row">
					<div
						class="popup-text col-sm-8  padding-bottom-required check-option">
						<div class="row">
							<div class="col-sm-7">
								<div class="" id="postSuccessMessage"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-xs-8">
					<div class="col-xs-6">
						<button type="button" data-dismiss="modal"
							class="continue-button1 post_success_btn">Ok</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div> 
<div class="modal fade" id="failure-post-popup" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="popup-header">
				<span class="modal-title">Error</span> <span class="close"
					data-dismiss="modal" aria-hidden="true"><img
					src="${imageURL}/close_icon.png" /></span>
			</div>
			<div class="modal-body container-fluid">
				<div class="row">
					<div
						class="popup-text col-sm-8  padding-bottom-required check-option">
						<div class="row">
							<div class="col-sm-7">
								<div class="" id="postFailureMessage"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-xs-8">
					<div class="col-xs-6">
						<button type="button" id="post_failure_btn" data-dismiss="modal"
							class="continue-button1">Ok</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>-->

<div class="modal fade" id="failure-post-popup" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<span class="modal-title" id="failure-popup-title">Failure</span>
				</div>
				<div class="modal-body">
					<span id="postFailureMessage"></span>
					<!-- <input id="postFailureMessage" readonly style="background: #e9eaec; height: 50px; padding: 5px;"/> -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary neuron-btn"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
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
