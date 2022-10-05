/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

/**
 *
 * @author lenovo
 */
 public class CurrentPassword {
   static String CurrentPassword;

     /*public CurrentPassword(String CurrentPassword) {
        this.CurrentPassword = CurrentPassword;
    } */      

    public static String getCurrentPassword() {
        return CurrentPassword;
    }

    public static void setCurrentPassword(String c) {
        CurrentPassword = c;
    }
    
     public CurrentPassword() {
    }       

}
