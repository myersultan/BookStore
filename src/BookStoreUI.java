import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by admin on 7/18/2016.
 */
public class BookStoreUI {
    private Book selectedBook;
    private Store store;

    public BookStoreUI(Store store){
        this.store = store;

        JFrame f = new JFrame();
        f.setMinimumSize(new Dimension(800, 600));
        f.setLocation(300, 100);

        f.getContentPane().add(createSellingPannel());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
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


        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField ftf = new JFormattedTextField(nf);
        ftf.setValue(1);
        ftf.setColumns(5);


        JButton buyButton = new JButton("Buy");

        buyButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

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
