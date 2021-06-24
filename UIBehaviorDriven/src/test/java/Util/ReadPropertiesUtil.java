package Util;

import java.io.FileInputStream;
import java.util.Properties;

//获取element.properties元素,供Baidosearch使用
public class ReadPropertiesUtil {
    // filename ：文件名 propname :属性名
    public static String getprop(String filename,String propname) throws Exception{
        Properties properties =new Properties();
        //getProperty("user.dir")+"\\src\\test\\java\\com\\selenium\\
        properties.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\"+filename+".properties"));
        String str=properties.getProperty(propname);
        return  str;




    }
}
