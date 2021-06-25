package Util;

import javafx.beans.binding.Bindings;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.util.Date;

/**
 * testng 适配器
 */
public class CustomListener extends TestListenerAdapter {



    @Override
    public void onTestFailure(ITestResult tr) {
        // 指定目录文件
        String base="test-output";
        //生成目录
        String dirName="screenshhot";
        // 获取测试上下文---获取正在执行的测试集--获取测试集的名字
       String testName= tr.getTestContext().getCurrentXmlTest().getName();
       //创建日期目录
        Date now=new Date();
      String dataDir=(DateFormatUtils.format(now,"yyyy-MM-dd"));
     // 文件名
        String fileName=now.getTime()+".jpg";
        // 保存路径文件File.separator分隔符
        String filePath=base+ File.separator+dirName+File.separator+testName+File.separator+dataDir+File.separator+fileName;

        // 截图工具类，写入到文件保存

        // 创建类ScreenshotUtil方法saveScreenshot，保存截图文件，把路径传入,获取一个文件

        File file=ScreenshotUtil.saveScreenshot(filePath);

// 获取testng配置xml中的参数

        String toBeReplaced=tr.getTestContext().getCurrentXmlTest().getParameter("apacheDocumentRoot");
        String replacement=tr.getTestContext().getCurrentXmlTest().getParameter("host");

// 定义方法，接受方法返回值
        String imgString=getImgString(toBeReplaced,replacement,file);
// 把方法返回值，写入到reportng框架之中去
        Reporter.log(imgString);



    }

    private String getImgString(String toBeReplaced, String replacement, File file) {

         String absoluteFile= file.getAbsolutePath();
         String access=absoluteFile.replace(toBeReplaced,replacement);
          String img="<img src='"+access+"' height='100' width='100'><a href='"+access+"' target='_blank'>点击查看大图</a></img>";





        return img;
    }
}
