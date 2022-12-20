package eu.teys.aenaemma2022.utilidades;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;


/**
 *
 * @author DSGregorio
 */
public class SQLconnection {
    private String user;
    private String password;
    private String db;
    private String host;
    private String url;
    private Connection conn = null;
    private Statement stm;
    private ResultSet rs;

    public SQLconnection(){
        this.url = "jdbc:sqlserver://" + this.host + "/" + this.db;
    }

    public SQLconnection (String server, String usuario, String contraseña, String bd){
        this.user = usuario;
        this.password = contraseña;
        this.db = bd;
        this.host = server;
        this.url = "jdbc:sqlserver://" + this.host + ";databaseName=" + this.db;
    }

    public void connectar() throws ClassNotFoundException, SQLException{

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(url, user, password);
        if (conn != null)
        {
            System.out.println("Conexión a base de datos "+url+" … Ok");
            stm = conn.createStatement();
        }
    }

    public void desconectar () throws SQLException{
        stm.close();
        conn.close();
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Connection getconn() {
        return conn;
    }

    public ResultSet getResultSet(){
        return rs;
    }

    public void setResultSet(ResultSet rs){
        this.rs = rs;
    }

    public ResultSet consultar(String sentenciaSQL) throws SQLException{
        rs = stm.executeQuery(sentenciaSQL);
        return rs;
    }

    public boolean ejecutar(String sentenciaSQL) throws SQLException{
        return stm.execute(sentenciaSQL);
    }

    public int ejecutarUpdate(String sentenciaSQL) throws SQLException{
        return stm.executeUpdate(sentenciaSQL);
    }

}
