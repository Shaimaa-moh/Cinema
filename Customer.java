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
import static movieticket.NewJFrame.idtxt;
import static movieticket.NewJFrame.jComboBox2;
//import static movieticket.NewJFrame.jTextField1;

import static movieticket.NewJFrame.titletxt;


public class Customer extends user{
  
    public Customer()
            
    {
    
    }
    public void rate_movie()
            
    {
          String id=idtxt.getText();
              
        String title=titletxt.getText();
        
        String rate =(String)jComboBox2.getSelectedItem();
             
        
        try {
            
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("insert into highrate values (?,?,?)");
            ps.setString(1,id);
            ps.setString(2,title);
            
                ps.setString(3, rate);
             
               
             ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "successfully saved");
            new NewJFrame().setVisible(false);
            new NewJFrame().setVisible(true);

        }
        catch(HeadlessException | SQLException e )
        {
            JOptionPane.showMessageDialog(null, e);

        }
        
    }
    
    /*    public void rate_movie()
    {
        
       String id=idtxt.getText();
              
        String title=titletxt.getText();
        
        String rate = jTextField10.getText();
        int a = Integer.valueOf(rate);
        a = (a*3)/10;
         b = String.valueOf(a);

        
        
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("update highrate set rate = ?, where id='" + id + "'");
            ps.setString(1, b);
            JOptionPane.showMessageDialog(null, "film successfully updated");
            
            new deleteAndUpdate().setVisible(false);
            new deleteAndUpdate().setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        
    }
   */
    
}
     
   
    
