package Cases;

import Util.UILibrearyUtil;
import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;


import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

public class OpenBrowse {
    public static WebDriver webDriver;

    //打开浏览器
    @Parameters(value ={"browsername"})
    @BeforeSuite
    public static void Open(String browsername)throws  Exception{
        if (browsername.equals("chrome")){
            setProperty("webdriver.chrome.driver","F:\\AutoTest\\UIBehaviorDriven\\src\\test\\java\\driver\\chromedriver.exe");
            webDriver = new ChromeDriver();

        }else if(browsername.equals("ie")){
            setProperty("webdriver.chrome.driver", getProperty("user.dir")+"src\\test\\java\\driver\\chromedriver.exe");
            webDriver=new InternetExplorerDriver();

        }else if(browsername.equals("ff")){
            setProperty("webdriver.chrome.driver", getProperty("user.dir")+"src\\test\\java\\driver\\chromedriver.exe");
            webDriver=new FirefoxDriver();

        }
        webDriver.manage().window().maximize();

        //放大浏览器


    }

    /**
     * 访问页面地址
     * @param url
     */

    public  static  void  to(String url){
        webDriver.get(url);
    }

    /**
     * 输入数据
     * @param pageKeyword
     * @param uiElementKeywprd
     * @param content
     */

    public  static  void  input(String pageKeyword,String uiElementKeywprd, String content){
        webDriver.findElement(UILibrearyUtil.getElementByKeyword(pageKeyword,uiElementKeywprd)) .sendKeys(content);

    }


    /**
     * 点击
     * @param pageKeyword
     * @param uiElementKeywprd
     */


    public static void cicki(String pageKeyword,String uiElementKeywprd){
        webDriver.findElement(UILibrearyUtil.getElementByKeyword(pageKeyword,uiElementKeywprd)) .click();

    }



    /**
     * 关闭浏览器
     */
    @AfterSuite
    public void colseBrowse(){
        webDriver.close();
    }

}
