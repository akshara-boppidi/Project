/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mscs710.taskmanager;

import Databaseconnectivity.Database;
import com.mscs710.taskmanager.StatsInfo.BasicInfo;
import com.mscs710.taskmanager.StatsInfo.IOInfo;
import com.mscs710.taskmanager.StatsInfo.NetworkInfo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raviteja, pooja, akshara
 */
public class InforCpu {
   Database db;
   private final static DateFormat date = new DateFormat("yyyy-mm-dd");
   private final static Logger log = LoggerFactory.getLogger(InforCpu.class);
   
   /*
   This method is used to assign a shell command and execute it at runtime  by 
   running top command to buffer the corresponding data into buffered reader 
   and display the necessary information
   */
  public List<BasicInfo> getCpu(String query) {
    LOGGER.debug("InformationOfCPU: Fetching CPU Information , getCpu() : starts");
    String status = "";
    List basicInfoList = null;
    try {
      if (query.equals("top -b")) {
        // runs thecommand in child process
        String Infocpu;
        Process childthread = Runtime.getRuntime().exec(query);
        BufferedReader entry = new BufferedReader(new InputStreamReader(childthread.getInputStream()));
        List<String> cpuStatusArray = new ArrayList();
        for (int i = 0; i < entry.read(); i++) {
          Infocpu = entry.readLine();
          cpuStatusArray.add(Infocpu);
        }
        //The information of cpu is stored in basicInfoList by splitting individually
        basicInfoList = setBasicStats(cpuStatusArray);
        db = new Database();
        status = db.saveBasicInfo(basicInfoList);
      } else {
        LOGGER.error("please enter correct shell command");
      }
      LOGGER.debug("InformationOfCPU: Fetching CPU Information , getCpu() : ends");
      return basicInfoList;
    } catch (Exception cpuinformation) {
      LOGGER.error("exception at getCpu() " + cpuinformation.getMessage());
      return null;
    }
  }

  /*
  This method helps in fetching the information stored in buffered reader and 
  seperates them with spaces. The final values are assigned to its class.
  */
   
  private List<BasicInfo> setBasicStats(List<String> array) {
    LOGGER.debug("InformationOfCPU:  setBasicStats(): Starts");
    List<BasicInfo> basicInfoList = new ArrayList<>();
    try {
        for (int i = 6; i < array.size(); i++) {
          //To eliminate spaces and seperate them with comma we use replace function 
          String value = array.get(i);
          value = value.replace(" ", ",");  value = value.replace(",,", ",");
          value = value.replace(",,", ","); value = value.replace(",,", ","); 
          value = value.replace(",,", ","); value = value.replace(",,", ",");
          value = value.replace(",,", ","); value = value.replace(",,", ",");
          String basicValues[] = value.split(",");
          BasicInfo basicInfo = new BasicInfo();
          // sets process info ID if the value matches
          for (int j = 0; j < basicValues.length; j++) {
              if (j % basicValues.length == 0) {
                  if (basicValues[0].equals("")) {
                      j = j + 1;
                  }
                  basicInfo.setBasicInfo_PID(Integer.parseInt(basicValues[j]));
              }
              // sets user if the value matches.
              if (j % basicValues.length == 1) {
                  if (basicValues[0].equals("")) {
                      j = j + 1;
                  }
                  basicInfo.setBasicInfo_Usrname(basicValues[j]);
              }
               //sets percentage of CPU used.
              if (j % basicValues.length == 2) {
                  if (basicValues[0].equals("")) {
                      j = j + 1;
                  }
                  basicInfo.setBasicInfo_PercentageCpuUsage(Double.parseDouble(basicValues[j]));
              }
              //sets precentage of memory values
              if (j % basicValues.length == 3) {
                  if (basicValues[0].equals("")) {
                      j = j + 1;
                  }
                  basicInfo.setBasicInfo_PercentageMemUsage(Double.parseDouble(basicValues[j]));
              }
              // sets time
              if (j % basicValues.length == 4) {
                  if (basicValues[0].equals("")) {
                      j = j + 1;
                  }
                  basicInfo.setBasicInfo_TIME(basicValues[j]);
              }
          }
          basicInfoList.add(basicInfo);
        }
    } catch (Exception setbasicstats) {
      LOGGER.error("exception occured" + setbasicstats.getMessage());
    }
    LOGGER.debug("Class InformationOfCPU : setBasicStats(): ends");
    return basicInfoList;
  }
  /*
  This method executes the command "netinfo -e -p -at" at the run time and 
  obtains the network information of CPU and stores it in buffered reader.
  */
   public List<NetworkInfo> networkInfo(String query) {
    LOGGER.debug("InformationOfCPU: networkInfo(): starts");
    String status = "";
    try {
      Process childthread = Runtime.getRuntime().exec(query);
      InputStream childthreadResult = childthread.getInputStream();
      // assigning child thread result to parent as a Entry.
      InputStreamReader parentEntry = new InputStreamReader(childthreadResult);
      BufferedReader readParentEntry = new BufferedReader(parentEntry);
      String Infocpu;
      // read the child process output
      List<String> networkInformation = new ArrayList();
      for (int i = 0; i < readParentEntry.read(); i++) {
        Infocpu = readParentEntry.readLine();
        networkInformation.add(Infocpu);
      }
      List networkInformationList;
      if ("netinfo -e -p -at".equals(query)) {
        networkInformationList = setNetworkInfo(networkInformation);
      } else {
        networkInformationList = setUdpNetworkInfo(networkInformantion);
      }
      db = new Database();
      status = db.saveNetworkInfo(networkInformationList);
      LOGGER.debug("InformationOfCPU : networkInfo(): ends");
      return networkInformationList;
    } catch (Exception e) {
      return null;
    }
  }
   
