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
@Table(name = "Exhibitor")
public class Exhibitor {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exhibitorId;

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
    
    @Column(name="role")
    private String role;
    
    @Column(name = "profile_image", columnDefinition = "LONGBLOB")
    private byte[] profileImage; 
    
    @PrePersist
    protected void onCreate() {
        if (this.role == null || this.role.isEmpty()) {
            this.role = "Exhibitor";
        }
    }

	public Exhibitor() {
		super();
	}

	public Exhibitor(int exhibitorId, String name, String email, String password, String phoneNumber, String address,
			String role, byte[] profileImage) {
		super();
		this.exhibitorId = exhibitorId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
		this.profileImage = profileImage;
	}

	public int getExhibitorId() {
		return exhibitorId;
	}

	public void setExhibitorId(int exhibitorId) {
		this.exhibitorId = exhibitorId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		return "Exhibitor [exhibitorId=" + exhibitorId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", address=" + address + ", role=" + role
				+ ", profileImage=" + Arrays.toString(profileImage) + "]";
	}

}
