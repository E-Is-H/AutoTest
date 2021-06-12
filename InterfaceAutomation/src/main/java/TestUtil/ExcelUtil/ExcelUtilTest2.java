package TestUtil.ExcelUtil;

import TestUtil.HttpClientUtil.HttpClientTools;
import com.alibaba.fastjson.JSONObject;

import java.net.URL;
import java.util.Map;

import static TestUtil.ExcelUtil.ExcelUtil.data;

public class ExcelUtilTest2 {
    public static void main(String[] args) throws Exception {
        HttpClientTools httpClientTools=new HttpClientTools();
        String object2="";
        String type="";
        /**
         *   读取用例表单数据，第3.4列数据，3：接口ApiId，4：data数据,然后放到Map pamar里面
         */
        int rows[]={2,3,4,5,6};
        int cells[]={3,4};
        Object[][]   datas=data("F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase-v2.xls","用例",rows,cells);


        int rowsinfo[]={2};
        int cellsinfo[]={1,3,4};
        Object[][]    datas1=data("F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase-v2.xls","接口地址",rowsinfo,cellsinfo);

        String  url="";
        for (Object[] objects:datas) {
            object2 = objects[0].toString();
            Object object1 = objects[1].toString();
            Map<String, String>   pamar = (Map<String, String>) JSONObject.parse(object1.toString());
            System.out.print(object1);
            /**
             * 读取表单信息中接口信息，第2行，第1，4列数据，1接口ip，4接口地址
             */

            for (Object[] objects3:datas1){
                String pamarinfo=objects3[0].toString();
                if (pamarinfo.equals(object2)){
                     type=objects3[1].toString();
                    url=objects3[2].toString();
                }
            }
           System.out.print(HttpClientTools.doService(url,type,pamar));


        }

    }
}

