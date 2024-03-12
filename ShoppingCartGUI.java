import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartGUI extends JFrame implements ActionListener {
    private ShoppingCart cart;
    private JTextField itemNameField = new JTextField(10);
    private JTextField itemPriceField = new JTextField(10);
    private JTextField itemQuantityField = new JTextField(10);
    private JTextArea cartContentArea = new JTextArea();
    private JLabel totalPriceLabel = new JLabel("Total : $0.0");
    private JButton addButton = new JButton("Add Item");
    private JButton removeButton = new JButton("Remove Item");

    public ShoppingCartGUI() {
        super("Shopping Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        cart = new ShoppingCart();

        // I am inputting the Panel
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        inputPanel.setBackground(Color.LIGHT_GRAY);

        inputPanel.add(new JLabel("Item Name:"));
        inputPanel.add(itemNameField);

        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(itemPriceField);

        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(itemQuantityField);

        addButton.addActionListener(this);
        addButton.setBackground(Color.GREEN);
        addButton.setForeground(Color.BLUE);
        inputPanel.add(addButton);

        removeButton.addActionListener(this);
        removeButton.setBackground(Color.GREEN);
        removeButton.setForeground(Color.BLUE);
        inputPanel.add(removeButton);

        cartContentArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(cartContentArea);

        //Total Price
        JPanel totalPanel = new JPanel(new BorderLayout());
        totalPanel.add(totalPriceLabel, BorderLayout.EAST);

        // I am adding components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(totalPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                String name = itemNameField.getText();
                double price = Double.parseDouble(itemPriceField.getText());
                int quantity = Integer.parseInt(itemQuantityField.getText());
                Item item = new Item(name, price);
                ItemOrder order = new ItemOrder(item, quantity);
                cart.addItemOrder(order);
                updateCartDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for price and quantity.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == removeButton) {
            String name = itemNameField.getText();
            ItemOrder orderToRemove = cart.searchItemOrder(name);
            if (orderToRemove != null) {
                cart.removeItemOrder(orderToRemove);
                updateCartDisplay();
            } else {
                JOptionPane.showMessageDialog(this, "Items not found.",
                        "Remove Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    // update the display of the cart content and price
    private void updateCartDisplay() {
        StringBuilder content = new StringBuilder();
        for (ItemOrder order: cart.itemOrders) {
            content.append(order.getItem().getName())
                    .append(" - Quantity ")
                    .append(order.getQuantity())
                    .append(", Total: $")
                    .append(order.getTotal())
                    .append("\n");
        }
        cartContentArea.setText(content.toString());
        totalPriceLabel.setText("Total: $" + cart.getTotalPrice());
    }

    public  static void main(String[] args) {
        new ShoppingCartGUI();


    }
}
