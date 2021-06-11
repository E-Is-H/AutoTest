package com.selenium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static java.lang.System.*;

public class OpenBrowser {
    //打开浏览器，打开网址
    public static WebDriver Open(WebDriver webDriver,String browsername,String url)throws  Exception{
        if (browsername.equals("chrome")){
            setProperty("webdriver.chrome.driver", getProperty("user.dir")+"\\src\\test\\java\\com\\selenium\\driver\\chromedriver.exe");
            webDriver = new ChromeDriver();


        }else if(browsername.equals("ie")){
            setProperty("webdriver.chrome.driver", getProperty("user.dir")+"\\src\\test\\java\\com\\selenium\\driver\\chromedriver.exe");
            webDriver=new InternetExplorerDriver();

        }else if(browsername.equals("ff")){
            setProperty("webdriver.chrome.driver", getProperty("user.dir")+"\\src\\test\\java\\com\\selenium\\driver\\chromedriver.exe");
            webDriver=new FirefoxDriver();

        }
        webDriver.get(url);
        //放大浏览器
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
