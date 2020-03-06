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
public class Rec_tags {
    private int recipe_id;
    private int tag_id;

    public Rec_tags(int recipe_id, int tag_id) {
        this.recipe_id = recipe_id;
        this.tag_id = tag_id;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }
    
    
}
