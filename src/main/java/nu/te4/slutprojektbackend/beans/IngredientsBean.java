/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.ejb.Stateless;
import nu.te4.slutprojektbackend.ConnectionFactory;
import nu.te4.slutprojektbackend.entities.Ingredients;
import nu.te4.slutprojektbackend.entities.Recipe;

/**
 *
 * @author Johan
 */
@Stateless
public class IngredientsBean {

    public int saveI(Recipe recipe) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO recipe_ingredients VALUES (?,?,?,?)");
            preparedstatement.setInt(1, recipe.getId());
            preparedstatement.setInt(2, recipe.getIngredients().get(0).getId());
            preparedstatement.setInt(3, recipe.getIngredients().get(0).getAmount());
            preparedstatement.setString(4, recipe.getIngredients().get(0).getUnit());
            
        } catch (Exception e) {
            
            
        }

    }

}
