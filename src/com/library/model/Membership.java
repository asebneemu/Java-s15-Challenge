package com.library.model;

public class Membership {
    private String membershipType; // "Student", "Faculty" vb.
    private int maxBookLimit;

    public Membership(String membershipType, int maxBookLimit) {
        this.membershipType = membershipType;
        this.maxBookLimit = maxBookLimit;
    }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public int getMaxBookLimit() { return maxBookLimit; }
    public void setMaxBookLimit(int maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }
}
