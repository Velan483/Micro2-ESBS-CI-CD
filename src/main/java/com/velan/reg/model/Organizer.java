package com.velan.reg.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="Organizer")
public class Organizer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organizerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;
    
    @Column(name = "profile_image", columnDefinition = "LONGBLOB")
    private byte[] profileImage; 
    
    @Column(name="role")
    private String role;
    
    @PrePersist
    protected void onCreate() {
        if (this.role == null || this.role.isEmpty()) {
            this.role = "Organizer";
        }
    }


	public Organizer() {
		super();
	}


	public Organizer(int organizerId, String name, String email, String password, String phoneNumber, String address,
			byte[] profileImage, String role) {
		super();
		this.organizerId = organizerId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.profileImage = profileImage;
		this.role = role;
	}


	public int getOrganizerId() {
		return organizerId;
	}


	public void setOrganizerId(int organizerId) {
		this.organizerId = organizerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public byte[] getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Organizer [organizerId=" + organizerId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", address=" + address + ", profileImage="
				+ Arrays.toString(profileImage) + ", role=" + role + "]";
	}

}
