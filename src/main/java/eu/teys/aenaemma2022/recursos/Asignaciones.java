/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.teys.aenaemma2022.recursos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.*;
import eu.teys.aenaemma2022.entidades.CuePasajeros;
import eu.teys.aenaemma2022.entidades.CueTrabajadores;
//import eu.teys.aenaemma2022.entidades.Cuestionarios;
import eu.teys.aenaemma2022.utilidades.SQLconnection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.PathParam;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Eduardo
 */
@Path("/")
public class Asignaciones {
    //Desarrollo
    /*
    static SQLconnection conexionActualizacion = new SQLconnection ("SRV-PROYECTOS:1433", "Java", "Netbeans", "SituacionEMMA");
    static SQLconnection conexionCuePasajeros = new SQLconnection ("SRV-PROYECTOS:1433", "Java", "Netbeans", "SituacionEMMA");
    static SQLconnection conexionCueTrabajadores = new SQLconnection ("SRV-PROYECTOS:1433", "Java", "Netbeans", "SituacionEMMA");
    */
    
    //Producción
    
    static SQLconnection conexionActualizacion = new SQLconnection ("TEYS-BASES:1433", "Java", "Netbeans", "SituacionEMMA");
    static SQLconnection conexionCuePasajeros = new SQLconnection ("TEYS-BASES:1433", "Java", "Netbeans", "SituacionEMMA");
    static SQLconnection conexionCueTrabajadores = new SQLconnection ("TEYS-BASES:1433", "Java", "Netbeans", "SituacionEMMA");
    
    final static String UPLOAD_PATH = "C:\\EMMA";
    //final static String UPLOAD_PATH = "D:\\EMMA";
    
    @POST
    @Path("/crunchifyService")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crunchifyREST(InputStream incomingData) {
        StringBuilder crunchifyBuilder = new StringBuilder();
        try {
                BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
                String line = null;
                while ((line = in.readLine()) != null) {
                        crunchifyBuilder.append(line);
                }
        } catch (Exception e) {
                System.out.println("Error Parsing: - ");
        }
        System.out.println("Data Received: " + crunchifyBuilder.toString());

        // return HTTP response 200 in case of success
        return Response.status(200).entity(crunchifyBuilder.toString()).build();
    }

    @GET
    @Path("/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyRESTService(InputStream incomingData) {
        String result = "CrunchifyRESTService Successfully started..";

        // return HTTP response 200 in case of success
        return Response.status(200).entity(result).build();
    }
    
