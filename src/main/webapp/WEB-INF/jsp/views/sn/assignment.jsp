<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<h5>ASSIGNMENT</h5>
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
					<h4>Solar System Project</h4>
					
				</div>
				<div id="assignmentDesc">
					<p style="padding:5px;">All students are supposed to create a miniature of Solar system. Refer attached.</p>
				</div>
				<div id="assignmentDate" style="padding:5px;">
					<span>Due on </span><span>13th January 2015</span>
				</div>
				
				<hr class="neuron-Hline">
				<div class="row" style="padding:5px;">
					<div class="col-sm-5 col-md-5">
						<img src="${imageURL}/attachment.png" class="img-rounded" width="20" height="20" />
						<a href="#">Solar System References.pdf</a>
					</div>
					<!--div class="col-sm-5 col-md-5">
						<c:set var="calendar" value="${post.createdDate}" />
							<span> Updated on - <fmt:formatDate pattern="MMM dd" type="date" value="${calendar.time}" />, <fmt:formatDate type="time" value="${calendar.time}" />
							</span>
					</div>
					<div class="col-sm-2 col-md-2">
						<button id="submitOnlineAssignment" type="button" class="btn neuron-btn btn-block btn-sm">Submit online</button>
					</div-->
					<div class="col-md-1"></div>
					<div class="col-sm-2 col-md-2">
						<strong>Marks: <span>25</span></strong>
					</div>
					<div class="col-sm-2 col-md-2">
						<strong>Submitted: <span>12</span></strong>
					</div>
					<div class="col-sm-2 col-md-2">
						<strong>Pending: <span>25</span></strong>
					</div>
				</div>
			</div>
		</div>
	</div>
	</br>
	<div id="assignmentPostDiv" class="row">
		<div class="col-sm-1 col-md-1">
			<img src="${imageURL}/${user.profilePic}" class="img-rounded" alt="Cinque Terre" width="100%" height="100%">
			<span>${post.usersByCreatedBy.firstName}</span>
			<span>${post.usersByCreatedBy.lastName}</span>
		</div>
		<div class="col-sm-11 col-md-11">
			<div class="commentSectionBorder">
				<div style="padding: 10px;">
					<input type="file">
				</div>
				<div style="padding: 10px;">
					<textarea rows="2" class="form-control" id="updateComments" style="background: #e9eaec;" placeholder="Enter you comment here..."></textarea>
				</div>
				
				<div class="text-right" style="padding: 10px;">
					<button type="button" class="btn neuron-btn btn-sm">Submit</button>
				</div>
			</div>
		</div>
	</div>
	</br>
	<div id="submiitedAssignmentList" class="commentSectionBorder">
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
	</div>
	</br>
	<div id="evaluateAssignmentDiv" class="row">
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
	</div>
</div>