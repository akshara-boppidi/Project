/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mscs710.taskmanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ravit, pooja, akshara
 */
public class TestCpu {

    public TestCpu() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCpu() {
        System.out.println("Test Cpu Info");
        String query = "free -m";
        TestCpu newtest = new TestCpu();
        String endResult = "Successful";
    }

    /* Memory stats information of CPU     */
    
    @Test
    public void testMemoryInfo() {
        System.out.println("Memory Info");
        String query = "free -m";
        TestCpu newtest = new TestCpu();
        String endResult = "Successful";
    }

    /* network stats information of CPU. */
    
    @Test
    public void testNetworkInfo() {
        System.out.println("Network Info");
        String query = "netstat -e -p -at";
        TestCpu newtest = new TestCpu();
        String endResult = "Successful";
    }

    /* IO stats Information of CPU */
    
    @Test
    public void testIOInfo() {
        System.out.println("IO Info");
        String query = "iostat -d -N";
        TestCpu newtest = new TestCpu();
        String endResult = "Successful";
    }

}

