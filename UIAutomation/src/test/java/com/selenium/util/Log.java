package com.selenium.util;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

    private static Logger Log = Logger.getLogger(Log.class.getName());

    public static void startTestCase(String titleName){
        PropertyConfigurator.configure("log4j.properties");
        Log.info("****************************************************************************************");
        Log.info("$ "+"$ "+titleName+ "$"+"$");
        Log.info("****************************************************************************************");

    }



    public static void info(String name,String password) {
        PropertyConfigurator.configure("log4j.properties");
        Log.info("Username:"+name+"    "+"password:"+password);
    }
    public static void endTestCase(String titleName){
        PropertyConfigurator.configure("log4j.properties");
        Log.info("#######################################################################################");
        Log.info("XX"+titleName+ "XX");
        Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
    }

}
