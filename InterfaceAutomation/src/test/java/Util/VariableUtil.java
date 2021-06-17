package Util;

import Entit.Variable;

import java.util.*;

public class VariableUtil {
    // 读取excel变量表单，放入list集合之中
    public static List<Variable> variableList=new ArrayList<Variable>();
    public static Map<String,String> variableMap=new HashMap<String, String>();
    static {
        try {
            // 加载数据
            ExcelUtil.load("F:\\AutoTest\\InterfaceAutomation\\src\\test\\resources\\GetCase-v5.xls", "变量", Variable.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 把variableList以key：value方式存储，这样我只需要用key就可以获取到变量值了

    public static void listvariableMap(){
        // 循环处理每个对象的值
        for (Variable variable:variableList){
            String name=variable.getName();
            String value=variable.getValue();
            // 放入map中
            variableMap.put(name,value);
        }


    }

    /**
     *
     * @param TestData excel     测试数据
     * @return
     */
    public static String relacevariable(String TestData){
       // 获取变量名，返回set
       Set<String> variableKey=variableMap.keySet();
       // 循环处理key值
       for (String variableString:variableKey){
           // 判断如果测试数据出现变量名
           if (TestData.contains(variableString)){
               // 那么这个值就被替换成map中值  replaceAll：替换的方法，替换之后返回的数据接受一下，进行返回
               TestData=TestData.replace(variableString, variableMap.get(variableString));
           }
       }

  // 现在是替换值之后的数据
return TestData;
    }
}
