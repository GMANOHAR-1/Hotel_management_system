/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import database.*;

/**
 *
 * @author dshre
 */
public class FoodBooking extends Food{
    private String RoomNo;
    private int Quantity;

    public FoodBooking() {
        
    }
    public FoodBooking(String foodno,String name,int price,String roomno,int quantity){
        super(foodno,name,price);
        this.RoomNo = roomno;
        this.Quantity = quantity;
    }
    
    public String getRoomNo() {
        return RoomNo;
    }
    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }
    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
    public void AddFood(String foodno,String name,int price,String roomno,int quantity){
        try 
        { 
            if(foodno.equals("")|| name.equals("")|| price==0 || roomno.equals("") || quantity==0){    
                JOptionPane.showMessageDialog(null, "Every Field is required");
            }
            else{
                String Query = "insert into foodbooking values('"+roomno+"','"+foodno+"','"+name+"',"+price+","+quantity+");";
                InsertUpdateDelete.setData(Query, "Food Item Added Successfully");  
            } 
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }                     
    }
}