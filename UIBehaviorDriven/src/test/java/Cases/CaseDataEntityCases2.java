package Cases;

import Entity.CaseDataEntity;
import Entity.WriteBackData;
import Util.CaseDataEntityUtil;
import Util.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class CaseDataEntityCases2 extends OpenBrowse {


    @Test
    public void RunAutoMation() {


        // 失败的测试用例
        List<CaseDataEntity> caseDataEntityList = CaseDataEntityUtil.failCaseDataEntity();
        for (CaseDataEntity caseDataEntity : caseDataEntityList) {
            try {
                // 访问
                OpenBrowse.to("http://114.215.239.112:8081/zentao/user-login-L3plbnRhby9teS5odG1s.html");
                // 输入
                OpenBrowse.input("登录页面", "用户名", caseDataEntity.getUsername());
                OpenBrowse.input("登录页面", "密码", caseDataEntity.getPassword());
                // 点击
                OpenBrowse.cicki("登录页面", "登录");
                // 获取测试用例ID，写入数据时使用
                String CaseId = caseDataEntity.getCaseId();
                Thread.sleep(2000);
                // 返回的信息
                String Resultinfo = webDriver.switchTo().alert().getText();
                // 写入返回数据
                WriteBackData writeBackData = new WriteBackData("用例", CaseId, "AxtualResponseData", Resultinfo);
                ExcelUtil.writeBackDataList.add(writeBackData);
                // 确定弹窗
                webDriver.switchTo().alert().accept();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ExcelUtil.batchWriteBackDatas("F:\\AutoTest\\UIBehaviorDriven\\src\\test\\resources\\UiDataTest.xls");

    }


    @DataProvider
    public static Object[][] getCaseDatasByapId() {
        // 通过循环找到对应的数据
        List<CaseDataEntity> caseDataEntityList = CaseDataEntityUtil.failCaseDataEntity();

        Object[] s = (Object[])caseDataEntityList.toArray();
        Object[][] objects = new Object[s.length][];
        for(int i=0;i<s.length;i++){
            objects[i] = (Object[])s[i];
        }

        return objects;


    }

    public static void main(String[] args) {
        List<CaseDataEntity> caseDataEntityList = CaseDataEntityUtil.failCaseDataEntity();

        Object[] s = (Object[])caseDataEntityList.toArray();
        Object[][] objects = new Object[s.length][];
        for(int i=0;i<s.length;i++){
            objects[i] = (Object[])s[i];
        }


        for(int z=0;z<objects.length;z++){
            for(int i=0;i<objects[z].length;i++){
                System.out.println(objects[z][i]);
            }
        }

    }




}