   /*
   This method takes the data from the buffered reader and the spaces are
   eliminated and the values are sent to the class.
   */
    private List<NetworkInfo> setNetworkInfo(List<String> array) {
    LOGGER.debug("InformationOfCPU : setNetworkInfo(): starts");
    List<NetworkInfo> networkInformationList = new ArrayList<>();
    for (int i = 6; i < array.size(); i++) {
      String value = array.get(i);
      value = value.replace(" ", ",");  value = value.replace(",,", ",");
      value = value.replace(",,", ","); value = value.replace(",,", ",");
      value = value.replace(",,", ","); value = value.replace(",,", ",");
      value = value.replace(",,", ","); value = value.replace(",,", ",");
      value = value.replace(",,", ",");
      String networkValues[] = value.split(",");
      NetworkInfo nwinfo = new NetworkInfo();
      for (int j = 0; j < networkValues.length; j++) {
        if (j % networkValues.length == 0) {
          String protocol = null;
          String query = networkValues[j];
          // coverting from cp to tcp
          if ("cp".equalsIgnoreCase(query)) {
            protocol = "tcp";
          }
          // converting from cp to tcp6
          if ("cp6".equals(query)) {
            protocol = "tcp6";
          }
          nwinfo.setNetworkInfo_Protocol(protocol);
        }
        if (j % networkValues.length == 1) {
          nwinfo.setNetworkInfo_BandWidthSent(Double.parseDouble(networkValues[j]));
        }
        if (j % networkValues.length == 2) {
          nwinfo.setNetworkInfo_BandWidthReceived(Double.parseDouble(networkValues[j]));
        }
        if (j % networkValues.length == 3) {
          nwinfo.setNetworkInfo_Status(networkValues[j]);
        }
        if (j % networkValues.length == 4) {
          nwinfo.setNetworkInfo_User(networkValues[j]);
        }
        //return values are split.
        if (j % networkValues.length == 5) {
          String dummy[] = new String[3];
          dummy[0] = networkValues[j];
          dummy = dummy[0].split("/");
          if (dummy[0].equals("-")) {
            dummy[0] = "0";
          }
          nwinfo.setNetworkInfo_PID(Integer.parseInt(dummy[0]));
        }
      }
      networkInformationList.add(nwinfo);
    }
    LOGGER.debug("CpuInfo: setNetworkStats(): ends");
    return networkInformationList;
  }
   
