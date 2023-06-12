package MAIN.HOTELMANGEMENT_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
import GUI.*;
/**
 *
 * @author G Bharti
 */
public class HotelManagement_main {
    public static void main(String[] args) {
        // TODO code application logic here
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_credentials().setVisible(true);
            }
        }); 
    }
}
