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
import nu.te4.slutprojektbackend.entities.Tag;

/**
 *
 * @author Johan
 */
@Stateless
public class TagBean { 

    public List<Tag> getRecipeTags(int id) {
        List<Tag> tags = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement("SELECT tags.id,tags.name FROM tags, recipe_tags WHERE tags.id = recipe_tags.tags_id AND recipe_id = ?");
            preparedstatement.setInt(1, id);
            preparedstatement.executeQuery();
            ResultSet data = preparedstatement.executeQuery();
            while (data.next()) {
                int tag_id = data.getInt("id");
                String name = data.getString("name");
                Tag tag = new Tag(tag_id, name);
                tags.add(tag);
            }

        } catch (Exception e) {
            
            System.out.println("Error: " + e.getMessage());

        }
        return tags;
    }
    /*public List<Tag> getAllTags(){
        List<Tag> tags = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement prepstat = connection.prepareStatement("SELECT * FROM tags");
            prepstat.execute();
            ResultSet data = prepstat.executeQuery();
        } catch (Exception e) {
        }
    }*/
  
    
}
