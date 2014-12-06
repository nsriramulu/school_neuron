<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources/images" var="imageURL" />
<div class="tabGroup">
	<!-- Nav tabs -->
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
	<!-- update tab start -->
	<div class="tab-pane active" id="update">
		<div>
			<textarea id="updateText"
				placeholder="Send an Update to Parents and Students"></textarea>
		</div>
	</div>
	<!-- update tab end -->
	<!-- event tab start -->
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
		<div class="row">
			<div class="col-sm-2 paddingLeft50">Type</div>
			<div class="col-sm-5">
				<select id="event_type" class="">
					<option>-- Select --</option>
					<option>Assignment</option>
					<option>Parents Meeting</option>
					<option>Sports</option>
					<option>Cultural</option>
				</select>
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
	</div>
	<!-- event tab end -->
	<div class="col-sm-12 paddingTop5">
		<div class="col-sm-6">
			<span class="whiteText"></span> 
				<select class="dropdown_module"	id="postClass">
					<option id="0">Class</option>
					<option id="1">6th 'D'</option>
					<option id="2">7th 'A'</option>
					<option id="3">10th 'C'</option>
				</select> 
				<i class="icon-large icon-attach pointerCursor" id="upload_post" title="Attach File"></i>
			<!-- <i class="icon-large icon-alarm pointerCursor" id="schedule_post" title="Schedule to post automatically"></i> -->
			<!-- <input type="file" id="post_file" class=""> -->
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
<!-- schedule modal dialog start-->
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
<!-- schedule modal dialog end -->
<!-- success modal dialog start-->
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
<!-- success modal dialog end -->
<!-- failure modal dialog start-->
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
</div>
<!-- failure modal dialog end -->