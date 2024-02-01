package projekti.bookstore.model;

public class Book {
    String title, author, isbn;
    int publicationdYear;
    double price;

    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public int getPublicationdYear() {
        return publicationdYear;
    }
    public void setPublicationdYear(int publicationdYear) {
        this.publicationdYear = publicationdYear;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Book() {
        super();
    }
    public Book(String title, String author, String isbn, int publicationdYear, double price) {
        super();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationdYear = publicationdYear;
        this.price = price;
    }


}
