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
    IngredientsBean ingredientsBean;
    
    public int saveRecipe(Recipe recipe){
        
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO recipe VALUES (NULL,?,?,?)");
            preparedstatement.setString(1, recipe.getName());
            preparedstatement.setString(2, recipe.getRecipe_descrip());
            preparedstatement.setInt(3, recipe.getUser_id());
            ingredientsBean.saveI(recipe.getId(), recipe.getIngredients().get(0).getId() , recipe.getIngredients().get(0).getAmount(), recipe.getIngredients().get(0).getUnit());
           return preparedstatement.executeUpdate(); 
        } catch (Exception e) {
           System.out.println("Error from Credentialsbean: " + e.getMessage());
           return 0;
        }
        
      
    }
    public int getRecipe(){
        List<Recipe> recipe = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedstatement = connection.prepareStatement("Select * recipe");
           
            ResultSet result = preparedstatement.executeQuery();
            while (data.next){
                int
            }
        } catch (Exception e) {
           System.out.println("Error from Credentialsbean: " + e.getMessage());
           return 0;
        }
        
      
    }
    
    
    
}
