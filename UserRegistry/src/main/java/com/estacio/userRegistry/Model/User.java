package com.estacio.userRegistry.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME", length = 100, nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "USER_TYPE_ID")
	private UserType userType;
	
	public User() {}
	
	public User(Long id, String name, UserType campus) {
		super();
		this.id = id;
		this.name = name;
		this.userType = campus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserType getType() {
		return userType;
	}

	public void setType(UserType type) {
		this.userType = type;
	}
	
}
