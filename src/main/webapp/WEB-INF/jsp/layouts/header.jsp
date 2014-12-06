<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/images" var="imageURL" />
<div class="row header">
			<div class="col-sm-7 col-sm-offset-1 header-left"><!-- tenant_image.png -->
				<span class="title"><a href="home.do"><img src="${imageURL}/logo.png" alt="tenant logo" /></a></span>
			</div>
			<div class="col-sm-2">
				<div class="row">
					<div class="col-sm-12 paddingTop10">
						<i class="icon-large icon-home pointerCursor" id="homeIcon" title="Home"></i> 
						<i class="icon-large icon-globe pointerCursor" title="Notifications"><span class="badge"></span></i>
						<i class="icon-large icon-envelope pointerCursor" title="Private Message"><span class="badge">2</span></i>
						<i class="icon-large icon-settings pointerCursor" title="Settngs"></i> 
						<i class="icon-large icon-off pointerCursor" title="Logout"></i>
					</div>
				</div>
			</div>
		</div>