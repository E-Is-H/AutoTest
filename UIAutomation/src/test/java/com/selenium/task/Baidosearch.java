package com.selenium.task;

import com.selenium.util.ElementLocation;
import com.selenium.util.ReadProperties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Baidosearch {
    public  static  void baserch(WebDriver webDriver,String username,String password) throws Exception{
        ElementLocation.locate(webDriver,"xpath", ReadProperties.getprop("element","username")).sendKeys(username);
        ElementLocation.locate(webDriver,"xpath", ReadProperties.getprop("element","password")).sendKeys(password);
        ElementLocation.locate(webDriver,"xpath", ReadProperties.getprop("element","loginbutton")).click();

    }
}
