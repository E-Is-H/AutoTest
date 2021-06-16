package Case;


import Util.CaseUtil;
import Util.ExcelUtil;
import Util.HttpClientTools;
import Util.RestUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 登录测试组件
 */
public class ExcelUtilTest4 {

    public void info(){

    }
    public static void main(String[] args) throws Exception {


        String apiId="";
        String CaseId="";
        String cellName[]={"CaseId","ApiId","TestData"};
        Object[][]  datas= CaseUtil.getCaseDatasByapId("2", cellName);


        for (Object[] objects : datas) {
            CaseId =objects[0].toString();
            apiId = objects[1].toString();
            Object object1 = objects[2].toString();
            Map<String, String>   pamar = (Map<String, String>) JSONObject.parse(object1.toString());
            String url = RestUtil.geturlByApiId(apiId);
            String type = RestUtil.geturlBytype(apiId);


          String reult= HttpClientTools.doService(url,type,pamar);
          System.out.print("**********"+reult);
            /**
             * 这个方法也是批量写，但是很耗时间，请查看ExcelUtil5里面的方法
             */
           ExcelUtil.writeAxtualResponseData("F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase-v4.xls","用例",CaseId,"AxtualResponseData",reult);
        }

    }
}

