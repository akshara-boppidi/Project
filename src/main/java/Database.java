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
import com.mscs710.taskmanger.StatsInfo.BasicInfo;
import com.mscs710.taskmanger.StatsInfo.IOInfo;
import com.mscs710.taskmanger.StatsInfo.NetworkInfo;
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
        String query = "INSERT INTO tblBasicInfo(PInfo_PID,PInfo_Username,PInfo_PercentageCpuUsage"
          + "PInfo_PercentageMemUsage,PI_TIME,PI_Date)"
          + "values(?,?,?,?,?,?)";
        PreparedStatement p = conn.prepareStatement(query);
        p.setInt(1, Info.getPInfo_PID());
        p.setString(2, Info.getPInfo_Username());
        p.setDouble(3, Info.getPInfo_PercentageCpuUsage());
        p.setDouble(4, Info.getPInfo_PercentageMemUsage());
        p.setString(5, Info.getPInfo_TIME());
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
   * @param networkStatList
   * @return m
   */
  public String NetworkInfo(List<NetworkInfo> networkStatList) {
   
    try {
      LOGGER.debug("Database: NetworkStats(): Starts");
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Result.db");
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:MM");
      Date date = new Date();
      String d = dateFormat.format(date);
      for (int i = 0; i < networkStatList.size(); i++) {
       NetworkInfo n = networkStatList.get(i);
       
        String query = "INSERT INTO tblNetworkInfo(NInfo_PID,NI_USER,NInfo_PROTOCOL,"
          + "NInfo_BandWidthSent,NInfo_BandWidthReceived,NInfo_STATUS,NInfo_DATE)"
          + "values(?,?,?,?,?,?,?)";
        PreparedStatement p = conn.prepareStatement(query);
        p.setInt(1, n.getNInfo_PID());
        p.setString(2, n.getNInfo_User());
        p.setString(3, n.getNInfo_Protocol());
        p.setDouble(4, n.getNInfo_BandWidthSent());
        p.setDouble(5, n.getNInfo_BandWidthReceived());
        p.setString(6, n.getNInfo_Status());
        p.setString(7, d);
        p.executeUpdate();
      }
      m = "Success";
    } catch (SQLException | ClassNotFoundException e) {
      LOGGER.error("Database: an exception Occured at NetworkStats()");
      LOGGER.error(e.getMessage());
      m = e.getMessage();
    }
    LOGGER.debug("Database: NetworkStats(): Ends");
    return m;
  }
  /**
   * IOStats
   *
   * @param iOStatsList
   * @return m
   */
  public String IOStats(List<IOInfo> iOStatsList) {
    try {
      LOGGER.debug("Database: IOStats(): Starts");
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Result.db");
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:MM");
      Date date = new Date();
      String d = dateFormat.format(date);
      for (int i = 0; i < iOStatsList.size(); i++) {
        IOInfo ioStats = iOStatsList.get(i);
       
        String query = "INSERT INTO tblIOStats(IOInfo_DISKNAME,IOInfo_TRANSFERRATEPERSEC,IOInfo_KB_READS,"
          + "IOInfo_KB_WRITES,IOInfo_BLOCKREADS,IOInfo_BLOCKWRITES,IOInfo_DATE)"
          + "values(?,?,?,?,?,?,?)";
        PreparedStatement p = conn.prepareStatement(query);
        p.setString(1, ioStats.getIOInfo_DISKNAME());
        p.setDouble(2, ioStats.getIOInfo_TRANSFERRATEPERSEC());
        p.setDouble(3, ioStats.getIOInfo_KB_READS());
        p.setDouble(4, ioStats.getIOInfo_KB_WRITES());
        p.setDouble(5, ioStats.getIOInfo_BLOCKREADS());
        p.setDouble(6, ioStats.getIOInfo_BLOCKWRITES());
        p.setString(7, d);
        p.executeUpdate();
      }
      m = "Success";
    } catch (SQLException | ClassNotFoundException e) {
      LOGGER.error("Database: an exception Occured at IOStats() ");
      LOGGER.error(e.getMessage());
      m = e.getMessage();
    }
    LOGGER.debug("Database: IOStats(): Ends");
    return m;
  }
}