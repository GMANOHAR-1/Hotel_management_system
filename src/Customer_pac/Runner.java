/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer_pac;
import GUI.*;
/**
 *
 * @author heman
 */
import java.awt.*;
import javax.swing.*;

public class Runner {

    private static final JFrame FRAME = new JFrame();
    private final ImageIcon icon;
    private final JLabel L1;

    public static JFrame getFrame() {
        return FRAME;
    }

    public Runner() {
        
        icon = new ImageIcon("C:\\Users\\heman\\OneDrive\\Desktop\\OOP Project\\HotelManagement\\src\\Customer_pac\\HOTEL.jpg");
        L1 = new JLabel(icon);
        FRAME.setUndecorated(true);
        FRAME.setSize(new Dimension(1550, 820));
        FRAME.setLocationRelativeTo(null);
        FRAME.add(L1);
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        Runner.FRAME.setVisible(true);

        try {
            Thread.sleep(1000);
            Runner.FRAME.getContentPane().removeAll();
            Runner.FRAME.setVisible(false);
            new home().setVisible(true);
            Runner.FRAME.getContentPane().revalidate();

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
