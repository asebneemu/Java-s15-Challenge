package com.library.person;
import com.library.model.Membership;

public class Reader extends Person {
    private Membership membership;
    private int currentBorrowedBookCount = 0;

    public Reader(String id, String name, String phoneNumber, Membership membership) {
        super(id, name, phoneNumber);
        this.membership = membership;
    }

    public Membership getMembership() {
        return membership;
    }
    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public int getCurrentBorrowedBookCount() {
        return currentBorrowedBookCount;
    }
    public void setCurrentBorrowedBookCount(int currentBorrowedBookCount) {
        this.currentBorrowedBookCount = currentBorrowedBookCount;
    }

    @Override
    public void showInfo() {
        System.out.println("Reader Info: " + super.toString()
                + ", MembershipType: " + membership.getMembershipType());
    }
}
