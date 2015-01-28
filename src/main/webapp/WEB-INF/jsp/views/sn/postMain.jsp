<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />

<c:choose>
		<c:when test="${fn:length(posts) gt 0}">
			<c:forEach var="post" begin="0" end="${fn:length(posts)-1}"
				items="${posts}">
	<div class="neuron-div" style="margin-left: 10px; margin-right: 10px;">
		<div>
			<img src="${imageURL}/${post.usersByCreatedBy.role}.jpg" class="img-circle"
				alt="Cinque Terre" width="30" height="30"> <span><b>${post.usersByCreatedBy.role}
									${post.usersByCreatedBy.firstName}
									${post.usersByCreatedBy.lastName}</b></span>&nbsp;&nbsp;
									<c:set var="calendar" value="${post.createdDate}" />
			<span>Posted an update on - <fmt:formatDate pattern="MMM dd" type="date"
									value="${calendar.time}" />, <fmt:formatDate type="time"
									value="${calendar.time}" /></span>
		</div>
		<div style="padding-bottom: 5px;">
			<input readonly
				style="background: #e9eaec; height: 50px; padding: 5px;"
				value="${post.message}">
		</div>
		<div class="row">
			<div class="col-sm-3 col-md-3">
				<span class="like_link" id="${post.id}_like"><img src="${imageURL}/appreciate.png"
					class="img-rounded pointerCursor" width="20" height="20" /> <span
					style="color: #4ca4c7" class="pointerWithLine">Appreciate</span></span>
					<span class="badge notice-board-badge  pointerCursor" id="${post.id}_likeCount" data-toggle="modal" data-target="#likesModal">${post.likeCount}</span>
			</div>
			<div class="col-sm-3 col-md-3">
				<span class="comment_link" id="${post.id}_comment"> <img src="${imageURL}/discuss.png"
					class="img-rounded pointerCursor" width="20" height="20" /> <span
					style="color: #4ca4c7" class="pointerWithLine">Discuss</span></span>
					<span class="badge notice-board-badge  pointerCursor" id="${post.id}_commentCount" data-toggle="modal" data-target="#commentsModal">${post.commentCount}</span>
			</div>
			<div class="col-sm-6 col-md-6">&nbsp;</div>
		</div>
		<!-- comment box -->
		<div class="row"  id="${post.id}_commentDiv" style="display: none;">
			<div class="col-sm-1 col-md-1">
			<img src="${imageURL}/${user.role}.jpg" class="img-circle"
				alt="Cinque Terre" width="30" height="30"> 
			</div>
			<div class="col-sm-11 col-md-11">
				<input style="background: #e9eaec; height: 25px; padding: 5px;"	placeholder="Discuss your thoughts..." id="${post.id}_commentText" class="commentBox">
			</div>
		</div>
	</div>
	</br>
	<div class="modal fade" id="likesModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">This post is appreciated by </h4>
						</div>
						<div class="modal-body">
							<div>
			<img src="${imageURL}/${post.usersByCreatedBy.role}.jpg" class="img-circle"
				alt="Cinque Terre" width="30" height="30"> 
				<span style="color: #4ca4c7" class="pointerWithLine">Naveen Kumar</span>
		</div>
		</br>
		<div>
			<img src="${imageURL}/${post.usersByCreatedBy.role}.jpg" class="img-circle"
				alt="Cinque Terre" width="30" height="30"> 
				<span style="color: #4ca4c7" class="pointerWithLine">Naveen Kumar</span>
		</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary neuron-btn"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
			
			<div class="modal fade" id="commentsModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">Discussion</h4>
						</div>
						<div class="modal-body">
							<div>
			<img src="${imageURL}/${post.usersByCreatedBy.role}.jpg" class="img-circle"
				alt="Cinque Terre" width="30" height="30"> 
				<span style="color: #4ca4c7" class="pointerWithLine">Naveen Kumar</span>&nbsp;&nbsp;
				<span>Its really interesting! Thanks for an update!!!</span>
		</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary neuron-btn"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
</c:when>
</c:choose>


<!-- 
<div class="row">
	<c:choose>
		<c:when test="${fn:length(posts) gt 0}">
			<c:forEach var="post" begin="0" end="${fn:length(posts)-1}"
				items="${posts}">
				<c:set var="tagStyle" value="label-info" />
				<c:choose>
					<c:when test="${post.type eq 'update'}">
						<c:set var="tagStyle" value="label-success" />
					</c:when>
					<c:when test="${post.type eq 'announcement'}">
						<c:set var="tagStyle" value="label-danger" />
					</c:when>
				</c:choose>
				<div class="col-sm-12 postDiv">
					<div class="row cmpinfo">
						<div class="col-sm-1">
							<img alt="pic" class="pointerCursor"
								src="${imageURL}/post_photo.jpg" width="50" height="30">
						</div>
						<div class="col-sm-10">
							<span class="pointerWithLine"><b>${post.usersByCreatedBy.role}
									${post.usersByCreatedBy.firstName}
									${post.usersByCreatedBy.lastName}</b></span>
							<c:set var="calendar" value="${post.createdDate}" />
							<span class="label ${tagStyle}"> Posted an ${post.type} on
								<fmt:formatDate pattern="MMM dd" type="date"
									value="${calendar.time}" />, <fmt:formatDate type="time"
									value="${calendar.time}" />
							</span>
						</div>
					</div>
					<div class="col-xs-12">
						<c:choose>
							<c:when test="${post.type eq 'update'}">
								<p class="">${post.message}</p>
							</c:when>
							<c:when test="${post.type eq 'event'}">
								<p class="">
								<div class="row">Title : ${post.eventTitle}</div>
								<div class="row">Description : ${post.eventDesc}</div>
								<div class="row">
									Date :
									<fmt:formatDate pattern="MMM dd yyyy" type="date"
										value="${post.eventDate.time}" />
								</div>
								</p>
							</c:when>
						</c:choose>
					</div>
					<div class="col-xs-12">
						<i class="icon-large icon-certificate pointerCursor"></i> <span
							class="pointerWithLine like_link" id="${post.id}_like">Appreciate</span>
						<span class="badge pointerCursor" id="${post.id}_likeCount">${post.likeCount}</span>
						&nbsp;&nbsp;&nbsp; <i class="icon-large icon-chat pointerCursor"></i>
						<span class="pointerWithLine comment_link" id="${post.id}_comment">Discuss</span>
						<a class="comment_link"><span class="badge"
							id="${post.id}_commentCount">${post.commentCount}</span></a>
					</div>
					<div class="row col-sm-9 cmpinfo">
						<div class="col-sm-2">
							<img alt="pic" src="${imageURL}/profile_image1.jpg" width="40"
								height="25">
						</div>
						<div class="col-sm-10 leftPaddingZero">
							<input type="text" id="${post.id}_commentText" class="commentBox"
								placeholder="Discuss your thoughts..." />
						</div>
					</div>
				</div>
				<hr />
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="col-sm-12">
				<div class="row col-sm-9 cmpinfo">No Posts to display</div>
			</div>
		</c:otherwise>
	</c:choose>

</div>
 -->