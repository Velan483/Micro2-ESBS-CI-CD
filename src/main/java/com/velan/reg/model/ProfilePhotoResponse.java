package com.velan.reg.model;

public class ProfilePhotoResponse {
    private String photoUrl;

    public ProfilePhotoResponse(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
