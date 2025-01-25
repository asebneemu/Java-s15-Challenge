package com.library.model;

public class Publisher {
    private String publisherName;
    private String address;
    private String phoneNumber;

    public Publisher(String publisherName, String address, String phoneNumber) {
        this.publisherName = publisherName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getPublisherName() { return publisherName; }
    public void setPublisherName(String publisherName) { this.publisherName = publisherName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public String toString() {
        return "Publisher: " + publisherName +
                ", Address: " + address +
                ", Phone: " + phoneNumber;
    }
}
