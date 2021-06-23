package Util;

import Cases.OpenBrowse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * 断言
 */
public class Assertion {
    /* 是否包含ulr地址 */
    public static  void assertUrlContains(String Url){
        WebDriverWait webDriverWait =new WebDriverWait(OpenBrowse.webDriver, 20);
       boolean isDirected=true;
       try {
           webDriverWait.until(ExpectedConditions.urlContains(Url));
       }catch (Exception e){
           isDirected=false;
       }

        Assert.assertTrue(isDirected);
    }

}
