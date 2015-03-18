<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<h5>ASSIGNMENT</h5>
<c:choose>
		<c:when test="${fn:length(posts) gt 0}">
			<c:forEach var="post" begin="0" end="${fn:length(posts)-1}"
				items="${posts}">
<div id="body-assignment" class="neuron-div" style="padding: 10px;">
	<div class="row">
		<div class="col-sm-1 col-md-1">
			<img src="${imageURL}/${user.profilePic}" class="img-rounded" alt="Cinque Terre" width="100%" height="100%">
			<span>${post.usersByCreatedBy.firstName}</span>
			<span>${post.usersByCreatedBy.lastName}</span>
		</div>
		<div class="col-sm-11 col-md-11">
			<div class="commentSectionBorder">
				<div id="assignment_name">
					<span class="label label-info" style="float:right;margin-top:-12px;font-size:12px;">Assignment</span>
					<h4>${post.eventTitle}</h4>
					
				</div>
				<div id="assignmentDesc">
					<p style="padding:5px;">${post.eventDesc}</p>
				</div>
				<div id="assignmentDate" style="padding:5px;">
					<c:set var="dueDate" value="${post.eventDate}" />
					<span>Due on </span><span><fmt:formatDate pattern="dd MMM yyyy" type="date" value="${dueDate.time}" /></span>
				</div>
				
				<hr class="neuron-Hline">
				<div class="row" style="padding:5px;">
					<div class="col-sm-5 col-md-5">
						<img src="${imageURL}/attachment.png" class="img-rounded" width="20" height="20" />
						<a href="downloadDoc?fileName=${post.uploads}">${post.uploads}</a>
					</div>
					<!--div class="col-sm-5 col-md-5">
						<c:set var="calendar" value="${post.createdDate}" />
							<span> Updated on - <fmt:formatDate pattern="MMM dd" type="date" value="${calendar.time}" />, <fmt:formatDate type="time" value="${calendar.time}" />
							</span>
					</div>
					<div class="col-sm-2 col-md-2">
						<button id="submitOnlineAssignment" type="button" class="btn neuron-btn btn-block btn-sm">Submit online</button>
					</div-->
					<div class="col-md-offset-1"></div>
					<div class="col-sm-offset-2 col-md-offset-2">
					</div>
					<div class="col-sm-2 col-md-2">
						<strong>Marks: <span>22/25</span></strong>
					</div>
					<input type="hidden" id="${post.id}_submittedCount" value="${post.likeCount}"/>
					<div class="col-sm-offset-2 col-md-offset-2" id="submit_online_div">
						<button id="${post.id}_assignment" class="btn student-submit-assignment">Submit Online</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</br>
	<!-- -->
	</br>
	<!-- <div id="submiitedAssignmentList" class="commentSectionBorder">
		<h4>Submitted: 12</h4>
		<div class="row" >
			<div class="col-md-1">
			</div>
			<div class="col-md-11">
				<div class="table-responsive">
					<table class="table table-striped">
						<tbody>
							<tr>
								<td><span style="font-size:18px;" class="glyphicon glyphicon-envelope"></span></td>
								<td>Arun submitted assignment on 12/12/2014</td>
								<td>Evaluate</td>
							</tr>
							<tr>
								<td><span style="font-size:18px;" class="glyphicon glyphicon-envelope"></span></td>
								<td>Arun submitted assignment on 12/12/2014</td>
								<td>Evaluate</td>
							</tr>
							<tr>
								<td><span style="font-size:18px;" class="glyphicon glyphicon-envelope"></span></td>
								<td>Arun submitted assignment on 12/12/2014</td>
								<td>Evaluate</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div> -->
	</br>
	<!-- <div id="evaluateAssignmentDiv" class="row">
		<div class="col-sm-1 col-md-1">
			<img src="${imageURL}/${user.profilePic}" class="img-rounded" alt="Cinque Terre" width="100%" height="100%">
			<span>${post.usersByCreatedBy.firstName}</span>
			<span>${post.usersByCreatedBy.lastName}</span>
		</div>
		<div class="col-sm-11 col-md-11">
			<div class="commentSectionBorder">
				<div style="padding: 10px;">
					<span>{firstName}{lastName}</span></br>
					<span>Class 6A</span>
				</div>
				<div class="row" style="padding:10px;">
					<div class="col-sm-6 col-md-6">
						<img src="${imageURL}/attachment.png" class="img-rounded" width="20" height="20" />
						<a href="#">Solar System References.pdf</a>
					</div>
				</div>
				<div style="padding: 10px;">
					<textarea rows="2" class="form-control" id="updateComments" style="background: #e9eaec;" placeholder="Enter you comment here..."></textarea>
				</div>
				<div class="row" style="padding:10px;">
					<label class="col-sm-2 control-label" for="awardPoints">Award Points: </label>
					<div class="col-sm-2">
						<input type="text" value="/25" class="form-control neuron-text" id="awardPoints">
					</div>
					<div class="col-sm-8 text-right" style="padding: 10px;">
						<button type="button" class="btn neuron-btn btn-sm">Send</button>
					</div>
				</div>
			</div>
		</div>
	</div> -->
</div>
	</c:forEach>
	</c:when>
	</c:choose>
<!-- submit assignment modal -->
	<div class="modal fade" id="submit-assignment" tabindex="-2" role="dialog"
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
				<input type="hidden" id="assignemntIdToSubmit" value=""/>
				<div id="assignmentPostDiv" class="row">
					<div class="col-sm-1 col-md-1">
						<img src="${imageURL}/${user.profilePic}" class="img-rounded"
							alt="Cinque Terre" width="100%" height="100%"> <span>${post.usersByCreatedBy.firstName}</span>
						<span>${post.usersByCreatedBy.lastName}</span>
					</div>
					<div class="col-sm-11 col-md-11">
						<div class="commentSectionBorder">
							<div style="padding: 10px;">
								<a data-toggle="modal" data-target="#document-upload-modal"><img src="${imageURL}/attachment.png" class="img-rounded" width="20" height="20" /></a>
							</div>
							<div style="padding: 10px;">
								<textarea rows="2" class="form-control" id="assignmentComments"
									style="background: #e9eaec;"
									placeholder="Enter you comment here..."></textarea>
							</div>
						</div>
					</div>
				</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="assignment-submit-modal" class="btn btn-primary neuron-btn"
						data-dismiss="modal">Submit</button>
				</div>
			</div>
		</div>
	</div>
<!--  end submit assignment -->