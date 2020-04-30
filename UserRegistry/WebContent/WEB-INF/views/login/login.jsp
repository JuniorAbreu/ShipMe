<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<div class="ds-row ds-margin-top-md-5 ds-padding-top-md-10 ds-padding-3" style="background-color: #004065!important; height: 1000px">
	<div class="ds-col-md-4"></div>
	<div class="ds-col-md-4">
		<div class="ds-panel ds-panel-floating">
			<div class="ds-panel-container">
				<div class="ds-row">

						<div class="ds-col-md-12 ds-padding-1">
							<h2 class="heading-2" style="text-align: center; color: grey">Login</h2>
							<hr class="ds-hr">
							<div class="ds-row">
								<div class="ds-col-12 ds-margin-top-3">
									<div class="ds-row ds-mar-b-1_5">
							      		<input type="hidden" id="userId" name="id">
									    <div class="ds-col-12">
									        <label for="form-name-prefix-1" class="ds-input-label ds-pad-l-0_5 ds-pad-l-0_5">Email</label>
									        <input id="email" type="text" class="ds-input" placeholder="Type your email...">
									    </div>
									</div>
									
									<div class="ds-row ds-mar-b-1_5" style="padding-top: 30px">
										<div class="ds-col-12">
									        <label for="form-name-prefix-1" class="ds-input-label ds-pad-l-0_5 ds-pad-l-0_5">Password</label>
									        <input id="pass" type="password" class="ds-input" placeholder="Type your password...">
									    </div>
									</div>
									<div class="ds-hr ds-border-b"></div>
									<p class="item-hidden" style="color: red" id="login-message"> You have no access.</p>
									<div class="ds-row" style="padding-top: 30px">
									    <div class="ds-col-xs-12 ds-col-md-5 ds-col-lg-4 ds-offset-md-3 ds-offset-lg-5 ds-push-md-4 ds-push-lg-3">
									        <button onclick="signIn()" id="save-user" class="ds-button ds-primary ds-pad-l-0 ds-pad-r-0 ds-text-align-center" style="width: 100%">Sign in</button>
									    </div>
									</div>
								</div>
							</div>			
						</div> 
				</div>
			</div>
		</div>
	</div>
	<div class="ds-col-md-4"></div>
</div>

<script type="text/javascript">

	function signIn() {
		var email = jQuery("#email").val();
		var pass = jQuery("#pass").val();
		if (!email || !pass) {
			alert("Insert email and password");
		} else {
			var request = jQuery.ajax({
				url: '<c:url value="/login/new/' + email + '/' + pass + '" />',
				method: "GET",
				contentType: "application/json; charset=UTF-8",
				async: false,
			});
			request.done(function (data) {
				if (!document.getElementById("login-message").classList.contains("item-hidden")) {
					document.getElementById("login-message").classList.add("item-hidden");
				}
				alert("Login Sucess");
				window.location.href = '/ship-me/';
			});
			request.fail(function (jqXHR, textStatus) {
				if (document.getElementById("login-message").classList.contains("item-hidden")) {
					document.getElementById("login-message").classList.remove("item-hidden");
				}
			});
		}
	}
	
</script>
</body>
</html>