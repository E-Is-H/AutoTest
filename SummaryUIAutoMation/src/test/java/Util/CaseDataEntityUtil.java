package Util;


import Entity.CaseDataEntity;
import com.google.inject.internal.cglib.core.$MethodInfoTransformer;

import java.util.ArrayList;
import java.util.List;

public class CaseDataEntityUtil {
    public  static List<CaseDataEntity> caseDataEntity= new ArrayList<CaseDataEntity>();
    static{
        try {
            ExcelUtil.load("F:\\AutoTest\\SummaryUIAutoMation\\src\\test\\resources\\UiDataTest.xls","用例",CaseDataEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
