/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.teys.aenaemma2022.entidades;

import java.io.Serializable;

/**
 *
 * @author Eduardo
 */
public class CueTrabajadores implements Serializable {

    private int iden;
    private int idUsuario;
    private int enviado;
    private int pregunta;
    private String clave;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private int idAeropuerto;
    private int idIdioma;
    private String nencdor;
    private int cdsexo;
    private String idioma;
    private String empresa;
    private String actempre;
    private String actempreotro;
    private String cdlocado;
    private String distres;
    private String distresotro;
    private String jornada;
    private String jornadaotro;
    private String ndiastrab;
    private int zonatrab1;
    private int zonatrab2;
    private int zonatrab3;
    private int zonatrab4;
    private int zonatrab5;
    private int zonatrab6;
    private String horaent1;
    private String horasal1;
    private String horaent2;
    private String horasal2;
    private String horaent3;
    private String horasal3;
    private String nmodos;
    private String modo1;
    private String modo2;
    private String ultimodo;
    private String nocucoche;
    private String satistranspubli;
    private String valtranspubli1;
    private String valtranspubli2;
    private String valtranspubli3;
    private String valtranspubliotro;
    private String mejtranspubli1;
    private String mejtranspubli2;
    private String mejtranspubli3;
    private String mejtranspubliotro;
    private String desplazatrab;
    private String notranspubli1;
    private String notranspubli2;
    private String notranspubli3;
    private String notranspubliotro;
    private String disptranspubli;
    private String disptranspubliotro;
    private String importranspubli;
    private String medtranspubli1;
    private String medtranspubli2;
    private String medtranspubli3;
    private String medtranspubliotro;
    private String tiempotranspubli;
    private String aparctrab;
    private String compartcoche1;
    private String compartcoche2;
    private String compartcoche3;
    private String compartcocheotro;
    private String dispbici1;
    private String dispbici2;
    private String dispbici3;
    private String dispbiciotro;
    private String modosalida;
    private String modosalidaotro;
    private String cdedadtrab;
    private String cdslab;
    private String puesto;
    private String sugerencias;

    public CueTrabajadores(){

    }

    public CueTrabajadores(int iden, int idAeropuerto){
        this.iden = iden;
        this.idAeropuerto = idAeropuerto;
    }

    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getEnviado() {
        return enviado;
    }

    public void setEnviado(int enviado) {
        this.enviado = enviado;
    }

    public int getPregunta() {
        return pregunta;
    }

