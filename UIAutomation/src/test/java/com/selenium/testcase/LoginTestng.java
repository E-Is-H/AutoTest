package com.selenium.testcase;


import com.selenium.task.Baidosearch;
import com.selenium.util.ElementLocation;
import com.selenium.util.Log;
import com.selenium.basic.OpenBrowser;
import com.selenium.util.RangDataPio;
import com.selenium.util.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTestng {
    WebDriver webDriver=null;

    @DataProvider(name ="provider")
    public  Object [] [] excelread() throws Exception{
        Object[] [] aa= RangDataPio.poiRangeData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\selenium\\data\\test_1.xls");
        return aa;
    }


 @BeforeTest
    public void beforeMethod() throws Exception {
        Log.startTestCase("开始testcase001");



    }
    @Test(dataProvider="provider")
    public void WapLoginA(String a,String b) throws Exception {
        Log.info(a, b);
        webDriver=OpenBrowser.Open(webDriver,"chrome","http://114.215.239.112:8081/zentao/user-login-L3plbnRhby9teS5odG1s.html");
        Baidosearch.baserch(webDriver,a,b);
        webDriver.close();


    }





  @AfterMethod
    public void afterMethod(){
        //关闭浏览器

        Log.endTestCase("结束testcase001");
        webDriver.quit();
    }
}
