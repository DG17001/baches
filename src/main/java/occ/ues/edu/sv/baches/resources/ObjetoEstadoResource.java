/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.resources;

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
import occ.ues.edu.sv.baches.control.EstadoBean;
import occ.ues.edu.sv.baches.control.ObjetoEstadoBean;
import occ.ues.edu.sv.baches.entity.Estado;
import occ.ues.edu.sv.baches.entity.ObjetoEstado;

/**
 *
 * @author magdiel
 */
@Path("objetoestado")
@RequestScoped
public class ObjetoEstadoResource {
    
    @Inject
    ObjetoEstadoBean toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findAll(){
        List<ObjetoEstado> registros=toBean.findAll();
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
    public Response crear(ObjetoEstado nuevo) {
        nuevo.setActual(Boolean.TRUE);
        nuevo.setFechaAlcanzado(new Date());
        toBean.crear(nuevo);
        return Response.ok(nuevo)
                .header("Nuevo Registro Creado", nuevo)
                .build();
    }

    @PUT
    public Response modificar(ObjetoEstado edit) {
        edit.setActual(Boolean.TRUE);
        edit.setFechaAlcanzado(new Date());
        toBean.modificar(edit);
        return Response.ok(edit)
                .header("Registro modificado", edit)
                .build();

    }
    
    @DELETE
    @Path("{userId}")
    public Response eliminar(ObjetoEstado eliminar,@PathParam("userId") Long id){
        eliminar.setIdObjetoEstado(id);
        toBean.eliminar(eliminar);
        return Response.ok(eliminar)
                .header("Eliminado el registro con id : ", id)
                .build();
    }
}
