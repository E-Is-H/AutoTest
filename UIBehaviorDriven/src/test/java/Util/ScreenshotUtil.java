package Util;

import Cases.OpenBrowse;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static File saveScreenshot(String filePath) {
        File dastFile=new File(filePath);


       File dastFile1= ((TakesScreenshot) OpenBrowse.webDriver).getScreenshotAs(OutputType.FILE);

// 将文件拷贝到这个目录下面
        try {
            FileUtils.copyFile(dastFile1, dastFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dastFile;
    }
}
