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

    // 获取反向测试用例

    public  static List<CaseDataEntity> failCaseDataEntity(){
        List<CaseDataEntity> list=new ArrayList<CaseDataEntity>();
        for (CaseDataEntity caseDataEntitylist:caseDataEntity){
            if ("0".equals(caseDataEntitylist.getIsEegtive())){
                list.add(caseDataEntitylist);
            }
        }

        return list;

    }

    // 获取反向测试用例

    public  static List<CaseDataEntity> passCaseDataEntity(){
        List<CaseDataEntity> list=new ArrayList<CaseDataEntity>();
        for (CaseDataEntity caseDataEntitylist:caseDataEntity){
            if ("1".equals(caseDataEntitylist.getIsEegtive())){
                list.add(caseDataEntitylist);
            }
        }

        return list;


    }

    public static void main(String[] args) {
        List<CaseDataEntity> list=CaseDataEntityUtil.passCaseDataEntity();
        for (CaseDataEntity caseDataEntity:list){
            System.out.print(caseDataEntity);
        }
    }

}
