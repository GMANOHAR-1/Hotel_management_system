/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import GUI.*;
import javax.swing.JOptionPane;
import database.*;
import java.sql.*;

/**
 *
 * @author dshre
 */
public class Food {
    protected String FoodNo;
    protected String FoodName;
    protected int Price;
    
    public Food(){
        
    }
    public Food(String foodno,String name,int price){
        this.FoodNo = foodno;
        this.FoodName = name;
        this.Price = price;
    }
    
    public String getFoodNo() {
        return FoodNo;
    }
    public void setFoodNo(String foodno) {
        this.FoodNo = foodno;
    }
    public String getFoodName() {
        return FoodName;
    }
    public void setFoodName(String name) {
        this.FoodName = name;
    }
    public int getPrice() {
        return Price;
    }
    public void setPrice(int price) {
        this.Price = price;
    }
    
    public void addfood(String foodno,String name,int price,char ch){
        try 
        { 
            if(foodno.equals("")|| name.equals("")|| price==0){    
                JOptionPane.showMessageDialog(null, "Every Field is required");
            }
            else{
                String Query;
                switch(ch){
                case 'A' :
                    Query = "insert into Breakfast values('"+foodno+"','"+name+"',"+price+");";
                    InsertUpdateDelete.setData(Query, "Food Item Added Successfully"); 
                    break;
                case 'B' :
                    Query = "insert into VegStarters values('"+foodno+"','"+name+"',"+price+");";
                    InsertUpdateDelete.setData(Query, "Food Item Added Successfully"); 
                    break;
                case 'C' :
                    Query = "insert into NonVegStarters('"+foodno+"','"+name+"',"+price+");";
                    InsertUpdateDelete.setData(Query, "Food Item Added Successfully"); 
                    break;
                case 'D' :
                    Query = "insert into VegRiceItems values('"+foodno+"','"+name+"',"+price+");";
                    InsertUpdateDelete.setData(Query, "Food Item Added Successfully"); 
                    break;
                case 'E' :
                    Query = "insert into NonVegRiceItems values('"+foodno+"','"+name+"',"+price+");";
                    InsertUpdateDelete.setData(Query, "Food Item Added Successfully"); 
                    break;
                case 'F' :
                    Query = "insert into VegGravies values('"+foodno+"','"+name+"',"+price+");";
                    InsertUpdateDelete.setData(Query, "Food Item Added Successfully"); 
                    break;
                case 'G' :
                    Query = "insert into NonVegGravies values('"+foodno+"','"+name+"',"+price+");";
                    InsertUpdateDelete.setData(Query, "Food Item Added Successfully"); 
                    break;
                case 'H' :
                    Query = "insert into IndianBread values('"+foodno+"','"+name+"',"+price+");";
                    InsertUpdateDelete.setData(Query, "Food Item Added Successfully"); 
                    break;
                case 'I' : 
                    Query = "insert into Desserts values('"+foodno+"','"+name+"',"+price+");";
                    InsertUpdateDelete.setData(Query, "Food Item Added Successfully"); 
                    break;
                }
            } 
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    public void removefood(String foodno,char ch){
        try 
        { 
            if(foodno.equals("")){    
                JOptionPane.showMessageDialog(null, "Every Field is required");
            }
            else{
                String Query;
                switch(ch){
                case 'A' :
                    Query = "delete from Breakfast where foodno = '" + foodno+"';";
                    InsertUpdateDelete.setData(Query, "Food Item Deleted Successfully "); 
                    break;
                case 'B' :
                    Query = "delete from VegStarters where foodno = '" + foodno+"';";
                    InsertUpdateDelete.setData(Query, "Food Item Deleted Successfully "); 
                    break;
                case 'C' :
                    Query = "delete from NonVegStarters where foodno = '" + foodno+"';";
                    InsertUpdateDelete.setData(Query, "Food Item Deleted Successfully "); 
                    break;
                case 'D' :
                    Query = "delete from VegRiceItems where foodno = '" + foodno+"';";
                    InsertUpdateDelete.setData(Query, "Food Item Deleted Successfully "); 
                    break;
                case 'E' :
                    Query = "delete from NonVegRiceItems where foodno = '" + foodno+"';";
                    InsertUpdateDelete.setData(Query, "Food Item Deleted Successfully "); 
                    break;
                case 'F' :
                    Query = "delete from VegGravies where foodno = '" + foodno+"';";
                    InsertUpdateDelete.setData(Query, "Food Item Deleted Successfully "); 
                    break;
                case 'G' :
                    Query = "delete from NonVegGravies where foodno = '" + foodno+"';";
                    InsertUpdateDelete.setData(Query, "Food Item Deleted Successfully "); 
                    break;
                case 'H' :
                    Query = "delete from IndianBread where foodno = '" + foodno+"';";
                    InsertUpdateDelete.setData(Query, "Food Item Deleted Successfully "); 
                    break;
                case 'I' : 
                    Query = "delete from Desserts where foodno = '" + foodno+"';";
                    InsertUpdateDelete.setData(Query, "Food Item Deleted Successfully "); 
                    break;
                }                  
            } 
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    public void updateFood(String foodno,String name,int price,char ch){
        try
        {
            String Query;
                switch(ch){
                case 'A' :
                    
                    Query = "update Breakfast set foodname= '" + name + "', price= " + price + " where foodno = '" + foodno + "';";
                    InsertUpdateDelete.setData(Query, "Food Item Updated Successfully "); 
                    break;
                case 'B' :
                    Query = "update VegStarters set foodname= '" + name + "', price= " + price + " where foodno = '" + foodno + "';";
                    InsertUpdateDelete.setData(Query, "Food Item Updated Successfully ");
                    break;
                case 'C' :
                    Query = "update NonVegStarters set foodname= '" + name + "', price= " + price + " where foodno = '" + foodno + "';";
                    InsertUpdateDelete.setData(Query, "Food Item Updated Successfully ");
                    break;
                case 'D' :
                    Query = "update VegRiceItems set foodname= '" + name + "', price= " + price + " where foodno = '" + foodno + "';";
                    InsertUpdateDelete.setData(Query, "Food Item Updated Successfully ");
                    break;
                case 'E' :
                    Query = "update NonVegRiceItems set foodname= '" + name + "', price= " + price + " where foodno = '" + foodno + "';";
                    InsertUpdateDelete.setData(Query, "Food Item Updated Successfully ");
                    break;
                case 'F' :
                    Query = "update VegGravies set foodname= '" + name + "', price= " + price + " where foodno = '" + foodno + "';";
                    InsertUpdateDelete.setData(Query, "Food Item Updated Successfully "); 
                    break;
                case 'G' :
                    Query = "update NonVegGravies set foodname= '" + name + "', price= " + price + " where foodno = '" + foodno + "';";
                    InsertUpdateDelete.setData(Query, "Food Item Updated Successfully "); 
                    break;
                case 'H' :
                    CSV_FILE_OPERATION.CSV_UPDATE("price",String.valueOf(price) , "FoodNo", "indianbread","INDIBREADS.csv",0);
//                    Query = "update IndianBread set foodname= '" + name + "', price= " + price + " where foodno = '" + foodno + "';";
//                    InsertUpdateDelete.setData(Query, "Food Item Updated Successfully ");
                    break;
                case 'I' : 
                    Query = "update Desserts set foodname= '" + name + "', price= " + price + " where foodno = '" + foodno + "';";
                    InsertUpdateDelete.setData(Query, "Food Item Updated Successfully ");
                    break;
                }         
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
}