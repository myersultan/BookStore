import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by admin on 7/17/2016.
 */
public class Store {

    private int positions = 100;
    private int custSize = 100;
    private int transSize = 100;

    private Book[] storage = new Book[positions];
    private Customer[] customer = new Customer[custSize];
    private Transaction[] transaction = new Transaction[transSize];
    private List<Transaction> transactions;
    private int transId = 1;

    public Store(){
        initBook();
        initCust();
        initTrans();
        transactions = new ArrayList<>();
    }

    public void initBook(){
        storage[0] = new Book("A Game of Thrones", "George R.R. Martin", 7, "0553593714", "Bantam", Category.FANTASY, 10);
        storage[1] = new Book("A Clash of Kings", "George R.R. Martin", 6, "0553579908", "Bantam", Category.FANTASY, 10);
        storage[2] = new Book("A Storm of Swords", "George R.R. Martin", 6, "055357342X", "Bantam", Category.FANTASY, 10);
        storage[3] = new Book("A Feast for Crows", "George R.R. Martin", 5, "055358202X", "Bantam", Category.FANTASY, 10);
        storage[4] = new Book("A Dance with Dragons", "George R.R. Martin", 5, "0553582011", "Bantam", Category.FANTASY, 10);
        storage[5] = new Book("Hackers: Heroes of the Computer Revolution", "Steven Levy", 16, "1449388396", "O'Reilly", Category.COMPUTERS, 10);
        storage[6] = new Book("Programming: Computer Programming for Beginners", "Joseph Connor", 11, "1518662587", "CreateSpace", Category.COMPUTERS, 10);
        storage[7] = new Book("Computers For Seniors For Dummies", "Nancy C. Muir", 20, "1118115538", "For Dummies", Category.COMPUTERS, 10);
        storage[8] = new Book("How Computers Work: Processor And Main Memory", "Roger Young", 4, "1442113987", "CreateSpace", Category.COMPUTERS, 10);
        storage[9] = new Book("Java Programming 24-Hour Trainer", "Yakov Fain", 9, "0470889640", "Wrox", Category.COMPUTERS, 10);
        storage[10] = new Book("The Book Thief", "Markus Zusak", 8, "0375842209", "Alfred A. Knopf", Category.FICTION, 10);
        storage[11] = new Book("Out of My Mind", "Sharon M. Draper", 5, "1416971718", "Atheneum Books for Young Readers", Category.FICTION, 10);
        storage[12] = new Book("The Girl on the Train: A Novel", "Paula Hawkins", 10, "1594634025", "Riverhead Books", Category.FICTION, 10);
        storage[13] = new Book("What She Left Behind", "Ellen Marie Wiseman", 9, "0758278454", "Kensington", Category.FICTION, 10);
        storage[14] = new Book("Ordinary Grace", "William Kent Krueger", 10, "1451645856", "Atria Books", Category.FICTION, 10);
        storage[15] = new Book("A Short History of Nearly Everything", "Bill Bryson", 10, "076790818X", "Broadway Books", Category.HISTORY, 10);
        storage[16] = new Book("The Forgotten 500: The Untold Story of the Men Who Risked All for the Greatest Rescue Mission of World War II", "Gregory A. Freeman", 10, "0451224957", "NAL", Category.HISTORY, 10);
        storage[17] = new Book("Lies My Teacher Told Me: Everything Your American History Textbook Got Wrong", "James W. Loewen", 15, "0743296281", "Touchstone", Category.HISTORY, 10);
        storage[18] = new Book("Alexander Hamilton", "Ron Chernow", 13, "0143034758", "Penguin Books", Category.HISTORY, 10);
        storage[19] = new Book("The Sea Wolves: A History of the Vikings", "Lars Brownworth", 13, "1909979120", "Crux Publishing Ltd", Category.HISTORY, 10);
    }

