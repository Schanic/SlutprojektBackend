/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.resources;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import nu.te4.slutprojektbackend.beans.RecipeBeans;

/**
 *
 * @author Johan
 */
@Path("recipe")
    
public class recipeResources {
    @EJB
    RecipeBeans recipeBeans;
}
