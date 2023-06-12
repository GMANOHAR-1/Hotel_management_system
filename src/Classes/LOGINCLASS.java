/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import GUI.*;
import GUI.home;
import database.InsertUpdateDelete;
import database.Select;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author G Bharti
 */
interface LOGININ{
    void loginthrough();
    void signupp();
}
public class LOGINCLASS  {
    private String name;
    private String emailid;
    private String password;
    private String aadhar;
    private String phoneno;
    private String address;

    public String getName() {
        return name;
    }
public LOGINCLASS(){
    
}
    public LOGINCLASS(String name, String emailid, String password, String aadhar, String phoneno, String address) {
        this.name = name;
        this.emailid = emailid;
        this.password = password;
        this.aadhar = aadhar;
        this.phoneno = phoneno;
        this.address = address;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getPassword() {
        return password;
    }

    public String getAadhar() {
        return aadhar;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public void setAddress(String address) {
        this.address = address;
    }
   
    public void loginthrough(String emailid,String passw){
         int check = 0;
         if(emailid.equals("") || passw.equals(""))
        {   System.out.println("hello");
            check = 1;
            JOptionPane.showMessageDialog(null,"please fill everything");
        }
        else if(emailid.equals("ooops@gmail.com") && passw.equals("123"))
        {   
            System.out.println("hello");
            check=1;
          // setVisible(false);
            new admpg().setVisible(true);
        }
        else 
        {
            ResultSet rs = Select.getData("select * from logintable where emailid ='"+emailid+"' and password = '"+passw+"' ");
            try
            {
               if(rs.next() )
               {
                   check=1;
                   if(rs.getString(7).equals("true"))
                   {  
                       //setVisible(false);
                       new home().setVisible(true); 
                   }
                   else 
                   {
                       JOptionPane.showMessageDialog(null,"have some patience for approval");
                   }
               }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         
    }
    

    
    
}
