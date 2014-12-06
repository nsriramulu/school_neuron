<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/images" var="imageURL" />
<div class="row user-details">
	<div class="col-xs-4 img-container">
		<img src="${imageURL}/profile_image1.jpg" alt="profile image" />
	</div>
	<div class="col-xs-8 personDetails">
		<div>Mr George</div>
		<div>Teacher</div>
		<div>Summer School</div>
		<div>
			<a href="#" class="more">Edit Profile</a>
		</div>
	</div>
</div>