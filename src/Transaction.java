import java.util.Date;

/**
 * Created by admin on 7/6/2016.
 */
public class Transaction {

    private Book book;
    private Customer customer;
    private String buyDate;
    private int amount;
    private int totalPrice;

    public Transaction(){

    }
    public Transaction(Book book, Customer customer, String  buyDate, int amount, int totalPrice){
        this.book = book;
        this.customer = customer;
        this.buyDate = buyDate;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}


