/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.resources;

import javax.ejb.EJB;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import nu.te4.slutprojektbackend.beans.CredentialsBeans;
import nu.te4.slutprojektbackend.entities.Credentials;


/**
 *
 * @author Johan
 */
@Path("userRes")
public class userResources {
    @EJB 
    CredentialsBeans creBean;
    
    /*
    *@POST Response
    *@param auth String
    * Checks if the parameter credentials sent from frontend matches a user from database.
    * @return response successful Authorization otherwise authorization denied.
    *
    */
    @POST
    @Path("Check")
    public Response checkUser(@HeaderParam("Authorization") String auth){
        
        Credentials cre = creBean.createCredentials(auth);
        if(creBean.checkCredentials(cre)) {
            return Response.ok("Authorization").build();
        }else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    
    /*
    *@POST Response
    *@param  auth String
    *If a post method is used in the header at frontend during registeration it wil register a new user
    *return Successful registeration, else denied registeration build.
    */
    @POST 
    @Path("Create")
    public Response createUser(@HeaderParam("Authorization") String auth){
        try {
            Credentials cre = creBean.createCredentials(auth);
            creBean.saveCredentials(cre);
            return Response.status(Response.Status.CREATED).build();
        
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(Response.Status.BAD_REQUEST).build();
            
        }
    }
}
