/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.resources;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import occ.ues.edu.sv.baches.control.TipoObjetoBean;
import occ.ues.edu.sv.baches.entity.TipoObjeto;

/**
 *
 * @author magdiel
 */

@Path("tipoobjeto")
@RequestScoped
public class TipoObjetoResource implements Serializable{
    
    @Inject
    TipoObjetoBean toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findAll(){
        List<TipoObjeto> registros=toBean.findAll();
        Long total=toBean.contar();
        return Response.ok(registros)
                .header("Total-registros", total)
                .build();
    }
    
    @GET
    @Path("contar")
    public CompletableFuture<Long> contar(){
        return CompletableFuture.supplyAsync(toBean::contar);
    }
    
    @POST
    public Response crear(TipoObjeto nuevo) {
        nuevo.setActivo(Boolean.TRUE);
        toBean.crear(nuevo);
        return Response.ok(nuevo)
                .build();
    }

    @PUT
    public Response modificar(TipoObjeto edit) {
        
        edit.setActivo(Boolean.FALSE);
        
        toBean.modificar(edit);
        return Response.ok(edit)
                .build();

    }
    
    @DELETE
    @Path("{userId}")
    public Response eliminar(TipoObjeto eliminar,@PathParam("userId") int id){
        eliminar.setIdTipoObjeto(id);
        toBean.eliminar(eliminar);
        return Response.ok(eliminar)
                .header("iD eliminado: ", id)
                .build();
    }

    
}
