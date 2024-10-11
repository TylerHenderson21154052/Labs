/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task01_1;

import java.net.URL;
import java.sql.*;

/**
 *
 * @author Weihua Li
 */
public class HelloWorld {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World");
        
        //create a Students instance
        Students s1 = new Students("Leo", 30);
        System.out.println("Student Name: " + s1.getName());
        
        
        String URL = "jdbc:derby:DatabaseTest;create=true";
        
        Connection conn = DriverManager.getConnection(URL, "username", "password");
        
        Statement stmt = conn.createStatement();
        
        stmt.executeUpdate("CREATE TABLE Sample (ID INT PRIMARY KEY, Name VARCHAR(30))");
        
    }

}
