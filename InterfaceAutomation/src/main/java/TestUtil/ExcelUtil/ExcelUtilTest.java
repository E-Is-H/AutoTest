package TestUtil.ExcelUtil;

import TestUtil.HttpClientUtil.HttpClientTools;

import java.util.HashMap;
import java.util.Map;

import static TestUtil.ExcelUtil.ExcelUtil.data;

public class ExcelUtilTest {
    public static void main(String[] args) throws Exception {
        HttpClientTools httpClientTools=new HttpClientTools();
        Map<String,String> map=new HashMap<String, String>();
        Object[][] datas=data();
        for (Object[] objects:datas){
            for (Object object:objects){

                System.out.print("【"+object+"】");

            }
            Object[] obj = (Object[])objects;
            map.put("name",obj[0].toString());
            map.put("age", obj[1].toString());
            System.out.print(httpClientTools.doPost("http://127.0.0.1:8899/post/with/headers",map));
            System.out.print("\n");
        }



    }
}
