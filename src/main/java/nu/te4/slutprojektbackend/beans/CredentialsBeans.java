/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.beans;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import javax.ejb.Stateless;
import nu.te4.slutprojektbackend.ConnectionFactory;
import nu.te4.slutprojektbackend.entities.Credentials;

/**
 *
 * @author fredr
 */
@Stateless
public class CredentialsBeans {
    public Credentials createCredentials(String basic){
        basic = basic.substring(6).trim();
        byte[] Byte = Base64.getDecoder().decode(basic);
        basic = new String(Byte);
        int colonPos = basic.indexOf(":");
        String username = basic.substring(0,colonPos);
        String password = basic.substring(colonPos + 1);
        return new Credentials(username, password);
    }
    
    public boolean checkCredentials(Credentials credentials){
        
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement prepStatement = connection.prepareStatement("SELECT * FROM users WHERE username=?");
            prepStatement.setString(1, credentials.getUsername());
            ResultSet data = prepStatement.executeQuery();
            if(data.next()){
                String password = data.getString("password");
                BCrypt.Result result = BCrypt.verifyer().verify(credentials.getPassword().toCharArray(), password);
                return result.verified;
            }
        } catch (Exception e) {
            System.out.println("Error from " + e.getMessage());
        }
        return false;
    }
    public int saveCredentials(Credentials credentials) throws Exception{
        try (Connection connection = ConnectionFactory.getConnection()){
            String password = BCrypt.withDefaults().hashToString(12, credentials.getPassword().toCharArray());  
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO users VALUES (NULL,?,?)");
            preparedstatement.setString(1, credentials.getUsername());
            preparedstatement.setString(2, password);
           return preparedstatement.executeUpdate(); 
        } catch (Exception e) {
           System.out.println("Error from Credentialsbean: " + e.getMessage());
           return 0;
        }
       
    }
}
