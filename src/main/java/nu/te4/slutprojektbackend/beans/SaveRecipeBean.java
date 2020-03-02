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
public class SaveRecipeBean {

    public int saveRecipe(Recipe recipe) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO recipe VALUES (?,?,?,?)");
            preparedstatement.setInt(1, recipe.getId());
            preparedstatement.setInt(2, recipe.getUser_id());
            preparedstatement.setString(1, recipe.getName());
            preparedstatement.setString(1, recipe.getRecipe_descrip());
            preparedstatement.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int saveIngRec(Recipe recipe) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO recipe_ingredients VALUES (?,?,?,?)");
            preparedstatement.setInt(1, recipe.getId());
            preparedstatement.setInt(2, recipe.getIngredients().get(0).getId());
            preparedstatement.setInt(3, recipe.getIngredients().get(0).getAmount());
            preparedstatement.setString(4, recipe.getIngredients().get(0).getUnit());
            preparedstatement.executeQuery();
            return 1;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }

    }

    public int saveTags(Recipe recipe) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO recipe_tags VALUES (?,?)");
            preparedstatement.setInt(1, recipe.getId());
            preparedstatement.setInt(2, recipe.getTags().get(0).getId());
            preparedstatement.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public int saveInstructions(Recipe recipe) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO instructions_steps VALUES (?,?,?,?)");
            preparedstatement.setInt(1, recipe.getInstructions().get(0).getId());
            preparedstatement.setString(2, recipe.getInstructions().get(0).getDescription());
            preparedstatement.setInt(3, recipe.getInstructions().get(0).getStepNumber());
            preparedstatement.setInt(1, recipe.getId());
            preparedstatement.executeQuery();
            return 1;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }

    }

}
