/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.resources;

import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import occ.ues.edu.sv.baches.JAXRSConfiguration;
import occ.ues.edu.sv.baches.control.AbstractDataAccess;
import occ.ues.edu.sv.baches.control.ObjetoEstadoBean;
import occ.ues.edu.sv.baches.entity.ObjetoEstado;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;

/**
 *
 * @author magdiel
 */
public class ObjetoEstadoResourceIT {
    
    @Deployment
    public static WebArchive crearDespliegue() {
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage("occ.ues.edu.sv.baches.entity")
                .addAsResource("persistence-arquillian.xml")
                .addClass(AbstractDataAccess.class)
                .addClass(ObjetoEstadoBean.class)
                .addClass(JAXRSConfiguration.class)
                .addClass(ObjetoEstadoResource.class)
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsResource("META-INF/sql/datos.sql", "META-INF/sql/datos.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "pom.xml");
        System.out.println(salida.toString(true));
        return salida;
    }
    
    @Inject
    ObjetoEstadoBean cut;
    
    @ArquillianResource
    URL url;
           
    @Test
    @RunAsClient
    @Order(1)
    public void testCrear() {
        System.out.println("Crear TipoObjeto");
        ObjetoEstado nuevo = new ObjetoEstado();
        nuevo.setActual(true);
        nuevo.setFechaAlcanzado(new Date());
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString() + "resources/");
        Response respuesta = target.path("objetoestado").request("accept","application/json").post(Entity.entity(nuevo, MediaType.APPLICATION_JSON));
        assertEquals(resultadoEsperado, respuesta.getStatus());
        String registro = respuesta.getHeaderString("Registro-Creado");
        assertNotEquals(null, registro);
        String cuerpoString = respuesta.readEntity(String.class);
        JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        JsonObject objeto = lector.readObject();
        System.out.println("\n\n");
        System.out.println("\n\n");
        System.out.println("Creado " + objeto);
        System.out.println("\n\n");
        System.out.println("\n\n");
    }

    @Test
    @RunAsClient
    @Order(2)
    public void testModificar() {
        System.out.println("Modificar Objeto");
        ObjetoEstado edit = new ObjetoEstado();
        edit.setActual(false);
        edit.setFechaAlcanzado(new Date());
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString() + "resources/");
        Response respuesta = target.path("objetoestado").request("accept","application/json").put(Entity.entity(edit, MediaType.APPLICATION_JSON));
        assertEquals(resultadoEsperado, respuesta.getStatus());
        String registro = respuesta.getHeaderString("Modificado");
        assertNotEquals(null, registro);
        String cuerpoString = respuesta.readEntity(String.class);
        JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        JsonObject objeto = lector.readObject();
        System.out.println("\n\n");
        System.out.println("\n\n");
        System.out.println("Modificado " + objeto);
        System.out.println("\n\n");
        System.out.println("\n\n");

    }

    @Test
    @RunAsClient
    @Order(3)
    public void testEliminar() {
        System.out.println("Eliminar ObjetoEstado");
        ObjetoEstado delete = new ObjetoEstado();        
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString() + "resources/");
        Response respuesta = target.path("objetoestado/3").request("accept","application/json").delete();
        assertEquals(resultadoEsperado, respuesta.getStatus());
        String registro = respuesta.getHeaderString("ID-eliminado");
        assertNotEquals(null, registro);
        String cuerpoString = respuesta.readEntity(String.class);
        JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        JsonObject objeto = lector.readObject();

        System.out.println("\n\n");
        System.out.println("\n\n");
        System.out.println("ID:" + objeto.getInt("idObjetoEstado") + " eliminado con exito");
        System.out.println("\n\n");
        System.out.println("\n\n");
    }
    
    @Test
    @RunAsClient
    @Order(4)
    public void testFindAll(){
        System.out.println("\n");
        System.out.println("--------------------------------------------------------------");
        System.out.println("findAllObjetoEstado");
        int resultadoEsperado=200;
        Client cliente=ClientBuilder.newClient();
        WebTarget target= cliente.target(url.toString()+"resources/");
        Response respuesta = target.path("objetoestado").request("accept","application/json").get(); 
        Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        String totalTexto = respuesta.getHeaderString("Total-Registros");
        Assertions.assertNotEquals(Integer.valueOf(0), Integer.valueOf(totalTexto));
        System.out.println("Total: "+totalTexto);
//        String cuerpoString = respuesta.readEntity(String.class);
//        JsonReader lector = Json.createReader(new StringReader(cuerpoString));
//        JsonArray listaJson = lector.readArray();
//        int totalRegistros = listaJson.size();
//        assertTrue(totalRegistros>0);
//        System.out.println("\n\n");
//        for(int i=0; i< listaJson.size(); i++){
//            JsonObject objeto = listaJson.getJsonObject(i);
//            System.out.println("ID: " + objeto.getInt("idTipoObjeto"));
//        }
//        System.out.println("\n\n");
//        System.out.println("\n\n");
    }
    
    @Test
    @Order(5)
    public void testContar() {
        System.out.println("Contar");
        assertNotNull(cut);
        Long resultado = cut.contar();
        assertNotNull(resultado);
        System.out.println("Se encontraron " + resultado);

    }
    
}
