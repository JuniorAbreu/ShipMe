<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="application/json; charset=utf8">
    <title>Products</title>
</head>

<body>
    <!-- Main -->
    <div class="ds-row ds-tabs ds-margin-top-5">
        <!-- Sidebar -->
        <div class="ds-col-lg-2 ds-affix ds-left ds-bg-neutral-1 ds-padding-2 ds-full-height ds-hide ds-display-lg-block">
            <!-- Items -->
            <div class="ds-tab-controls ds-margin-bottom-5 ds-margin-top-5" role="tablist">
                <div class="ds-flex ds-flex-align-items-center">
                    <button id="tab-control-bmsiw" class="tab-links ds-button ds-flat ds-selected" role="tab">Products</button>
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
				            		<h3>Product List</h3>
							    </div>
				            	<div class="ds-col-2 ds-mar-b-xs-1 ds-mar-b-md-0 ds-pad-r-0">
				            		<button onclick="edit('', '', '')" id="new-product-btn" class="ds-button ds-primary ds-pad-l-0 ds-pad-r-0 ds-text-align-center" style="width: 100%">New +</button>
							    </div>
				            </div>
		            		<table id="productTable" class="ds-table">
					            <thead>
					                <tr>
					                    <th>Name</th>
					                    <th>Description</th>
					                    <th>Actions</th>
					                </tr>
					            </thead>
					            <tbody>
					            <c:forEach items="${productList}" var="product">
					                <tr>
					                	<td> ${product.name}</td>
					                	<td> ${product.description}</td>
					                	<td> <span class="cursor-pointer" onclick="edit(${product.id}, '${product.name}', '${product.description}')"> Edit</span> <span class="cursor-pointer text-red" onclick="saveProduct(${product.id}, '${product.name}', '${product.description}')"> Delete</span></td>
					            	</tr>
					            </c:forEach>
					            </tbody>
					        </table>
		            	</div>
			            <div id="newItem" class="item-hidden">
				            <div class="ds-row ds-mar-b-1_5">
				            	<div class="ds-col-8 ds-mar-b-xs-4 ds-mar-b-md-0 ds-pad-r-0">
				            		<h3>New Product</h3>
							    </div>
				            </div>
			            	
					      	<div class="ds-row ds-mar-b-1_5">
					      		<input type="hidden" id="productId" name="id">
							    <div class="ds-col-4 ds-mar-b-xs-2 ds-mar-b-md-0 ds-pad-r-0">
							        <label for="name" class="ds-input-label ds-pad-l-0_5 ds-pad-l-0_5">Name</label>
							        <input id="name" type="text" class="ds-input" placeholder="Name">
							    </div>
							    <div class="ds-col-4 ds-mar-b-xs-2 ds-mar-b-md-0 ds-pad-r-0">
							        <label for="description" class="ds-input-label ds-pad-l-0_5 ds-pad-l-0_5">Description</label>
							        <input id="description" type="text" class="ds-input" placeholder="Description">
							    </div>
							</div>
							
							<div class="ds-hr ds-border-b"></div>
							<div class="ds-row" style="padding-top: 30px">
							    <div class="ds-col-xs-12 ds-col-md-5 ds-col-lg-4 ds-offset-md-3 ds-offset-lg-5 ds-push-md-4 ds-push-lg-3">
							        <button onclick="saveProduct()" id="save-produc" class="ds-button ds-primary ds-pad-l-0 ds-pad-r-0 ds-text-align-center" style="width: 100%">Save</button>
							    </div>
							    <div class="ds-col-xs-12 ds-col-md-4 ds-col-lg-3 ds-pull-md-5 ds-pull-lg-4">
							        <button onclick="edit('', '', '')" class="ds-button ds-secondary ds-pad-l-0 ds-pad-r-0 ds-text-align-center" style="width: 100%">Cancel</button>
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
		    $('#productTable').DataTable();
		});
    
		function saveProduct(id, name, description) {
			var hml = makeItem(id, name, description);
			var request = jQuery.ajax({
	 			url: id ? '<c:url value="/products/delete" />' : '<c:url value="/products/create" />',
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
		
		function makeItem(id, name, description){
			return {
				"id" : id ? id : jQuery("#productId").val(),
				"name" : name ? name : jQuery("#name").val(),
				"description" : description ? description : jQuery("#description").val()
			}
		}
		
		function edit(id, name, description) {
			document.getElementById("newItem").classList.toggle("item-hidden");
			document.getElementById("listIntens").classList.toggle("item-hidden");
			jQuery("#productId").val(id);
			jQuery("#description").val(description);
			jQuery("#name").val(name);
		}

	</script>
</body>

</html>