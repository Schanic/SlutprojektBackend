/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fredr
 */
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException{
        String user ="";
        String password="";
        String url ="jdbc:mysql://localhost/slutprojekt";
        return (Connection) DriverManager.getConnection(user,password,url);
                
    }
}
