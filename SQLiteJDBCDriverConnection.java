/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.metricscollector;
import java.sql.Connection;     //Contains connection menthod required by JDBC.
import java.sql.DriverManager; //Manages a set of JDBC drivers.
import java.sql.SQLException;   // Catches Exceptions both in Driver and Database.
/**
 *
 * @author akshara,pooja,raja
 */
public class SQLiteJDBCDriverConnection { 
    /**
    * Connecting to a database
    */
   public static void connect() {
       Connection connection = null;
       try {
           /** Constructing the URL string to establish connection to the database(SQLite)
            * by providing type of JDBC and the database path.
            */
           String url = "jdbc:sqlite:C:/Users/akshara/Documents/project/MetricsCollector/testconnect.db";
           // create a connection to the database
           connection = DriverManager.getConnection(url);
           
           System.out.println("Successfully connected to SQLite");
           
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       } finally {
           try {
               if (connection != null) {
                   connection.close();
               }
           } catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }
   }
   public static void main(String[] args) {
   connect();    
   }
}
