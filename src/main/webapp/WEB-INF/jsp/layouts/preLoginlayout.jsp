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
	<div class="container-fluid" style="background:#e9eaec;">
		<tiles:insertAttribute name="header" />
		<div class="row">
			<div id="bodyContainer">
				</br>
				</br>
					<div class="col-sm-8 col-md-7 hidden-xs banner-container">
						<img class="banner-image" src="${imageURL}/banner.jpg"	alt="banner" />
					</div>
					<div class="col-xs-12 visible-xs banner-container no-padding-right">
            			<img class="banner-image" src="${imageURL}/banner.jpg" alt="banner"/>
            		</div>
            	<div class="col-sm-4 col-md-5 margin-20">
            	<div class="col-xs-12 loginPanel">
						<div class="row text-center">
							<spring:message code="label.welcome"/>
						</div>
						<div class="row neuron-div login-panel-neuron-div" style="color:black;">
							<form action="<c:url value='/j_spring_security_check'/>" class="login-form" method='POST'>
							<div class="row padding5">
								<div class="col-xs-4 col-md-3"><spring:message code="label.username"/></div>
								<div class="col-xs-8 col-md-9"><input type="text" id="userName" name="j_username" placeholder="username"  value="${username}" autocomplete="off" class="form-control neuron-text"></div>
							</div>
							<div class="row padding5">
								<div class="col-xs-4 col-md-3"><spring:message code="label.password"/></div>
								<div class="col-xs-8 col-md-9"><input type="password" id="userPassword" name="j_password" 
								placeholder="password" autocomplete="off" class="form-control neuron-text"></div>
							</div>
							<c:if test="${not empty error}">
								<div class="col-xs-12 errorMessageDisp">
											${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
							</c:if>
							<div class="row col-xs-8 col-xs-offset-4 col-md-9 col-md-offset-3 padding5">
									<div class="col-xs-6">
									<input type="hidden" id="tenantKey" value="${tenantKey}"/>
										<input type="submit" class="login-button btn neuron-btn btn-block btn-sm"vvalue="<spring:message code="label.login"/>">
									</div>
									<div class="col-xs-6">
										<input type="reset" class="login-button btn neuron-btn btn-block btn-sm" value="<spring:message code="label.reset"/>">
									</div>
								</div>
							</form>
							<div class="row col-sm-8 col-sm-offset-4 col-xs-8  col-xs-offset-4 col-md-9 col-md-offset-3 padding5">
								<div class="col-xs-6">
								<a class="underlined-link forgot-password" href="#" data-toggle="modal" data-target="#forgot-password-userId-modal">&nbsp;&nbsp;<spring:message code="label.forgotpassword"/></a>
								</div>
								<div class="col-xs-6"> 
								<a class="underlined-link forgot-id" href="#" data-toggle="modal" data-target="#forgot-password-emailId-modal"><spring:message code="label.forgotid"/></a>
								</div>
							</div>
							
							<div class="col-xs-12 first-time-user padding-top-required hidden-xs">
								<div class="row">
								<div style="color:grey;"><hr/></div>
									<div class="col-xs-12"><spring:message code="label.ftuser"/></div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-8 col-sm-offset-2 padding-top-required padding5">
								<input type="button" class="login-button btn neuron-btn btn-block btn-sm" value="<spring:message code="label.signup"/>" id="signUp">
							</div>
						</div>
					</div>
                         
				<div class="col-xs-12 loginPanel">
						<div class="row text-center">
							About School Neuron
						</div>
						<div class="row neuron-div login-panel-neuron-div" style="color:black;">
							<p>SchoolNeuron helps you to connect with largest K-12 social learning community where teachers, students, and parents can connect safely and securely. An education takes place in and out of the classroom. We set you up for anytime, anywhere learning.</p>
								<p>Education opens minds. Technology connects them.We bring you the best of both, all in one place.</p>
							<p>As an educational tool, social media enriches the learning experience by allowing students and teachers to connect and interact in new, exciting ways.</p>
						</div>
					</div>
					
			</div>
			</div>
		</div>
	</div>
    <script src="${jsURL}/jquery.js"></script>
	<script src="${jsURL}/bootstrap.min.js"></script>
	<script src="${jsURL}/sn.js"></script>
  </body>
</html>