    public void setPregunta(int pregunta) {
        this.pregunta = pregunta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public int getIdAeropuerto() {
        return idAeropuerto;
    }

    public void setIdAeropuerto(int idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNencdor() {
        return nencdor;
    }

    public void setNencdor(String nencdor) {
        this.nencdor = nencdor;
    }

    public int getCdsexo() {
        return cdsexo;
    }

    public void setCdsexo(int cdsexo) {
        this.cdsexo = cdsexo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getActempre() {
        return actempre;
    }

    public void setActempre(String actempre) {
        this.actempre = actempre;
    }

    public String getActempreotro() {
        return actempreotro;
    }

    public void setActempreotro(String actempreotro) {
        this.actempreotro = actempreotro;
    }

    public String getCdlocado() {
        return cdlocado;
    }

    public void setCdlocado(String cdlocado) {
        this.cdlocado = cdlocado;
    }

    public String getDistres() {
        return distres;
    }

    public void setDistres(String distres) {
        this.distres = distres;
    }

    public String getDistresotro() {
        return distresotro;
    }

    public void setDistresotro(String distresotro) {
        this.distresotro = distresotro;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getJornadaotro() {
        return jornadaotro;
    }

    public void setJornadaotro(String jornadaotro) {
        this.jornadaotro = jornadaotro;
    }

    public String getNdiastrab() {
        return ndiastrab;
    }

    public void setNdiastrab(String ndiastrab) {
        this.ndiastrab = ndiastrab;
    }

    public int getZonatrab1() {
        return zonatrab1;
    }

    public void setZonatrab1(int zonatrab1) {
        this.zonatrab1 = zonatrab1;
    }

    public int getZonatrab2() {
        return zonatrab2;
    }

    public void setZonatrab2(int zonatrab2) {
        this.zonatrab2 = zonatrab2;
    }

    public int getZonatrab3() {
        return zonatrab3;
    }

    public void setZonatrab3(int zonatrab3) {
        this.zonatrab3 = zonatrab3;
    }

    public int getZonatrab4() {
        return zonatrab4;
    }

    public void setZonatrab4(int zonatrab4) {
        this.zonatrab4 = zonatrab4;
    }

    public int getZonatrab5() {
        return zonatrab5;
    }

    public void setZonatrab5(int zonatrab5) {
        this.zonatrab5 = zonatrab5;
    }

    public int getZonatrab6() {
        return zonatrab6;
    }

    public void setZonatrab6(int zonatrab6) {
        this.zonatrab6 = zonatrab6;
    }

    public String getHoraent1() {
        return horaent1;
    }

    public void setHoraent1(String horaent1) {
        this.horaent1 = horaent1;
    }

    public String getHorasal1() {
        return horasal1;
    }

    public void setHorasal1(String horasal1) {
        this.horasal1 = horasal1;
    }

    public String getHoraent2() {
        return horaent2;
    }

    public void setHoraent2(String horaent2) {
        this.horaent2 = horaent2;
    }

    public String getHorasal2() {
        return horasal2;
    }

    public void setHorasal2(String horasal2) {
        this.horasal2 = horasal2;
    }

    public String getHoraent3() {
        return horaent3;
    }

    public void setHoraent3(String horaent3) {
        this.horaent3 = horaent3;
    }

    public String getHorasal3() {
        return horasal3;
    }

    public void setHorasal3(String horasal3) {
        this.horasal3 = horasal3;
    }

    public String getNmodos() {
        return nmodos;
    }

    public void setNmodos(String nmodos) {
        this.nmodos = nmodos;
    }

    public String getModo1() {
        return modo1;
    }

    public void setModo1(String modo1) {
        this.modo1 = modo1;
    }

    public String getModo2() {
        return modo2;
    }

    public void setModo2(String modo2) {
        this.modo2 = modo2;
    }

    public String getUltimodo() {
        return ultimodo;
    }

    public void setUltimodo(String ultimodo) {
        this.ultimodo = ultimodo;
    }

    public String getNocucoche() {
        return nocucoche;
    }

    public void setNocucoche(String nocucoche) {
        this.nocucoche = nocucoche;
    }

    public String getSatistranspubli() {
        return satistranspubli;
    }

    public void setSatistranspubli(String satistranspubli) {
        this.satistranspubli = satistranspubli;
    }

    public String getValtranspubli1() {
        return valtranspubli1;
    }

    public void setValtranspubli1(String valtranspubli1) {
        this.valtranspubli1 = valtranspubli1;
    }

    public String getValtranspubli2() {
        return valtranspubli2;
    }

    public void setValtranspubli2(String valtranspubli2) {
        this.valtranspubli2 = valtranspubli2;
    }

    public String getValtranspubli3() {
        return valtranspubli3;
    }

    public void setValtranspubli3(String valtranspubli3) {
        this.valtranspubli3 = valtranspubli3;
    }

    public String getValtranspubliotro() {
        return valtranspubliotro;
    }

    public void setValtranspubliotro(String valtranspubliotro) {
        this.valtranspubliotro = valtranspubliotro;
    }

    public String getMejtranspubli1() {
        return mejtranspubli1;
    }

    public void setMejtranspubli1(String mejtranspubli1) {
        this.mejtranspubli1 = mejtranspubli1;
    }

    public String getMejtranspubli2() {
        return mejtranspubli2;
    }

    public void setMejtranspubli2(String mejtranspubli2) {
        this.mejtranspubli2 = mejtranspubli2;
    }

    public String getMejtranspubli3() {
        return mejtranspubli3;
    }

    public void setMejtranspubli3(String mejtranspubli3) {
        this.mejtranspubli3 = mejtranspubli3;
    }

    public String getMejtranspubliotro() {
        return mejtranspubliotro;
    }

    public void setMejtranspubliotro(String mejtranspubliotro) {
        this.mejtranspubliotro = mejtranspubliotro;
    }

    public String getDesplazatrab() {
        return desplazatrab;
    }

    public void setDesplazatrab(String desplazatrab) {
        this.desplazatrab = desplazatrab;
    }

    public String getNotranspubli1() {
        return notranspubli1;
    }

    public void setNotranspubli1(String notranspubli1) {
        this.notranspubli1 = notranspubli1;
    }

    public String getNotranspubli2() {
        return notranspubli2;
    }

    public void setNotranspubli2(String notranspubli2) {
        this.notranspubli2 = notranspubli2;
    }

    public String getNotranspubli3() {
        return notranspubli3;
    }

    public void setNotranspubli3(String notranspubli3) {
        this.notranspubli3 = notranspubli3;
    }

    public String getNotranspubliotro() {
        return notranspubliotro;
    }

    public void setNotranspubliotro(String notranspubliotro) {
        this.notranspubliotro = notranspubliotro;
    }

    public String getDisptranspubli() {
        return disptranspubli;
    }

    public void setDisptranspubli(String disptranspubli) {
        this.disptranspubli = disptranspubli;
    }

    public String getDisptranspubliotro() {
        return disptranspubliotro;
    }

    public void setDisptranspubliotro(String disptranspubliotro) {
        this.disptranspubliotro = disptranspubliotro;
    }

    public String getImportranspubli() {
        return importranspubli;
    }

    public void setImportranspubli(String importranspubli) {
        this.importranspubli = importranspubli;
    }

    public String getMedtranspubli1() {
        return medtranspubli1;
    }

    public void setMedtranspubli1(String medtranspubli1) {
        this.medtranspubli1 = medtranspubli1;
    }

    public String getMedtranspubli2() {
        return medtranspubli2;
    }

    public void setMedtranspubli2(String medtranspubli2) {
        this.medtranspubli2 = medtranspubli2;
    }

    public String getMedtranspubli3() {
        return medtranspubli3;
    }

    public void setMedtranspubli3(String medtranspubli3) {
        this.medtranspubli3 = medtranspubli3;
    }

    public String getMedtranspubliotro() {
        return medtranspubliotro;
    }

    public void setMedtranspubliotro(String medtranspubliotro) {
        this.medtranspubliotro = medtranspubliotro;
    }

    public String getTiempotranspubli() {
        return tiempotranspubli;
    }

    public void setTiempotranspubli(String tiempotranspubli) {
        this.tiempotranspubli = tiempotranspubli;
    }

    public String getAparctrab() {
        return aparctrab;
    }

    public void setAparctrab(String aparctrab) {
        this.aparctrab = aparctrab;
    }

    public String getCompartcoche1() {
        return compartcoche1;
    }

    public void setCompartcoche1(String compartcoche1) {
        this.compartcoche1 = compartcoche1;
    }

    public String getCompartcoche2() {
        return compartcoche2;
    }

    public void setCompartcoche2(String compartcoche2) {
        this.compartcoche2 = compartcoche2;
    }

    public String getCompartcoche3() {
        return compartcoche3;
    }

    public void setCompartcoche3(String compartcoche3) {
        this.compartcoche3 = compartcoche3;
    }

    public String getCompartcocheotro() {
        return compartcocheotro;
    }

    public void setCompartcocheotro(String compartcocheotro) {
        this.compartcocheotro = compartcocheotro;
    }

    public String getDispbici1() {
        return dispbici1;
    }

    public void setDispbici1(String dispbici1) {
        this.dispbici1 = dispbici1;
    }

    public String getDispbici2() {
        return dispbici2;
    }

    public void setDispbici2(String dispbici2) {
        this.dispbici2 = dispbici2;
    }

    public String getDispbici3() {
        return dispbici3;
    }

    public void setDispbici3(String dispbici3) {
        this.dispbici3 = dispbici3;
    }

    public String getDispbiciotro() {
        return dispbiciotro;
    }

    public void setDispbiciotro(String dispbiciotro) {
        this.dispbiciotro = dispbiciotro;
    }

    public String getModosalida() {
        return modosalida;
    }

    public void setModosalida(String modosalida) {
        this.modosalida = modosalida;
    }

    public String getModosalidaotro() {
        return modosalidaotro;
    }

    public void setModosalidaotro(String modosalidaotro) {
        this.modosalidaotro = modosalidaotro;
    }

    public String getCdedadtrab() {
        return cdedadtrab;
    }

    public void setCdedadtrab(String cdedadtrab) {
        this.cdedadtrab = cdedadtrab;
    }

    public String getCdslab() {
        return cdslab;
    }

    public void setCdslab(String cdslab) {
        this.cdslab = cdslab;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getSugerencias() {
        return sugerencias;
    }

    public void setSugerencias(String sugerencias) {
        this.sugerencias = sugerencias;
    }
}