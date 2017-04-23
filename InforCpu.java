/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mscs710.taskmanager;

import Databaseconnectivity.Database;
import com.mscs710.taskmanager.StatsInfo.BasicInfo;
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
    LOGGER.debug("InformationCPU: Fetching CPU Information , getCpu() : starts");
    String status = "";
    List basicInfoList = null;
    try {
      if (query.equals("top -b")) {
        // start up the command in child process
        String Infocpu;
        Process childthread = Runtime.getRuntime().exec(query);
        BufferedReader input = new BufferedReader(new InputStreamReader(childthread.getInputStream()));
        
        List<String> cpuStatusArray = new ArrayList();
        for (int i = 0; i < input.read(); i++) {
          Infocpu = input.readLine();
          cpuStatusArray.add(Infocpu);
        }
        //The information of cpu is stored in basicInfoList by splitting individually
        basicInfoList = setBasicStats(cpuStatusArray);
        db = new Database();
        status = db.saveBasicInfo(basicInfoList);
      } else {
        LOGGER.error("please enter correct shell command");
      }
      LOGGER.debug("InformationCPU: Fetching CPU Information , getCpu() : ends");
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
    LOGGER.debug("CpuInfo:  setBasicStats(): Starts");
    List<BasicInfo> basicInfoList = new ArrayList<>();
    try {
        for (int i = 6; i < array.size(); i++) {
          //To eliminate spaces and seperate them with comma we use replace function 
          String val = array.get(i);
          val = val.replace(" ", ",");  val = val.replace(",,", ",");
          val = val.replace(",,", ","); val = val.replace(",,", ","); 
          val = val.replace(",,", ","); val = val.replace(",,", ",");
          val = val.replace(",,", ","); val = val.replace(",,", ",");
          String basicValues[] = val.split(",");
          BasicInfo basicInfo = new BasicInfo();
          // sets process info ID if the value matches
          for (int j = 0; j < basicValues.length; j++) {
              if (j % basicValues.length == 0) {
                  if (basicValues[0].equals("")) {
                      j = j + 1;
                  }
                  basicInfo.setPInfo_PID(Integer.parseInt(basicValues[j]));
              }
              // sets user if the value matches.
              if (j % basicValues.length == 1) {
                  if (basicValues[0].equals("")) {
                      j = j + 1;
                  }
                  basicInfo.setPInfo_Usrname(basicValues[j]);
              }
               //sets percentage of CPU used.
              if (j % basicValues.length == 2) {
                  if (basicValues[0].equals("")) {
                      j = j + 1;
                  }
                  basicInfo.setPInfo_PercentageCpuUsage(Double.parseDouble(basicValues[j]));
              }
              //sets precentage of memory values
              if (j % basicValues.length == 3) {
                  if (basicValues[0].equals("")) {
                      j = j + 1;
                  }
                  basicInfo.setPInfo_PercentageMemUsage(Double.parseDouble(basicValues[j]));
              }
              // sets time
              if (j % basicValues.length == 4) {
                  if (basicValues[0].equals("")) {
                      j = j + 1;
                  }
                  basicInfo.setPInfo_TIME(basicValues[j]);
              }
          }
          basicInfoList.add(basicInfo);
        }
    } catch (Exception setbasicstats) {
      LOGGER.error("exception occured" + setprocessstats.getMessage());
    }
    LOGGER.debug("Class Informationcpu: setBasicStats(): ends");
    return basicInfoList;
  }
  
   public List<NetworkInfo> networkStats(String query) {
    LOGGER.debug("CpuInformation: networkInfo(): starts");
    String status = "";
   return null;
  }
   
}