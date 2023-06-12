/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import GUI.*;
import database.InsertUpdateDelete;
import javax.swing.JOptionPane;
/**
 *
 * @author G Bharti
 */
public class signup extends login{
    
    
    
    
    
    
    
    
    
    
    
    
    
          public void signupp(String email,String name,String password,String AADHAR,String ph,String Address)   {
     if(email.equals("") || name.equals("") || password.equals("") || AADHAR.equals("") || ph.equals("") || Address.equals(""))
        {
            JOptionPane.showMessageDialog(null, "PLEASE FILL EVERY FILL");
        }
        else
        {
            String Query;
            Query = "insert into logintable values('"+name+"','"+email+"','"+password+"','"+AADHAR+"','"+ph+"','"+ Address+"','false')";
            InsertUpdateDelete.setData(Query,"hulla successfully registered");
            //setVisible(false);
            new login().setVisible(true);
            
        }
 }
}
