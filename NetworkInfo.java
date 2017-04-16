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

    int    NInfo_PID;
    String NInfo_User;
    String NInfo_Protocol;
    double NInfo_BandWidthSent;
    double NInfo_BandWidthReceived;
    String NInfo_Status;

    /* getNInfo_Protocol */
    /* setNInfo_Protocol*/
    
    public String getNInfo_Protocol() {
        return NInfo_Protocol;
    }
    
    public void setNInfo_Protocol(String NInfo_Protocol) {
        this.NInfo_Protocol = NInfo_Protocol;
    }

    /* getNInfo_PID */
    /* setNInfo_PID */
    
    public int getNInfo_PID() {
        return NInfo_PID;
    }

    public void setNInfo_PID(int NInfo_PID) {
        this.NInfo_PID = NInfo_PID;
    }

    /* getNInfo_User */
    /* setNInfo_User */
    
    public String getNInfo_User() {
        return NInfo_User;
    }
    
    public void setNInfo_User(String NInfo_User) {
        this.NInfo_User = NInfo_User;
    }

    /* getNInfo_BandWidthSent */
    /* setNInfo_BandWidthSent */
    
    public double getNInfo_BandWidthSent() {
        return NInfo_BandWidthSent;
    }
    
    public void setNInfo_BandWidthSent(double NInfo_BandWidthSent) {
        this.NInfo_BandWidthSent = NInfo_BandWidthSent;
    }

    /* getNInfo_BandWidthReceived */
    /* setNInfo_BandWidthReceived */
    
    public double getNInfo_BandWidthReceived() {
        return NInfo_BandWidthReceived;
    }
    
    public void setNInfo_BandWidthReceived(double NInfo_BandWidthReceived) {
        this.NInfo_BandWidthReceived = NInfo_BandWidthReceived;
    }

    /* getNInfo_Status */
    /* setNInfo_Status */
    
    public String getNInfo_Status() {
        return NInfo_Status;
    }
    
    public void setNInfo_Status(String NInfo_Status) {
        this.NInfo_Status = NInfo_Status;
    }

    
}
