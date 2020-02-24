/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.beans;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import javax.ejb.Stateless;
import nu.te4.slutprojektbackend.ConnectionFactory;
import nu.te4.slutprojektbackend.entities.Recipe;

/**
 *
 * @author Johan
 */
@Stateless
public class RecipeBeans {
    public int saveRecipe(Recipe recipe){
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO recipe VALUES (NULL,?,?,?)");
            preparedstatement.setString(1, recipe.getName());
            preparedstatement.setString(2, recipe.getRecipe_descrip());
            // Kanske måste skicka med User_id(Borde vara så)
           return preparedstatement.executeUpdate(); 
        } catch (Exception e) {
           System.out.println("Error from Credentialsbean: " + e.getMessage());
           return 0;
        }
    }
}
