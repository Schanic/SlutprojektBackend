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
public class Recipe {
    private int id; 
    private String name;
    private String recipe_descrip;
    private int user_id;
    private List<Tag> tags = new  ArrayList<>();
    private List<Ingredients> ingredients = new  ArrayList<>();
    private List<Instruction> instructions = new ArrayList<>();
    // Gör lista för taggar osv. Så få en böna ta taggarna och gör en koppling.
    

    public Recipe() {
    }

    public Recipe(String name, String recipe_descrip, int user_id) {
        this.name = name;
        this.recipe_descrip = recipe_descrip;
        this.user_id = user_id;
    }

    public Recipe(int id, String name, String recipe_descrip, int user_id) {
        this.id = id;
        this.name = name;
        this.recipe_descrip = recipe_descrip;
        this.user_id = user_id;
    }

    public Recipe(int id, String title, String author) {
        this.id = id;
        this.name = title;
        String author = 
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }



    public String getName() {
        return name;
    }

    public String getRecipe_descrip() {
        return recipe_descrip;
    }

 
    

    public void setName(String name) {
        this.name = name;
    }

    public void setRecipe_descrip(String recipe_descrip) {
        this.recipe_descrip = recipe_descrip;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }


    
    

   
    

    
    

   
    
    
}
