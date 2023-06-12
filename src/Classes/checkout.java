/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import database.Select;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import Customer_pac.*;
import java.util.Calendar;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author thanu
 */
public class checkout {
    String roomNo;
    java.util.Date dateBefore;
    java.util.Date dateAfter;
    String dateBeforeString;

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Date getDateBefore() {
        return dateBefore;
    }

    public void setDateBefore(Date dateBefore) {
        this.dateBefore = dateBefore;
    }

    public Date getDateAfter() {
        return dateAfter;
    }

    public void setDateAfter(Date dateAfter) {
        this.dateAfter = dateAfter;
    }

    public String getDateBeforeString() {
        return dateBeforeString;
    }

    public void setDateBeforeString(String dateBeforeString) {
        this.dateBeforeString = dateBeforeString;
    }

    public int getNoofDaysStay() {
        return noofDaysStay;
    }

    public void setNoofDaysStay(int noofDaysStay) {
        this.noofDaysStay = noofDaysStay;
    }
    int noofDaysStay;
    
    public void calculate(String roomNo){
    try{
            
           ResultSet rs = Select.getData("select * from customer where roomNo= '"+roomNo+"' ");
//                   + "and checkOut is NULL ");
           if(rs.next()){
              
               SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
               Calendar cal = Calendar.getInstance();
               dateBeforeString = rs.getString(9);
               dateBefore= myFormat.parse (dateBeforeString);
               String dateAfterString = myFormat.format(cal.getTime());
               dateAfter= myFormat.parse (dateAfterString);              
           }   
           else{
               JOptionPane.showMessageDialog(null,"No Room");
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }


   public static String checkoutdate() {
          SimpleDateFormat myFormat = new SimpleDateFormat("YYYY/MM/dd");
          Calendar cal = Calendar.getInstance();
          return myFormat.format(cal.getTime());       
    }
    
    public int noofDays() throws ParseException{
        long difference = dateAfter.getTime()- dateBefore.getTime();
        noofDaysStay = (int)(difference/(1000*60*60*24));
        System.out.println(noofDaysStay);
               if(noofDaysStay==0){
                   noofDaysStay=1;
               }
               
        return noofDaysStay;
    }
}
