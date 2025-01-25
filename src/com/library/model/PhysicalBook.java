package com.library.model;

public class PhysicalBook extends Media {
    private Publisher publisher;
    private String shelfLocation;
    private double price;
    private BookStatus status;

    public PhysicalBook(String id, String title, Author author, Category category,
                        Publisher publisher, String shelfLocation, double price) {
        super(id, title, author, category);
        this.publisher = publisher;
        this.shelfLocation = shelfLocation;
        this.price = price;
        this.status = BookStatus.AVAILABLE;
    }

    public Publisher getPublisher() { return publisher; }
    public void setPublisher(Publisher publisher) { this.publisher = publisher; }

    public String getShelfLocation() { return shelfLocation; }
    public void setShelfLocation(String shelfLocation) { this.shelfLocation = shelfLocation; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public BookStatus getStatus() { return status; }
    public void setStatus(BookStatus status) { this.status = status; }

    @Override
    public void borrow() {
        if (status == BookStatus.AVAILABLE) {
            status = BookStatus.BORROWED;
            System.out.println(getTitle() + " (fiziksel kitap) ödünç alındı.");
        } else {
            System.out.println(getTitle() + " zaten ödünç alınmış.");
        }
    }

    @Override
    public void returnMedia() {
        if (status == BookStatus.BORROWED) {
            status = BookStatus.AVAILABLE;
            System.out.println(getTitle() + " (fiziksel kitap) iade edildi.");
        } else {
            System.out.println(getTitle() + " zaten kütüphanede müsait.");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Publisher=" + (publisher != null ? publisher.getPublisherName() : "N/A") +
                ", Price=" + price +
                ", Status=" + status;
    }
}
