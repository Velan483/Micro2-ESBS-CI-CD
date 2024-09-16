package com.velan.reg.model;

public class LoginResponse {

    private int id;
    private String role;
    private String email;
    private String name;
    private String phoneNumber;

    public LoginResponse() {
    	super();
    }

	public LoginResponse(int id, String role, String email, String name, String phoneNumber) {
		super();
		this.id = id;
		this.role = role;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
       
}
