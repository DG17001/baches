/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import occ.ues.edu.sv.baches.control.TipoObjetoBean;
import occ.ues.edu.sv.baches.entity.TipoObjeto;

/**
 *
 * @author magdiel
 */

@Path("tipoobjeto")
public class TipoObjetoResources implements Serializable{
    
    @Inject
    TipoObjetoBean toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findAll(){
        List<TipoObjeto> registros=toBean.findAll();
        Long total=toBean.contar();
        return Response.ok(registros).header("Total registros", total).build();
    }
    
    
}
