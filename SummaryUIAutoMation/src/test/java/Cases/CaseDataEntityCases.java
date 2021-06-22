package Cases;

import Entity.CaseDataEntity;
import Entity.WriteBackData;
import Util.CaseDataEntityUtil;
import Util.ExcelUtil;
import Util.ReadPropertiesUtil;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.List;

public class CaseDataEntityCases {


    public static void main(String[] args) {
        WebDriver webDriver = null;

        // 失败的测试用例
        List<CaseDataEntity> caseDataEntityList = CaseDataEntityUtil.failCaseDataEntity();
        for (CaseDataEntity caseDataEntity : caseDataEntityList) {
        try {
            webDriver = OpenBrowse.Open(webDriver, "chrome", "http://114.215.239.112:8081/zentao/user-login-L3plbnRhby9teS5odG1s.html");
            webDriver.findElement(By.xpath(ReadPropertiesUtil.getprop("Paths", "UserName"))).sendKeys(caseDataEntity.getUsername());
            webDriver.findElement(By.xpath(ReadPropertiesUtil.getprop("Paths", "PassWord"))).sendKeys(caseDataEntity.getPassword());
            webDriver.findElement(By.xpath(ReadPropertiesUtil.getprop("Paths", "Submit"))).click();
            String CaseId=caseDataEntity.getCaseId();
            Thread.sleep(2000);
            // 返回的信息
            String Resultinfo=webDriver.switchTo().alert().getText();
            WriteBackData writeBackData=new WriteBackData("用例", CaseId, "AxtualResponseData", Resultinfo);
            ExcelUtil.writeBackDataList.add(writeBackData);
            webDriver.switchTo().alert().accept();
            webDriver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        ExcelUtil.batchWriteBackDatas("F:\\AutoTest\\SummaryUIAutoMation\\src\\test\\resources\\UiDataTest.xls");

    }


}
