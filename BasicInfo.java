/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mscs710.taskmanager.StatsInfo;

/**
 *
 * @author raviteja, pooja, akshara
 */
public class BasicInfo {
    int BasicInfo_PID;
    String BasicInfo_Usrname;
    double BasicInfo_PercentageCpuUsage;
    double BasicInfo_PercentageMemUsage;
    String BasicInfo_TIME;
    String Date;
    
    public String getDate() {
    return Date;
  }

  public void setDate(String Date) {
    this.Date = Date;
  }
   
   /* getBasicInfo_TIME */
   /* setBasicInfo_TIME */
    
    public String getBasicInfo_TIME() {
        return BasicInfo_TIME;
    }

    public void setBasicInfo_TIME(String BasicInfo_TIME) {
        this.BasicInfo_TIME = BasicInfo_TIME;
    }    
    
    /* getBasicInfo_PID */
    /* setBasicInfo_PID */
  
    public int getBasicInfo_PID() {
        return BasicInfo_PID;
    }
    
    public void setBasicInfo_PID(int BasicInfo_PID) {
        this.BasicInfo_PID = BasicInfo_PID;
    }

    /* getBasicInfo_Usrname */
    /* setBasicInfo_Usrname */
    
    public String getBasicInfo_Usrname() {
        return BasicInfo_Usrname;
    }

   
    public void setBasicInfo_Usrname(String BasicInfo_Usrname) {
        this.BasicInfo_Usrname = BasicInfo_Usrname;
    }

    /* getBasicInfo_PercentageCpuUsage */
    /*setBasicInfo_PercentageCpuUsage*/
    
    public double getBasicInfo_PercentageCpuUsage() {
        return BasicInfo_PercentageCpuUsage;
    }
 
    public void setBasicInfo_PercentageCpuUsage(double BasicInfo_PercentageCpuUsage) {
        this.BasicInfo_PercentageCpuUsage = BasicInfo_PercentageCpuUsage;
    }

    /* getBasicInfo_PercentageMemUsage */
    /* setBasicInfo_PercentageMemUsage */
    
    public double getBasicInfo_PercentageMemUsage() {
        return BasicInfo_PercentageMemUsage;
    }
    
    public void setBasicInfo_PercentageMemUsage(double BasicInfo_PercentageMemUsage) {
        this.BasicInfo_PercentageMemUsage = BasicInfo_PercentageMemUsage;
    }
}