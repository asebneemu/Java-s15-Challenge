package com.library.main;
import com.library.model.*;
import com.library.person.Reader;
import com.library.servise.Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Örnek okuyucular ekleyelim
        Reader reader1 = new Reader("R1", "Ali", "555-1111", new Membership("Student", 5));
        Reader reader2 = new Reader("R2", "Ayşe", "555-2222", new Membership("Faculty", 5));
        library.addReader(reader1);
        library.addReader(reader2);

        // Birkaç yazar
        Author author1 = new Author("Orhan Pamuk", "Nobel Edebiyat Ödüllü");
        Author author2 = new Author("Yuval Noah Harari", "Tarihçi, yazar");

        // Publisher
        Publisher publisher1 = new Publisher("YayınEvi A", "İstanbul", "0212-555-1234");

        // Fiziksel kitap ekle
        PhysicalBook pBook = new PhysicalBook(
                "B1",
                "Masumiyet Müzesi",
                author1,
                Category.LITERATURE,
                publisher1,
                "Raf A-3",
                50.0
        );
        library.addMedia(pBook);

        // E-kitap ekle
        EBook eBook = new EBook(
                "E1",
                "Hayvanlardan Tanrılara: Sapiens",
                author2,
                Category.SCIENCE,
                "PDF",
                5.0,
                "http://example.com/sapiens.pdf"
        );
        library.addMedia(eBook);

        // AudioBook ekle
        AudioBook aBook = new AudioBook(
                "A1",
                "Sapiens (Sesli Kitap)",
                author2,
                Category.SCIENCE,
                720.0,     // dakika
                "John Doe",
                "MP3",
                "http://example.com/sapiens-audio"
        );
        library.addMedia(aBook);

        // Kısa menü örneği
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== KÜTÜPHANE OTOMASYONU ===");
            System.out.println("1) Tüm Medyayı Listele");
            System.out.println("2) Ödünç Al (ReaderID, MediaID)");
            System.out.println("3) İade Et (ReaderID, MediaID)");
            System.out.println("4) Rezervasyon Yap (ReaderID, MediaID)");
            System.out.println("5) Değerlendirme Ekle (ReaderID, MediaID, Puan, Yorum)");
            System.out.println("6) Çıkış");
            System.out.print("Seçiminiz: ");
            String secim = sc.nextLine();

            switch (secim) {
                case "1":
                    library.listAllMedia();
                    break;
                case "2":
                    System.out.print("ReaderID: ");
                    String rId = sc.nextLine();
                    System.out.print("MediaID: ");
                    String mId = sc.nextLine();
                    library.borrowMedia(rId, mId);
                    break;
                case "3":
                    System.out.print("ReaderID: ");
                    rId = sc.nextLine();
                    System.out.print("MediaID: ");
                    mId = sc.nextLine();
                    library.returnMedia(rId, mId);
                    break;
                case "4":
                    System.out.print("ReaderID: ");
                    rId = sc.nextLine();
                    System.out.print("MediaID: ");
                    mId = sc.nextLine();
                    library.createReservation(rId, mId);
                    break;
                case "5":
                    System.out.print("ReaderID: ");
                    rId = sc.nextLine();
                    System.out.print("MediaID: ");
                    mId = sc.nextLine();
                    System.out.print("Puan (1-5): ");
                    int rating = Integer.parseInt(sc.nextLine());
                    System.out.print("Yorum: ");
                    String comment = sc.nextLine();
                    library.addReview(rId, mId, rating, comment);
                    break;
                case "6":
                    System.out.println("Çıkılıyor...");
                    sc.close();
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}
