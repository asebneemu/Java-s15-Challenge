package com.library.model;

public class EmailNotification implements Notification {
    private String emailAddress;

    public EmailNotification(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("E-posta gönderiliyor -> " + emailAddress
                + "\nİçerik: " + message);
    }
}
