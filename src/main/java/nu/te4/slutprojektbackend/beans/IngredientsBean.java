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
import nu.te4.slutprojektbackend.ConnectionFactory;
import nu.te4.slutprojektbackend.entities.Ingredient;


/**
 *
 * @author Johan
 */
@Stateless
public class IngredientsBean {
    public List<Ingredient> getRecipeIng(int id) {
        List<Ingredient> ingredients = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("SELECT ingredients.id ,ingredients.name, amount, unit FROM recipe_ingredients, ingredients WHERE ingredients.id = recipe_ingredients.ingredients_id AND recipe_id = ?");
            preparedstatement.setInt(1, id);
            preparedstatement.executeQuery();
            ResultSet data = preparedstatement.executeQuery();
            while (data.next()) {
                int recId = data.getInt("id");
                String name = data.getString("name");
                int amount = data.getInt("amount");
                String unit = data.getString("unit");
                Ingredient ing = new Ingredient(recId, name, amount, unit);
                ingredients.add(ing);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(ingredients + "getRecipeIng");
        return ingredients;
    }

}
