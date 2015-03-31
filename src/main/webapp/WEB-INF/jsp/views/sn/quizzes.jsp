<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/img" var="imageURL" />
<h5>QUIZ</h5>
<c:choose>
	<c:when test="${fn:length(posts) gt 0}">
		<c:forEach var="post" begin="0" end="${fn:length(posts)-1}" items="${posts}">
			<div class="neuron-div" style="padding: 10px;">
				<div class="row">
					<div class="col-sm-1 col-md-1">
						<img src="${imageURL}/${user.profilePic}" class="img-rounded" alt="Cinque Terre" width="100%" height="100%">
						<span>${post.usersByCreatedBy.firstName}</span>
						<span>${post.usersByCreatedBy.lastName}</span>
					</div>
					<div class="col-sm-11 col-md-11">
						<div class="commentSectionBorder">
							<div id="quiz_name">
								<strong>Quiz Title: </strong><span>${post.eventTitle}</span>
							</div>
							<div id="quiz_type">
								<strong>Type of Question: </strong><span>Multiple</span>
							</div>
							<div id="quiz_marks">
								<strong>Marks: </strong><span>${post.points}</span>
							</div>
							<hr class="neuron-Hline">
							<div class="row" style="padding:5px;">
								<div class="col-sm-10 col-md-10">
									
								</div>
								<div class="col-sm-2 col-md-2">
									<button type="button" class="btn neuron-btn btn-block btn-sm">Respond</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br>
		</c:forEach>
	</c:when>
</c:choose>