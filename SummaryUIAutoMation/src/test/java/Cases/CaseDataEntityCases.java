package Cases;

import Entity.CaseDataEntity;
import Util.CaseDataEntityUtil;
import Util.ReadPropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.List;

public class CaseDataEntityCases {


    public static void main(String[] args) {
        WebDriver webDriver=null;
        List<CaseDataEntity> caseDataEntityList= CaseDataEntityUtil.caseDataEntity;
        for (CaseDataEntity caseDataEntity:caseDataEntityList){

            System.out.println(caseDataEntity);
        }

        try {
            webDriver= OpenBrowse.Open(webDriver,"chrome","http://114.215.239.112:8081/zentao/user-login-L3plbnRhby9teS5odG1s.html");

            webDriver.findElement(By.xpath(ReadPropertiesUtil.getprop("Paths","UserName"))).sendKeys("1");
            webDriver.findElement(By.xpath(ReadPropertiesUtil.getprop("Paths","PassWord"))).sendKeys("2");
            webDriver.findElement(By.xpath(ReadPropertiesUtil.getprop("Paths","Submit"))).click();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
