package com.library.model;

public class EBook extends Media {
    private String fileFormat;   // PDF, ePub, vb.
    private double fileSizeMB;
    private String downloadLink;
    private boolean activeLicense;

    public EBook(String id, String title, Author author, Category category,
                 String fileFormat, double fileSizeMB, String downloadLink) {
        super(id, title, author, category);
        this.fileFormat = fileFormat;
        this.fileSizeMB = fileSizeMB;
        this.downloadLink = downloadLink;
        this.activeLicense = true;
    }

    @Override
    public void borrow() {
        if (activeLicense) {
            System.out.println(getTitle() + " e-kitabı ödünç alındı. Link: " + downloadLink);
        } else {
            System.out.println(getTitle() + " e-kitabının lisansı geçersiz.");
        }
    }

    @Override
    public void returnMedia() {
        // E-kitap için fiziki iade yok, lisans iptali vb.
        System.out.println(getTitle() + " e-kitabı ödünç işlemi kapatıldı.");
        // Gerekirse activeLicense = false gibi mantık
    }

    @Override
    public String toString() {
        return super.toString() +
                ", fileFormat=" + fileFormat +
                ", fileSizeMB=" + fileSizeMB +
                ", activeLicense=" + activeLicense;
    }

    // Getters / Setters ...
}
