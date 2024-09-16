package com.velan.reg.model;

public class ExhibitionResponse {
    private String status;
    private int exhibitionId;

    
    public ExhibitionResponse() {}

    public ExhibitionResponse(String status, int exhibitionId) {
        this.status = status;
        this.exhibitionId = exhibitionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
    }
}
