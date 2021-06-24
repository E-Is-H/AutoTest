package Util;

import org.testng.ITestResult;
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
      //  String dataDir= DateFormatUtils.format(now,"yyyy-MM-dd");  缺少这个添加filepath+File.separator
     // 文件名
        String fileName=now.getTime()+"jpg";
        // 保存路径文件File.separator分隔符
        String filePath=base+ File.separator+dirName+File.separator+testName+File.separator+fileName;

        // 截图工具类，写入到文件保存



    }
}
