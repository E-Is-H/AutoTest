package Cases;

import Entity.CaseDataEntity;
import Util.CaseDataEntityUtil;

import java.util.List;

public class CaseDataEntityCases {
    public static void main(String[] args) {
        List<CaseDataEntity> caseDataEntityList= CaseDataEntityUtil.caseDataEntity;
        for (CaseDataEntity caseDataEntity:caseDataEntityList){

            System.out.println(caseDataEntity);
        }


    }


}
