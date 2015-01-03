<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/images" var="imageURL" />
<div class="row user-details">
	<div class="col-xs-4 img-container">
		<img src="${imageURL}/profile_image1.jpg" alt="profile image" />
	</div>
	<div class="col-xs-8 personDetails">
		<div>
			<c:choose>
				<c:when test="${user.gender eq 'M'}">Mr. </c:when>
				<c:otherwise>Miss. </c:otherwise>
			</c:choose>${user.firstName}</div>
		<div>${user.role}</div>
		<div>${school.name}</div>
		<div>
			<a href="#" class="more">Edit Profile</a>
		</div>
	</div>
</div>