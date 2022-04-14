/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.resources;

import java.math.BigDecimal;
import java.util.Date;
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
import occ.ues.edu.sv.baches.control.ObjetoBean;
import occ.ues.edu.sv.baches.entity.Objeto;


/**
 *
 * @author magdiel
 */

@Path("objeto")
@RequestScoped
public class ObjetoResource {
    
    @Inject
    ObjetoBean toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findAll(){
        List<Objeto> registros=toBean.findAll();
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
    public Response crear(Objeto nuevo) {
        nuevo.setNombre("Insertado desde ObjetoResource");
        nuevo.setLatitud(BigDecimal.ONE);
        nuevo.setLongitud(BigDecimal.ONE);
        toBean.crear(nuevo);
        return Response.ok(nuevo)
                .header("Nuevo Registro Creado", nuevo)
                .build();
    }

    @PUT
    public Response modificar(Objeto edit) {
        edit.setNombre("Modificado desde ObjetoResource");
        edit.setLatitud(BigDecimal.ONE);
        edit.setLongitud(BigDecimal.ONE);
        toBean.modificar(edit);
        return Response.ok(edit)
                .header("Registro modificado", edit)
                .build();

    }
    
    @DELETE
    @Path("{userId}")
    public Response eliminar(Objeto eliminar,@PathParam("userId") Long id){
        eliminar.setIdObjeto(id);
        toBean.eliminar(eliminar);
        return Response.ok(eliminar)
                .header("Eliminado el registro con id : ", id)
                .build();
    }
    
}
