package stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chagd
 */
public class MyConnection {
    public static Connection con=null;
    public static Connection getMyConnection(){
        if(con==null){
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                try {
                    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","Pinacle19");
                    System.out.println("connecter avec succes");
                } catch (SQLException ex) {
                    Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return con;
    }
    
}
