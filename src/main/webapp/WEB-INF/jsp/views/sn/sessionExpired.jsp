<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<c:set var="key" value="tenantKey"/>
<c:forEach items="${cookie}" var="currentCookie"> 
<c:set var="qid" value="${currentCookie.value.name}"/>
<c:choose>
	<c:when test="${qid==key}"><h5>your session has expired please 
	<p>Please <a href="<c:url value="/login.do?id=${currentCookie.value.value}"/>" style="color:green">login</a> and try again.</p>
	 to continue</h5>
	</c:when>
</c:choose>
</c:forEach>
</body>
