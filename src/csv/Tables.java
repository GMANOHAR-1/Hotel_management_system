/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csv;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.FileReader;
import database.*;
/**
 *
 * @author heman
 */
public class Tables {
    public static void main(String[] args) throws Exception{
        Connection con = null;
        Statement st = null;
         
        con=Connectiondb.getCon();
        st = con.createStatement();
        FileReader fr1;
        Scanner sin=null;

        try {
            fr1 = new FileReader("C:\\Users\\heman\\OneDrive\\Desktop\\OOP Project\\HotelManagement\\src\\csv\\customer.csv");
            sin = new Scanner(fr1);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        sin.nextLine();
        String row;
        ArrayList<String> tokens1 = new ArrayList<String>();
        while (sin.hasNext()) {
            row = sin.nextLine();
             
            String[] tokens = row.split(",");
             for(String se : tokens){
                tokens1.add(se);
             }
                  if(Integer.parseInt(tokens1.get(0)) == 1){
                   st.executeUpdate("update customer set foodname = 'hi' where foodno = 1");   
                  
              }
             //st.executeUpdate("insert into customer(id,name) values('"+Integer.parseInt(tokens1.get(0))+"','"+tokens1.get(1)+"')");
            tokens1.clear();
         

        }
        JOptionPane.showMessageDialog(null,"SUCCEFULLY INSERTED");
    }       
}
//        finally{
//            try{
//            con.close();
//            st.close();
//        }
//        catch(Exception e){
//            
//        }
//        }
//    }