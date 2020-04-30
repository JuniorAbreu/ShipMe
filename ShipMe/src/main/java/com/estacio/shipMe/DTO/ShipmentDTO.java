package com.estacio.shipMe.DTO;

import com.estacio.shipMe.Model.Shipment;

public class ShipmentDTO {
	
	String id;
	String destination;
	String user;
	String userId;
	String product;
	String productId;
	
	public ShipmentDTO(String id, String destination, String user, String userId, String product, String productId) {
		super();
		this.id = id;
		this.destination = destination;
		this.user = user;
		this.userId = userId;
		this.product = product;
		this.productId = productId;
	}

	public ShipmentDTO() {}
	
	public ShipmentDTO(Shipment ship) {
		super();
		this.id = ship.getId().toString();
		this.destination = ship.getDestination();
		this.user = ship.getUser().getName();
		this.userId = ship.getUser().getId().toString();
		this.product = ship.getProduct().getName();
		this.productId = ship.getProduct().getId().toString();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
