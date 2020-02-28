/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.resources;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.te4.slutprojektbackend.beans.IngredientsBean;
import nu.te4.slutprojektbackend.beans.RecipeBeans;
import nu.te4.slutprojektbackend.beans.TagBean;
import nu.te4.slutprojektbackend.entities.Recipe;

/**
 *
 * @author Johan
 */
@Path("recipe")

public class recipeResources {

    @EJB
    RecipeBeans recipeBeans;
    @EJB
    IngredientsBean ingrediensbeans;
    @EJB
    TagBean tagBean;

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createData(Recipe recipe) {
       recipeBeans.saveRecipe(recipe); 
       ingrediensbeans.saveI(recipe.getIngredients());


        return null;
    }
    
    @GET
    @Path("allTitleRecipes")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getData(Recipe recipe) {
       List<Recipe> data = recipeBeans.getRecipe();


        return null;
    }

}
