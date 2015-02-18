<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<h5>UPCOMING EVENTS</h5>

<c:choose>
		<c:when test="${fn:length(posts) gt 0}">
			<c:forEach var="post" begin="0" end="${fn:length(posts)-1}"
				items="${posts}">
				<div id="body-assignment" class="neuron-div" style="padding: 10px;">
	<div class="row">
		<div class="col-sm-1 col-md-1">
			<img src="${imageURL}/${post.usersByCreatedBy.profilePic}" class="img-rounded" alt="Cinque Terre" width="100%" height="100%">
									<c:choose>
										<c:when test="${user.uid eq post.usersByCreatedBy.uid}">
										You
										</c:when>
										<c:otherwise>
										<span>${post.usersByCreatedBy.role}</span>
										<span>${post.usersByCreatedBy.firstName}</span>
										<span>${post.usersByCreatedBy.lastName}</span>
									</c:otherwise>
									</c:choose>
		</div>
		<div class="col-sm-11 col-md-11">
			<div class="commentSectionBorder">
				<div id="event_name">
					<span class="label label-info" style="float:right;margin-top:-12px;font-size:12px;">Events</span>
					<h4>${post.eventTitle}</h4>
				</div>
				<div id="eventDesc">
					<p style="padding:5px;">${post.eventDesc}</p>
				</div>
				<div id="eventDate" style="padding:5px;">
					<c:set var="eventDate" value="${post.eventDate}" />
			<span>on </span><span><fmt:formatDate pattern="MMM dd" type="date"
									value="${eventDate.time}" />, <fmt:formatDate type="time"
									value="${eventDate.time}" /></span>
				</div>
				
				<c:choose>
						<c:when test="${user.uid eq post.usersByCreatedBy.uid}">
							<div class="row">
								<div class="col-md-1">YES</div>
								<div class="col-md-10">
									<div class="progress" style="border-radius: 10px;">
									  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${post.likeCount}" aria-valuemin="0" aria-valuemax="100" style="width: ${post.likeCount}%; border-radius: 10px;">
										<span class="sr-only">${post.likeCount}</span>
									  </div>
									</div>
								</div>
								<div class="col-md-1">${post.likeCount}</div>
							</div>
							<div class="row">
								<div class="col-md-1">NO</div>
								<div class="col-md-10">
									<div class="progress" style="border-radius: 10px;">
									  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="${post.disLikeCount}" aria-valuemin="0" aria-valuemax="100" style="width: ${post.disLikeCount}%; border-radius: 10px;"><span class="sr-only">${post.disLikeCount}</span></div>
									</div>
								</div>
								<div class="col-md-1">${post.disLikeCount}</div>
							</div>
							<div class="row">
								<div class="col-md-1">MAYBE</div>
								<div class="col-md-10">
									<div class="progress" style="border-radius: 10px;">
									  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${post.commentCount}" aria-valuemin="0" aria-valuemax="100" style="width: ${post.commentCount}%; border-radius: 10px;"><span class="sr-only">${post.commentCount}</span></div>
									</div>
								</div>
								<div class="col-md-1">${post.commentCount}</div>
							</div>
						</c:when>
						<c:otherwise>
						<hr class="neuron-Hline">
						<div class="row">
							<div class="col-sm-2 col-md-2">
								<button type="button" class="btn neuron-btn center-block btn-sm event-response yes" id="${post.id}_yes">YES</button>
							</div>
							<div class="col-sm-2 col-md-2">
								<button type="button" class="btn neuron-btn center-block btn-sm event-response no" id="${post.id}_no">NO</button>
							</div>
							<div class="col-sm-2 col-md-2">
								<button type="button" class="btn neuron-btn center-block btn-sm event-response maybe" id="${post.id}_maybe">MAYBE</button>
							</div>
							<div class="col-sm-1 col-md-1">
							</div>
							<div class="col-sm-5 col-md-5">
								<c:set var="calendar" value="${post.createdDate}" />
									<span> Updated on - <fmt:formatDate pattern="MMM dd" type="date" value="${calendar.time}" />, <fmt:formatDate type="time" value="${calendar.time}" />
									</span>
							</div>
						</div>
						</c:otherwise>
					</c:choose>
			</div>
		</div>
	</div>
</div>
<br/>
	</c:forEach>
	</c:when>
	</c:choose>
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