package Cases;

import Entity.CaseDataEntity;
import Entity.WriteBackData;
import Util.CaseDataEntityUtil;
import Util.ExcelUtil;
import Util.ReadPropertiesUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

public class CaseDataEntityCases2 extends OpenBrowse {

    private static Logger Log = Logger.getLogger(CaseDataEntityCases2.class.getName());
    @Test(dataProvider="getCase")
    public void RunAutoMation(String CaseId,String Desc,String Username,String Password) {


            try {
                // 访问   调用properties中BrowesPath访问地址
                OpenBrowse.to(ReadPropertiesUtil.getprop("Paths", "BrowsePath"));
                // 输入
                Log.info("*******************************************UserName"+Username);
                OpenBrowse.input("登录页面", "用户名",Username);
                Log.info("*******************************************Password"+Password);
                OpenBrowse.input("登录页面", "密码", Password);
                // 点击
                OpenBrowse.cicki("登录页面", "登录");

                Thread.sleep(2000);
                // 返回的信息
                String Resultinfo = webDriver.switchTo().alert().getText();
                // 写入返回数据
                WriteBackData writeBackData = new WriteBackData("用例", CaseId, "AxtualResponseData", Resultinfo);
                ExcelUtil.writeBackDataList.add(writeBackData);
                // 确定弹窗
                webDriver.switchTo().alert().accept();
                Assert.assertTrue(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        try {
            ExcelUtil.batchWriteBackDatas(ReadPropertiesUtil.getprop("ExcelPath","Paths"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @DataProvider
    public static Object[][] getCase() {
       // String cellName[] = {"CaseId", "IsEegtive", "Desc", "Username", "Password", "ExpectedResponseData", "AxtualResponseData"};
        String cellName[] = {"CaseId","Desc", "Username", "Password"};
        // 传入一个对象类
        Class<CaseDataEntity> clazz = CaseDataEntity.class;

        // 对象数组
        List<CaseDataEntity> caseDataEntityList = CaseDataEntityUtil.failCaseDataEntity();
        // 行数: 对象的大小，列数：类的属性个数
        Object[][] objects = new Object[caseDataEntityList.size()][cellName.length];
        String value = "";
        // 循环获取对象数据
        for (int i = 0; i < caseDataEntityList.size(); i++) {
            // 获取对象值
            CaseDataEntity caseDataEntity = caseDataEntityList.get(i);

            // 循环获取每个属性值
            for (int j = 0; j < cellName.length; j++) {
                //反射的方法名
                String methodname = "get" + cellName[j];
                //反射的方法对象
                Method method = null;
                try {
                    method = method = clazz.getMethod(methodname);
                    value = (String) method.invoke(caseDataEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                objects[i][j] = value;
            }
        }
return objects;

    }


}


