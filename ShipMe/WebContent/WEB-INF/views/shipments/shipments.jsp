<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="application/json; charset=utf8">
    <title>Shipments</title>
</head>

<body>
    <!-- Main -->
    <div class="ds-row ds-tabs ds-margin-top-5">
        <!-- Sidebar -->
        <div class="ds-col-lg-2 ds-affix ds-left ds-bg-neutral-1 ds-padding-2 ds-full-height ds-hide ds-display-lg-block">
            <!-- Items -->
            <div class="ds-tab-controls ds-margin-bottom-5 ds-margin-top-5" role="tablist">
                <div class="ds-flex ds-flex-align-items-center">
                    <button id="tab-control-bmsiw" class="tab-links ds-button ds-flat ds-selected" role="tab">Shipments</button>
                </div>
            </div>
            <!-- /Items -->
        </div>
        <!-- Sidebar -->

        <!-- Content -->
        <div class="ds-col-lg-10 ds-offset-lg-2 ds-margin-top-md-2 ds-padding-md-1 ds-full-height">
            <div class="ds-row ds-tab-contents">
			    <div class="ds-table-container">
		            <div id="tab-control-bmsiw" class="ds-tab-content ds-col-md-12 ds-padding-2 ds-margin-top-3">
		            	<div id="listIntens">
		            		<div class="ds-row ds-mar-b-1_5">
				            	<div class="ds-col-10 ds-mar-b-xs-2 ds-mar-b-md-0 ds-pad-r-0">
				            		<h3>Shipment List</h3>
							    </div>
				            	<div class="ds-col-2 ds-mar-b-xs-1 ds-mar-b-md-0 ds-pad-r-0">
				            		<button onclick="edit('', '', '')" id="new-user-btn" class="ds-button ds-primary ds-pad-l-0 ds-pad-r-0 ds-text-align-center" style="width: 100%">New +</button>
							    </div>
				            </div>
		            		<table id="bmsiwTable" class="ds-table">
					            <thead>
					                <tr>
					                    <th>Prodcut</th>
					                    <th>User</th>
					                    <th>Destination</th>
					                    <th>Actions</th>
					                </tr>
					            </thead>
					            <tbody>
					            <c:forEach items="${shipmentList}" var="shipment">
					                <tr>
					                	<td> ${shipment.product}</td>
					                	<td> ${shipment.user}</td>
					                	<td> ${shipment.destination}</td>
					                	<td> <span class="cursor-pointer" onclick="edit(${shipment.id}, '${shipment.productId}', '${shipment.userId}', '${shipment.destination}')"> Edit</span> <span class="cursor-pointer text-red" onclick="saveShip(${shipment.id}, '${shipment.product}', '${shipment.user}', '${shipment.destination})"> Delete</span></td>
					            	</tr>
					            </c:forEach>
					            </tbody>
					        </table>
		            	</div>
			            <div id="newItem" class="item-hidden">
				            <div class="ds-row ds-mar-b-1_5">
				            	<div class="ds-col-8 ds-mar-b-xs-4 ds-mar-b-md-0 ds-pad-r-0">
				            		<h3>New Shipment</h3>
							    </div>
				            </div>
			            	
					      	<div class="ds-row ds-mar-b-1_5">
					      		<input type="hidden" id="shipmentId" name="id">
							    <div class="ds-col-4 ds-mar-b-xs-2 ds-mar-b-md-0 ds-pad-r-0">
							        <label for="destination" class="ds-input-label ds-pad-l-0_5 ds-pad-l-0_5">Destination</label>
							        <input id="destination" type="text" class="ds-input" placeholder="Destination">
							    </div>
							    <div class="ds-col-4 ds-mar-b-xs-2 ds-mar-b-md-0 ds-pad-l-md-1 ds-pad-l-0_5">
							        <label for="product" class="ds-input-label ds-pad-l-0_5 ds-pad-l-0_5">Product</label>
							            <div class="ds-select">
									        <select id="product" required>
							        				<c:forEach items="${productList}" var="product">
														<option value="${product.id}">${product.name}</option>
													</c:forEach>
									        </select>
									    </div>
							    </div>
							  <div class="ds-col-4 ds-mar-b-xs-2 ds-mar-b-md-0 ds-pad-l-md-1 ds-pad-l-0_5">
							        <label for="user" class="ds-input-label ds-pad-l-0_5 ds-pad-l-0_5">User</label>
							            <div class="ds-select">
									        <select id="user" required>
							        				<c:forEach items="${userList}" var="user">
														<option value="${user.id}">${user.name}</option>
													</c:forEach>
									        </select>
									    </div>
							    </div>
							</div>
							
							<div class="ds-hr ds-border-b"></div>
							<div class="ds-row" style="padding-top: 30px">
							    <div class="ds-col-xs-12 ds-col-md-5 ds-col-lg-4 ds-offset-md-3 ds-offset-lg-5 ds-push-md-4 ds-push-lg-3">
							        <button onclick="saveShip()" id="save-user" class="ds-button ds-primary ds-pad-l-0 ds-pad-r-0 ds-text-align-center" style="width: 100%">Save</button>
							    </div>
							    <div class="ds-col-xs-12 ds-col-md-4 ds-col-lg-3 ds-pull-md-5 ds-pull-lg-4">
							        <button onclick="edit('', '', '', '')" class="ds-button ds-secondary ds-pad-l-0 ds-pad-r-0 ds-text-align-center" style="width: 100%">Cancel</button>
							    </div>
							</div>
			            </div>
		            </div>
			    </div>
            </div>
        </div>
        <!-- /Content -->
    </div>
    <script>
	 	$(document).ready(function () {
		    $('#bmsiwTable').DataTable();
		});
	 	
		function saveShip(id, product, user, destination) {
			var hml = makeItem(id, product, user, destination);
			var request = jQuery.ajax({
	 			url: id ? '<c:url value="/shipments/delete" />' : '<c:url value="/shipments/create" />',
	 			method: "POST",
	 			data: JSON.stringify(hml),
	 			contentType: "application/json; charset=UTF-8",
	 			async: false
 			});
 			request.done(function( data ) {
 				document.location.reload(true);
 			});
	 		request.fail(function( jqXHR, textStatus ) {
	 			console.error(textStatus);
	 		});
		}
		
		function makeItem(id, product, user, destination){
			return {
				"id" : id ? id : jQuery("#shipmentId").val(),
				"product" : product ? product : jQuery("#product").val(),
				"user" : user ? user : jQuery("#user").val(),
				"destination" : destination ? destination : jQuery("#destination").val(),
				"userId": "",
				"productId": ""
			}
		}
		
		function edit(id, product, user, destination) {
			document.getElementById("newItem").classList.toggle("item-hidden");
			document.getElementById("listIntens").classList.toggle("item-hidden");
			jQuery("#shipmentId").val(id);
			jQuery("#product").val(product);
			jQuery("#user").val(user);
			jQuery("#destination").val(destination);
		}

	</script>
</body>

</html>