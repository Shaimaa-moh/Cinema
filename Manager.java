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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static movieticket.AddNewFilm.Durationtxt;
import static movieticket.AddNewFilm.Herostxt;
import static movieticket.AddNewFilm.Titletxt;
import static movieticket.AddNewFilm.Typetxt;
import static movieticket.AddNewFilm.idtxt;
import static movieticket.AddNewFilm.jComboBox1;
import static movieticket.AddNewFilm.jComboBox2;
import static movieticket.deleteAndUpdate.jTextField1;
import static movieticket.deleteAndUpdate.jTextField2;
import static movieticket.deleteAndUpdate.jTextField3;
import static movieticket.deleteAndUpdate.jTextField4;
import static movieticket.deleteAndUpdate.jTextField5;
import static movieticket.deleteAndUpdate.jTextField6;
import static movieticket.deleteAndUpdate.jTextField7;
import static movieticket.login.jPasswordField1;
import static movieticket.login.textField1;




/**
 *
 * @author HP
 */
public class Manager extends user {

      private String username;
    private String password;

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
   
    
    

   
    public Manager() {
        //To change body of generated methods, choose Tools | Templates.
    }
  public static void  login()
  {
     
   if (textField1.getText().equals("manager") &&jPasswordField1.getText().equals("admin") )
        { 
            new login().setVisible(false);
            new goHome().setVisible(true);
        }
        else  
                login.label2.setVisible(true);
  
  
  }
  public static void add_movie()
  {
      
  
       String id=idtxt.getText();
        String title= Titletxt.getText();
        String type=Typetxt.getText();
        String duration=Durationtxt.getText();
        String heros=Herostxt.getText();
        String day=(String)jComboBox1.getSelectedItem();
        String time=(String)jComboBox2.getSelectedItem();
        try {
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("insert into film values (?,?,?,?,?,?,?)");
            ps.setString(1,id);
            ps.setString(2,title);
            ps.setString(3, type);
            ps.setString(4,duration);
            ps.setString(5, heros);
            ps.setString(6, day);
            ps.setString(7, time);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "successfully saved");
          new AddNewFilm().setVisible(false);
            new AddNewFilm().setVisible(true);

        }
        catch(HeadlessException | SQLException e )
        {
            JOptionPane.showMessageDialog(null, e);

        }
  }
public static void update_movie()
{
  
   
        String id = jTextField1.getText();
        String title = jTextField2.getText();
        String type = jTextField3.getText();
        String duration = jTextField4.getText();
        String heros = jTextField5.getText();
        String day=jTextField6.getText();
        String time=jTextField7.getText();
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("update film set id=?,title=?,type=?,duration=?,heros=?,day=?,time=?where id='" + id + "'");
            ps.setString(1, id);
            ps.setString(2, title);
            
            ps.setString(3, type);
            ps.setString(4, duration);
            ps.setString(5, heros);
            ps.setString(6,day );
            ps.setString(7,time);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "film successfully updated");
            
            new deleteAndUpdate().setVisible(false);
            new deleteAndUpdate().setVisible(true);

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
}
public static void delete_movie()
{
    
       int a = JOptionPane.showConfirmDialog(null, "do you really want to delete ?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            String id = jTextField1.getText();
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                st.executeUpdate("delete from film where id ='" + id + "'");
                JOptionPane.showMessageDialog(null, "film is successfully deleted");
                 new deleteAndUpdate().setVisible(false);
                new deleteAndUpdate().setVisible(true);
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
}
public static void search_movie()
{
       int checkid = 0;
        String id = jTextField1.getText();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from film where id='" + id + "'");
            while (rs.next()) {
                checkid = 1;
                jTextField1.setEditable(false);
                jTextField2.setText(rs.getString(2));
                jTextField3.setText(rs.getString(3));
                jTextField4.setText(rs.getString(4));
                jTextField5.setText(rs.getString(5));

                jTextField6.setText(rs.getString(6));

                jTextField7.setText(rs.getString(7));
            }
            if (checkid == 0) {
                JOptionPane.showMessageDialog(null, "film id doesn't exist");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
  }
    
