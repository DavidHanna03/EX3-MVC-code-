import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//created a swing interface to communicate/read the UPC code and send it to the cash register


public class Keyboard{
    private JFrame frame;
    private JLabel UPCLabel1;
    private JTextField UPCTextField;
    private JButton UPCButton;
    private CashRegisterModel cashRegister;

    Keyboard(String title, CashRegisterModel register){
        this.cashRegister = register;
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,80);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //creating UI elements
        UPCLabel1 = new JLabel("UPC:");
        UPCTextField = new JTextField();
        UPCButton = new JButton ("Enter");

        // ass UI elements to frame 

        GroupLayout layout = new GroupLayout (frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) .addComponent(UPCLabel1))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(UPCTextField))
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(UPCButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(UPCLabel1)
        .addComponent(UPCTextField).addComponent(UPCButton)));

        frame.getContentPane().setLayout(layout);
        // set the keyboard to manage the upc Enter button event
        this.UPCButton.addActionListener(e -> processUPCCode());
        }
        private void processUPCCode(){
            try{
                int code = Integer.parseInt(UPCTextField.getText());
                cashRegister.processUPC(code);
            } catch (NumberFormatException e) {
                System.out.println("Invalid UPC Code");
            }
        }




}