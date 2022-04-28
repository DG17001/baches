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
import occ.ues.edu.sv.baches.entity.Estado;


/**
 *
 * @author magdiel
 */
@Path("estado")
@RequestScoped
public class EstadoResource{
    @Inject
    EstadoBean toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findAll(){
        List<Estado> registros=toBean.findAll();
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
    public Response crear(Estado nuevo) {
        nuevo.setNombre("Insertado desde EstadoResource");
        nuevo.setFechaCreacion(new Date());
        toBean.crear(nuevo);
        return Response.ok(nuevo)
                .header("Nuevo Registro Creado", nuevo)
                .build();
    }

    @PUT
    public Response modificar(Estado edit) {
        edit.setNombre("Modificado desde EstadoResource");
        edit.setFechaCreacion(new Date());
        toBean.modificar(edit);
        return Response.ok(edit)
                .header("Registro modificado", edit)
                .build();

    }
    
    @DELETE
    @Path("{userId}")
    public Response eliminar(Estado eliminar,@PathParam("userId") int id){
        eliminar.setIdEstado(id);
        toBean.eliminar(eliminar);
        return Response.ok(eliminar)
                .header("Eliminado el registro con id : ", id)
                .build();
    }
}
