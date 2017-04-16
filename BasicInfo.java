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
    int PInfo_PID;
    String PInfo_Usrname;
    double PInfo_PercentageCpuUsage;
    double PInfo_PercentageMemUsage;
    String PInfo_TIME;
    String Date;
    
    public String getDate() {
    return Date;
  }

  public void setDate(String Date) {
    this.Date = Date;
  }
   
   /* getPInfo_TIME */
   /* setPInfo_TIME */
    
    public String getPInfo_TIME() {
        return PInfo_TIME;
    }

    public void setPInfo_TIME(String PInfo_TIME) {
        this.PInfo_TIME = PInfo_TIME;
    }    
    
    /* getPInfo_PID */
    /* setPInfo_PID */
  
    public int getPInfo_PID() {
        return PInfo_PID;
    }
    
    public void setPInfo_PID(int PInfo_PID) {
        this.PInfo_PID = PInfo_PID;
    }

    /* getPInfo_Usrname */
    /* setPInfo_Usrname */
    
    public String getPInfo_Usrname() {
        return PInfo_Usrname;
    }

   
    public void setPInfo_Usrname(String PInfo_Usrname) {
        this.PInfo_Usrname = PInfo_Usrname;
    }

    /* getPInfo_PercentageCpuUsage */
    /*setPInfo_PercentageCpuUsage*/
    
    public double getPInfo_PercentageCpuUsage() {
        return PInfo_PercentageCpuUsage;
    }
 
    public void setPInfo_PercentageCpuUsage(double PInfo_PercentageCpuUsage) {
        this.PInfo_PercentageCpuUsage = PInfo_PercentageCpuUsage;
    }

    /* getPInfo_PercentageMemUsage */
    /* setPInfo_PercentageMemUsage */
    
    public double getPInfo_PercentageMemUsage() {
        return PInfo_PercentageMemUsage;
    }
    
    public void setPInfo_PercentageMemUsage(double PInfo_PercentageMemUsage) {
        this.PInfo_PercentageMemUsage = PInfo_PercentageMemUsage;
    }
}