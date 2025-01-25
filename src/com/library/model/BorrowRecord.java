package com.library.model;
import java.time.LocalDate;

public class BorrowRecord extends Transaction {
    private LocalDate returnDate;
    private Invoice invoice; // fatura/ücretlendirme

    public BorrowRecord(String transactionId, String readerId, String mediaId, Invoice invoice) {
        super(transactionId, readerId, mediaId);
        this.invoice = invoice;
    }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    public Invoice getInvoice() { return invoice; }
    public void setInvoice(Invoice invoice) { this.invoice = invoice; }

    @Override
    public void process() {
        // Örneğin mediaId'ye erişip Media.borrow() çağırma
        System.out.println("BorrowRecord işlem işleniyor: " + toString());
    }

    @Override
    public String toString() {
        return super.toString() + ", returnDate=" + returnDate
                + ", invoiceAmount=" + (invoice != null ? invoice.getAmount() : "N/A");
    }
}
