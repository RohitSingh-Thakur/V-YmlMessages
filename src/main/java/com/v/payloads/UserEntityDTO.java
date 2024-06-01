package com.v.payloads;

import javax.validation.constraints.NotBlank;

public class UserEntityDTO {
	
	@NotBlank(message = "{app.messages.nameEmpty}")
	private String name;
	
	public UserEntityDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserEntityDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserEntityDTO [name=" + name + "]";
	}
}
