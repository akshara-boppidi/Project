/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package project.metricscollector;
import java.sql.Connection;
import java.sql.DatabaseMetaData; //Provides information about database.
import java.sql.DriverManager;
import java.sql.SQLException;
/**
*
* @author raviteja, pooja, akshara
*/
public class createdatabase {
   /**
   * Connecting to a database
   *
   * @param firstDB the database file name
   */
  public static void createNewDatabase(String firstDB) {

      String url = "jdbc:sqlite:C:/Users/Pooja/Documents/NetBeansProjects/" + firstDB;

      try (Connection connection = DriverManager.getConnection(url)) {
          if (connection != null) {
              DatabaseMetaData meta = connection.getMetaData();
              System.out.println("The driver name is " + meta.getDriverName());
              System.out.println("Database has been created successfully");
          }

      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }

public static void main(String[] args) {
      createNewDatabase("test.db");
  }
   
}