package Cases;

import Entity.CaseDataEntity;
import Entity.WriteBackData;
import Util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CaseDataEntityCases2 {


    public static void main(String[] args) {
        WebDriver webDriver = null;

        // 失败的测试用例
        List<CaseDataEntity> caseDataEntityList = CaseDataEntityUtil.passCaseDataEntity();
        for (CaseDataEntity caseDataEntity : caseDataEntityList) {
        try {
            webDriver = OpenBrowse.Open(webDriver, "chrome", "http://114.215.239.112:8081/zentao/user-login-L3plbnRhby9teS5odG1s.html");
            webDriver.findElement(UILibrearyUtil.getElementByKeyword("登录页面","用户名")).sendKeys(caseDataEntity.getUsername());
            webDriver.findElement(UILibrearyUtil.getElementByKeyword("登录页面","密码")).sendKeys(caseDataEntity.getPassword());
            webDriver.findElement(UILibrearyUtil.getElementByKeyword("登录页面","登录")).click();
            String CaseId=caseDataEntity.getCaseId();
            Thread.sleep(2000);
            // 返回的信息
            String Resultinfo=webDriver.switchTo().alert().getText();
            WriteBackData writeBackData=new WriteBackData("用例", CaseId, "AxtualResponseData", Resultinfo);
            ExcelUtil.writeBackDataList.add(writeBackData);
            webDriver.switchTo().alert().accept();

            /*断言登录成功之后的地址中是否包含url*/
            WebDriverWait webDriverWait =new WebDriverWait(webDriver, 20);
            String indexUrl="index.html";
            /*调用断言方法*/
            Assertion.assertUrlContains(indexUrl);



            webDriver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        ExcelUtil.batchWriteBackDatas("F:\\AutoTest\\SummaryUIAutoMation\\src\\test\\resources\\UiDataTest.xls");

    }


}
