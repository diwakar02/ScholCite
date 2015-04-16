/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diwakarsharma
 */

//imports
import javax.swing.*;
import java.sql.*;

public class javaconnect {
    
    Connection conn=null;
    public static Connection ConnecrDb(){
        
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:sqlite://Users//bhartisharma//NetBeansProjects//Scholar.sqlite");
            return conn;
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
    
}
