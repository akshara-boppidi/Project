import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.io.IOException;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raviteja, pooja, akshara
 */


public class TaskManager {
    public static void main(String[] args) {
        
        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        
        int availableProcessors = os.getAvailableProcessors();
        
        for (Method md : os.getClass().getDeclaredMethods()) {
            md.setAccessible(true);
            if (md.getName().startsWith("get") 
                    && Modifier.isPublic(md.getModifiers())) {
                Object value;
                try {
                    value = md.invoke(os);
                } catch (Exception e) {
                    value = e;
                }
                System.out.println(md.getName() + " = " + value);
            } 
        }
        
    }
}
