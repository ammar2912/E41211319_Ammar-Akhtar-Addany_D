/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r.a.c._pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author ammar
 */
public class Config {
 private static Connection mysqlconfig;
    public static Connection configDB()throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:/r.a.c._pos"; // Url database
            String user = "root"; // user database
            String pass = ""; // password database
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println("Koneksi Gagal " + e.getMessage());
        } 
        return mysqlconfig;
    } 
    public static boolean isConnected() {
        try {
            Config.configDB();
            System.out.println("Database terkoneksi");
            return true;
        } catch (Exception e) {
           java.util.logging.Logger.getLogger(Config.class.getName()).log(Level.SEVERE,null,e);
           System.err.println("Koneksi gagal");
           return false;
        }
    }
    public static void main(String[] args) {
       System.out.println("Cek");
       if (true) {
           new login().setVisible(true);
       } 
       isConnected();
    }   
}
