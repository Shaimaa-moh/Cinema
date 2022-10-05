/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;
import java.sql.*;


/**
 *
 * @author Hp
 */
public class NewClass1 {
     public static Connection getCon(){
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/list","root","123456789");
            return con;
    }
        catch(ClassNotFoundException | SQLException e )
        {
            return null;
        }
        
        }
    
}
