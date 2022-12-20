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
public class CuePasajeros implements Serializable {

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
    private int acomptes;
    private String bulgrupo;
    private String cdalojin;
    private String cdalojin_otros;
    private String cdbillet;
    private String cdcambio;
    private String cdedad;
    private String cdentrev;
    private String cdiaptod;
    private String cdiaptodotro;
    private String cdiaptoe;
    private String cdiaptof;
    private String cdiaptofotro;
    private String cdiaptoo;
    private String cdiaptoootro;
    private String cdidavue;
    private String cdlocaco;
    private String cdlocado;
    private String cdmviaje;
    private String cdociaar;
    private String cdociaarotro;
    private String cdpaisna;
    private String cdpaisnaotro;
    private String cdpaisre;
    private String cdpaisreotro;
    private int cdsexo;
    private String cdslab;
    private String cdsprof;
    private String cdterm;
    private String cdtreser;
    private int chekinb;
    private String ciaantes;
    private String ciaantesotro;
    private String comprart;
    private String conexfac;
    private String consume;
    private String estudios;
    private String fentrev;
    private int gas_com;
    private int gas_cons;
    private String hentrev;
    private String hfin;
    private String hini;
    private String hllega;
    private String idioma;
    private String modulo;
    private String motivoavion2;
    private String motivoavion2otro;
    private String nencdor;
    private int nniños;
    private String nperbul;
    private int npers;
    private String numvueca;
    private String numvuepa;
    private String nviaje;
    private String p44factu;
    private String pqfuera;
    private String prefiere;
    private String prod1;
    private String prod2;
    private String prod3;
    private String prod4;
    private String prod5;
    private String puerta;
    private String relacion;
    private String sitiopark;
    private int taus;
    private String ultimodo;
    private String ultimodootro;
    private String usoave;
    private String vien_re;
    private String vol12mes;
    private String distres;
    private String distresotro;
    private String cdsinope;
    private String cdalojen;
    private String distracce;
    private String distracceotro;
    private String nmodos;
    private String modo1;
    private String modo2;
    private int bustermi;
    private String dropoff;
    private String eleccovid;
    private String cdlocacootro;
    private int valorexp;
    private String empresa;
    private String empresaotro;
    private String cdlocadootro;
    private String destino;
    private String destinootro;
    private String cia;
    private String ciaotro;
    private String hllegabus;
    private String hsaleavion;
    private String bustransfer;
    private String entautobus;
    private String desautobus;
    private String hsalebus;
    private String seccion;
    private String modo;
    private String modootro;
    private String numcomp;
    private String numbus;
    private String numdarsena;

    public CuePasajeros(){

    }

