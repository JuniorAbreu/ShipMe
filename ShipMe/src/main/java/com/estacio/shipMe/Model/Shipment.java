package com.estacio.shipMe.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SHIPMENT")
public class Shipment {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	
	@Column(name = "DESTINATION", length = 100, nullable = false)
	private String destination;

	public Shipment() {}
	
	public Shipment(Long id, User user, Product product, String destination) {
		super();
		this.id = id;
		this.user = user;
		this.product = product;
		this.destination = destination;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}