    public void initCust(){
        customer[0] = new Customer("Yersultan", "7071001122", "yersultan@gmail.com");
        customer[1] = new Customer("Sergey", "7071110022", "sergey@gmail.com");
        customer[2] = new Customer("Andrey", "7071221122", "andrey@gmail.com");
        customer[3] = new Customer("Vova", "7071331122", "vova@gmail.com");
    }

    public void initTrans(){
//        transaction[0] = new Transaction(storage[0], customer[1], "12/07/2016", 2);
//        transaction[1] = new Transaction(storage[3], customer[3], "13/07/2016", 5);
//        transaction[2] = new Transaction(storage[9], customer[0], "18/07/2016", 3);
//        transaction[3] = new Transaction(storage[10], customer[2], "18/07/2016", 1);
    }

    public void getPrice(){
        System.out.println("======================= Price List =======================");
        for (int i = 0; i < storage.length && storage[i] != null; i++) {
            System.out.println(i+1 + ") " + storage[i].getTitle() + " - $" + storage[i].getPrice());
        }
    }

    public void getAvailable(){
        System.out.println("====================== Available in storage ====================");
        for (int i = 0; i < storage.length && storage[i] != null; i++) {
            System.out.println(i+1 + ") " + storage[i].getTitle() + " - " + storage[i].getQuantity());
        }
    }

    public void lastDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = new GregorianCalendar();
        String today = sdf.format(c.getTime());

        int transCount = 0;
        int transPrice = 0;
        int transAmount = 0;


        for (int i = 0; i <transaction.length-1 && transaction[i] != null ; i++) {
            String currDay = transaction[i].getBuyDate();

            if (currDay.equals(today)){
                transAmount += transaction[i].getAmount();
                transPrice += transaction[i].getBook().getPrice()*transaction[i].getAmount();
                transCount++;
            }

        }
        System.out.println("=========== List of Transaction for Today =============");
        System.out.println("Number of transactions: " + transCount);
        System.out.println("Total amount: " + transAmount);
        System.out.println("Total price: " + transPrice);
        System.out.println("=======================================================");
    }

    public void lastWeek(){
        System.out.println("============= Number of Transactions for last 7 days ==============");
       // System.out.print("( ");
        for (int i = 6; i >= 0 ; i--) {
            int transCount = 0;
            Calendar cal = new GregorianCalendar();
            cal.add(Calendar.DAY_OF_MONTH, -i);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String checkDay = sdf.format(cal.getTime());
           // System.out.println(checkDay);
            for (int j = 0; j < transaction.length && transaction[j] !=null; j++) {

                String currDay = transaction[j].getBuyDate();
                if (checkDay.equals(currDay)){
                    transCount++;
                }
            }
            System.out.println(checkDay + " - " + transCount);


        }
       // System.out.println(" )");
        System.out.println("=======================================================");
    }

    public ArrayList<Book> getBooks(){
        ArrayList<Book> list = new ArrayList<Book>();
        for (int i = 0; i < storage.length; i++) {
            list.add(storage[i]);
        }
        list.removeAll(Collections.singleton(null));
        return list;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public void sell(Book book, Customer cust, int count){

        System.out.println("id: " + transId + " | " + getTime() + " | " + count + " " + book.getTitle() + ": "
                + book.getPrice()*count + " | " + cust.getName());

        Transaction t = new Transaction();
        t.setBuyDate(getTime());
        t.setBook(book);
        t.setCustomer(cust);
        t.setAmount(count);
        int total = (int) book.getPrice() * count;
        t.setTotalPrice(checkDiscount(total));
        addTransaction(t);
        transId++;
    }

    private int checkDiscount(int total){
        if(total >= 500 && total < 1000){
            return (int)(total*0.95);
        } if (total >= 1000){
            return (int)(total*0.90);
        }
        return total;
    }

    private String getTime(){
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy hh:mm:ss");
        return sdf.format(calendar.getTime());
    }

}
