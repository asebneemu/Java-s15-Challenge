package com.library.model;
import java.time.LocalDate;

public class Review {
    private String reviewId;
    private String readerId; // yorumu yapan kişi
    private String mediaId;  // hangi kitap (fiziksel/dijital)
    private int rating;      // 1-5 arası puan
    private String comment;
    private LocalDate reviewDate;

    public Review(String reviewId, String readerId, String mediaId, int rating, String comment) {
        this.reviewId = reviewId;
        this.readerId = readerId;
        this.mediaId = mediaId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = LocalDate.now();
    }

    public String getReviewId() { return reviewId; }
    public String getReaderId() { return readerId; }
    public String getMediaId() { return mediaId; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }
    public LocalDate getReviewDate() { return reviewDate; }

    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", readerId=" + readerId
                + ", mediaId=" + mediaId + ", rating=" + rating
                + ", comment=" + comment + ", reviewDate=" + reviewDate + "]";
    }
}
