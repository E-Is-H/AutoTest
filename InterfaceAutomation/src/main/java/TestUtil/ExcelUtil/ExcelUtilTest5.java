package TestUtil.ExcelUtil;

import CaseData.CaseUtil;
import CaseData.RestUtil;
import TestUtil.HttpClientUtil.HttpClientTools;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 登录测试组件
 */
public class ExcelUtilTest5 {

    public void info(){

    }
    public static void main(String[] args) throws Exception {


        String apiId="";
        String CaseId="";
        String cellName[]={"CaseId","ApiId","TestData"};
        Object[][]  datas=CaseUtil.getCaseDatasByapId("2", cellName);


        for (Object[] objects : datas) {
            CaseId =objects[0].toString();
            apiId = objects[1].toString();
            Object object1 = objects[2].toString();
            Map<String, String>   pamar = (Map<String, String>) JSONObject.parse(object1.toString());
            String url = RestUtil.geturlByApiId(apiId);
            String type = RestUtil.geturlBytype(apiId);


          String reult=HttpClientTools.doService(url,type,pamar);
          System.out.print("**********"+reult);
           ExcelUtil.writeAxtualResponseData("F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase-v4.xls","用例",CaseId,"AxtualResponseData",reult);
        }

    }
}

