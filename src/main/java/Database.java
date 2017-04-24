/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Databaseconnectivity;
/**
 *
 * @author raviteja, pooja, akshara
 */

import com.mscs710.taskmanager.StatsInfo.BasicInfo;
import com.mscs710.taskmanager.StatsInfo.NetworkInfo;
import com.mscs710.taskmanager.StatsInfo.IOInfo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Database {
 private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);
 private static Connection conn;
 private static Statement s;
 private String m = "";
 
 /** 
  * To save the metrics
  */
 
  public static void Store() {
    LOGGER.debug("Database: Store(): Starts");
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Result.db");
      String url = "jdbc:sqlite:C:/Users/akshara/Documents/project/MetricsCollector/CreateTable.sql";
      s = conn.createStatement();
      boolean executeDB;
      executeDB = executeDB(url, s);
    } 
    catch (ClassNotFoundException | SQLException | IOException e) {
      LOGGER.error(e.getClass().getName() + ": " + e.getMessage());
      LOGGER.error("Database: exception occured at Store() " + e.getMessage());
    }
    LOGGER.info("Database: Opened database successfully");
    LOGGER.debug("Database: Store(): Ends");
  }
   /**
   * To execute DB
   **/
private static boolean executeDB(String SQLFilePath, Statement s)
    throws IOException, SQLException {
    LOGGER.debug("Database: executeDB(): Starts");
    boolean SqlExecuted = false;
    try {
        StringBuilder sb;
        try (BufferedReader in = new BufferedReader(new FileReader(SQLFilePath))) {
            String a;
            sb = new StringBuilder();
            while ((a = in.readLine()) != null) {
                sb.append(a).append("\n ");
            } }
      int i = s.executeUpdate(sb.toString());
      SqlExecuted = true;
    }
    catch (IOException | SQLException e) {
      LOGGER.error("Database: Failed to Execute" + SQLFilePath + ". The error is" + e.getMessage());
    }
    LOGGER.debug("Database: executeDB(): Ends");
    return SqlExecuted;
    }
 /**
   * BASIC INFO
   *
   * @param InfoList
   * @return m
   */
  public String basicInfo(List<BasicInfo> InfoList) {
    try {
      LOGGER.debug("Database: basicInfo(): Starts");
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Result.db");
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:MM");
      Date date = new Date();
      String d = dateFormat.format(date);
      for (int i = 0; i < InfoList.size(); i++) {
        BasicInfo Info = InfoList.get(i);
        String query = "INSERT INTO tblBasicInfo(BasicInfo_PID,BasicInfo_Username,BasicInfo_PercentageCpuUsage"
          + "BasicInfo_PercentageMemUsage,PI_TIME,PI_Date)"
          + "values(?,?,?,?,?,?)";
        PreparedStatement p = conn.prepareStatement(query);
        p.setInt(1, Info.getBasicInfo_PID());
        p.setString(2, Info.getBasicInfo_Username());
        p.setDouble(3, Info.getBasicInfo_PercentageCpuUsage());
        p.setDouble(4, Info.getBasicInfo_PercentageMemUsage());
        p.setString(5, Info.getBasicInfo_TIME());
        p.setString(6, d);
        p.executeUpdate();
      }
      m = "Success";
    } catch (SQLException | ClassNotFoundException e) {
      LOGGER.error("Database: an exception Occured at BasicInfo()");
      LOGGER.error(e.getMessage());
      m = e.getMessage();
    }
    LOGGER.debug("Database: BasicInfo(): Ends");
    return m;
  }
   /**
   *  NetworkStats
   *
     * @param networkInformationtList
   * @return m
   */
  public String NetworkInfo(List<NetworkInfo> networkInformationtList) {
   
    try {
      LOGGER.debug("Database: NetworkInfo(): Starts");
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Result.db");
      SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd HH:MM");
      Date newdate = new Date();
      String d = date.format(newdate);
      for (int i = 0; i < networkInformationtList.size(); i++) {
       NetworkInfo n = networkInformationtList.get(i);
       
        String query = "INSERT INTO tblNetworkInfo(NetworkInfo_PID,NetworkInfo_USER,NetworkInfo_Protocol,"
          + "NetworkInfo_BandWidthSent,NetworkInfo_BandWidthReceived,NetworkInfo_Status,NetworkInfo_DATE)"
          + "values(?,?,?,?,?,?,?)";
        PreparedStatement p = conn.prepareStatement(query);
        p.setInt(1, n.getNetworkInfo_PID());
        p.setString(2, n.getNetworkInfo_User());
        p.setString(3, n.getNetworkInfo_Protocol());
        p.setDouble(4, n.getNetworkInfo_BandWidthSent());
        p.setDouble(5, n.getNetworkInfo_BandWidthReceived());
        p.setString(6, n.getNetworkInfo_Status());
        p.setString(7, d);
        p.executeUpdate();
      }
      m = "Success";
    } catch (SQLException | ClassNotFoundException e) {
      LOGGER.error("Database: an error Occured at NetworkInfo()");
      LOGGER.error(e.getMessage());
      m = e.getMessage();
    }
    LOGGER.debug("Database: NetworkInfo(): Ends");
    return m;
  }
  /**
   * IOInfo
   *
   * @param ioInformationList
   * @return m
   */
  public String IOInfo(List<IOInfo> ioInformationList) {
    try {
      LOGGER.debug("Database: IOInfo(): Starts");
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Result.db");
      SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd HH:MM");
      Date newdate = new Date();
      String d = date.format(newdate);
      for (int i = 0; i < ioInformationList.size(); i++) {
        IOInfo ioInfo = ioInformationList.get(i);
       
        String query = "INSERT INTO tblIOInfo(IOInformation_DISKNAME,IOInformation_TRANSFERRATEPERSEC,IOInformation_KB_READS,"
          + "IOInformation_KB_WRITES,IOInformation_BLOCKREADS,IOInformation_BLOCKWRITES,IOInformation_DATE)"
          + "values(?,?,?,?,?,?,?)";
        PreparedStatement p = conn.prepareStatement(query);
        p.setString(1, ioInfo.getIOInformation_DISKNAME());
        p.setDouble(2, ioInfo.getIOInformation_TRANSFERRATEPERSEC());
        p.setDouble(3, ioInfo.getIOInformation_KB_READS());
        p.setDouble(4, ioInfo.getIOInformation_KB_WRITES());
        p.setDouble(5, ioInfo.getIOInformation_BLOCKREADS());
        p.setDouble(6, ioInfo.getIOInformation_BLOCKWRITES());
        p.setString(7, d);
        p.executeUpdate();
      }
      m = "Success";
    } catch (SQLException | ClassNotFoundException e) {
      LOGGER.error("Database: an error Occured at IOInfo() ");
      LOGGER.error(e.getMessage());
      m = e.getMessage();
    }
    LOGGER.debug("Database: IOInfo(): Ends");
    return m;
  }
    public String saveBasicInfo(List basicInfoList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}