package com.velan.reg.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Exhibition")
public class Exhibition {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exhibitionId;

    @Column(name = "Mobile Number")
    private String mobileNumber;

    @Column(name = "Organizer Name")
    private String organizerName;

    @Column(name = "Event Name")
    private String eventName;

    @Column(name = "Event Venue")
    private String eventVenue;

    @Column(name = "Venue Type")
    private String venueType;

    @Column(name = "Event Type")
    private String eventType;

    @Column(name = "Start Date")
    private Date startDate;

    @Column(name = "End Date")
    private Date endDate;

	public Exhibition() {
		super();
	}

	public Exhibition(int exhibitionId, String mobileNumber, String organizerName, String eventName, String eventVenue,
			String venueType, String eventType, Date startDate, Date endDate) {
		super();
		this.exhibitionId = exhibitionId;
		this.mobileNumber = mobileNumber;
		this.organizerName = organizerName;
		this.eventName = eventName;
		this.eventVenue = eventVenue;
		this.venueType = venueType;
		this.eventType = eventType;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getExhibitionId() {
		return exhibitionId;
	}

	public void setExhibitionId(int exhibitionId) {
		this.exhibitionId = exhibitionId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventVenue() {
		return eventVenue;
	}

	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}

	public String getVenueType() {
		return venueType;
	}

	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Exhibition [exhibitionId=" + exhibitionId + ", mobileNumber=" + mobileNumber + ", organizerName="
				+ organizerName + ", eventName=" + eventName + ", eventVenue=" + eventVenue + ", venueType=" + venueType
				+ ", eventType=" + eventType + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	
}
