package TestUtil.ExcelUtil;

import CaseData.CaseUtil;
import CaseData.RestUtil;
import TestUtil.Authenticacation.WriteBackData;
import TestUtil.DBCheckUtil;
import TestUtil.HttpClientUtil.HttpClientTools;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 登录测试组件
 */
public class ExcelUtilTest6 {

    public void info(){

    }
    public static void main(String[] args) throws Exception {


        String apiId="";
        String CaseId="";

        /* "CaseId":用例编号,"ApiId":接口地址编号,"TestData":请求数据,"ExpectedResponseData"：期望数据,
        "PreValidateSql"：接口执行前的sql语句,"AfterValidatesql"：接口执行后的sql语句*/
        String cellName[]={"CaseId","ApiId","TestData","ExpectedResponseData","PreValidateSql","AfterValidatesql"};

        Object[][]  datas=CaseUtil.getCaseDatasByapId("2", cellName);


        for (Object[] objects : datas) {
            CaseId =objects[0].toString();
            apiId = objects[1].toString();
           String  TestData =objects[2].toString();
           String ExpectedResponseData = objects[3].toString();

           /* 接口请求未发送之前，先查询一下数据库里面的数据*/
            //先判断一下表格中PreValidateSql这列是否有sql语句，有就执行
            if (objects[4].toString()!=null&&objects[4].toString().trim().length()>0){
                // DBCheckUtil用来执行sql语句
                String afterValidateResult= DBCheckUtil.doQuert(objects[5].toString());
                // 保存结果到对象中数组中，前面我们已经写过这个类与数据，只需要把，写入数据的列与数据换一下即可
                /* 把数据放入对象之中*/
                WriteBackData writeBackData=new WriteBackData("用例",CaseId,"afterValidateResult",afterValidateResult);
                // 把对象数据，保存到ExcelUtil对象writeBackDataList数组中
                ExcelUtil.writeBackDataList.add(writeBackData);

            }



            Object object1 = objects[2].toString();
            Map<String, String>   pamar = (Map<String, String>) JSONObject.parse(object1.toString());
            String url = RestUtil.geturlByApiId(apiId);
            String type = RestUtil.geturlBytype(apiId);
            String reult=HttpClientTools.doService(url,type,pamar);
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




            /* 接口请求发送之后，我们在查询一下数据库里面的数据进行校验*/
            //先判断一下表格中AfterValidatesql这列是否有sql语句，有就执行
            if (objects[5].toString()!=null&&objects[5].toString().trim().length()>0){

                String afterValidateResult= DBCheckUtil.doQuert(objects[5].toString());





            }

        }

    }
}

