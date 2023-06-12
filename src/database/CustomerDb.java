/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author heman
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Classes.*;

public class CustomerDb {
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;
    
    public CustomerDb()
    {
        conn = Connectiondb.getCon();
    }
      public void insertCustomer(CustomerInfo user) {
        try {
            if (user.getName().equals("") || user.getMobileNumber().equals("") || user.getNationality().equals("")
                    || user.getGender().equals("")|| user.getEmail().equals("")
                        || user.getAddress().equals("") || user.getAadhar().equals("")) {
              JOptionPane.showMessageDialog(null, "Every Field is necessary");
            }
              else{
                     String insertQuery = "insert into customer(id, name,gender,nationality,mobileNumber,email,address,aadhar) values('"+ user.getId()
                    + "','"+ user.getName()+ "','" + user.getGender() + "','" + user.getNationality() + "','" + user.getMobileNumber() + "','" + user.getEmail() + "','" + user.getAddress() + "','" + user.getAadhar() + "')";
         
            statement = conn.prepareStatement(insertQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully inserted new Customer"); 
                      }
              
            
        }
         catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "InsertQuery Failed");
        }
        finally
        {
            flushStatementOnly();
        }
        
        
    }
    
      public void insertLog(CustomerInfo user) {
          String Query1 = "select max(id) from customer";
          
        try {
            ResultSet rs = Select.getData(Query1);
            while (rs.next()) {
                if (user.getName().equals("") || user.getMobileNumber().equals("")
                    || user.getEmail().equals("")) {
              JOptionPane.showMessageDialog(null, "Every Field is necessary");
            }
              else{
                     String insertQ = "insert into logbook(id,name,mobileNumber,email) values('"+ user.getId()+ "','"+ user.getName()+ "','" + user.getMobileNumber() + "','" + user.getEmail() + "')";

            statement = conn.prepareStatement(insertQ);

            statement.execute();

            //JOptionPane.showMessageDialog(null, ""); 
                      }
            }
        }
         catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "InsertQuery Failed");
        }
        finally
        {
            flushStatementOnly();
        }
    }
      
      
    public void updateCustomer(CustomerInfo user) {
        try {
            String updateQuery = "update customer set "
                    + "name = '" + user.getName() + "',"
                    + "address = '" + user.getAddress() + "',"
                    + "mobileNumber = '" + user.getMobileNumber() + "',"
                    + "email = '" + user.getEmail() + "',"
                    + "gender = '" + user.getGender() + "',"
                    + "nationality = '" + user.getNationality() + "',"
                    + "aadhar = '" + user.getAadhar() + "' where id= "+ user.getId()+"";

            statement = conn.prepareStatement(updateQuery);
   System.out.println(updateQuery);
            statement.execute();

            JOptionPane.showMessageDialog(null, "successfully updated new Customer");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }
        
        finally
        {
            flushStatementOnly();
        }

    }

    
    public void updatelog(CustomerInfo user) {
        try {
            String updateQuery = "update logbook set "
                    + "name = '" + user.getName() + "',"
                     + "mobileNumber = '" + user.getMobileNumber() + "',"
                    + "email = '" + user.getEmail() + "' where id = "+ user.getId()+"";
                    
                   
         

            statement = conn.prepareStatement(updateQuery);

            statement.execute();

           // JOptionPane.showMessageDialog(null, "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }
        
        finally
        {
            flushStatementOnly();
        }

    }
    
    public void deleteCustomer(String userId) throws SQLException {
        try {
            String deleteQuery = "delete from customer where id= " + userId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Deleted user");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Delete query Failed");
        }
        finally
        {
            flushStatementOnly();
        }

    }
    public void deletelog(String userId) throws SQLException {
        try {
            String deleteQuery = "delete from logbook where id= " + userId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Deleted user");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Delete query Failed");
        }
        finally
        {
            flushStatementOnly();
        }

    }

    public ResultSet getAllCustomer() {
        try {
            String query = "select * from customer";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all customer DB Operation");
        }
        

        return result;
    }
     private void flushStatementOnly()
    {
        {
                        try
                        {
                            statement.close();
                            //conn.close();
                        }
                        catch(SQLException ex)
                        {System.err.print(ex.toString()+" >> CLOSING DB");}
                    }
    }
     public void flushAll()
    {
        {
                        try
                        {
                            statement.close();
                            result.close();
                        }
                        catch(SQLException ex)
                        {System.err.print(ex.toString()+" >> CLOSING DB");}
                    }
    }

     
     
    
    
}
