/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.resources;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.te4.slutprojektbackend.beans.IngredientsBean;
import nu.te4.slutprojektbackend.beans.InstructionsBean;
import nu.te4.slutprojektbackend.beans.RecipeBeans;
import nu.te4.slutprojektbackend.beans.SaveRecipeBean;
import nu.te4.slutprojektbackend.beans.TagBean;
import nu.te4.slutprojektbackend.entities.Ingredient;
import nu.te4.slutprojektbackend.entities.Instruction;
import nu.te4.slutprojektbackend.entities.Recipe;
import nu.te4.slutprojektbackend.entities.Tag;

/**
 *
 * @author Johan
 */
@Path("recipe")

public class recipeResources {

    @EJB
    IngredientsBean ing;
    @EJB
    RecipeBeans recipeBeans;
    @EJB
    SaveRecipeBean saveRecipeBean;
    @EJB
    TagBean tagBean;
    @EJB
    InstructionsBean instructBean;

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createData(Recipe recipe) {
        
        int result = saveRecipeBean.saveRecipe(recipe);
        recipe.setId(result);
        int result2 =saveRecipeBean.saveInstructions(recipe);
        int result5 =saveRecipeBean.saveTagsRec(recipe);
        int result1 =saveRecipeBean.saveIngRec(recipe);
        
        if (result > 1 ) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

   

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        List<Recipe> data = recipeBeans.getAllRecipes();
        return Response.ok(data).build();
    }

    @GET
    @Path("wholeRecipe")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipe(@QueryParam("id") int id) {

        Recipe data = recipeBeans.getRecipe(id);
        List<Ingredient> ingredient = ing.getRecipeIng(id);
        List<Instruction> instruct = instructBean.getInstruction(id);
        List<Tag> tag = tagBean.getRecipeTags(id);

        data.setInstructions(instruct);
        data.setIngredient(ingredient);
        String name = data.getName();
        data.setTags(tag);
        data.setId(id);
        data.setName(name);
        //data.setUser_id(userId);

        return Response.ok(data).build();
    }

}