    public CuePasajeros(int iden){
        this.iden = iden;
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

    public int getAcomptes() {
        return acomptes;
    }

    public void setAcomptes(int acomptes) {
        this.acomptes = acomptes;
    }

    public String getBulgrupo() {
        return bulgrupo;
    }

    public void setBulgrupo(String bulgrupo) {
        this.bulgrupo = bulgrupo;
    }

    public String getCdalojin() {
        return cdalojin;
    }

    public void setCdalojin(String cdalojin) {
        this.cdalojin = cdalojin;
    }

    public String getCdalojin_otros() {
        return cdalojin_otros;
    }

    public void setCdalojin_otros(String cdalojin_otros) {
        this.cdalojin_otros = cdalojin_otros;
    }

    public String getCdbillet() {
        return cdbillet;
    }

    public void setCdbillet(String cdbillet) {
        this.cdbillet = cdbillet;
    }

    public String getCdcambio() {
        return cdcambio;
    }

    public void setCdcambio(String cdcambio) {
        this.cdcambio = cdcambio;
    }

    public String getCdedad() {
        return cdedad;
    }

    public void setCdedad(String cdedad) {
        this.cdedad = cdedad;
    }

    public String getCdentrev() {
        return cdentrev;
    }

    public void setCdentrev(String cdentrev) {
        this.cdentrev = cdentrev;
    }

    public String getCdiaptod() {
        return cdiaptod;
    }

    public void setCdiaptod(String cdiaptod) {
        this.cdiaptod = cdiaptod;
    }

    public String getCdiaptodotro() { return cdiaptodotro; }

    public void setCdiaptodotro(String cdiaptodotro) { this.cdiaptodotro = cdiaptodotro; }

    public String getCdiaptoe() {
        return cdiaptoe;
    }

    public void setCdiaptoe(String cdiaptoe) {
        this.cdiaptoe = cdiaptoe;
    }

    public String getCdiaptof() {
        return cdiaptof;
    }

    public void setCdiaptof(String cdiaptof) {
        this.cdiaptof = cdiaptof;
    }

    public String getCdiaptofotro() {
        return cdiaptofotro;
    }

    public void setCdiaptofotro(String cdiaptofotro) {
        this.cdiaptofotro = cdiaptofotro;
    }

    public String getCdiaptoo() {
        return cdiaptoo;
    }

    public void setCdiaptoo(String cdiaptoo) {
        this.cdiaptoo = cdiaptoo;
    }

    public String getCdiaptoootro() { return cdiaptoootro; }

    public void setCdiaptoootro(String cdiaptoootro) { this.cdiaptoootro = cdiaptoootro; }

    public String getCdidavue() {
        return cdidavue;
    }

    public void setCdidavue(String cdidavue) {
        this.cdidavue = cdidavue;
    }

    public String getCdlocaco() {
        return cdlocaco;
    }

    public void setCdlocaco(String cdlocaco) {
        this.cdlocaco = cdlocaco;
    }

    public String getCdlocado() {
        return cdlocado;
    }

    public void setCdlocado(String cdlocado) {
        this.cdlocado = cdlocado;
    }

    public String getCdlocacootro() {
        return cdlocacootro;
    }

    public void setCdlocacootro(String cdlocacootro) {
        this.cdlocacootro = cdlocacootro;
    }

    public String getCdmviaje() {
        return cdmviaje;
    }

    public void setCdmviaje(String cdmviaje) {
        this.cdmviaje = cdmviaje;
    }

    public String getCdociaar() {
        return cdociaar;
    }

    public void setCdociaar(String cdociaar) {
        this.cdociaar = cdociaar;
    }

    public String getCdociaarotro() { return cdociaarotro; }

    public void setCdociaarotro(String cdociaarotro) { this.cdociaarotro = cdociaarotro; }

    public String getCdpaisna() {
        return cdpaisna;
    }

    public void setCdpaisna(String cdpaisna) {
        this.cdpaisna = cdpaisna;
    }

    public String getCdpaisre() {
        return cdpaisre;
    }

    public void setCdpaisre(String cdpaisre) {
        this.cdpaisre = cdpaisre;
    }

    public int getCdsexo() {
        return cdsexo;
    }

    public void setCdsexo(int cdsexo) {
        this.cdsexo = cdsexo;
    }

    public String getCdslab() {
        return cdslab;
    }

    public void setCdslab(String cdslab) {
        this.cdslab = cdslab;
    }

    public String getCdsprof() {
        return cdsprof;
    }

    public void setCdsprof(String cdsprof) {
        this.cdsprof = cdsprof;
    }

    public String getCdterm() {
        return cdterm;
    }

    public void setCdterm(String cdterm) {
        this.cdterm = cdterm;
    }

    public String getCdtreser() {
        return cdtreser;
    }

    public void setCdtreser(String cdtreser) {
        this.cdtreser = cdtreser;
    }

    public int getChekinb() {
        return chekinb;
    }

    public void setChekinb(int chekinb) {
        this.chekinb = chekinb;
    }

    public String getCiaantes() {
        return ciaantes;
    }

    public void setCiaantes(String ciaantes) {
        this.ciaantes = ciaantes;
    }

    public String getCiaantesotro() { return ciaantesotro; }

    public void setCiaantesotro(String ciaantesotro) { this.ciaantesotro = ciaantesotro; }

    public String getComprart() {
        return comprart;
    }

    public void setComprart(String comprart) {
        this.comprart = comprart;
    }

    public String getConexfac() {
        return conexfac;
    }

    public void setConexfac(String conexfac) {
        this.conexfac = conexfac;
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getFentrev() {
        return fentrev;
    }

    public void setFentrev(String fentrev) {
        this.fentrev = fentrev;
    }

    public int getGas_com() {
        return gas_com;
    }

    public void setGas_com(int gas_com) {
        this.gas_com = gas_com;
    }

    public int getGas_cons() {
        return gas_cons;
    }

    public void setGas_cons(int gas_cons) {
        this.gas_cons = gas_cons;
    }

    public String getHentrev() {
        return hentrev;
    }

    public void setHentrev(String hentrev) {
        this.hentrev = hentrev;
    }

    public String getHfin() {
        return hfin;
    }

    public void setHfin(String hfin) {
        this.hfin = hfin;
    }

    public String getHini() {
        return hini;
    }

    public void setHini(String hini) {
        this.hini = hini;
    }

    public String getHllega() {
        return hllega;
    }

    public void setHllega(String hllega) {
        this.hllega = hllega;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getMotivoavion2() {
        return motivoavion2;
    }

    public void setMotivoavion2(String motivoavion2) {
        this.motivoavion2 = motivoavion2;
    }

    public String getMotivoavion2otro() {
        return motivoavion2otro;
    }

    public void setMotivoavion2otro(String motivoavion2otro) {
        this.motivoavion2otro = motivoavion2otro;
    }

    public String  getNencdor() {
        return nencdor;
    }

    public void setNencdor(String nencdor) {
        this.nencdor = nencdor;
    }

    public int getNniños() {
        return nniños;
    }

    public void setNniños(int nniños) {
        this.nniños = nniños;
    }

    public String getNperbul() {
        return nperbul;
    }

    public void setNperbul(String nperbul) {
        this.nperbul = nperbul;
    }

    public int getNpers() {
        return npers;
    }

    public void setNpers(int npers) {
        this.npers = npers;
    }

    public String getNumvueca() {
        return numvueca;
    }

    public void setNumvueca(String numvueca) {
        this.numvueca = numvueca;
    }

    public String getNumvuepa() {
        return numvuepa;
    }

    public void setNumvuepa(String numvuepa) {
        this.numvuepa = numvuepa;
    }

    public String getNviaje() {
        return nviaje;
    }

    public void setNviaje(String nviaje) {
        this.nviaje = nviaje;
    }

    public String getP44factu() {
        return p44factu;
    }

    public void setP44factu(String p44factu) {
        this.p44factu = p44factu;
    }

    public String getPqfuera() {
        return pqfuera;
    }

    public void setPqfuera(String pqfuera) {
        this.pqfuera = pqfuera;
    }

    public String getPrefiere() {
        return prefiere;
    }

    public void setPrefiere(String prefiere) {
        this.prefiere = prefiere;
    }

    public String getProd1() {
        return prod1;
    }

    public void setProd1(String prod1) {
        this.prod1 = prod1;
    }

    public String getProd2() {
        return prod2;
    }

    public void setProd2(String prod2) {
        this.prod2 = prod2;
    }

    public String getProd3() {
        return prod3;
    }

    public void setProd3(String prod3) {
        this.prod3 = prod3;
    }

    public String getProd4() {
        return prod4;
    }

    public void setProd4(String prod4) {
        this.prod4 = prod4;
    }

    public String getProd5() {
        return prod5;
    }

    public void setProd5(String prod5) {
        this.prod5 = prod5;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getSitiopark() {
        return sitiopark;
    }

    public void setSitiopark(String sitiopark) {
        this.sitiopark = sitiopark;
    }

    public int getTaus() {
        return taus;
    }

    public void setTaus(int taus) {
        this.taus = taus;
    }

    public String getUltimodo() {
        return ultimodo;
    }

    public void setUltimodo(String ultimodo) {
        this.ultimodo = ultimodo;
    }

    public String getUltimodootro() {
        return ultimodootro;
    }

    public void setUltimodootro(String ultimodootro) {
        this.ultimodootro = ultimodootro;
    }

    public String getUsoave() {
        return usoave;
    }

    public void setUsoave(String usoave) {
        this.usoave = usoave;
    }

    public String getVien_re() {
        return vien_re;
    }

    public void setVien_re(String vien_re) {
        this.vien_re = vien_re;
    }

    public String getVol12mes() {
        return vol12mes;
    }

    public void setVol12mes(String vol12mes) {
        this.vol12mes = vol12mes;
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

    public String getCdsinope() {
        return cdsinope;
    }

    public void setCdsinope(String cdsinope) {
        this.cdsinope = cdsinope;
    }

    public String getCdalojen() {
        return cdalojen;
    }

    public void setCdalojen(String cdalojen) {
        this.cdalojen = cdalojen;
    }

    public String getDistracce() {
        return distracce;
    }

    public void setDistracce(String distracce) {
        this.distracce = distracce;
    }

    public String getDistracceotro() {
        return distracceotro;
    }

    public void setDistracceotro(String distracceotro) { this.distracceotro = distracceotro; }

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

    public int getBustermi() {
        return bustermi;
    }

    public void setBustermi(int bustermi) {
        this.bustermi = bustermi;
    }

    public String getDropoff() {
        return dropoff;
    }

    public void setDropoff(String dropoff) {
        this.dropoff = dropoff;
    }

    public String getEleccovid() {
        return eleccovid;
    }

    public void setEleccovid(String eleccovid) {
        this.eleccovid = eleccovid;
    }

    public int getValorexp() { return valorexp; }

    public void setValorexp(int valorexp) { this.valorexp = valorexp; }

    public String getCdpaisnaotro() {
        return cdpaisnaotro;
    }

    public void setCdpaisnaotro(String cdpaisnaotro) {
        this.cdpaisnaotro = cdpaisnaotro;
    }

    public String getCdpaisreotro() {
        return cdpaisreotro;
    }

    public void setCdpaisreotro(String cdpaisreotro) {
        this.cdpaisreotro = cdpaisreotro;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresaotro() {
        return empresaotro;
    }

    public void setEmpresaotro(String empresaotro) {
        this.empresaotro = empresaotro;
    }

    public String getCdlocadootro() {
        return cdlocadootro;
    }

    public void setCdlocadootro(String cdlocadootro) {
        this.cdlocadootro = cdlocadootro;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestinootro() {
        return destinootro;
    }

    public void setDestinootro(String destinootro) {
        this.destinootro = destinootro;
    }

    public String getCia() {
        return cia;
    }

    public void setCia(String cia) {
        this.cia = cia;
    }

    public String getCiaotro() {
        return ciaotro;
    }

    public void setCiaotro(String ciaotro) {
        this.ciaotro = ciaotro;
    }

    public String getHllegabus() {
        return hllegabus;
    }

    public void setHllegabus(String hllegabus) {
        this.hllegabus = hllegabus;
    }

    public String getHsaleavion() {
        return hsaleavion;
    }

    public void setHsaleavion(String hsaleavion) {
        this.hsaleavion = hsaleavion;
    }

    public String getBustransfer() {
        return bustransfer;
    }

    public void setBustransfer(String bustransfer) {
        this.bustransfer = bustransfer;
    }

    public String getEntautobus() {
        return entautobus;
    }

    public void setEntautobus(String entautobus) {
        this.entautobus = entautobus;
    }

    public String getDesautobus() {
        return desautobus;
    }

    public void setDesautobus(String desautobus) {
        this.desautobus = desautobus;
    }

    public String getHsalebus() {
        return hsalebus;
    }

    public void setHsalebus(String hsalebus) {
        this.hsalebus = hsalebus;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getModootro() {
        return modootro;
    }

    public void setModootro(String modootro) {
        this.modootro = modootro;
    }

    public String getNumcomp() {
        return numcomp;
    }

    public void setNumcomp(String numcomp) {
        this.numcomp = numcomp;
    }

    public String getNumbus() {
        return numbus;
    }

    public void setNumbus(String numbus) {
        this.numbus = numbus;
    }

    public String getNumdarsena() {
        return numdarsena;
    }

    public void setNumdarsena(String numdarsena) {
        this.numdarsena = numdarsena;
    }
    
}