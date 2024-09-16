package com.velan.reg.model;

import java.util.Arrays;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stall")
public class Stall {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stallId;

    @Column(name="Total Stall")
    private int totalStall;

    @Column(name="Available Stall")
    private int availableStall;

    @Column(name="Stall Type")
    private String stallType;
    
    @Column(name="Rent Per Day")
    private int rent;

    @Column(name="Stall Model")
    private String stallModel;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] eventPoster; 

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] floorPlan; 

    @Column(name="Visitor Count")
    private int visitorCount;
    
    @OneToOne
    @JoinColumn(name = "exhibition_id")
    private Exhibition exhibition;

	public Stall() {
		super();
	}

	public Stall(int stallId, int totalStall, int availableStall, String stallType, int rent, String stallModel,
			byte[] eventPoster, byte[] floorPlan, int visitorCount, Exhibition exhibition) {
		super();
		this.stallId = stallId;
		this.totalStall = totalStall;
		this.availableStall = availableStall;
		this.stallType = stallType;
		this.rent = rent;
		this.stallModel = stallModel;
		this.eventPoster = eventPoster;
		this.floorPlan = floorPlan;
		this.visitorCount = visitorCount;
		this.exhibition = exhibition;
	}

	public int getStallId() {
		return stallId;
	}

	public void setStallId(int stallId) {
		this.stallId = stallId;
	}

	public int getTotalStall() {
		return totalStall;
	}

	public void setTotalStall(int totalStall) {
		this.totalStall = totalStall;
	}

	public int getAvailableStall() {
		return availableStall;
	}

	public void setAvailableStall(int availableStall) {
		this.availableStall = availableStall;
	}

	public String getStallType() {
		return stallType;
	}

	public void setStallType(String stallType) {
		this.stallType = stallType;
	}

	public String getStallModel() {
		return stallModel;
	}

	public void setStallModel(String stallModel) {
		this.stallModel = stallModel;
	}

	public byte[] getEventPoster() {
		return eventPoster;
	}

	public void setEventPoster(byte[] eventPoster) {
		this.eventPoster = eventPoster;
	}

	public byte[] getFloorPlan() {
		return floorPlan;
	}

	public void setFloorPlan(byte[] floorPlan) {
		this.floorPlan = floorPlan;
	}

	public int getVisitorCount() {
		return visitorCount;
	}

	public void setVisitorCount(int visitorCount) {
		this.visitorCount = visitorCount;
	}

	public Exhibition getExhibition() {
		return exhibition;
	}

	public void setExhibition(Exhibition exhibition) {
		this.exhibition = exhibition;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Stall [stallId=" + stallId + ", totalStall=" + totalStall + ", availableStall=" + availableStall
				+ ", stallType=" + stallType + ", rent=" + rent + ", stallModel=" + stallModel + ", eventPoster="
				+ Arrays.toString(eventPoster) + ", floorPlan=" + Arrays.toString(floorPlan) + ", visitorCount="
				+ visitorCount + ", exhibition=" + exhibition + "]";
	}

}
