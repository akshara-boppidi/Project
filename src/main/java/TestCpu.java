/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravit, pooja, akshara
 */
public class TestCpu {
    
    public TestCpu() {
    }

    public static void setUpClass() {
    }

    public static void dropDownClass() {
    }

    public void setUp() {
    }

    public void dropDown() {
    }

    /*CPU information  */
    public void testCpu() {
        System.out.println("Test Cpu Info");
        String query = "free -m";
        TestCpu newtest = new TestCpu();
        String endResult = "Successful";
    }

    /* Memory stats information of CPU     */

    public void testMemoryInfo() {
        System.out.println("Memory Info");
        String query = "free -m";
        TestCpu newtest = new TestCpu();
        String endResult = "Successful";
    }

    /* network stats information of CPU. */

    public void testNetworkInfo() {
        System.out.println("Network Info");
        String query = "netstat -e -p -at";
        TestCpu newtest = new TestCpu();
        String endResult = "Successful";
    }

    /* IO stats Information of CPU */

    public void testIOInfo() {
        System.out.println("IO Info");
        String query = "iostat -d -N";
        TestCpu newtest = new TestCpu();
        String endResult = "Successful";
    }

}
