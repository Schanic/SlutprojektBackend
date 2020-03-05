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
import javax.ejb.EJB;
import javax.ejb.Stateless;
import nu.te4.slutprojektbackend.ConnectionFactory;
import nu.te4.slutprojektbackend.entities.IdTag;
import nu.te4.slutprojektbackend.entities.Tag;

/**
 *
 * @author Johan
 */
@Stateless
public class TagBean { 

    public List<IdTag> getRecipeTags(int id) {
        System.out.println("HEJ EJEWJEA JEJW");
        List<IdTag> tags = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("SELECT recipe_id, tags_id FROM `recipe_tags` WHERE recipe_id = ?");
            preparedstatement.setInt(1, id);
            preparedstatement.executeQuery();
            ResultSet data = preparedstatement.executeQuery();
            while (data.next()) {
                int recipe_id = data.getInt("recipe_id");
                int tag_id = data.getInt("tags_id");
                IdTag tag = new IdTag(recipe_id, tag_id);
                tags.add(tag);
            }

        } catch (Exception e) {
            System.out.println("HEJ EJEWJEA JEJW");
            System.out.println("Error: " + e.getMessage());

        }
        return tags;
    }
  
    public List getRecipeTagsList() {
        List<Tag> tags = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            List<IdTag> value = getRecipeTags(0);

            for (IdTag tag : value) {
                int id = tag.getRecipe_id();
                PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM tags WHERE id = ?");
                preparedstatement.setInt(1, id);
                ResultSet data = preparedstatement.executeQuery();
                while (data.next()) {
                    int tag_id = data.getInt("id");
                    String namess = data.getString("name");
                    Tag tagContent = new Tag(tag_id, namess);
                    tags.add(tagContent);
                    
                }
                
            }
            System.out.println(tags);
        } catch (Exception e) {
            System.out.println("HEJ EJEWJEA JEJW 222222222");
            System.out.println("Error: " + e.getMessage());

        }
        return tags;
    }
}
