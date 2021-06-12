package TestUtil.ExcelUtil;

import TestUtil.HttpClientUtil.HttpClientTools;
import com.alibaba.fastjson.JSONObject;


import java.util.HashMap;
import java.util.Map;

import static TestUtil.ExcelUtil.ExcelUtil.data;

public class ExcelUtilTest {
    public static void main(String[] args) throws Exception {
        HttpClientTools httpClientTools=new HttpClientTools();
        //定义行，读取第2，3，4，5，6行  第6列
        int rows[]={2,3,4,5,6};
        int cells[]={6};
        Object[][] datas=data("D:\\2 - Ju Chun\\220 - java\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase.xls",rows,cells);
        for (Object[] objects:datas){
            for (Object object:objects){

                System.out.print("【"+object+"】");

            }
            Object[] obj = (Object[])objects;
            Map<String,String> pamar= (Map<String, String>) JSONObject.parse(obj.toString());

            System.out.print(httpClientTools.doPost("http://127.0.0.1:8899/post/with/headers",pamar));
            System.out.print("\n");
        }



    }
}
