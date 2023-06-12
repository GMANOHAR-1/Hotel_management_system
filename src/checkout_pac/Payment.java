/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package checkout_pac;
import GUI.*;
import database.*;
import Classes.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author thanu
 * 
 */

public class Payment extends javax.swing.JFrame {
    
     /**
     * Creates new form Payment
     */
    
    public Payment() {
        initComponents();
    }
    
    
private int id=1;
private String Query;
private float ad;
private float famount=0;


    public Payment(String rn, float a) {
        initComponents();
        populateWithCustomerData(rn);
        calculateamount(a);
        filldetails(rn);
        A_D_TIME(rn);
        foodamount(rn);
        getroomno(rn);
        finalamount(a);
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
    }
 

    @SuppressWarnings("unchecked")
    String rnumber;
    
    private String getroomno(String roomNo){
         rnumber = roomNo;
        return rnumber;
    }
    
    private void A_D_TIME(String roomNo){
        ResultSet rs =Select.getData("select * from customer where roomNo= '"+roomNo+"'");
        DefaultTableModel model= (DefaultTableModel)A_D_Time.getModel();
        try{
            while(rs.next()){
                model.addRow(new Object[] {rs.getString(9),checkout.checkoutdate()});        
            }
            rs.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymenttable = new javax.swing.JTable();
        printbill = new javax.swing.JButton();
        Totalpayment = new javax.swing.JLabel();
        tamount = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Roomtable = new javax.swing.JTable();
        exit = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        taxtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        A_D_Time = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel3.setText("INVOICE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 130, 30));

        jScrollPane1.setForeground(new java.awt.Color(255, 102, 102));

        paymenttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Rate", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        paymenttable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(paymenttable);
        if (paymenttable.getColumnModel().getColumnCount() > 0) {
            paymenttable.getColumnModel().getColumn(0).setResizable(false);
            paymenttable.getColumnModel().getColumn(1).setResizable(false);
            paymenttable.getColumnModel().getColumn(2).setResizable(false);
            paymenttable.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 520, 140));

        printbill.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        printbill.setText("PRINT BILL");
        printbill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbillActionPerformed(evt);
            }
        });
        getContentPane().add(printbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 504, -1, 30));
        getContentPane().add(Totalpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 47, -1));

        tamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamountActionPerformed(evt);
            }
        });
        getContentPane().add(tamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 460, 71, -1));

        Roomtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room_Number", "Room_Type", "Bed"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Roomtable);
        if (Roomtable.getColumnModel().getColumnCount() > 0) {
            Roomtable.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 270, 50));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 40, 30));

        jScrollPane4.setForeground(new java.awt.Color(255, 102, 102));

        taxtable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taxtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(taxtable);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 260, 80));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel1.setText("BALANCE DUE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 460, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 190, 30));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 190, 30));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 190, 30));

        jScrollPane3.setForeground(new java.awt.Color(255, 102, 102));

        A_D_Time.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        A_D_Time.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ARRIVAL", "DEPARTURE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(A_D_Time);
        if (A_D_Time.getColumnModel().getColumnCount() > 0) {
            A_D_Time.getColumnModel().getColumn(0).setResizable(false);
            A_D_Time.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 280, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IMBAC.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1160, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void filldetails(String roomNo){
        try{
            
           ResultSet rs = Select.getData("select * from customer where roomNo= '"+roomNo+"' ");
           if(rs.next()){
               jTextField1.setText(rs.getString(2));
               jTextField2.setText(rs.getString(8));
               jTextField3.setText(rs.getString(3));
           }   
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     private void populateWithCustomerData(String roomNo)
    {
        ResultSet rs =Select.getData("select * from customer where roomNo= '"+roomNo+"'");
        DefaultTableModel model= (DefaultTableModel)Roomtable.getModel();
        try{
            while(rs.next()){
                ad =Float.parseFloat(rs.getString(14));
                model.addRow(new Object[] {rs.getString(10),rs.getString(12),rs.getString(11)});                
            }
            rs.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
     
     
     
     private void foodamount(String roomNo){
        ResultSet rs =Select.getData("select * from foodbooking where RoomNo= '"+roomNo+"'");
        DefaultTableModel model= (DefaultTableModel)paymenttable.getModel();
        try{
            while(rs.next()){
                float price = Float.parseFloat(rs.getString(4));
                float qty = Float.parseFloat(rs.getString(5));
                float amount = price*qty;
                famount+=amount;
                model.addRow(new Object[] {rs.getString(3),rs.getString(4),rs.getString(5),amount}); 
                
            }
            rs.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
         
     }
     
     
     private void calculateamount(float a)
    {
        DefaultTableModel model1= (DefaultTableModel)paymenttable.getModel();
        try{
            model1.addRow(new Object[] {"RoomFare",a,1,a});
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
     
    private void finalamount(float a)
    {
        float fa= famount+a;
        float ta = fa+((fa*5)/100);
        float topay = ta-ad;
        tamount.setText(Float.toString(topay)); 
        DefaultTableModel model1= (DefaultTableModel)taxtable.getModel();
        try{
            model1.addRow(new Object[] {"SUB TOTAL",fa});
            model1.addRow(new Object[] {"CGST (2.5%)",((fa*2.5)/100)});
            model1.addRow(new Object[] {"SGST (2.5%)",((fa*2.5)/100)});
            model1.addRow(new Object[] {"FINAL TOTAL",ta});
            
        }
        catch(Exception e){
            System.out.println(e);
        }
             
    }
       
    
    private void printbillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbillActionPerformed
        payment p = new payment();
        p.printbill(rnumber);
    }//GEN-LAST:event_printbillActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new home().setVisible(true);
    }//GEN-LAST:event_exitActionPerformed

    private void tamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamountActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable A_D_Time;
    private javax.swing.JTable Roomtable;
    private javax.swing.JLabel Totalpayment;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable paymenttable;
    private javax.swing.JButton printbill;
    private javax.swing.JTextField tamount;
    private javax.swing.JTable taxtable;
    // End of variables declaration//GEN-END:variables
}
