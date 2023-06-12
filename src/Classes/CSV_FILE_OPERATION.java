/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.util.*;
import java.io.FileReader;
import javax.swing.JOptionPane;
import database.*;
import GUI.*;
/**
 *
 * @author G Bharti
 */
interface csv_file{
      void CSV_UPDATE();
      void CSV_INSERTION();
}
abstract class CSV_FILE_OPERATION implements csv_file{
 //@Override;
 public static void CSV_UPDATE(String setattributename,String setting,String conattributename,String tablename,String filename,int i){
CustomerInfo user;
    FileReader fr1;
    Scanner san=null;
        try {
            fr1 = new FileReader("C:\\Users\\G Bharti\\Documents\\image_hoteel\\HotelManagement_1\\HotelManagement_1\\src\\csv\\"+filename+"");
            san = new Scanner(fr1);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

       san.nextLine();
        String row;
         String Query;
        ArrayList<String> tokens1 = new ArrayList<String>();
        try{
        while (san.hasNext()) {
            row = san.nextLine();
             
            String[] tokens = row.split(",");
            tokens1.addAll(Arrays.asList(tokens));
            if(tablename.equals("indianbread")){
             Query = "update "+tablename+" set "+setattributename+" = "+setting+"  where "+conattributename+" = '"+tokens1.get(i)+"'";
             System.out.println(tokens1.get(i));
            }
            else  
            { 
                Query = "update "+tablename+" set "+setattributename+" = '"+setting+"'  where "+conattributename+"='"+tokens1.get(i)+"'";
            }
           // System.out.println(Query);
            InsertUpdateDelete.setData(Query, "");
          //  JOptionPane.showMessageDialog(null, "successfuly updated"); 
            tokens1.clear();
                
        }}
        catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                }
        }
  
    public static void CSV_INSERTION(String tablename,String filename){

    FileReader fr1;
    Scanner sin=null;
        try {
            fr1 = new FileReader("C:\\Users\\G Bharti\\Documents\\image_hoteel\\HotelManagement_1\\HotelManagement_1\\src\\csv\\"+filename+"");
            sin = new Scanner(fr1);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        sin.nextLine();
        String row;
          
        ArrayList<String> tokens1 = new ArrayList<String>();
        try{
        while (sin.hasNext()) {
            row = sin.nextLine();
             
            String[] tokens = row.split(",");
            tokens1.addAll(Arrays.asList(tokens));
            if(tablename.equals("logintable")){
            String Query = "insert into logintable values('"+tokens1.get(1)+"','"+tokens1.get(0)+"','"+tokens1.get(2)+"','"+tokens1.get(3)+"','"+tokens1.get(4)+"','"+tokens1.get(5)+"','false')";
            InsertUpdateDelete.setData(Query, "");
             tokens1.clear();
            } 
             if(tablename.equals("customer")){
            String Query = "insert into customer(name,mobilenumber,nationality,gender,email,aadhar,address) values('"+tokens1.get(1)+"','"+tokens1.get(2)+"','"+tokens1.get(3)+"','"+tokens1.get(4)+"','"+tokens1.get(5)+"','"+tokens1.get(6)+"','"+tokens1.get(7)+"' )";
            InsertUpdateDelete.setData(Query, "");
            System.out.println(Query);
             tokens1.clear();
            } 
            
              if(tablename.equals("indianbread")){
            String Query = "insert into indianbread values('"+tokens1.get(0)+"','"+tokens1.get(1)+"','"+tokens1.get(2)+"')";
            InsertUpdateDelete.setData(Query, "");
           // System.out.println(Query);
             tokens1.clear();
            } 
             if(tablename.equals("desserts")){
            String Query = "insert into desserts values('"+tokens1.get(0)+"','"+tokens1.get(1)+"','"+tokens1.get(2)+"')";
            InsertUpdateDelete.setData(Query, "");
             tokens1.clear();
            } 
             if(tablename.equals("veggravies")){
            String Query = "insert into veggravies values('"+tokens1.get(0)+"','"+tokens1.get(1)+"','"+tokens1.get(2)+"')";
            InsertUpdateDelete.setData(Query, "");
             tokens1.clear();
            } 
             if(tablename.equals("nonveggravies")){
            String Query = "insert into nonveggravies values('"+tokens1.get(0)+"','"+tokens1.get(1)+"','"+tokens1.get(2)+"')";
            InsertUpdateDelete.setData(Query, "");
             tokens1.clear();
            } 
              if(tablename.equals("nonvegriceitems")){
            String Query = "insert into nonvegriceitems values('"+tokens1.get(0)+"','"+tokens1.get(1)+"','"+tokens1.get(2)+"')";
            InsertUpdateDelete.setData(Query, "");
             tokens1.clear();
            } 
               if(tablename.equals("vegriceitems")){
            String Query = "insert into vegriceitems values('"+tokens1.get(0)+"','"+tokens1.get(1)+"','"+tokens1.get(2)+"')";
            InsertUpdateDelete.setData(Query, "");
             tokens1.clear();
            } 
                if(tablename.equals("nonvegstarters")){
            String Query = "insert into nonvegstarters values('"+tokens1.get(0)+"','"+tokens1.get(1)+"','"+tokens1.get(2)+"')";
            InsertUpdateDelete.setData(Query, "");
             tokens1.clear();
            } 
                 if(tablename.equals("breakfast")){
            String Query = "insert into breakfast values('"+tokens1.get(0)+"','"+tokens1.get(1)+"','"+tokens1.get(2)+"')";
            InsertUpdateDelete.setData(Query, "");
             tokens1.clear();
            } 
               if(tablename.equals("vegstarters")){
            String Query = "insert into vegstarters values('"+tokens1.get(0)+"','"+tokens1.get(1)+"','"+tokens1.get(2)+"')";
            InsertUpdateDelete.setData(Query, "");
             tokens1.clear();
            }    
        }}
        catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                }
        }
    
    //"C:\Users\G Bharti\Documents\IndianBread.csv.xls"
    
        public static void main(String[] args){
             
                    //CSV_INSERTION("logintable","LOGINUSERS.csv");
//                    CSV_INSERTION("indianbread", "INDIBREADS.csv");
//                    CSV_INSERTION("nonvegriceitems","NONVEGRICEITEMSS.csv");
//                    CSV_INSERTION("logintable","LOGINUSERS.csv");
//                    CSV_INSERTION("breakfast","BFAST.csv");
                    //CSV_INSERTION("customer","customer.csv");
                    ///CSV_UPDATE( , setting, conattributename, tablename, filename, 0);
        
                    
                    
                CSV_INSERTION("logintable", "LOGINUSERS.csv");
                    CSV_INSERTION("indianbread", "INDIBREADS.csv");
                    CSV_INSERTION("breakfast","BFAST.csv");
                    CSV_INSERTION("nonvegriceitems","NONVEGRICEITEMSS.csv");
                   CSV_INSERTION("vegstarters","STARTERSVEG.csv");
                  CSV_INSERTION("nonvegstarters","NVSTARTERS.csv");
                CSV_INSERTION("vegriceitems","VEGRITEMS.csv");
               CSV_INSERTION("veggravies","VEGGRAVIES.csv");
              CSV_INSERTION("nonveggravies","NONVEGGRAVIES.csv");
              CSV_INSERTION("desserts","DESSERTS.csv");
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_credentials().setVisible(true);
            }
        }); 
        
        
        }
     }