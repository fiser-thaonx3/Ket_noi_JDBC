/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ket_noi_jdbc;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author nguye_000
 */
public class Ket_noi_JDBC {
    Connection con;
    public Connection getKetNoi() throws SQLException{
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ket_noi_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        con = java.sql.DriverManager.getConnection("jdbc:sqlserver://XUANTHIEN-IT:1039;databaseName=qlda", "sa", "123456 ");
        return con;
    }
    public void close(){
    if(con != null){
        try {
            if(!con.isClosed()){
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ket_noi_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Ket_noi_JDBC kn = new Ket_noi_JDBC();
        Connection con = kn.getKetNoi();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from NHANVIEN");
            while(rs.next()){
                System.out.println(rs.getString("TENNV"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ket_noi_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
