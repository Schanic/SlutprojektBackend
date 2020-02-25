/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.entities;

/**
 *
 * @author Johan
 */
public class Recipe {
    private int id; 
    private String name;
    private String recipe_descrip;
    private int user_id;

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


    
    

   
    

    
    

   
    
    
}
