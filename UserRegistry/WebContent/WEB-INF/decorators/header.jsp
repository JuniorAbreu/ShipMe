<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>

<body>

<!-- W3DS Nav -->
<div id="navbar" class="ds-row ds-bg-blue-7 ds-bg-dark ds-padding-1 ds-full-width ds-affix">
	<div class="ds-col-md-3 ds-col-lg-3 ds-margin-top-xs-0_5 ds-margin-top-lg-0 ds-padding-left-lg-2 ds-margin-left-lg-2">
		<a class="ds-text-neutral-1 ds-link-unstyled" href="<c:url value="/" />"> <h2 class="">ShipMe</h2></a>
	</div>
    <c:set var = "theString" value="${pageContext.request.requestURL}"/>
    <c:if test = "${fn:contains(theString, 'users') || fn:contains(theString, 'products') || fn:contains(theString, 'shipments')}">
	    <div class="ds-col-lg-2 ds-inline-block ds-margin-left-1">
			<a class="ds-button ds-button-flat" href="<c:url value="/shipments" />">Shipments</a>
		</div>
		<div class="ds-col-lg-2 ds-inline-block ds-margin-left-1">
			<a class="ds-button ds-button-flat" href="<c:url value="/products" />">Products</a>
		</div>
		<div class="ds-col-lg-2 ds-inline-block">
			<a class="ds-button ds-button-flat" href="<c:url value="users" />">Users</a>
		</div>
    </c:if>
</div>
	<!-- /W3DS Nav -->

</body>

</html>