<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>

<div class="ds-row ds-margin-top-md-5 ds-padding-top-md-10 ds-padding-3">
	<div class="ds-col-md-4">
		<div class="ds-panel ds-panel-floating">
			<div class="ds-panel-container">
				<div class="ds-row">
					<a class="ds-link-unstyled" href="<c:url  value="/shipments"/>">

						<div class="ds-col-md-12 ds-padding-1">
							<h2 class="heading-2">Shipments</h2>
							<hr class="ds-hr">
							<div class="ds-row">
								<div class="ds-col-12 ds-margin-top-3">
									<p>Manage our shipments</p>
								</div>
							</div>			
						</div>
					   
					</a>
				</div>
			</div>
		</div>
	</div>
		<div class="ds-col-md-4">
		<div class="ds-panel ds-panel-floating">
			<div class="ds-panel-container">
				<div class="ds-row">
					<a class="ds-link-unstyled" href="<c:url  value="/products"/>">

						<div class="ds-col-md-12 ds-padding-1">
							<h2 class="heading-2">Products</h2>
							<hr class="ds-hr">
							<div class="ds-row">
								<div class="ds-col-12 ds-margin-top-3">
									<p>Manage our products</p>
								</div>
							</div>			
						</div>
					   
					</a>
				</div>
			</div>
		</div>
	</div>
		<div class="ds-col-md-4">
		<div class="ds-panel ds-panel-floating">
			<div class="ds-panel-container">
				<div class="ds-row">
					<a class="ds-link-unstyled" href="<c:url  value="/users"/>">

						<div class="ds-col-md-12 ds-padding-1">
							<h2 class="heading-2">Users</h2>
							<hr class="ds-hr">
							<div class="ds-row">
								<div class="ds-col-12 ds-margin-top-3">
									<p>Manage our users</p>
								</div>
							</div>			
						</div>
					   
					</a>
				</div>
			</div>
		</div>
	</div>

</div>
</body>
</html>