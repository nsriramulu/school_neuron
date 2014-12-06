<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<c:url value="/resources/scripts" var="jsURL" />
<c:url value="/resources/styles" var="cssURL" />
<c:url value="/resources/images" var="imageURL" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>school neuron</title>
<!-- Bootstrap -->
<link href="${cssURL}/bootstrap.min.css" rel="stylesheet">
<link href="${cssURL}/custom.css" rel="stylesheet">
<link href="${cssURL}/bootstrap-datetimepicker.css" rel="stylesheet">
<link href="${cssURL}/bootstrap.icon-large.min.css" rel="stylesheet">
<link href="${cssURL}/popups.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
 		var ctx = "<%=request.getContextPath()%>";
	</script>
	<% String ctx = request.getContextPath(); %>
</head>
<body class="admin">
	<div class="container-fluid">
		<tiles:insertAttribute name="header" />
		<div class="col-sm-12 col-md-10 col-md-offset-1">
			<!-- main content start -->
			<div class="row main-content">
				<!-- left content start -->
				<div class="col-sm-4 col-md-4 logged-user-left-container">
					<div class="col-sm-12 logged-user-left">
						<tiles:insertAttribute name="profile" />
						<tiles:insertAttribute name="menu" />
						<tiles:insertAttribute name="noticeSection" />
					</div>
				</div>
				<!-- left content end -->
				<!-- body content start -->
				<div>
					<div class="col-md-8 col-sm-8 logged-user-right">
						<tiles:insertAttribute name="postTab"/>
						<tiles:insertAttribute name="body" />
					</div>
				</div>
				<!-- body content start -->
			</div>
			<!-- main content end -->
		</div>
	</div>
	<!-- footer start -->
	<tiles:insertAttribute name="footer" />
	<!-- footer end -->

	<script src="${jsURL}/jquery.min.js"></script>
	<script src="${jsURL}/bootstrap.min.js"></script>
	<script src="${jsURL}/moment.js"></script>
	<script src="${jsURL}/bootstrap-datetimepicker.js"></script>
	<script src="${jsURL}/jquery.dataTables.min.js"></script>
	<script src="${jsURL}/dataTables.bootstrap.js"></script>
	<!-- <script src="${jsURL}/jquery.placeholder.js"></script>-->
	<script src="${jsURL}/sn.js"></script>
	<!--  <script src="js/popups.js"></script> -->
</body>
</html>