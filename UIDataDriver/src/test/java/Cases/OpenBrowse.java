package Cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

public class OpenBrowse {
    public  static  WebDriver webDriver;

    //打开浏览器，打开网址
    public static WebDriver Open(WebDriver webDriver,String browsername,String url)throws  Exception{
        if (browsername.equals("chrome")){
            setProperty("webdriver.chrome.driver", getProperty("user.dir")+"\\SummaryUIAutoMation\\src\\test\\java\\driver\\chromedriver.exe");


        }else if(browsername.equals("ie")){
           setProperty("webdriver.chrome.driver", getProperty("user.dir")+"src\\test\\java\\driver\\chromedriver.exe");
            webDriver=new InternetExplorerDriver();

        }else if(browsername.equals("ff")){
           setProperty("webdriver.chrome.driver", getProperty("user.dir")+"src\\test\\java\\driver\\chromedriver.exe");
            webDriver=new FirefoxDriver();

        }
        webDriver.get(url);
        //放大浏览器
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
