import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * Created by admin on 7/18/2016.
 */
public class BookStoreUI {
    private JFrame f;

    private Book selectedBook;
    private Store store;
    private int bookIndex;

    public BookStoreUI(Store store){
        this.store = store;

        f = new JFrame();
        f.setMinimumSize(new Dimension(600, 400));
        f.setLocation(300, 100);

        JMenuItem buyBooks = new JMenuItem("Buy Books");
        buyBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSellingForm();
            }
        });

        JMenu menu = new JMenu("Books");
        menu.add(buyBooks);

        JMenuBar mb = new JMenuBar();
        mb.add(menu);

        f.getRootPane().setJMenuBar(mb);

        f.getContentPane().add(createTransactionPanel());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }


    private void showSellingForm(){
       f.getContentPane().removeAll();
        f.getContentPane().add(createSellingPannel());

        f.pack();
        f.repaint();
    }

    private void showTransactionosPanel(){
        f.getContentPane().removeAll();
        f.getContentPane().add(createTransactionPanel());
        f.pack();
        f.repaint();
    }


    private JPanel createTransactionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        String[] columns = {"TID", "Date", "Book Name", "Price", "Customer"};
        List<Transaction> transactions = store.getTransactions();

        Object[][] data = new Object[transactions.size()][];
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            Object[] co = new Object[]{i+1, t.getBuyDate(), t.getBook().getTitle(), t.getAmount(), t.getCustomer().getName()};
            data[i] = co;
        }

        JTable transactionTable = new JTable(data, columns);
        transactionTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        transactionTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        transactionTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        transactionTable.getColumnModel().getColumn(3).setPreferredWidth(40);

        JScrollPane scrollPane = new JScrollPane(transactionTable);
        panel.add(scrollPane);

        return panel;
    }

    private JPanel createSellingPannel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JLabel label = new JLabel("Your name: ");
        JLabel lBooks = new JLabel("Books");
        JLabel lAmount = new JLabel("Amount");
        JTextField tfName = new JTextField(20);
       // tfName.setColumns(10);

        ArrayList<Book> book = store.getBooks();

        ButtonGroup prodButtons = new ButtonGroup();


        JPanel bookPanel = new JPanel();
        bookPanel.setLayout(new GridLayout(book.size(), 0));
        bookPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        JRadioButton rb;
        for(int i = 0; i < book.size(); i++){
            rb = new JRadioButton(book.get(i).getTitle() + " - " + book.get(i).getPrice() + "$", false);
            prodButtons.add(rb);
            bookPanel.add(rb);
            rb.setActionCommand(book.get(i).getTitle());
            Book bkk = book.get(i);


            rb.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedBook = bkk;

                }


            });


        }

       // List<Book> books = store.getBooks();

        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField ftf = new JFormattedTextField(nf);
        ftf.setValue(1);
        ftf.setColumns(5);


        JButton buyButton = new JButton("Buy");

        buyButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                Customer c = new Customer();
                c.setName(tfName.getText());
                int count = Integer.parseInt(ftf.getText());

                store.sell(selectedBook, c, count);
                showTransactionosPanel();
            }
        });


        panel.add(buyButton, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));

        panel.add(label, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0,0,0,0), 0, 0));
        panel.add(tfName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));
        panel.add(lBooks, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));
        panel.add(bookPanel, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,3,0,0), 0, 0));
        panel.add(lAmount, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));
        panel.add(ftf, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));
        panel.add(buyButton, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));

        return panel;
    }
}
