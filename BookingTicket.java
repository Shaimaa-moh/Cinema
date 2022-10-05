/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movieticket;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static movieticket.ticket_booking.jCheckBox1;
import static movieticket.ticket_booking.jCheckBox2;
import static movieticket.ticket_booking.jCheckBox3;
import static movieticket.ticket_booking.jCheckBox4;
import static movieticket.ticket_booking.jComboBox1;
import static movieticket.ticket_booking.jComboBox2;
import static movieticket.ticket_booking.jComboBox3;
import static movieticket.ticket_booking.jComboBox4;
import static movieticket.ticket_booking.jComboBox5;
import static movieticket.ticket_booking.jComboBox6;
import static movieticket.ticket_booking.jComboBox7;
import static movieticket.ticket_booking.jComboBox8;
import static movieticket.ticket_booking.jTable1;
import static movieticket.ticket_booking.jTextField1;
import static movieticket.ticket_booking.jTextField4;
/**
 *
 * @author HP
 */
public class BookingTicket {
  float Totalprice;
String MovieTime;
Date Date;
int room;
int NumberOfTickets;
String TicketType;
int MovieTicket[];

    public void setTotalprice(float Totalprice) {
        this.Totalprice = Totalprice;
    }

    public void setMovieTime(String MovieTime) {
        this.MovieTime = MovieTime;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setNumberOfTickets(int NumberOfTickets) {
        this.NumberOfTickets = NumberOfTickets;
    }

    public void setTicketType(String TicketType) {
        this.TicketType = TicketType;
    }

    public void setMovieTicket(int[] MovieTicket) {
        this.MovieTicket = MovieTicket;
    }

    public float getTotalprice() {
        return Totalprice;
    }

    public String getMovieTime() {
        return MovieTime;
    }

    public Date getDate() {
        return Date;
    }

    public int getRoom() {
        return room;
    }

    public int getNumberOfTickets() {
        return NumberOfTickets;
    }

    public String getTicketType() {
        return TicketType;
    }

    public int[] getMovieTicket() {
        return MovieTicket;
    }
public void book ()
{
     int sum =0;
       int price;
       String row;
       String seat;
       
       
         DefaultTableModel model = new DefaultTableModel();
       if (jCheckBox1.isSelected())
       {
           String regular = jCheckBox1.getText();
           price =100;
           seat =jComboBox2.getSelectedItem().toString();
           row =jComboBox1.getSelectedItem().toString();
           model = (DefaultTableModel)jTable1.getModel();
           model.addRow(new Object[]{
                 regular,
                 row,
                 seat,
                 price,
                  
           });
       }
       else if (jCheckBox2.isSelected())
       {
           String silver = jCheckBox2.getText();
           price =150;
           seat =jComboBox4.getSelectedItem().toString();
           row =jComboBox3.getSelectedItem().toString();
           model = (DefaultTableModel)jTable1.getModel();
           model.addRow(new Object[]{
                 silver,
                 row,
                 seat,
                 price,
                  
           });
       }
       else  if (jCheckBox3.isSelected())
       {
           String gold = jCheckBox3.getText();
           price =200;
           seat =jComboBox6.getSelectedItem().toString();
           row =jComboBox5.getSelectedItem().toString();
           model = (DefaultTableModel)jTable1.getModel();
           model.addRow(new Object[]{
                 gold,
                 row,
                 seat,
                 price,
                  
           });
       }
        else  if (jCheckBox4.isSelected())
       {
           String vip = jCheckBox4.getText();
           price =300;
           seat =jComboBox8.getSelectedItem().toString();
           row =jComboBox7.getSelectedItem().toString();
           model = (DefaultTableModel)jTable1.getModel();
           model.addRow(new Object[]{
                 vip,
                 row,
                 seat,
                 price,
                  
           });
       }
          for(int i=0;i<jTable1.getRowCount();i++)
          {
              sum+=Integer.parseInt(jTable1.getValueAt(i, 3).toString());
          }
          jTextField1.setText(String.valueOf(sum));
          
           String filmid = jTextField4.getText();
        try 
        {
            Connection c2=NewClass1.getCon();
            PreparedStatement s1=c2.prepareStatement(" insert into film7 values(?,?,?,?,?,?)");
            
            int rows = jTable1.getRowCount();
            String tickettype="";
            String row1;
            String seat1;
            int price1;
            int total=0;
            
            for(int i=0;i<jTable1.getRowCount();i++)
            {
                tickettype = (String)jTable1.getValueAt(i, 0);
                row1=(String)jTable1.getValueAt(i, 1);
                seat1 =(String)jTable1.getValueAt(i, 2);
                price1=(int)jTable1.getValueAt(i, 3);
            s1.setString(1, filmid);
            s1.setString(2, tickettype);
            s1.setString(3, row1);
            s1.setString(4, seat1);
            s1.setInt(5, price1);
            s1.setInt(6, total);
            
            JOptionPane.showMessageDialog(null, " check that you book one ticket");
            
            }
        }
                  catch (HeadlessException | SQLException e)
        {
             JOptionPane.showMessageDialog(null, e);
        }
}
  
    public void print_invoice()
    {
        invoice vv = new invoice();
   
   invoice.jTextField1.setText(ticket_booking.jTextField4.getText());
    for(int i=0;i<jTable1.getRowCount();i++)
            {
   invoice.jTextField2.setText( ticket_booking.jTable1.getValueAt(i, 0).toString());
   invoice.jTextField3.setText( ticket_booking.jTable1.getValueAt(i, 1).toString());
   invoice.jTextField4.setText( ticket_booking.jTable1.getValueAt(i, 2).toString());
   invoice.jTextField5.setText( ticket_booking.jTable1.getValueAt(i, 3).toString());
            }
    invoice.jTextField6.setText(ticket_booking.jTextField1.getText());
   vv. setVisible(false);
            vv.setVisible(true);
   // ListOfMovies  ll = new ListOfMovies ();
   /* for(int i=1;i<jTable1.getRowCount();i++)
            {
    vv.jTextField7.setText(ListOfMovies.jTable5.getValueAt(i, 1).toString());
        vv.jTextField8.setText(ListOfMovies.jTable5.getValueAt(i, 2).toString());
            vv.jTextField9.setText(ListOfMovies.jTable5.getValueAt(i, 3).toString());
                vv.jTextField10.setText(ListOfMovies.jTable5.getValueAt(i, 4).toString());
                    vv.jTextField11.setText(ListOfMovies.jTable5.getValueAt(i, 5).toString());
                        vv.jTextField12.setText(ListOfMovies.jTable5.getValueAt(i, 6).toString());
            }*/
  /* DefaultTableModel model;
        model = (DefaultTableModel) jTable5.getModel();
        
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs= st.executeQuery("select *from film");
            while (rs.next())
            {
                model.addRow(new Object []{ rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
              
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
         for(int i=1;i<jTable1.getRowCount();i++)
            {
    vv.jTextField7.setText(ListOfMovies.jTable5.getValueAt(i, 1).toString());
        vv.jTextField8.setText(ListOfMovies.jTable5.getValueAt(i, 2).toString());
            vv.jTextField9.setText(ListOfMovies.jTable5.getValueAt(i, 3).toString());
                vv.jTextField10.setText(ListOfMovies.jTable5.getValueAt(i, 4).toString());
                    vv.jTextField11.setText(ListOfMovies.jTable5.getValueAt(i, 5).toString());
                        vv.jTextField12.setText(ListOfMovies.jTable5.getValueAt(i, 6).toString());
            }
        
    
            vv.setVisible(false);
            vv.setVisible(true); 
    }

   */
    }
}
