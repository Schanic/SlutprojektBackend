/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johan
 */
public class RTest {
    private int id; 
    private String name;
    private String recipe_descrip;
    private int user_id;
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public RTest() {
        tags =new  ArrayList<>(); 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe_descrip() {
        return recipe_descrip;
    }

    public void setRecipe_descrip(String recipe_descrip) {
        this.recipe_descrip = recipe_descrip;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
}
