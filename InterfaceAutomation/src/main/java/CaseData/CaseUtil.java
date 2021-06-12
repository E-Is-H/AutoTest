package CaseData;

import TestUtil.ExcelUtil.ExcelUtil;
import jdk.internal.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.List;
//保存所有测试用例对象

public class CaseUtil {
    public static List<Case3> list=new ArrayList<Case3>();
    static {
        //将所有的数据解析封装到cases中
        ExcelUtil.load("F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase-v3.xls","用例");
    }

    /**
     *
     * @param apiId   指定接口编号
     * @param cellName  根据名称获取所有的列数
     * @return  共享数据
     */
    public static Object[][] getCaseDatasByapId (String apiId, String[] cellName){
        // 通过循环找到对应的数据

        for (Object listdata:list){

        }
     return null;
    }

}
