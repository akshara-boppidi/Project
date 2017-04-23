/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mscs710.taskmanager;

import Databaseconnectivity.Database;
import com.mscs710.taskmanager.StatsInfo.BasicInfo;
import java.io.BufferedReader;
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
   
   
  public List<BasicInfo> getCpu(String cmd) {
    LOGGER.debug("InformationCPU: Fetching CPU Information , getCpu() : starts");
    String status = "";
    List basicInfoList = null;
    try {
      if (cmd.equals("top -b")) {
        // start up the command in child process
        Process child = Runtime.getRuntime().exec(cmd);
        BufferedReader input = new BufferedReader(new InputStreamReader(child.getInputStream()));
        String Infocpu;
        List<String> cpuStatArray = new ArrayList();
        for (int i = 0; i < input.read(); i++) {
          Infocpu = input.readLine();
          cpuStatArray.add(Infocpu);
        }
        //The information of cpu is stored in basicInfoList by splitting individually
        basicInfoList = setProcessStats(cpuStatArray);
        db = new Database();
        status = db.saveBasicInfo(basicInfoList);
      } else {
        LOGGER.error("please enter correct shell command");
      }
      LOGGER.debug("InformationCPU: Fetching CPU Information , getCpu() : ends");
      return basicInfoList;
    } catch (Exception cpuinfo) {
      LOGGER.error("exception at getCpu() " + cpuinfo.getMessage());
      return null;
    }
  }

    private List setProcessStats(List<String> cpuStatArray) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
