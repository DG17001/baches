/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.control;

import java.io.StringReader;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import occ.ues.edu.sv.baches.JAXRSConfiguration;
import occ.ues.edu.sv.baches.TipoObjetoResource;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author magdiel
 */

@ExtendWith(ArquillianExtension.class)
public class TipoObjetoResourceIT {
    
    @Deployment
    public static WebArchive crearDespliegue() {
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage("occ.ues.edu.sv.baches.entity")
                .addAsResource("persistence-arquillian.xml")
                .addClass(AbstractDataAccess.class)
                .addClass(TipoObjetoBean.class)
                .addClass(JAXRSConfiguration.class)
                .addClass(TipoObjetoResource.class)
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsResource("META-INF/sql/datos.sql", "META-INF/sql/datos.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "pom.xml");
        System.out.println(salida.toString(true));
        return salida;
    }
    
    @ArquillianResource
    URL url;
    
    @Test
    @RunAsClient
    public void testFindAll(){
        System.out.println("\n\n");
        System.out.println("\n\n");
        System.out.println("--------------------------------------------------------------");
        System.out.println("findAllTipoObjeto");
        int resultadoEsperado=200;
        Client cliente=ClientBuilder.newClient();
        WebTarget target= cliente.target(url.toString()+"resources/");
        Response respuesta = target.path("tipoobjeto").request("application/json").get(); 
        assertEquals(resultadoEsperado, respuesta.getStatus());
        String totalTexto = respuesta.getHeaderString("Total-Registros");
        assertNotEquals(Integer.valueOf(0), Integer.valueOf(totalTexto));
        String cuerpoString = respuesta.readEntity(String.class);
        JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        JsonArray listaJson = lector.readArray();
        int totalRegistros = listaJson.size();
        assertTrue(totalRegistros>0);
        System.out.println("\n\n");
        System.out.println("\n\n");
        for(int i=0; i< listaJson.size(); i++){
            JsonObject objeto = listaJson.getJsonObject(i);
            System.out.println("ID: " + objeto.getInt("idTipoObjeto"));
        }
        System.out.println("\n\n");
        System.out.println("\n\n");
    }
}

