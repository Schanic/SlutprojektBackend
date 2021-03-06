/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.beans;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import nu.te4.slutprojektbackend.ConnectionFactory;
import nu.te4.slutprojektbackend.entities.Recipe;

/**
 *
 * @author Johan
 */
@Stateless
public class RecipeBeans {

    @Inject
    SaveRecipeBean ingredientsBean;

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("SELECT recipe.*, users.username FROM recipe LEFT JOIN users ON recipe.user_id = users.id");
            ResultSet data = preparedstatement.executeQuery();
            while (data.next()) {
                int id = data.getInt("id");
                String title = data.getString("name");
                String author = data.getString("username");
                Recipe recipe = new Recipe(id, title, author);
                recipes.add(recipe);
            }
        } catch (Exception e) {
            System.out.println("Error from Credentialsbean: " + e.getMessage());

        }
        return recipes;

    }

    public Recipe getRecipe(int id) {
        Recipe recipe = new Recipe();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("SELECT recipe.*, users.username FROM recipe, users WHERE recipe.user_id  = users.id AND recipe.id =?");
            preparedstatement.setInt(1, id);
            ResultSet data = preparedstatement.executeQuery();
            while (data.next()) {
                int recipe_id = data.getInt("id");
                int user_id = data.getInt("user_id");
                String description = data.getString("recipe_descrip");
                String title = data.getString("name");
                String username = data.getString("username");
                recipe = new Recipe(recipe_id, user_id,title , description, username);
                
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return recipe;
    }

}
