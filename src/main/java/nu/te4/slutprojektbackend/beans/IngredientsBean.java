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
import nu.te4.slutprojektbackend.entities.Ingredients;


/**
 *
 * @author Johan
 */
@Stateless
public class IngredientsBean {
    public List<Ingredients> getRecipeIng(int id) {
        List<Ingredients> ingredients = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("");
            preparedstatement.setInt(1, id);
            preparedstatement.executeQuery();
            ResultSet data = preparedstatement.executeQuery();
            while (data.next()) {
                int recId = data.getInt("recipe_id");
                int ingId = data.getInt("ingredients_id");
                int amount = data.getInt("amount");
                String unit = data.getString("unit");
                Ingredients ing = new Ingredients(recId, ingId, amount, unit);
                ingredients.add(ing);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
        return ingredients;
    }

    public List getRecipeIngList() {
        List<Ingredient> ingredients = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            List<Ingredients> value = getRecipeIng(0);

            for (Ingredients ing : value) {
                int id = ing.getIng_id();
                PreparedStatement preparedstatement = connection.prepareStatement("");
                preparedstatement.setInt(1, id);
                ResultSet data = preparedstatement.executeQuery();
                while (data.next()) {
                    int ing_id = data.getInt("id");
                    String name = data.getString("name");
                    Ingredient ingContent = new Ingredient(ing_id, name);
                    ingredients.add(ingContent);
                }
                
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
        return ingredients;
    }
}
