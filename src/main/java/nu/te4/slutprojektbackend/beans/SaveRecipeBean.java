/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.ejb.Stateless;
import nu.te4.slutprojektbackend.ConnectionFactory;
//import nu.te4.slutprojektbackend.entities.Rec_Ing;
import nu.te4.slutprojektbackend.entities.Recipe;

/**
 *
 * @author Johan
 */
@Stateless
public class SaveRecipeBean {

    public int saveRecipe(Recipe recipe) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO recipe (id,name,user_id,recipe_descrip)VALUES (NULL,?,?,?)");
            
            preparedstatement.setString(1, recipe.getName());
            preparedstatement.setInt(2, recipe.getUser_id());
            preparedstatement.setString(3, recipe.getRecipe_descrip());
            preparedstatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println("Error: RecipeSave" + e.getMessage());
            return 0;
        }
    }

    public int saveIng(Recipe recipe) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO recipe_ingredients VALUES (?,?)");
            preparedstatement.setInt(1, recipe.getIngredient().get(0).getId());
            preparedstatement.setString(1, recipe.getIngredient().get(0).getName());
            preparedstatement.executeUpdate();
            return 1;

        } catch (Exception e) {
            System.out.println("Error: SaveIng" + e.getMessage());
            return 0;
        }

    }
    
    public int saveIngRec(Recipe recipe) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO recipe_ingredients (recipe_id,ingredients_id,unit,amount)VALUES (?,?,?,?)");
            preparedstatement.setInt(1, recipe.getId());
            preparedstatement.setInt(2, recipe.getIngredient().get(0).getId());
            preparedstatement.setString(3, recipe.getIngredient().get(0).getUnit());
            preparedstatement.setInt(4, recipe.getIngredient().get(0).getAmount());
            preparedstatement.executeUpdate();
            return 1;

        } catch (Exception e) {
            System.out.println("Error: SaveIngRec" + e.getMessage());
            return 0;
        }

    }
    

    public int saveTags(Recipe recipe) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO tags VALUES (NULL,?)");
            //preparedstatement.setInt(1, recipe.getTags().get(0).getId());
            preparedstatement.setString(1, recipe.getTags().get(0).getName());
            preparedstatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println("Error: SaveTags" + e.getMessage());
            return 0;
        }
    }
    public int saveTagsRec(Recipe recipe) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO recipe_tags VALUES (?,?)");
            preparedstatement.setInt(1, recipe.getId());
            preparedstatement.setInt(2, recipe.getTags().get(0).getId());
            preparedstatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println("Error: SaveTagsRec" + e.getMessage());
            return 0;
        }
    }

    public int saveInstructions(Recipe recipe) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO instructions_steps VALUES (NULL,?,?,?)");
            preparedstatement.setString(1, recipe.getInstructions().get(0).getDescription());
            preparedstatement.setInt(2, recipe.getInstructions().get(0).getStepNumber());
            preparedstatement.setInt(3, recipe.getId());
            preparedstatement.executeUpdate();
            return 1;

        } catch (Exception e) {
            System.out.println("Error: saveInstructions" + e.getMessage());
            return 0;
        }

    }

}
