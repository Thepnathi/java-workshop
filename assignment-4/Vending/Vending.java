import javax.swing.*;


/**
 * Created by thepnathi on 04/05/2018.
 */
public class Vending {

    public static void main(String[] args) {
        // Set up our vendor with all the components
        VendorFrame frame = new VendorFrame();

        // Set up the JFrame
        frame.setTitle("Vendor Digital Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 170, 500, 300);
        frame.setLayout(null);
        frame.setVisible(true);


    }
}
