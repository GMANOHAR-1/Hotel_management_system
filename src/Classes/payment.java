/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import checkout_pac.Payment;
import checkout_pac.CustomerCheckOut;
import Customer_pac.*;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import database.*;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author thanu
 */
public class payment extends CustomerCheckOut{
    
    String roomNo;
    String Query;
    int id=1;
    float tfamount;
    public void printbill(String rnumber){
        try{
            ResultSet rs = Select.getData("select * from customer where roomNo= '"+rnumber+"'");
            if(rs.next()){
            int ide = Integer.parseInt(rs.getString(1));
            
            String name= rs.getString(2);
            String Address =rs.getString(8);
            String phoneno = rs.getString(3);
            String email =rs.getString(6);
            String bed =rs.getString(11);
            String roomtype =rs.getString(12);
            String ppd = rs.getString(13);
            
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            String dateBeforeString = rs.getString(9);
            String dateAfterString = myFormat.format(cal.getTime());
           
            checkout cout1= new checkout();
            cout1.setDateBefore(myFormat.parse(rs.getString(9)));
            cout1.setDateAfter(cal.getTime());
            int nds = cout1.noofDays();
            

            float price = Float.parseFloat(rs.getString(13));
            float Tamount =nds*price;
//            Query = "update customer set numberOfDaysStay='"+nds+"',totalamount='"+Tamount+"',checkOut='"+dateAfterString+"' where roomNo='"+rnumber+"'";
//            InsertUpdateDelete.setData(Query, "");
            Query = "update room set flag='not booked' where roomNo='"+rnumber+"'";
           InsertUpdateDelete.setData(Query, "");
           Query = "delete from foodbooking where RoomNo='"+rnumber+"'";
           InsertUpdateDelete.setData(Query, "");
           Query = "delete from customer where id='"+ide+"'";
           InsertUpdateDelete.setData(Query, "");
             String path="C:\\Users\\G Bharti\\Documents\\image_hoteel\\HotelManagement_1\\HotelManagement_1\\src\\csv\\";
            com.itextpdf.text.Document doc= new com.itextpdf.text.Document();
            try{
                PdfWriter.getInstance(doc, new FileOutputStream(path+""+id+".pdf"));
                doc.open();
                Paragraph paragraph0 = new Paragraph("                                                            HOTEL MANAGEMENT SYSTEM");
                doc.add(paragraph0);
                Paragraph paragraph1 = new Paragraph("                                                                      STAY INN");
                doc.add(paragraph1); 
                Paragraph stars = new Paragraph("****************************************************************************************************************");
                doc.add(stars);
                Paragraph paragraph2 = new Paragraph("\tBill ID:"+id+"\nCustomer Details:\nName: "+name+"\nAddress: "+Address+"\nMobile Number: "+phoneno+"\nEmail: "+email+"\n ");
                doc.add(paragraph2);
                doc.add(stars);
                Paragraph paragraph3 = new Paragraph("\tRoom Details:\nRoomNumber: "+rnumber+"\nRoomType: "+roomtype+"\nBed: "+bed+"\nPriceperday: "+ppd+"\n ");
                doc.add(paragraph3);
                PdfPTable tb2 = new PdfPTable(3);
//
                tb2.addCell("Check In Date:" +dateAfterString);
                tb2.addCell("Check Out Date:" +dateBeforeString);
                tb2.addCell("No of Days Stay:" +nds);
                doc.add(tb2);
                
                doc.add(stars);
                
                Paragraph paragraph4 = new Paragraph("GUEST BILL ");
                doc.add(paragraph4);
                Paragraph paragraph5 = new Paragraph(" ");
                doc.add(paragraph5);
                int no0fcolumns =4;
                PdfPTable tb1 = new PdfPTable(no0fcolumns);
//            
                tb1.addCell("Particulars");
                tb1.addCell("Rate");
                tb1.addCell("Quantity");
                tb1.addCell("Price");
                tb1.addCell("RoomFare");
                tb1.addCell(String.valueOf(Tamount));
                tb1.addCell("1");
                tb1.addCell(String.valueOf(Tamount));
                ResultSet rs1 =Select.getData("select * from foodbooking where RoomNo= '"+rnumber+"'");
                while(rs1.next()){
                    tb1.addCell(rs1.getString(3));
                    int foodrate =Integer.valueOf((rs1.getString(4)));
                    int fqty= Integer.valueOf((rs1.getString(5)));
                    float foodprice =foodrate*fqty;
                    tfamount +=foodprice;
                    tb1.addCell(rs1.getString(4));
                    tb1.addCell(rs1.getString(5));
                    tb1.addCell(String.valueOf(foodprice));
                }
                float fa = tfamount+Tamount;
                float ta = fa+((fa*5)/100);
                tb1.addCell(" ");
                tb1.addCell(" ");
                tb1.addCell("SUBTOTAL");
                tb1.addCell(String.valueOf(fa));
                tb1.addCell(" ");
                tb1.addCell(" ");
                tb1.addCell("CGST(2.5%)");
                tb1.addCell(String.valueOf((fa*2.5)/100)); 
                tb1.addCell(" ");
                tb1.addCell(" ");
                tb1.addCell("SGST(2.5%)");
                tb1.addCell(String.valueOf((fa*2.5)/100)); 
                tb1.addCell(" ");
                tb1.addCell(" ");
                tb1.addCell("FINAL TOTAL");
                tb1.addCell(String.valueOf(ta));
                doc.add(tb1);
                doc.add(paragraph5);
                doc.add(stars);
                Paragraph paragraph6 = new Paragraph("                                                            THANK YOU VISIT AGAIN");
                doc.add(paragraph6);
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);    
            }
            doc.close();  
            int a=JOptionPane.showConfirmDialog(null,"Do you want to PRINT BILL","Select",JOptionPane.YES_NO_OPTION);   
        if(a==0){
            try{
                if((new File("C:\\Users\\G Bharti\\Documents\\image_hoteel\\HotelManagement_1\\HotelManagement_1\\src\\csv\\"+id+".pdf")).exists()){
                    Process p =Runtime
                            .getRuntime()
                            .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\heman\\OneDrive\\Desktop\\OOP Project\\HotelManagement\\src\\csv\\"+id+".pdf ");
                }
                else
                    System.out.println("File is not found");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        setVisible(false);
        new Payment().setVisible(true);
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

}
