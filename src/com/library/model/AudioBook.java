package com.library.model;

public class AudioBook extends Media {
    private double durationInMinutes;
    private String narrator;
    private String audioFormat;  // MP3, WAV, vb.
    private String streamingURL;

    public AudioBook(String id, String title, Author author, Category category,
                     double durationInMinutes, String narrator,
                     String audioFormat, String streamingURL) {
        super(id, title, author, category);
        this.durationInMinutes = durationInMinutes;
        this.narrator = narrator;
        this.audioFormat = audioFormat;
        this.streamingURL = streamingURL;
    }

    @Override
    public void borrow() {
        System.out.println(getTitle() + " sesli kitabı ödünç verildi. URL: " + streamingURL);
    }

    @Override
    public void returnMedia() {
        System.out.println(getTitle() + " sesli kitabının erişimi kapatıldı.");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", duration=" + durationInMinutes +
                ", narrator=" + narrator +
                ", audioFormat=" + audioFormat;
    }
}
