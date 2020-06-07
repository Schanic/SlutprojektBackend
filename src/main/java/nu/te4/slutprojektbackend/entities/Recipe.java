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
    private List<Instruction> instructions = new ArrayList<>();
    private List<Ingredient> ingredient = new ArrayList<>();
    
    

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
        this.user_id = user_id;
    }

    public Recipe(int recipe_id, int user_id, String title, String description, String username) {
        recipe_id = recipe_id;
        this.user_id = user_id;
        this.name = title;
        this.recipe_descrip = description;
        this.name = name;
        
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

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Recipe{" + "id=" + id + ", name=" + name + ", recipe_descrip=" + recipe_descrip + ", user_id=" + user_id + ", tags=" + tags + ", instructions=" + instructions + ", ingredient=" + ingredient + '}';
    }



    
    

   
    

    
    

   
    
    
}
