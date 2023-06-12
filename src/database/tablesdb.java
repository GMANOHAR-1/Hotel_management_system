package database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author heman
 */
import java.sql.*;
import javax.swing.*;

public class tablesdb {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = Connectiondb.getCon();
            st = con.createStatement();
             //st.executeUpdate("create table logindetails(name varchar(100), email varchar(100), password varchar(100), phone_no varchar(20))");
             //st.executeUpdate("create table room(roomno varchar(10), roomType varchar(100), bed varchar(100), price int, status varchar(20))");
            // st.executeUpdate("create table customer(id int, name varchar(200), mobileNumber varchar(10), nationality varchar(200),gender varchar(50), email varchar(200), aadhar varchar(200),address varchar(500), checkIn varchar(50), roomNo varchar(50), bed varchar(20), roomType varchar(200), pricePerDay int, advance int,numberOfDaysStay int, TotalAmount varchar(200), CheckOut varchar(50))");
             //st.executeUpdate("create table logintable(name varchar(230),emailid varchar(230),email varchar(230),password varchar(30),aadhar varchar(20),phoneno varchar(20),address varchar(230),flag varchar(20))");
             //st.executeUpdate("create table room(roomno varchar(10),type varchar(100),beds varchar(100),price varchar(20),TV varchar(50),geyser varchar(50),flag varchar(20))");
             //st.executeUpdate("create table food(foodno varchar(50),foodname varchar(40),price varchar(20))");
            //st.executeUpdate("create table FoodBooking(RoomNo varchar(10),FoodID varchar(10),Name varchar(40),Price varchar(15),Quantity varchar(10))");
            st.executeUpdate("create table FoodBooking(RoomNo varchar(10),FoodNo varchar(10),FoodName varchar(40),Price int,Quantity int)");
            JOptionPane.showMessageDialog(null, "table created successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                con.close();
                st.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
