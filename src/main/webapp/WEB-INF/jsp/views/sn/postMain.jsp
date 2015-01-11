<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/images" var="imageURL" />
<div class="row">
	<c:choose>
		<c:when test="${fn:length(posts) gt 0}">
			<!--post starts-->
			<c:forEach var="post" begin="0" end="${fn:length(posts)-1}" items="${posts}">
			<c:set var="tagStyle" value="label-info"/>
			<c:choose>
				<c:when test="${post.type eq 'update'}">
					<c:set var="tagStyle" value="label-success"/>
				</c:when>
				<c:when test="${post.type eq 'announcement'}">
					<c:set var="tagStyle" value="label-danger"/>
				</c:when>
			</c:choose>
			<div class="col-sm-12 postDiv">
				<div class="row cmpinfo">
					<div class="col-sm-1">
						<img alt="pic" class="pointerCursor" src="${imageURL}/post_photo.jpg"
							width="50" height="30">
					</div>
					<div class="col-sm-10">
						<span class="pointerWithLine"><b>${post.usersByCreatedBy.role} ${post.usersByCreatedBy.firstName} ${post.usersByCreatedBy.lastName}</b></span>
						<c:set var="calendar" value="${post.createdDate}"/>
						<span class="label ${tagStyle}">
							Posted an ${post.type} on 
							<fmt:formatDate pattern="MMM dd" type="date" value="${calendar.time}"/>,
							<fmt:formatDate type="time" value="${calendar.time}"/>
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
								<div class="row">Date : <fmt:formatDate pattern="MMM dd yyyy" type="date" value="${post.eventDate.time}"/></div>
							</p>
						</c:when>
					</c:choose>
				</div>
				<div class="col-xs-12">
					<i class="icon-large icon-certificate pointerCursor"></i>
					<span class="pointerWithLine like_link" id="${post.id}_like">Appreciate</span> 
					<span class="badge pointerCursor" id="${post.id}_likeCount">${post.likeCount}</span>
					&nbsp;&nbsp;&nbsp; 
					<i class="icon-large icon-chat pointerCursor"></i>
					<span class="pointerWithLine comment_link" id="${post.id}_comment">Discuss</span> 
					<a class="comment_link"><span class="badge" id="${post.id}_commentCount">${post.commentCount}</span></a>
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
			<!-- post ends -->
			<hr />
	</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="col-sm-12">
				<div class="row col-sm-9 cmpinfo">
					No Posts to display
				</div>
			</div>
		</c:otherwise>
		</c:choose>
	
</div>