import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by thepnathi on 06/05/2018.
 */
public class VendorFrame extends JFrame {

    private Product[] products = new Product[10]; // Stores product information
    private JLabel[] lblProducts = new JLabel[10]; // Labels for the product name
    private JLabel[] lblStocks = new JLabel[10];    // Labels for the product stock level
    private JButton[] btnProducts = new JButton[10]; // Buttons for purchasing product

    private double totalSales = 0.00; // Stores total sales
    private JButton btnVendorInfo, btnReset; // Button for the vendor window
    private JLabel lblTotalSales;

    private DecimalFormat twoDP = new DecimalFormat(".##"); // converts double to two decimal place
    private Color defaultColor = new Color(240, 237, 229); // Color scheme for the products type
    private Color lightBlue = new Color(79, 132, 196);
    private Color chocoBrown = new Color(128, 90, 52);
    private Color sweetYellow = new Color(236, 219, 84);
    private Color zeroStockColor = new Color(180, 183, 186);

    public VendorFrame() {
        setLayout(null);
        ActionButton actionButton = new ActionButton();

        // Initialise Product objects - name and corresponding price
        products[1] = new Product("Coka Kola", "drink", 0.99);
        products[2] = new Product("Mountain Water", "drink", 2.25);
        products[3] = new Product("Pluto Bar" ,"chocolate", 7.15);
        products[4] = new Product("Gummy Monster", "sweet", 1.65);
        products[5] = new Product("USB-Stick", "others", 15.85);
        products[6] = new Product("Ramen To Go", "others", 0.99);
        products[7] = new Product("Pear Dongles", "drink", 99.99);
        products[8] = new Product("British Choco", "chocolate", 29.99);
        products[9] = new Product("Halibros", "sweet", 5.99);

        // Vendor windows setup
        // User can open this extra window with a button
        btnVendorInfo = new JButton("Vendor Information");
        btnVendorInfo.setBounds(300, 250, 200, 30);
        btnVendorInfo.addActionListener(actionButton);
        add(btnVendorInfo);

        // Initialise product label or product names
        // Index correspong to the products
        for (int i = 1; i <= lblProducts.length - 1; i++) {
            lblProducts[i] = new JLabel(products[i].getProductName());
            add(lblProducts[i]); // add component to the window frame
        }

        // Initiliase product label stock level
        for (int i = 1; i <= lblStocks.length - 1; i++) {
            lblStocks[i] = new JLabel(String.valueOf("Stock: " + products[i].getProductStock()));
            add(lblStocks[i]);
        }

        // Initialise product corresponding purchase button
        // NOTE: Each button display product price
        for (int i = 1; i <= btnProducts.length - 1; i++) {
            btnProducts[i] = new JButton(String.valueOf("£ "+products[i].getProductPrice()));
            btnProducts[i].setOpaque(true);
            btnProducts[i].setBorder(new LineBorder(Color.LIGHT_GRAY));

            // Set btn custom colours
            String currProductType = products[i].getProductType();
            setCustomButtonColor(currProductType, btnProducts[i]);

            add(btnProducts[i]);
        }

        // Set components positions or coordinates
        // First row
        lblProducts[1].setBounds(70, 0, 300, 50);
        lblStocks[1].setBounds(70, 15, 300, 50);
        btnProducts[1].setBounds(50, 50, 100, 30);

        lblProducts[2].setBounds(220, 0, 300, 50);
        lblStocks[2].setBounds(220, 15, 300, 50);
        btnProducts[2].setBounds(200, 50, 100, 30);

        lblProducts[3].setBounds(370, 0, 300, 50);
        lblStocks[3].setBounds(370, 15, 300, 50);
        btnProducts[3].setBounds(350, 50, 100, 30);

        // Second row
        lblProducts[4].setBounds(70, 80, 300, 50);
        lblStocks[4].setBounds(70, 95, 300, 50);
        btnProducts[4].setBounds(50, 130, 100, 30);

        lblProducts[5].setBounds(220, 80, 300, 50);
        lblStocks[5].setBounds(220, 95, 300, 50);
        btnProducts[5].setBounds(200, 130, 100, 30);

        lblProducts[6].setBounds(370, 80, 300, 50);
        lblStocks[6].setBounds(370, 95, 300, 50);
        btnProducts[6].setBounds(350, 130, 100, 30);

        // Third Row
        lblProducts[7].setBounds(70, 160, 300, 50);
        lblStocks[7].setBounds(70, 175, 300, 50);
        btnProducts[7].setBounds(50, 210, 100, 30);

        lblProducts[8].setBounds(220, 160, 300, 50);
        lblStocks[8].setBounds(220, 175, 300, 50);
        btnProducts[8].setBounds(200, 210, 100, 30);

        lblProducts[9].setBounds(370, 160, 300, 50);
        lblStocks[9].setBounds(370, 175, 300, 50);
        btnProducts[9].setBounds(350, 210, 100, 30);


        // Add action listener to all the buttons
        for (int i = 1; i <= btnProducts.length - 1; i++) {
            btnProducts[i].addActionListener(actionButton);
        }

    }

