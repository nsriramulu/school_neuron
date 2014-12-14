<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/images" var="imageURL" />
<c:url value="/resources/scripts" var="jsURL" />
<script src="${jsURL}/jquery.min.js"></script>
<script src="${jsURL}/sn.js"></script>
<script src="${jsURL}/jquery.placeholder.js"></script>

<div class="row">
	<div class="col-md-10 col-sm-12 col-md-offset-1">
		<div class="row login-container">
			<div class="col-sm-8 col-md-7 hidden-xs banner-container">
				<img class="banner-image" src="${imageURL}/banner.jpg"
					alt="banner" />
			</div>
            <div class="col-xs-12 visible-xs banner-container no-padding-right">
            <img class="banner-image" src="${imageURL}/banner.jpg" alt="banner"/>
            </div><!-- include image-->
			<div class="col-sm-4 col-md-5 login-module">
				<div class="col-xs-12 login-welcome"><spring:message code="label.welcome"/></div>
				<div class="row"></div>
				<form action="<c:url value='/j_spring_security_check'/>" class="login-form" method='POST'>
					<div class="col-xs-12 padding-bottom-required padding-top-required">
						<div class="row">
							<div class="col-xs-4 col-md-3"><spring:message code="label.username"/></div>
							<div class="col-xs-8 col-md-9"><input type="text" id="userName" name="j_username" placeholder="username"  value="${username}" autocomplete="off" class="paddingLess"></div>
						</div>
					</div>
					<div class="col-xs-12 padding-bottom-required">
						<div class="row">
							<div class="col-xs-4 col-md-3"><spring:message code="label.password"/></div>
							<div class="col-xs-8 col-md-9"><input type="password" id="userPassword" name="j_password" placeholder="password" autocomplete="off" class="paddingLess"></div>
						</div>
					</div>
					<c:if test="${not empty error}">
										<div class="col-xs-12 errorMessageDisp">
											${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
									</c:if>
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-8 col-xs-offset-4 col-md-9 col-md-offset-3  ">
								<div class="row">
									<div class="col-xs-6 form-button login-button">
									<input type="hidden" id="tenantKey" value="${tenantKey}"/>
										<input type="submit" value="<spring:message code="label.login"/>">
									</div>
									<div class="col-xs-6 form-button reset-button">
										<input type="reset" value="<spring:message code="label.reset"/>">
									</div>
								</div>
							</div>
						</div>
					</div>
					
                         
                         
                          <div class="col-xs-12 forgot padding-bottom-required">
    <div class="row">
							<div class="col-sm-8 col-sm-offset-4 col-xs-offset-4 col-md-9 col-md-offset-3">
								<a class="underlined-link forgot-password" href="#" data-toggle="modal" data-target="#forgot-password-userId-modal"><spring:message code="label.forgotpassword"/></a> 
								<a class="underlined-link forgot-id" href="#" data-toggle="modal" data-target="#forgot-password-emailId-modal"><spring:message code="label.forgotid"/></a>
							</div>
						</div>
					</div>
				</form>
				<div
					class="col-xs-12 first-time-user padding-top-required hidden-xs">
					<div class="row">
						<div class="col-xs-12"><spring:message code="label.ftuser"/></div>
					</div>
				</div>
				<div class="col-xs-12 signup-container">
					<div
						class="col-xs-12 col-sm-8 col-sm-offset-2 padding-top-required">
						<input type="button" class="sign-up" value="<spring:message code="label.signup"/>" id="signUp">
					</div>
					<div class="col-xs-12 text-center padding-bottom-required">
						<!-- <a class="underlined-link" href="#"><spring:message code="label.moreinfo"/></a> -->
					</div>
				</div>
			</div>

		</div>

		<div class="row hidden-xs">
			<div class="col-sm-12">
				<div class="row">
				<div class="middleRow">         
					<div class="col-sm-3 feature-profile less-padding">
						<div class="col-xs-12 border-required  features-text loginAdvBg">
							<div class="profile-head margin-top-15">
								<img src="${imageURL}/profile.png" />Students</span>
							</div>
							<div class="password-text  margin-top-10"><p><spring:message code="label.servicesmessege1"/></p>
																	 <p><spring:message code="label.servicesmessege2"/></p>
							</div>
						</div>
					</div>
					<div class="col-sm-3 feature-services less-padding">
						<div class="col-xs-12 border-required  features-text loginAdvBg">
							<div class="services-head margin-top-15">
								<img src="${imageURL}/services.png" />Parents</span>
							</div>
							<div class="password-text  margin-top-10"><p><spring:message code="label.servicesmessege1"/></p>
																	 <p><spring:message code="label.servicesmessege2"/></p>
							</div>
						</div>
					</div>
					<div class="col-sm-3 feature-password less-padding">
						<div class="col-xs-12 border-required  features-text loginAdvBg">
							<div class="password-head margin-top-15">
								<img src="${imageURL}/profile.png" />Teachers</span>
							</div>
							<div class="password-text  margin-top-10"><p><spring:message code="label.passwordmessege1"/></p>
																	 <p><spring:message code="label.passwordmessege2"/></p>
							</div>
						</div>
					</div>
					<div class="col-sm-3 feature-password less-padding">
						<div class="col-xs-12 border-required  features-text loginAdvBg">
							<div class="password-head margin-top-15">
								<img src="${imageURL}/profile.png" /><span>Administration</span>
							</div>
							<div class="password-text  margin-top-10"><p><spring:message code="label.passwordmessege1"/></p>
																	 <p><spring:message code="label.passwordmessege2"/></p>
							</div>
						</div>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" data-backdrop="static" id="forgot-password-userId-modal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="popup-header">
				<span class="modal-title"><spring:message code="label.forgotpassword"/></span> <span class="close"
					data-dismiss="modal" aria-hidden="true"><img
					src="${imageURL}/close_icon.png" /></span>
			</div>
			<div class="modal-body container-fluid">
			<div class="popup-text col-sm-12  padding-bottom-required-popup"><spring:message code="label.enteruserid"/></div>   
			<div class="col-sm-12 fp-user-id  padding-bottom-required-popup">
				<label>User Id</label>
				<input type="text" placeholder="User Id"	name="fp-userId">
			</div>
			<div class="col-xs-12 col-sm-8 col-md-12">
				<div class="col-xs-6">
					<button type="button" id ="forgot-password-userId-btn" class="btn btn-primary"><spring:message code="label.submit"/></button>
				</div>
				<div class="col-xs-6">
					<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="label.cancel"/></button>
				</div>

			</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" data-backdrop="static" id="forgot-password-emailId-modal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="popup-header">
				<span class="modal-title"><spring:message code="label.forgotid"/></span> <span class="close"
					data-dismiss="modal" aria-hidden="true"><img
					src="${imageURL}/close_icon.png" /></span>
			</div>
			<div class="modal-body container-fluid">
			<div class="popup-text col-sm-12  padding-bottom-required-popup"><spring:message code="label.enterregemail"/></div>   
			<div class="col-sm-12 fp-user-id  padding-bottom-required-popup">
				<label><spring:message code="label.emailid"/></label>
				<input type="text" placeholder="Email Id"	name="fp-emailId">
			</div>
			<div class="col-xs-12 col-md-12">
				<div class="col-xs-6">
					<button type="button" id ="forgot-password-emailId-btn" class="btn btn-primary"><spring:message code="label.submit"/></button>
				</div>
				<div class="col-xs-6">
					<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="label.cancel"/></button>
				</div>

			</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" data-backdrop="static" id="forgot-password-modal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		
		<div class="popup-header">
				<span class="modal-title"><spring:message code="label.forgotpassword"/></span> <span class="close"
					data-dismiss="modal" aria-hidden="true"><img
					src="${imageURL}/close_icon.png" /></span>
			</div>
			<div class="modal-body container-fluid">
			<div class="popup-text col-sm-12  padding-bottom-required-popup error"  id="secAnsErrMsg"></div>   
			<div class="popup-text col-sm-12  padding-bottom-required-popup"><spring:message code="label.securityanswer"/></div>   
			<div class="col-sm-12 secret-select">
				<label><spring:message code="label.securityquestion"/></label>
				<select id="secretQuestions"></select>
			</div>
			<div class="col-sm-12 padding-bottom-required-popup">
				<label><spring:message code="label.answer"/></label>
				<input type="text" placeholder="Answer" name="secretAnswer">
				<input type="hidden" value="" id="userId">
				<c:out value="">Tenant Id : ${id}</c:out>
				<input type="hidden" value="${id}" id="id">
			</div>
			<div class="col-xs-12">
				<div class="col-xs-6">
					<button type="button" id ="secret-answer-submit-btn" class="btn btn-primary"><spring:message code="label.submit"/></button>
				</div>
				<div class="col-xs-6">
					<button type="button" class="btn btn-default" id="modal-cancel-btn" data-toggle="modal" data-target="#forgot-password-userId-modal"><spring:message code="label.cancel"/></button>
				</div>
			</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" data-backdrop="static" id="message-modal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="popup-header">
				<span class="modal-title" id="message-title"></span> <span class="close"
					data-dismiss="modal" aria-hidden="true"><img
					src="${imageURL}/close_icon.png" /></span>
			</div>
			<div class="modal-body container-fluid">
			<div class="popup-text col-sm-12  padding-bottom-required-popup"></div>  
			<div class="col-sm-12"></div> 
			<div class="popup-text col-sm-12  padding-bottom-required-popup" id="message"></div> 
			<div class="col-xs-12">
				<div class="col-xs-6">
					<button type="button" id="message-modal-ok-btn" data-dismiss="modal" class="btn btn-default" ><spring:message code="label.ok"/></button>
				</div>

			</div>
			</div>
		</div>
	</div>
</div>
