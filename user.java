/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

import images.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static movieticket.ListOfMovies.jTable5;

/**
 *
 * @author HP
 */
public class user {
   

    public user() {
    }
   

    public void select_movie(){
    DefaultTableModel model;
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
    
}
}
