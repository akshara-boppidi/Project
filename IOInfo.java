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
public class IOInfo {
    String IOInfo_DISKNAME;
    double IOInfo_TRANSFERRATEPERSEC;
    double IOInfo_KB_READS;
    double IOInfo_KB_WRITES;
    double IOInfo_BLOCKREADS;
    double IOInfo_BLOCKWRITES;

    /* getIOInfo_DISKNAME */
    /* setIOInfo_DISKNAME  */
    
    public String getIOInfo_DISKNAME() {
        return IOInfo_DISKNAME;
    }
 
    public void setIOInfo_DISKNAME(String IOInfo_DISKNAME) {
        this.IOInfo_DISKNAME = IOInfo_DISKNAME;
    }

    /* getIOInfo_TRANSFERRATEPERSEC */
    /* setIOInfo_TRANSFERRATEPERSEC */
    
    public double getIOInfo_TRANSFERRATEPERSEC() {
        return IOInfo_TRANSFERRATEPERSEC;
    }
    
    public void setIOInfo_TRANSFERRATEPERSEC(double IOInfo_TRANSFERRATEPERSEC) {
        this.IOInfo_TRANSFERRATEPERSEC = IOInfo_TRANSFERRATEPERSEC;
    }

    /* getIOInfo_KB_READS */
    /* setIOInfo_KB_READS */
    
    public double getIOInfo_KB_READS() {
        return IOInfo_KB_READS;
    }
    
    public void setIOInfo_KB_READS(double IOInfo_KB_READS) {
        this.IOInfo_KB_READS = IOInfo_KB_READS;
    }

    /* getIOInfo_KB_WRITES */
    /* setIOInfo_KB_WRITES */
    
    public double getIOInfo_KB_WRITES() {
        return IOInfo_KB_WRITES;
    }
 
    public void setIOInfo_KB_WRITES(double IOInfo_KB_WRITES) {
        this.IOInfo_KB_WRITES = IOInfo_KB_WRITES;
    }

    /* getIOInfo_BLOCKREADS */
    /* setIOInfo_BLOCKREADS */
    
    public double getIOInfo_BLOCKREADS() {
        return IOInfo_BLOCKREADS;
    }
    
    public void setIOInfo_BLOCKREAD(double IOInfo_BLOCKREADS) {
        this.IOInfo_BLOCKREADS = IOInfo_BLOCKREADS;
    }

    /* getIOInfo_BLOCKWRITES */
    /* setIOInfo_BLOCKWRITES */
    
    public double getIOInfo_BLOCKWRITES() {
        return IOInfo_BLOCKWRITES;
    }
    
    public void setIOInfo_BLOCKWRITES(double IOInfo_BLOCKWRITES) {
        this.IOInfo_BLOCKWRITES = IOInfo_BLOCKWRITES;
    }
    
}