    @GET
    @Path("/actualizacion/{varX}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizacion(@PathParam("varX") String usuario) {
        String respuesta = new String();
        if (usuario == null) {
            usuario = "";
        }
        
        try {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray;
            
            conexionActualizacion.connectar();
            
            conexionActualizacion.consultar("SELECT COUNT(*) AS conteo FROM ActualizaDatos AD INNER JOIN Encuestadores E ON AD.idUsuario = E.iden WHERE E.usuario = '" + usuario + "' AND AD.ejecutado = 'False'");
            jsonArray = convertToJSON(conexionActualizacion.getResultSet());
            
            jsonObject.put("Total",jsonArray);
            
            conexionActualizacion.consultar("SELECT codigo FROM ActualizaDatos AD INNER JOIN Encuestadores E ON AD.idUsuario = E.iden WHERE E.usuario = '" + usuario + "' AND AD.ejecutado = 'False' ORDER BY AD.iden");
            jsonArray = convertToJSON(conexionActualizacion.getResultSet());
            
            jsonObject.put("Codigo",jsonArray);
            
            respuesta = jsonObject.toString();
            
            conexionActualizacion.ejecutar("UPDATE ActualizaDatos SET ejecutado = 'True' WHERE iden IN (SELECT AD.iden FROM ActualizaDatos AD INNER JOIN Encuestadores E ON AD.idUsuario = E.iden WHERE E.usuario = '" + usuario + "' AND AD.ejecutado = 'False')");
            
            conexionActualizacion.desconectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Asignaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Asignaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Asignaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // return HTTP response 200 in case of success
        return Response.status(200).entity(respuesta).build();
    }
    
    @POST
    @Path("/envio/cuepasajeros")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response envioCuePasajeros(InputStream incomingData) {
        StringBuilder crunchifyBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData, "UTF8"));
            String line = null;
            while ((line = in.readLine()) != null) {
                Gson gson = new Gson();
                CuePasajeros cuestionario = gson.fromJson(line, CuePasajeros.class);
                if(cuestionario != null){
                    String fileName = saveIntoFile(cuestionario, line);
                    saveIntoDB(cuestionario, fileName);
                }
                crunchifyBuilder.append(line);
            }
        } catch (Exception e) {
            System.out.println("Envíos Pas: No ha sido posible leer el cuestionario recibido");
            e.printStackTrace();
            return Response.status(400).entity("No ha sido posible leer el cuestionario").build();
        }
        System.out.println("Data Received: " + crunchifyBuilder.toString());
        
        // return HTTP response 200 in case of success
        return Response.status(200).entity(crunchifyBuilder.toString()).build();
    }
    
    private String saveIntoFile(CuePasajeros cuestionario, String line){
	//Define path and filename
        File uploads = new File(UPLOAD_PATH);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        ParsePosition pos = new ParsePosition(0);
        Date fechaCues = sdf.parse(cuestionario.getFecha()+" "+cuestionario.getHoraInicio(), pos);
        String fileName = "EMMA_"+ cuestionario.getNencdor() + "_PAS_" + String.valueOf(cuestionario.getClave()) + ".json";
                        
	//Create a new file
        try {
            File file = new File(uploads, fileName);
            FileOutputStream outputStream;
        
            outputStream = new FileOutputStream(file);
            outputStream.write(line.getBytes());
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Envíos Pas: Error while writting que into File");
            e.printStackTrace();
        }
        
        return fileName;
    }
    
    private void saveIntoDB(CuePasajeros cuestionario, String fileName){        
        String SQL = "INSERT INTO [dbo].[CuePasajeros] "+
           "([idTablet],[idUsuario],[enviado],[pregunta],[clave],[fecha],[horaInicio],[horaFin],[idAeropuerto], "+
	   "[idIdioma],[acomptes],[bulgrupo],[cdalojin],[cdalojin_otros],[cdbillet],[cdcambio],[cdedad], "+
	   "[cdentrev],[cdiaptod],[cdiaptodotros],[cdiaptoe],[cdiaptof],[cdiaptofotro],[cdiaptoo],[cdiaptoootros],[cdidavue], "+
	   "[cdlocaco],[cdlocacootro],[cdlocado],[cdmviaje],[cdociaar],[cdociaarotros],[cdpaisna],[cdpaisnaotro],[cdpaisre],[cdpaisreotro],[cdsexo],[cdslab], "+
	   "[cdsprof],[cdterm],[cdtreser],[chekinb],[ciaantes],[ciaantesotros],[comprart],[conexfac],[consume], "+
	   "[estudios],[fentrev],[gas_com],[gas_cons],[hentrev],[hfin],[hini],[hllega],[idioma],[modulo], "+
	   "[motivoavion2],[nencdor],[nniños],[nperbul],[npers],[numvueca],[numvuepa],[nviaje],[p44factu], "+
	   "[pqfuera],[prefiere],[prod1],[prod2],[prod3],[prod4],[prod5],[puerta],[relacion],[sitiopark],[taus], "+
	   "[ultimodo],[ultimodootro],[usoave],[vien_re],[vol12mes],[distres],[distresotro],[cdsinope],[cdalojen], "+
	   "[distracce],[distracceotro],[nmodos],[modo1],[modo2],[bustermi],[dropoff],[eleccovid],[valorexp], "+
           "[empresa],[empresaotro],[cdlocadootro],[destino],[destinootro],[cia],[ciaotro],[hllegabus],[hsaleavion], "+
           "[bustransfer],[entautobus],[desautobus],[hsalebus],[seccion],[modo],[modootro],[numcomp],[numbus],[numdarsena]) VALUES ("+
cuestionario.getIden()+", "+
cuestionario.getIdUsuario()+", "+
cuestionario.getEnviado()+", "+
cuestionario.getPregunta()+", "+
"'"+cuestionario.getClave()+"', "+
"'"+cuestionario.getFecha()+"', "+
"'"+cuestionario.getHoraInicio()+"', "+
"'"+cuestionario.getHoraFin()+"', "+
cuestionario.getIdAeropuerto()+", "+
cuestionario.getIdIdioma()+", "+
cuestionario.getAcomptes()+", "+
"'"+cuestionario.getBulgrupo()+"', "+
"'"+cuestionario.getCdalojin()+"', "+
"'"+cuestionario.getCdalojin_otros()+"', "+
"'"+cuestionario.getCdbillet()+"', "+
"'"+cuestionario.getCdcambio()+"', "+
"'"+cuestionario.getCdedad()+"', "+
"'"+cuestionario.getCdentrev()+"', "+
"'"+cuestionario.getCdiaptod()+"', "+
"'"+cuestionario.getCdiaptodotro()+"', "+
"'"+cuestionario.getCdiaptoe()+"', "+
"'"+cuestionario.getCdiaptof()+"', "+
"'"+cuestionario.getCdiaptofotro()+"', "+
"'"+cuestionario.getCdiaptoo()+"', "+
"'"+cuestionario.getCdiaptoootro()+"', "+
"'"+cuestionario.getCdidavue()+"', "+
"'"+cuestionario.getCdlocaco()+"', "+
"'"+cuestionario.getCdlocacootro()+"', "+
"'"+cuestionario.getCdlocado()+"', "+
"'"+cuestionario.getCdmviaje()+"', "+
"'"+cuestionario.getCdociaar()+"', "+
"'"+cuestionario.getCdociaarotro()+"', "+
"'"+cuestionario.getCdpaisna()+"', "+
"'"+cuestionario.getCdpaisnaotro()+"', "+
"'"+cuestionario.getCdpaisre()+"', "+
"'"+cuestionario.getCdpaisreotro()+"', "+
cuestionario.getCdsexo()+", "+
"'"+cuestionario.getCdslab()+"', "+
"'"+cuestionario.getCdsprof()+"', "+
"'"+cuestionario.getCdterm()+"', "+
"'"+cuestionario.getCdtreser()+"', "+
cuestionario.getChekinb()+", "+
"'"+cuestionario.getCiaantes()+"', "+
"'"+cuestionario.getCiaantesotro()+"', "+
"'"+cuestionario.getComprart()+"', "+
"'"+cuestionario.getConexfac()+"', "+
"'"+cuestionario.getConsume()+"', "+
"'"+cuestionario.getEstudios()+"', "+
"'"+cuestionario.getFentrev()+"', "+
cuestionario.getGas_com()+", "+
cuestionario.getGas_cons()+", "+
"'"+cuestionario.getHentrev()+"', "+
"'"+cuestionario.getHfin()+"', "+
"'"+cuestionario.getHini()+"', "+
"'"+cuestionario.getHllega()+"', "+
"'"+cuestionario.getIdioma()+"', "+
"'"+cuestionario.getModulo()+"', "+
"'"+cuestionario.getMotivoavion2()+"', "+
"'"+cuestionario.getNencdor()+"', "+
cuestionario.getNniños()+", "+
"'"+cuestionario.getNperbul()+"', "+
"'"+cuestionario.getNpers()+"', "+
"'"+cuestionario.getNumvueca()+"', "+
"'"+cuestionario.getNumvuepa()+"', "+
"'"+cuestionario.getNviaje()+"', "+
"'"+cuestionario.getP44factu()+"', "+
"'"+cuestionario.getPqfuera()+"', "+
"'"+cuestionario.getPrefiere()+"', "+
"'"+cuestionario.getProd1()+"', "+
"'"+cuestionario.getProd2()+"', "+
"'"+cuestionario.getProd3()+"', "+
"'"+cuestionario.getProd4()+"', "+
"'"+cuestionario.getProd5()+"', "+
"'"+cuestionario.getPuerta()+"', "+
"'"+cuestionario.getRelacion()+"', "+
"'"+cuestionario.getSitiopark()+"', "+
cuestionario.getTaus()+", "+
"'"+cuestionario.getUltimodo()+"', "+
"'"+cuestionario.getUltimodootro()+"', "+
"'"+cuestionario.getUsoave()+"', "+
"'"+cuestionario.getVien_re()+"', "+
"'"+cuestionario.getVol12mes()+"', "+
"'"+cuestionario.getDistres()+"', "+
"'"+cuestionario.getDistresotro()+"', "+
"'"+cuestionario.getCdsinope()+"', "+
"'"+cuestionario.getCdalojen()+"', "+
"'"+cuestionario.getDistracce()+"', "+
"'"+cuestionario.getDistracceotro()+"', "+
"'"+cuestionario.getNmodos()+"', "+
"'"+cuestionario.getModo1()+"', "+
"'"+cuestionario.getModo2()+"', "+
cuestionario.getBustermi()+", "+
"'"+cuestionario.getDropoff()+"', "+
"'"+cuestionario.getEleccovid()+"', "+
cuestionario.getValorexp()+", "+
"'"+cuestionario.getEmpresa()+"', "+
"'"+cuestionario.getEmpresaotro()+"', "+
"'"+cuestionario.getCdlocadootro()+"', "+
"'"+cuestionario.getDestino()+"', "+
"'"+cuestionario.getDestinootro()+"', "+
"'"+cuestionario.getCia()+"', "+
"'"+cuestionario.getCiaotro()+"', "+
"'"+cuestionario.getHllegabus()+"', "+
"'"+cuestionario.getHsaleavion()+"', "+
"'"+cuestionario.getBustransfer()+"', "+
"'"+cuestionario.getEntautobus()+"', "+
"'"+cuestionario.getDesautobus()+"', "+
"'"+cuestionario.getHsalebus()+"', "+
"'"+cuestionario.getSeccion()+"', "+
"'"+cuestionario.getModo()+"', "+
"'"+cuestionario.getModootro()+"', "+
"'"+cuestionario.getNumcomp()+"', "+
"'"+cuestionario.getNumbus()+"', "+
"'"+cuestionario.getNumdarsena()+"'"
                +") ";
      
        try {
            conexionCuePasajeros.connectar();
            
            conexionCuePasajeros.ejecutar(SQL);
                    
            conexionCuePasajeros.desconectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Asignaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Asignaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @POST
    @Path("/envio/cuetrabajadores")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response envioCueTrabajadores(InputStream incomingData) {
        StringBuilder crunchifyBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData, "UTF8"));
            String line = null;
            while ((line = in.readLine()) != null) {
                Gson gson = new Gson();
                CueTrabajadores cuestionario = gson.fromJson(line, CueTrabajadores.class);
                if(cuestionario != null){
                    String fileName = saveIntoFile(cuestionario, line);
                    saveIntoDB(cuestionario, fileName);
                }
                crunchifyBuilder.append(line);
            }
        } catch (Exception e) {
            System.out.println("Envíos Trab: No ha sido posible leer el cuestionario recibido");
            e.printStackTrace();
            return Response.status(400).entity("No ha sido posible leer el cuestionario").build();
        }
        System.out.println("Data Received: " + crunchifyBuilder.toString());
        
        // return HTTP response 200 in case of success
        return Response.status(200).entity(crunchifyBuilder.toString()).build();
    }
    
    private String saveIntoFile(CueTrabajadores cuestionario, String line){
	//Define path and filename
        File uploads = new File(UPLOAD_PATH);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        ParsePosition pos = new ParsePosition(0);
        Date fechaCues = sdf.parse(cuestionario.getFecha()+" "+cuestionario.getHoraInicio(), pos);
        String fileName = "EMMA_"+ cuestionario.getNencdor() + "_TRAB_" + String.valueOf(cuestionario.getClave()) + ".json";
                        
	//Create a new file
        try {
            File file = new File(uploads, fileName);
            FileOutputStream outputStream;
        
            outputStream = new FileOutputStream(file);
            outputStream.write(line.getBytes());
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Envíos Trab: Error while writting que into File");
            e.printStackTrace();
        }
        
        return fileName;
    }
    
    private void saveIntoDB(CueTrabajadores cuestionario, String fileName){        
        String SQL = "INSERT INTO [dbo].[CueTrabajadores] "+
           "([idTablet],[idUsuario],[enviado],[pregunta],[clave],[fecha],[horaInicio],[horaFin],[idAeropuerto], "+
	   "[idIdioma],[nencdor],[cdsexo],[idioma],[empresa],[actempre],[actempreotro],[cdlocado],[distres], "+
	   "[distresotro],[jornada],[jornadaotro],[ndiastrab],[zonatrab1],[zonatrab2],[zonatrab3],[zonatrab4], "+
	   "[zonatrab5],[zonatrab6],[horaent1],[horasal1],[horaent2],[horasal2],[horaent3],[horasal3],[nmodos], "+
	   "[modo1],[modo2],[ultimodo],[nocucoche],[satistranspubli],[valtranspubli1],[valtranspubli2], "+
	   "[valtranspubli3],[valtranspubliotro],[mejtranspubli1],[mejtranspubli2],[mejtranspubli3], "+
	   "[mejtranspubliotro],[desplazatrab],[notranspubli1],[notranspubli2],[notranspubli3],[notranspubliotro], "+
	   "[disptranspubli],[disptranspubliotro],[importranspubli],[medtranspubli1],[medtranspubli2], "+
	   "[medtranspubli3],[medtranspubliotro],[tiempotranspubli],[aparctrab],[compartcoche1],[compartcoche2], "+
           "[compartcoche3],[compartcocheotro],[dispbici1],[dispbici2],[dispbici3],[dispbiciotro],[modosalida], "+
	   "[modosalidaotro],[cdedadtrab],[cdslab],[puesto],[sugerencias]) VALUES ("+
cuestionario.getIden()+", "+
cuestionario.getIdUsuario()+", "+
cuestionario.getEnviado()+", "+
cuestionario.getPregunta()+", "+
"'"+cuestionario.getClave()+"', "+
"'"+cuestionario.getFecha()+"', "+
"'"+cuestionario.getHoraInicio()+"', "+
"'"+cuestionario.getHoraFin()+"', "+
cuestionario.getIdAeropuerto()+", "+
cuestionario.getIdIdioma()+", "+
"'"+cuestionario.getNencdor()+"', "+
cuestionario.getCdsexo()+", "+
"'"+cuestionario.getIdioma()+"', "+
"'"+cuestionario.getEmpresa()+"', "+
"'"+cuestionario.getActempre()+"', "+
"'"+cuestionario.getActempreotro()+"', "+
"'"+cuestionario.getCdlocado()+"', "+
"'"+cuestionario.getDistres()+"', "+
"'"+cuestionario.getDistresotro()+"', "+
"'"+cuestionario.getJornada()+"', "+
"'"+cuestionario.getJornadaotro()+"', "+
"'"+cuestionario.getNdiastrab()+"', "+
cuestionario.getZonatrab1()+", "+
cuestionario.getZonatrab2()+", "+
cuestionario.getZonatrab3()+", "+
cuestionario.getZonatrab4()+", "+
cuestionario.getZonatrab5()+", "+
cuestionario.getZonatrab6()+", "+
"'"+cuestionario.getHoraent1()+"', "+
"'"+cuestionario.getHorasal1()+"', "+
"'"+cuestionario.getHoraent2()+"', "+
"'"+cuestionario.getHorasal2()+"', "+
"'"+cuestionario.getHoraent3()+"', "+
"'"+cuestionario.getHorasal3()+"', "+
"'"+cuestionario.getNmodos()+"', "+
"'"+cuestionario.getModo1()+"', "+
"'"+cuestionario.getModo2()+"', "+
"'"+cuestionario.getUltimodo()+"', "+
"'"+cuestionario.getNocucoche()+"', "+
"'"+cuestionario.getSatistranspubli()+"', "+
"'"+cuestionario.getValtranspubli1()+"', "+
"'"+cuestionario.getValtranspubli2()+"', "+
"'"+cuestionario.getValtranspubli3()+"', "+
"'"+cuestionario.getValtranspubliotro()+"', "+
"'"+cuestionario.getMejtranspubli1()+"', "+
"'"+cuestionario.getMejtranspubli2()+"', "+
"'"+cuestionario.getMejtranspubli3()+"', "+
"'"+cuestionario.getMejtranspubliotro()+"', "+
"'"+cuestionario.getDesplazatrab()+"', "+
"'"+cuestionario.getNotranspubli1()+"', "+
"'"+cuestionario.getNotranspubli2()+"', "+
"'"+cuestionario.getNotranspubli3()+"', "+
"'"+cuestionario.getNotranspubliotro()+"', "+
"'"+cuestionario.getDisptranspubli()+"', "+
"'"+cuestionario.getDisptranspubliotro()+"', "+
"'"+cuestionario.getImportranspubli()+"', "+
"'"+cuestionario.getMedtranspubli1()+"', "+
"'"+cuestionario.getMedtranspubli2()+"', "+
"'"+cuestionario.getMedtranspubli3()+"', "+
"'"+cuestionario.getMedtranspubliotro()+"', "+
"'"+cuestionario.getTiempotranspubli()+"', "+
"'"+cuestionario.getAparctrab()+"', "+
"'"+cuestionario.getCompartcoche1()+"', "+
"'"+cuestionario.getCompartcoche2()+"', "+
"'"+cuestionario.getCompartcoche3()+"', "+
"'"+cuestionario.getCompartcocheotro()+"', "+
"'"+cuestionario.getDispbici1()+"', "+
"'"+cuestionario.getDispbici2()+"', "+
"'"+cuestionario.getDispbici3()+"', "+
"'"+cuestionario.getDispbiciotro()+"', "+
"'"+cuestionario.getModosalida()+"', "+
"'"+cuestionario.getModosalidaotro()+"', "+
"'"+cuestionario.getCdedadtrab()+"', "+
"'"+cuestionario.getCdslab()+"', "+
"'"+cuestionario.getPuesto()+"', "+
"'"+cuestionario.getSugerencias()+"') ";
      
        try {
            conexionCueTrabajadores.connectar();
            
            
            conexionCueTrabajadores.ejecutar(SQL);
                    
            conexionCueTrabajadores.desconectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Asignaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Asignaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static JSONArray convertToJSON(ResultSet resultSet) throws Exception {
        JSONArray jsonArray = new JSONArray();
        
        while (resultSet.next()) {
            int total_columns = resultSet.getMetaData().getColumnCount();
            JSONObject obj = new JSONObject();
            
            for (int i = 0; i < total_columns; i++) {
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
            }
            jsonArray.put(obj);
        }
        
        return jsonArray;
    }
}
