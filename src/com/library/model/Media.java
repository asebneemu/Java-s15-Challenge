package com.library.model;

public abstract class Media {
    private String id;
    private String title;
    private Author author;
    private Category category;

    public Media(String id, String title, Author author, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    // Ortak davranışlar (ödünç alma vs.) soyut metotlar:
    public abstract void borrow();
    public abstract void returnMedia();

    @Override
    public String toString() {
        return "Media [id=" + id + ", title=" + title
                + ", author=" + (author != null ? author.getName() : "N/A") + "]";
    }
}
