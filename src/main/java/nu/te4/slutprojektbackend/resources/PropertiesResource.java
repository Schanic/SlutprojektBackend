/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.slutprojektbackend.resources;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import nu.te4.slutprojektbackend.beans.PropertiesBean;

/**
 *
 * @author Johan
 */
@Path("key")
public class PropertiesResource {
    @EJB 
    PropertiesBean propbean;
    
    @GET
    public Response getKey(@QueryParam("key") String key){
        return Response
                .ok(propbean.getProp(key))
                .build();
    }
}
