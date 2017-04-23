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
public class NetworkInfo {

    int    NetworkInfo_PID;
    String NetworkInfo_User;
    String NetworkInfo_Protocol;
    double NetworkInfo_BandWidthSent;
    double NetworkInfo_BandWidthReceived;
    String NetworkInfo_Status;

    /* getNetworkInfo_Protocol */
    /* setNetworkInfo_Protocol*/
    
    public String getNetworkInfo_Protocol() {
        return NetworkInfo_Protocol;
    }
    
    public void setNetworkInfo_Protocol(String NetworkInfo_Protocol) {
        this.NetworkInfo_Protocol = NetworkInfo_Protocol;
    }

    /* getNetworkInfo_PID */
    /* setNetworkInfo_PID */
    
    public int getNetworkInfo_PID() {
        return NetworkInfo_PID;
    }

    public void setNetworkInfo_PID(int NetworkInfo_PID) {
        this.NetworkInfo_PID = NetworkInfo_PID;
    }

    /* getNetworkInfo_User */
    /* setNetworkInfo_User */
    
    public String getNetworkInfo_User() {
        return NetworkInfo_User;
    }
    
    public void setNetworkInfo_User(String NetworkInfo_User) {
        this.NetworkInfo_User = NetworkInfo_User;
    }

    /* getNetworkInfo_BandWidthSent */
    /* setNetworkInfo_BandWidthSent */
    
    public double getNetworkInfo_BandWidthSent() {
        return NetworkInfo_BandWidthSent;
    }
    
    public void setNetworkInfo_BandWidthSent(double NetworkInfo_BandWidthSent) {
        this.NetworkInfo_BandWidthSent = NetworkInfo_BandWidthSent;
    }

    /* getNetworkInfo_BandWidthReceived */
    /* setNetworkInfo_BandWidthReceived */
    
    public double getNetworkInfo_BandWidthReceived() {
        return NetworkInfo_BandWidthReceived;
    }
    
    public void setNetworkInfo_BandWidthReceived(double NetworkInfo_BandWidthReceived) {
        this.NetworkInfo_BandWidthReceived = NetworkInfo_BandWidthReceived;
    }

    /* getNetworkInfo_Status */
    /* setNetworkInfo_Status */
    
    public String getNetworkInfo_Status() {
        return NetworkInfo_Status;
    }
    
    public void setNetworkInfo_Status(String NetworkInfo_Status) {
        this.NetworkInfo_Status = NetworkInfo_Status;
    }

    
}
