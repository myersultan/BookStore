import java.awt.*;

/**
 * Created by admin on 7/17/2016.
 */
public class Launcher {

    public static void main(String[] args) throws Exception{
        SplashScreen splash = SplashScreen.getSplashScreen();
        Thread.sleep(5000);
        splash.close();
        Store store = new Store();
//        store.getPrice();
//        System.out.println();
//        store.getAvailable();
//        System.out.println();
//        store.lastWeek();
//        System.out.println();
//        store.lastDay();

        Customer c = new Customer();
        c.setName("Yersultan");
        store.sell(store.getBooks().get(0), c, 10);
        store.sell(store.getBooks().get(1), c, 10);


//        TransactionUI tui = new TransactionUI(store);

        BookStoreUI ui = new BookStoreUI(store);
    }
}
