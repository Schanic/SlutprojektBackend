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
import nu.te4.slutprojektbackend.entities.IdTag;
import nu.te4.slutprojektbackend.entities.Recipe;

/**
 *
 * @author Johan
 */
@Stateless
public class RecipeBeans {
    
    @Inject
    SaveRecipeBean ingredientsBean;
    
    
        
     //SELECT recipe.*, users.username FROM recipe LEFT JOIN users ON recipe.user_id = users.id
      
    
    public List<Recipe> getAllRecipes(){
        List<Recipe> recipes = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedstatement = connection.prepareStatement("SELECT recipe.*, users.username FROM recipe LEFT JOIN users ON recipe.user_id = users.id");
            
            ResultSet data = preparedstatement.executeQuery();
            while (data.next()){
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
    
    public Recipe getWholeRecipe(int id){
        Recipe recipe = new Recipe();
        List<IdTag> tags = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("SELECT recipe.*, users.username FROM recipe LEFT JOIN users ON recipe.user_id = users.id");
            preparedstatement.setInt(1, id);
            preparedstatement.executeQuery();
            
            PreparedStatement preparedstatement2 = connection.prepareStatement("SELECT * FROM recipe_tags WHERE recipe_id = ?");
            preparedstatement2.setInt(1, id);
            ResultSet data = preparedstatement2.executeQuery();
            while(data.next()){
                int recipe_id = data.getInt("recipe_id");
                int tag_id = data.getInt("tags_id");
                IdTag tag = new IdTag(recipe_id, tag_id);
                tags.add(tag);
            }
            
            
            
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            
        }
        return recipe;
    }
    public Recipe getWholeRecipe2()
}
    
    
    

