/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

import images.ConnectionProvider;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static movieticket.PaymentMethods.jTextField5;
import static movieticket.ticket_booking.jLabel4;
import static movieticket.ticket_booking.jTextField1;
import static movieticket.ticket_booking.jTextField2;
import static movieticket.PaymentMethods.jTextField3;

/**
 *
 * @author HP
 */
public class payment {
    int id;
    private String password;
    private String exp_date;
    private int serial_no;
    private float amount;
    private int payment_method;
  public void payCash()
  {
       String paymentid = jLabel4.getText();
        String subtotal=jTextField1.getText();
        String pay=jTextField2.getText();
        
        

        int balance = Integer.parseInt(jTextField1.getText()) - Integer.parseInt(jTextField2.getText());
   
       
        try
        {
            Connection c1=NewClass1.getCon();
            PreparedStatement s1=c1.prepareStatement(" insert into payment7 values(?,?,?,?)");
            s1.setString(1,paymentid );
            s1.setString(2, subtotal);
            s1.setString(3, pay);
            s1.setInt(4, balance);
            s1.executeUpdate();
            JOptionPane.showMessageDialog(null, "succesufully saved");
            /*setVisible(false);
            new ticket_booking().setVisible(true);*/
                    
        }
        catch(HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
         
      
      
  }
  public void payVisa()
  {
      
      String id=jTextField5.getText();
          
          String amount=jTextField3.getText();
                  
                  try {
                      Connection conn=ConnectionProvider.getCon();
                      PreparedStatement ps =conn.prepareStatement("insert into pay values(?,?)");
                      ps.setString(1, id);
                      
                        ps.setString(2, amount);
                          ps.executeUpdate();
                       
                      JOptionPane.showMessageDialog(null,"Successfully confirmed");
                      new PaymentMethods().setVisible(true);
                        
                        
                        
                  }
                  catch(HeadlessException | SQLException e){
                       JOptionPane.showMessageDialog(null,e);
                  } 
                       
  }
}