    // This is our action listener
    // Pass an event (button clicked) and
    // Calls another method with the corresponding button and data
    // to update the application
    private class ActionButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Button to open vendor's info - shows total sales
            if (e.getSource() == btnVendorInfo) {
                displayTotalSales();
            } else if (e.getSource() == btnReset) {
               // reset all products stock back to 4
                // and change the colour back to the corresponding colours
                for (int i = 1; i <= products.length - 1; i++) {
                    products[i].setProductStock(4);
                    updateStockLabel(lblStocks[i], products[i]);
                    setCustomButtonColor(products[i].getProductType(), btnProducts[i]);
                }
                // Reset total sales back for next time the user access total sales
                setTotalSales(0);
            } else if (e.getSource() == btnProducts[1]) {
                productPurchased(1);
            } else if (e.getSource() == btnProducts[2]) {
                productPurchased(2);
            } else if (e.getSource() == btnProducts[3]) {
                productPurchased(3);
            } else if (e.getSource() == btnProducts[4]) {
                productPurchased(4);
            } else if (e.getSource() == btnProducts[5]) {
                productPurchased(5);
            } else if (e.getSource() == btnProducts[6]) {
                productPurchased(6);
            } else if (e.getSource() == btnProducts[7]) {
                productPurchased(7);
            } else if (e.getSource() == btnProducts[8]) {
                productPurchased(8);
            } else if (e.getSource() == btnProducts[9]) {
                productPurchased(9);
            }
        }
    }

    // Set JButton custom colours based on product type
    private void setCustomButtonColor(String type, JButton btn) {
        switch (type) {
            case "drink":
                btn.setBackground(lightBlue);
                break;
            case "chocolate":
                btn.setBackground(chocoBrown);
                break;
            case "sweet":
                btn.setBackground(sweetYellow);
                break;
            default:
                btn.setBackground(defaultColor);
        }
    }

    // Method to update multiple parts of the application
    // When the user click on a product button
    // Updates stock level(data), stock label and increment total sales
    private void productPurchased(int productNumber){
        decreaseStock(products[productNumber], btnProducts[productNumber]);
        updateStockLabel(lblStocks[productNumber], products[productNumber]);
        setTotalSales(getTotalSales() + products[productNumber].getProductPrice());
    }

    // This decreases the stock level of a given product
    // when the user click the button - which trigger this
    public void decreaseStock(Product item, JButton button) {
        if (item.getProductStock() > 0) {
            item.setProductStock(item.getProductStock() - 1);
            // Change button to different color when no stock are left
            if (item.getProductStock() == 0) {
                button.setBackground(zeroStockColor);
            }
        } else {
            // If stock is 0, a message will appear
            JOptionPane.showMessageDialog(null, "The selected product is out of stock!");
        }
    }

    // Allows the application to update the label with
    // new product stock level
    private void updateStockLabel(JLabel stockLabel, Product item) {
        stockLabel.setText(String.valueOf("Stock: " + item.getProductStock()));
    }

    // Create a new window to display the sales and allow the user to reset all product stock level
    public void displayTotalSales() {
        JFrame salesFrame = new JFrame();
        ActionButton salesActionButton = new ActionButton();

        salesFrame.setBounds(200, 170, 160, 200);
        salesFrame.setTitle("Vendor's Information");
        salesFrame.setLayout(null);
        salesFrame.setVisible(true);

        btnReset = new JButton("Reset Stocks");
        btnReset.setBounds(10, 150, 150, 30);
        lblTotalSales = new JLabel(String.valueOf("Total Sales: £ " + twoDP.format(getTotalSales())));
        lblTotalSales.setBounds(10, 100, 150, 30);

        btnReset.addActionListener(salesActionButton);
        salesFrame.add(btnReset); salesFrame.add(lblTotalSales);
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }


}
