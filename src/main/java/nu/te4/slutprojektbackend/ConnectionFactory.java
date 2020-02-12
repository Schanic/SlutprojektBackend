/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend;

import java.sql.DriverManager;

/**
 *
 * @author fredr
 */
public class ConnectionFactory {
    public static Connection getConnection(){
        String user ="";
        String password="";
        String url ="jdbc:mysql://localhost/slutprojekt";
        return (Connection) DriverManager.getConnection(user,password,url);
                
    }
}
