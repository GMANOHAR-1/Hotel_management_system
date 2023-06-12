/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;    

import Customer_pac.*;
import database.InsertUpdateDelete;
import database.Select;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author heman
 */
public class CustomerInfo extends RoomInfo{
        private int id = 1;
        private String name;
        private String gender;
        private String nationality;
        private String mobileNumber;
        private String email;
        private String address;
        private String aadhar;
        private String checkIn;
        private String advance;

        public int getId() {
                return this.id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return this.name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getGender() {
                return this.gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public String getNationality() {
                return this.nationality;
        }

        public void setNationality(String nationality) {
                this.nationality = nationality;
        }

        public String getMobileNumber() {
                return this.mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
                this.mobileNumber = mobileNumber;
        }

        public String getEmail() {
                return this.email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getAddress() {
                return this.address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getAadhar() {
                return this.aadhar;
        }

        public void setAadhar(String aadhar) {
                this.aadhar = aadhar;
        }

        public String getCheckIn() {
                return this.checkIn;
        }

        public void setCheckIn(String checkIn) {
                this.checkIn = checkIn;
        }

        public String getAdvance() {
                return this.advance;
        }

        public void setAdvance(String advance) {
                this.advance = advance;
        }
        
//        RoomInfo ri = new RoomInfo();
//        public void setRoom(String roomno, String roomType,String bed, String pricePerDay){
//            ri.setRoomno(roomno);
//            ri.setRoomType(roomType);
//            ri.setBed(bed);
//            ri.setPricePerDay(pricePerDay);
//        }
        public void allocateRoom(){
            String Query = "select max(id) from customer";
        try {
            ResultSet rs = Select.getData(Query);
            while (rs.next()) {
                id = rs.getInt(1);
                id++;
                if (this.getName().equals("") || this.getMobileNumber().equals("") || this.getNationality().equals("") || this.getGender().equals("")
                        || this.getEmail().equals("")
                        || this.getAddress().equals("") || this.getCheckIn().equals("") || super.getRoomno()==null || super.getBed().equals("")
                        || super.getRoomType().equals("") || super.getPricePerDay()==null || this.getAdvance().equals("")) {
                    JOptionPane.showMessageDialog(null, "Every Field is necessary");
                } else {
                    Query = "update room set flag = 'booked' where roomno = '" + super.getRoomno() + "'";
                    InsertUpdateDelete.setData(Query, "");
                    
                    
                    Query = "insert into customer(id,name,mobileNumber,nationality,gender,email,aadhar,address,checkIn,roomno,bed,roomType,pricePerDay,advance) values ('"
                            + id + "','"+ name + "','" + mobileNumber + "','" + nationality + "','" + gender + "','" + email + "','"
                            + aadhar + "','" + address + "','"
                            + checkIn + "','" + super.getRoomno() + "','" + super.getBed() + "','" + super.getRoomType() + "','" + super.getPricePerDay() + "','"+advance+"')";

                    InsertUpdateDelete.setData(Query, "Customer Check In Successfully");
                    
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        public void CustomerDetailsPrinter(CustomerInfo user) {
        try {                                                                       
            FileWriter w = new FileWriter(user.getId()+"_"+user.getName() + "_Details.txt");
            w.write("Hotel Customer Details\r\n");  
            w.write("\r\n"); 
            w.write("Customer Id: "+user.getId()+"\r\n");
            w.write("Name: "+user.getName()+"\r\n");
            w.write("mobileNumber: "+user.getMobileNumber()+"\r\n");
            w.write("Nationality: "+user.getNationality()+"\r\n");
            w.write("Gender: "+user.getGender()+"\r\n");
            w.write("Email: "+user.getEmail()+"\r\n");
            w.write("Address: "+user.getAddress()+"\r\n");
            w.write("Aadhar number: "+user.getAadhar()+"\r\n");
            w.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        }
        public int returnid(String aadhar){
            int id;
            try{
                String Query = "select id from customer where name = '"+aadhar+"' ";
                ResultSet rs = Select.getData(Query);
                while(rs.next()){
                    id = rs.getInt(0);
                     System.out.println(id);
                    return id;
                   
                }
            }
            catch(Exception e){
                
            }
            return 1;
        }
}
