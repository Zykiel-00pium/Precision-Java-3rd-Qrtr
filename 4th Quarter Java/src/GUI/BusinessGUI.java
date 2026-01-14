package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BusinessGUI {
  private JFrame frame;
    private JTable cartTable;
    private DefaultTableModel cartModel;
    private JLabel totalLabel;
    private double total = 0;

    // Store dogs
    private ArrayList<Dog> dogs = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BusinessGUI window = new BusinessGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BusinessGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Dog Store");
        frame.setSize(800, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Initialize dog breeds
        dogs.add(new Dog("German Shepherd", 300 ));
        dogs.add(new Dog("Chihuahua", 150 ));
        dogs.add(new Dog("Bulldog", 250 ));
        dogs.add(new Dog("Labrador Retriever", 280 ));
        dogs.add(new Dog("Poodle", 200 ));
        dogs.add(new Dog("Beagle", 180 ));
        dogs.add(new Dog("Dachshund", 170 ));

        // Display dog buttons
        int x = 20, y = 20;
        for (Dog dog : dogs) {
            JButton btn = new JButton(dog.getName() + " - ₱" + dog.getPrice());
            btn.setBounds(x, y, 220, 40);
            frame.add(btn);

            btn.addActionListener(e -> addToCart(dog));

            x += 240;
            if (x > 500) {
                x = 20;
                y += 50;
            }
        }

        // Cart table
        cartModel = new DefaultTableModel(new Object[]{"Dog", "Price"}, 0);
        cartTable = new JTable(cartModel);
        JScrollPane scrollPane = new JScrollPane(cartTable);
        scrollPane.setBounds(20, 250, 740, 150);
        frame.add(scrollPane);

        // Total label
        totalLabel = new JLabel("Total: ₱0");
        totalLabel.setBounds(20, 410, 200, 30);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(totalLabel);

        // Buy button
        JButton buyButton = new JButton("Buy");
        buyButton.setBounds(600, 410, 150, 30);
        frame.add(buyButton);

        buyButton.addActionListener(e -> printReceipt());
    }

    private void addToCart(Dog dog) {
        cartModel.addRow(new Object[]{dog.getName(), dog.getPrice()});
        total += dog.getPrice();
        totalLabel.setText("Total: ₱" + total);
        JOptionPane.showMessageDialog(frame, dog.getName() + " added to cart!");
    }

    private void printReceipt() {
        if (cartModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Cart is empty!");
            return;
        }

        StringBuilder receipt = new StringBuilder("---- RECEIPT ----\n");
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            receipt.append(cartModel.getValueAt(i, 0))
                   .append(" - ₱")
                   .append(cartModel.getValueAt(i, 1))
                   .append("\n");
        }
        receipt.append("-----------------\nTotal: ₱").append(total);

        JOptionPane.showMessageDialog(frame, receipt.toString());

        // Clear cart after purchase
        cartModel.setRowCount(0);
        total = 0;
        totalLabel.setText("Total: ₱0");
    }

    // Inner class for dog
    class Dog {
        private String name;
        private double price;

        public Dog(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
    }
}
