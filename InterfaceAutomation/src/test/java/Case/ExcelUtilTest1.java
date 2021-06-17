package Case;


import Util.HttpClientTools;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;



public class ExcelUtilTest1 {
    public static void main(String[] args) throws Exception {
        HttpClientTools httpClientTools=new HttpClientTools();
        Map<String,String> pamar=null;
        //定义行，读取第2，3，4，5，6行  第6列
        int rows[]={2,3,4,5,6};
        int cells[]={6};
        //Object[][] datas=data("F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase-v1.xls","Login",rows,cells);
        //for (Object[] objects:datas){
        //   for (Object object:objects){
        //       pamar= (Map<String, String>) JSONObject.parse(object.toString());
        //   }


        //   System.out.print(httpClientTools.doPost("http://127.0.0.1:8899/post/with/headers",pamar));
        //     System.out.print("\n");
        //   }



    }
}
