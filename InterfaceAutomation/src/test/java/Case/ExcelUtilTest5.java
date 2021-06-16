package Case;



import Entit.WriteBackData;
import Util.CaseUtil;

import Util.ExcelUtil;
import Util.HttpClientTools;
import Util.RestUtil;
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
        String cellName[]={"CaseId","ApiId","TestData","ExpectedResponseData"};
        Object[][]  datas=CaseUtil.getCaseDatasByapId("2", cellName);


        for (Object[] objects : datas) {
            CaseId =objects[0].toString();
            apiId = objects[1].toString();
          String  TestData =objects[2].toString();
           String ExpectedResponseData = objects[3].toString();
            Object object1 = objects[2].toString();
            Map<String, String>   pamar = (Map<String, String>) JSONObject.parse(object1.toString());
            String url = RestUtil.geturlByApiId(apiId);
            String type = RestUtil.geturlBytype(apiId);


          String reult=HttpClientTools.doService(url,type,pamar);
          System.out.print("**********"+reult);

          /* 把数据放入对象之中*/
            WriteBackData writeBackData=new WriteBackData("用例",CaseId,"AxtualResponseData",reult);
           // 把对象数据，保存到ExcelUtil对象writeBackDataList数组中
            ExcelUtil.writeBackDataList.add(writeBackData);




          /* 封装断言方法, 传入参数：实际测试结果，预期测试结果，因为方法在test包中
            Asserutil.assertEquals(TestData,ExpectedResponseData);
           */


          // 这个方法很浪费时间
          //ExcelUtil.writeAxtualResponseData("F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase-v4.xls","用例",CaseId,"AxtualResponseData",reult);
            // 这个方法不浪费时间
           ExcelUtil.batchWriteBackDatas("F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase-v4.xls");



        }

    }
}

