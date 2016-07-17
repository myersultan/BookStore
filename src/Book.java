/**
 * Created by admin on 7/6/2016.
 */
public class Book {

    private String title;
    private String author;
    private Category category;
    private double price;
    private String isbn;
    private String publisher;
    private int quantity;

    public Book(){
    }

    public Book(String title, String author, double price, String isbn, String publisher,Category category, int quantity){
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.publisher = publisher;
        this.category = category;
        this.quantity = quantity;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
