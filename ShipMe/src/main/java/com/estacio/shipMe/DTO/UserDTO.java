package com.estacio.shipMe.DTO;

import com.estacio.shipMe.Model.User;

public class UserDTO {
	
	String id;
	String name;
	String type;
	String typeName;
	public UserDTO(String id, String name, String type, String typeName) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.typeName = typeName;
	}
	
	public UserDTO(User user) {
		super();
		this.id = user.getId().toString();
		this.name = user.getName();
		this.type = user.getType().getId().toString();
		this.typeName = user.getType().getName();
	}
	
	public UserDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
