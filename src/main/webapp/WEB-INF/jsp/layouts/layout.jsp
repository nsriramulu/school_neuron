<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<c:url value="/resources/js" var="jsURL" />
<c:url value="/resources/css" var="cssURL" />
<c:url value="/resources/img" var="imageURL" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>School Neuron</title>
    <link href="${cssURL}/bootstrap.min.css" rel="stylesheet">
	<link href="${cssURL}/neuron.css" rel="stylesheet">
  </head>
  <body>
	<div class="container">
		<div class="row">
			<!-- <div class="col-sm-1 col-md-1">
			</div> -->
			<div id="bodyContainer" class="col-sm-12 col-md-12" style="background:#e9eaec;">
				</br>
				<tiles:insertAttribute name="header" />
				</br>
				<div class="row">
					<div class="col-sm-2 col-md-2">
						<div class="profile-div">
						<img src="${imageURL}/${user.role}.jpg" class="img-circle" alt="Cinque Terre" width="150" height="150">
						</div>
						<div class="left-section-2">
							<div class="neuron-div">
								${user.firstName} ${user.lastName}</br> ${user.role}, <br/>${school.name}
							</div>
							<security:authorize access="hasAnyRole('Principal,Teacher')">
							
							<div id="myClassRoosm-div" class="leftPanelSubHeader">
								<div class="text-center padding5">
									<span class="text-info" style="padding: 5px">MY CLASSROOMS
									</span>
								</div>
								<c:forEach var ="classSubjectTeacher" items="${classSubjectTeachers}">
								<div class="left-panel-neuron-div">
									<a href="myClassRoom?classId=${classSubjectTeacher.classesByClassId.id}">${classSubjectTeacher.classesBySubjectId.subjectName} - ${classSubjectTeacher.classesByClassId.className}</a>
								</div>
								</c:forEach>
							</div>
							</security:authorize>
							
							<div id="actions-div"  class="leftPanelSubHeader">
							<div class="text-center padding5">
							<span class="text-info" style="padding: 5px">ACTIONS</span>
								</div>
								<div class="neuron-div">
									 <security:authorize access="hasAnyRole('Principal,Teacher')">
										<a href="classRoom"><span>Create Classroom</span></a></br>
									</security:authorize>
									<a href="messages"><span>Private Messages</span></a><br/>
								</div>
							</div>
							<div id="noticeBoard-div"  class="leftPanelSubHeader">
							<div class="text-center padding5">
								<span class="text-info" style="padding: 5px">NOTICEBOARD</span>
								</div>
								<div class="neuron-div">
									<div><a href="events"><span>Events<span class="badge notice-board-badge">2</span></span></a></div>
									<div><a href="assignments"><span>Assignments<span class="badge notice-board-badge">1</span></span></a></div>
									<div><a href="polls"><span>Polls</span></a></div>
								</div>
							</div>
						</div>
					</div>
					<div id="body-home" class="col-sm-8 col-md-8">
					<security:authorize access="hasAnyRole('Principal,Teacher,Student')">
					<tiles:insertAttribute name="postTab"/>
					</security:authorize>
					</br>
						<tiles:insertAttribute name="body" />
					</div>
					<div class="col-sm-2 col-md-2">
						<h5 class="text-info">TRENDING</h5>
						Annual day function on 25th Dec</br>
						State first by Arun Setting
					</div>
				</div>
			</div>
			<!-- <div class="col-sm-1 col-md-1">
			</div> -->
		</div>
	</div>
    <script src="${jsURL}/jquery.js"></script>
	<script src="${jsURL}/bootstrap.min.js"></script>
	<script src="${jsURL}/sn.js"></script>
  </body>
</html>