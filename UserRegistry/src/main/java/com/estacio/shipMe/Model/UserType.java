package com.estacio.shipMe.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TYPE")
public class UserType {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	private String name;
	
	public UserType() {}
	
	public UserType(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
