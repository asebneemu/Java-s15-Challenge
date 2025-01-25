package com.library.model;
import java.time.LocalDate;

public abstract class Transaction {
    private String transactionId;
    private String readerId;
    private String mediaId; // hangi kitap/medya
    private LocalDate transactionDate;

    public Transaction(String transactionId, String readerId, String mediaId) {
        this.transactionId = transactionId;
        this.readerId = readerId;
        this.mediaId = mediaId;
        this.transactionDate = LocalDate.now();
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public String getReaderId() { return readerId; }
    public void setReaderId(String readerId) { this.readerId = readerId; }

    public String getMediaId() { return mediaId; }
    public void setMediaId(String mediaId) { this.mediaId = mediaId; }

    public LocalDate getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDate transactionDate) { this.transactionDate = transactionDate; }

    public abstract void process(); // işlemi gerçekleştirmek için

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId
                + ", readerId=" + readerId
                + ", mediaId=" + mediaId
                + ", transactionDate=" + transactionDate + "]";
    }
}