  /*
    This method takes the data from the buffered reader when query 
    "netstat -au -e -p" is executed at the runtime and thr spaces are
    eliminated and the values are sent to the class.
    
  */  
  private List<NetworkInfo> setUdpNetworkInfo(List<String> array) {
    LOGGER.debug("InformationOfCPU : setNetworkInfo(): starts");
    List<NetworkInfo> networkInformationList = new ArrayList<>();
    for (int i = 6; i < array.size(); i++) {
      String value = array.get(i);
      // replaces spaces with commas
      value = value.replace(" ", ",");  value = value.replace(",,", ",");
      value = value.replace(",,", ","); value = value.replace(",,", ",");
      value = value.replace(",,", ","); value = value.replace(",,", ",");
      value = value.replace(",,", ","); value = value.replace(",,", ",");
      value = value.replace(",,", ",");
      String networkValues[] = value.split(",");
      NetworkInfo nwinfo = new NetworkInfo();
      for (int j = 0; j < networkValues.length; j++) {
        if (j % networkValues.length == 0) {
          String protocol = null;
          String query = networkValues[j];
          // converting from dp to udp
          if ("dp".equalsIgnoreCase(query)) {
            protocol = "udp";
          }
          // converting from dp6 to udp6
          if ("dp6".equals(query)) {
            protocol = "udp6";
          }
          nwinfo.setNetworkInfo_Protocol(protocol);
        }
        if (j % networkValues.length == 1) {
          nwinfo.setNetworkInfo_BandWidthSent(Double.parseDouble(networkValues[j]));
        }
        if (j % networkValues.length == 2) {
          nwinfo.setNetworkInfo_BandWidthReceived(Double.parseDouble(networkValues[j]));
        }
        if (j % networkValues.length == 4) {
          nwinfo.setNetworkInfo_User(networkValues[j]);
        }
        if (j % networkValues.length == 6) {
          String dummy[] = new String[3];
          dummy[0] = networkValues[j];
          dummy = dummy[0].split("/");
          if (dummy[0].equals("-")) {
            dummy[0] = "0";
          }
          nwinfo.setNetworkInfo_PID(Integer.parseInt(dummy[0]));
        }
      }
      networkInformationList.add(nwinfo);
    }
    LOGGER.debug("InfromationOfCPU : setNetworkStats(): ends");
    return networkInformationList;
  }
  
  /*
    This method executes the query "iostat -d -N" at the runtime and
  obtains the io information of CPU and stores it in buffered reader.  
  */
  
  public List<IOInfo> iOInfo(String query) {
    LOGGER.debug("InformationOfCPU : iOInfo(): Starts ");
    String status = "";
    try {
      // query will be initiated in the childthread
      Process childthread = Runtime.getRuntime().exec(query);
      InputStream childthreadResult = childthread.getInputStream();
      // assigning child result to parent
      InputStreamReader parentEntry = new InputStreamReader(childthreadResult);
      BufferedReader readParentEntry = new BufferedReader(parentEntry);
      String Infocpu;
      // read the childthread Result
      List<String> iOInfo = new ArrayList();
      for (int i = 0; i < readParentEntry.read(); i++) {
        Infocpu = readParentEntry.readLine();
        iOInfo.add(Infocpu);
      }
      List iOInformationList = setIOInfo(iOInfo);
      db = new Database();
      status = db.saveIOInfo(iOInformationList);
      LOGGER.debug("InformationOfCPU : iOStats(): Ends ");
      return iOInformationList;
    } catch (Exception ioinfo) {
      LOGGER.error("InformationOfCPU : error at iOInfo()" + ioinfo.getMessage());
      return null;
    }
  }
  
}