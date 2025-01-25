package com.library.model;
import java.time.LocalDate;

public class Reservation extends Transaction {
    private LocalDate reservationExpireDate;

    public Reservation(String transactionId, String readerId, String mediaId) {
        super(transactionId, readerId, mediaId);
        this.reservationExpireDate = LocalDate.now().plusDays(7); // örnek
    }

    public LocalDate getReservationExpireDate() { return reservationExpireDate; }
    public void setReservationExpireDate(LocalDate reservationExpireDate) {
        this.reservationExpireDate = reservationExpireDate;
    }

    @Override
    public void process() {
        System.out.println("Reservation işlem işleniyor: " + toString());
        // bekleme listesine ekleme, kullanıcıya bildirim vs.
    }

    @Override
    public String toString() {
        return super.toString() +
                ", reservationExpireDate=" + reservationExpireDate;
    }
}
