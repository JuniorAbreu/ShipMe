<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
	<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"/>
	<link href="<c:url value='/resources/css/w3ds-3.8.5-border-sides.css' />" rel="stylesheet"/>
	<link href="<c:url value='/resources/css/w3ds-3.8.5-compact.css' />" rel="stylesheet"/>
	<link href="<c:url value='/resources/css/w3ds-3.8.5-data-tables.css' />" rel="stylesheet"/>
	<link href="<c:url value='/resources/css/w3ds-3.8.5-prism.css' />" rel="stylesheet"/>
	
	<script src="<c:url value='/resources/js/jquery-3.1.1.min.js' />" ></script>
	<script src="<c:url value='/resources/js/datatables.min-1.10.18.js' />"></script>
	<script src="<c:url value='/resources/js/w3ds-3.8.5.js' />"></script>
    <title> <decorator:title /> </title>
</head>
<body>
	<div class="ds-grid">
		<%@include file="header.jsp" %>
		<decorator:body/>
		<div id="footerClear"></div>
		<%@include file="footer.jsp" %>
	</div>
		
	

</body>
</html>