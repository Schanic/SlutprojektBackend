/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.ejb.EJB;
import nu.te4.slutprojektbackend.beans.PropertiesBean;

/**
 *
 * @author fredr
 */
public class ConnectionFactory {
    @EJB 
    PropertiesBean propbean;
    public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream is = classLoader.getResourceAsStream("newproperties.properties");
            // Skap properties
            Properties properties = new Properties();
            properties.load(is);
            String sting = is.toString();
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection) DriverManager.getConnection(sting);
                
    }
}
