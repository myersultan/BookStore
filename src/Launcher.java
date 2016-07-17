/**
 * Created by admin on 7/17/2016.
 */
public class Launcher {

    public static void main(String[] args) throws Exception{
        Store store = new Store();
        store.getPrice();
        System.out.println();
        store.getAvailable();
        System.out.println();
        store.lastWeek();
        System.out.println();
        store.lastDay();
    }
}
