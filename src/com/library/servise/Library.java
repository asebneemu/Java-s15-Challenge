package com.library.servise;

import com.library.model.*;
import com.library.person.Reader;

import java.util.*;

public class Library {
    private Map<String, Media> allMedia;         // Tüm kitaplar (fiziksel, e-kitap, sesli) polimorfik
    private Map<String, Reader> readers;         // Key: readerId
    private Map<String, BorrowRecord> borrowRecords; // Key: transactionId
    private Map<String, Reservation> reservations;   // Key: transactionId

    private List<Review> reviews; // Tüm değerlendirmeler

    public Library() {
        this.allMedia = new HashMap<>();
        this.readers = new HashMap<>();
        this.borrowRecords = new HashMap<>();
        this.reservations = new HashMap<>();
        this.reviews = new ArrayList<>();
    }

    // -----------------------------
    // MEDIA İşlemleri
    // -----------------------------
    public void addMedia(Media media) {
        allMedia.put(media.getId(), media);
        System.out.println("Medya eklendi: " + media.toString());
    }

    public Media findMediaById(String id) {
        return allMedia.get(id);
    }

    public List<Media> findMediaByTitle(String title) {
        List<Media> result = new ArrayList<>();
        for (Media m : allMedia.values()) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
    }

    public List<Media> listMediaByCategory(Category category) {
        List<Media> result = new ArrayList<>();
        for (Media m : allMedia.values()) {
            if (m.getCategory() == category) {
                result.add(m);
            }
        }
        return result;
    }

    public void listAllMedia() {
        for (Media m : allMedia.values()) {
            System.out.println(m);
        }
    }

    // -----------------------------
    // READER İşlemleri
    // -----------------------------
    public void addReader(Reader reader) {
        readers.put(reader.getId(), reader);
        System.out.println("Okuyucu eklendi: " + reader.getName());
    }

    public Reader getReader(String readerId) {
        return readers.get(readerId);
    }

    // -----------------------------
    // BORROW (ÖDÜNÇ) İşlemleri
    // -----------------------------
    public void borrowMedia(String readerId, String mediaId) {
        Reader r = readers.get(readerId);
        Media m = allMedia.get(mediaId);

        if (r == null) {
            System.out.println("Okuyucu bulunamadı: " + readerId);
            return;
        }
        if (m == null) {
            System.out.println("Medya bulunamadı: " + mediaId);
            return;
        }

        // 5 kitap (media) limiti kontrolü
        if (r.getCurrentBorrowedBookCount() >= r.getMembership().getMaxBookLimit()) {
            System.out.println("Okuyucu kitap limitine ulaştı! (Limit: "
                    + r.getMembership().getMaxBookLimit() + ")");
            return;
        }

        // Polimorfik borrow() çağrısı
        m.borrow();

        // Fatura (örnek: media fiyatı 50 TL ise, BasicInvoice kesiyoruz)
        double invoiceAmount = 0.0;
        if (m instanceof PhysicalBook) {
            invoiceAmount = ((PhysicalBook) m).getPrice();
        }
        Invoice invoice = new BasicInvoice(invoiceAmount);

        // BorrowRecord oluştur
        String transactionId = UUID.randomUUID().toString();
        BorrowRecord record = new BorrowRecord(transactionId, readerId, mediaId, invoice);
        borrowRecords.put(transactionId, record);

        // Reader'ın sayacını artır
        r.setCurrentBorrowedBookCount(r.getCurrentBorrowedBookCount() + 1);

        System.out.println("Ödünç alma kaydedildi. Transaction ID: " + transactionId);
        invoice.printInvoice();
    }

    public void returnMedia(String readerId, String mediaId) {
        // Aktif borrowRecord'u bulalım
        BorrowRecord found = null;
        for (BorrowRecord br : borrowRecords.values()) {
            if (br.getReaderId().equals(readerId) && br.getMediaId().equals(mediaId)
                    && br.getReturnDate() == null) {
                found = br;
                break;
            }
        }
        if (found == null) {
            System.out.println("Bu medya için aktif ödünç kaydı yok!");
            return;
        }

        // Media’yı bul, polimorfik returnMedia() çağır
        Media m = allMedia.get(mediaId);
        if (m != null) {
            m.returnMedia();
        }

        // İade tarihi ayarla
        found.setReturnDate(java.time.LocalDate.now());

        // Okuyucu sayacını azalt
        Reader r = readers.get(readerId);
        if (r != null) {
            r.setCurrentBorrowedBookCount(r.getCurrentBorrowedBookCount() - 1);
        }

        // Fatura tutarını sıfırlama (veya iade)
        found.getInvoice().setAmount(0.0);

        System.out.println("Medya iade alındı, ücret iade edildi. Transaction: " + found);
    }

    // -----------------------------
    // RESERVATION (Rezerve) İşlemleri
    // -----------------------------
    public void createReservation(String readerId, String mediaId) {
        Reader r = readers.get(readerId);
        Media m = allMedia.get(mediaId);

        if (r == null || m == null) {
            System.out.println("Okuyucu veya medya bulunamadı!");
            return;
        }

        String transactionId = UUID.randomUUID().toString();
        Reservation res = new Reservation(transactionId, readerId, mediaId);
        reservations.put(transactionId, res);

        // process() çağrısı
        res.process();

        System.out.println("Rezervasyon oluşturuldu: " + res);
    }

    // -----------------------------
    // REVIEW (Değerlendirme) İşlemleri
    // -----------------------------
    public void addReview(String readerId, String mediaId, int rating, String comment) {
        if (!readers.containsKey(readerId)) {
            System.out.println("Okuyucu bulunamadı: " + readerId);
            return;
        }
        if (!allMedia.containsKey(mediaId)) {
            System.out.println("Medya bulunamadı: " + mediaId);
            return;
        }

        String reviewId = UUID.randomUUID().toString();
        Review review = new Review(reviewId, readerId, mediaId, rating, comment);
        reviews.add(review);

        System.out.println("Yeni değerlendirme eklendi: " + review);
    }

    public List<Review> listReviewsForMedia(String mediaId) {
        List<Review> result = new ArrayList<>();
        for (Review rev : reviews) {
            if (rev.getMediaId().equals(mediaId)) {
                result.add(rev);
            }
        }
        return result;
    }
}
