package CaseData;

import TestUtil.ExcelUtil.ExcelUtil;
import jdk.internal.dynalink.beans.StaticClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
//保存所有测试用例对象

public class CaseUtil {
    public static List<Case3> cases=new ArrayList<Case3>();
    static {
        //将所有的数据解析封装到cases中
        try {
            ExcelUtil.load("F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase-v3.xls","用例",Case3.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param apiId   指定接口编号
     * @param cellName  根据名称获取所有的列数
     * @return  共享数据
     */
    public static Object[][] getCaseDatasByapId (String apiId, String[] cellName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 通过循环找到对应的数据
        Class<Case3> clazz=Case3.class;
        ArrayList<Case3> case3s=new ArrayList<Case3>();
        for (Case3 listdata:cases){
            if(listdata.getApiId().equals(apiId)) {
                case3s.add(listdata);
            }
        }
        Object[][] datas=new Object[case3s.size()][cellName.length];
        for (int i=0;i<case3s.size();i++){
            Case3 cs =case3s.get(i);
            for(int j=0;j<cellName.length;j++){
                //反射的方法名
                String methodname="get"+cellName[j];
                //反射的方法对象
                Method method=clazz.getMethod(methodname);
                //
                String value= (String) method.invoke(cs);

                datas[i][j]=value;
            }
        }
     return datas;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String [] cellName={"TestData"};
        Object [][] datas=getCaseDatasByapId("1",cellName);
        for (Object[] objects :datas){
            for (Object object :objects){
                System.out.print(object);
            }
            System.out.println();
        }
    }
}
