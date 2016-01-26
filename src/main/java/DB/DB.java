/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.util.logging.Logger;
import java.sql.*;
import java.util.logging.Level;

/**
 *
 * @author c0663919
 */
public class DB {

    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        String name = "db";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
        Connection con =DriverManager.getConnection(url, username, password);
        return con;

    }

    public static String getTable() {
        String output = "";
            Connection conn;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();//    
            ResultSet rs = stmt.executeQuery("select * from people");
            while (rs.next()) {
            output +="<h2>"+rs.getString("name")+"<h2>";
            output +="<h2>"+rs.getString("bio")+"<h2>";
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return output;
        

    }

}
