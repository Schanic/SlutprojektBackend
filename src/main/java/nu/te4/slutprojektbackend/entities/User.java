/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.entities;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import nu.te4.slutprojektbackend.ConnectionFactory;

/**
 *
 * @author Johan
 */
public class User {
    private String name;
    private int id_number;

    public User(String name, int id_number) {
        this.name = name;
        this.id_number = id_number;
    }

    User(int user_id) {
        //ställa frågan
        try(Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedstatement = connection.prepareStatement("SELECT users.id WHERE username=?");
            preparedstatement.setString(1, name);

        } catch (Exception e) {
        }
    }

     

    public String getName() {
        return name;
    }

    public int getId_number() {
        return id_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_number(int id_number) {
        this.id_number = id_number;
    }
    
    
    
    
}
