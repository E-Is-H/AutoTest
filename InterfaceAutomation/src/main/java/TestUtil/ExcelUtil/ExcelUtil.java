package TestUtil.ExcelUtil;


import CaseData.Case3;
import CaseData.CaseUtil;
import CaseData.Rest;
import CaseData.RestUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class ExcelUtil {
    //根据caseId获取行数
    public  static Map<String,Integer> row= new HashMap<String, Integer>();
    // 保存列名列索引
    public  static Map<String,Integer> cell= new HashMap<String, Integer>();
    /**
     *
     * @param excelpath   excel路径
     * @param rows        行数
     * @param cells        列数
     * @return              表格中的数据
     */
   public  static Object[][] data(String excelpath,String sheetName,int [] rows ,int [] cells) {
       //定义xls路径
       //String datapath=excelpath;
       //String datapath="F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase.xls";
       Object[][] datas=null;
       try {
           //获取WorkBook对像
           Workbook workbook=WorkbookFactory.create(new File(excelpath));
           //获取sheet对象
           Sheet sheet=workbook.getSheet(sheetName);
           //定义保存数据的数组，几行几列的数据,rows.length :我要去几行的数据,cells.length :取几列的数据
           datas= new Object[rows.length][cells.length];
           //for 获取行数组里面长度，循环取出
           for (int i =0;i < rows.length;i++){
               //根据行索引获取数组中的数据，减一因为getrow方法是从0开始读取excel的所以excel中1在getrow方法就是0
              Row row= sheet.getRow(rows[i]-1);
               //获取列
               for (int j=0;j<cells.length;j++){
                   // Row.MissingCellPolicy.CREATE_NULL_AS_BLANK用来解决列值为空
                  Cell cell=row.getCell(cells[j]-1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                  // 设置类型
                   cell.setCellType(CellType.STRING);
                   String value=cell.getStringCellValue();
                   //把值取出放入二维数组中
                   datas [i][j]=value;
               }
           }
           //获取列
       } catch (Exception e) {
           e.printStackTrace();
       }
       return datas;
   }

    /**
     * 解析指定excel表单的数据，封装为对象
     * @param excelpath 文件路径
     * @param sheetname  excel表单名
     */
    public static <T> void load(String excelpath, String sheetname ,Class<T> tClass) throws Exception {
        //创建类
       // Class clazz = tClass;
        //创建workbook对象
        Workbook workbook= null;
        try {
            workbook = WorkbookFactory.create(new File(excelpath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        //创建sheet对象
        Sheet sheet=workbook.getSheet(sheetname);
        //获取第一行
       Row titlerow= sheet.getRow(0);
       //获取最后一列列号
       int lastcellnum=titlerow.getLastCellNum();
       String [] fileds=new String[lastcellnum];
       //循环处理每一列，取出每一列字段名
        for (int i=0;i<lastcellnum;i++){
            //根据列索引获取对应的列
            Cell cell=titlerow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            //设置列类型，返回字符串
            cell.setCellType(CellType.STRING);
            //获取列的值
            String tilte=cell.getStringCellValue();
           // System.out.print(tilte);
            //截取需要的字段
            tilte=tilte.substring(0, tilte.indexOf("("));
            System.out.print(tilte);
            fileds[i]=tilte;
        // String mothername="set"+tilte;
        // Method method=clazz.getMethod(mothername, String.class);
        // method.invoke()

        }
        // 获取最后一行
       int  Indexof=sheet.getLastRowNum();
        //循环处理每一行

        for (int i=1;i<=Indexof;i++){
            //创建原始对象
          Object object=  tClass.newInstance();
            //拿到一个数据行
            Row row=sheet.getRow(i);
            //拿到此数据行上面的每一列,封装到对象里面去
            for (int j=0;j<lastcellnum;j++){
              Cell cell=  row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
              cell.setCellType(CellType.STRING);
              String value=cell.getStringCellValue();
             //获取要反射的方法
                String mothername="set"+fileds[j];
                //获取要反射的对象
                Method method=tClass.getMethod(mothername, String.class);
               // 完成反射调用
                method.invoke(object,value);
            }
            if (object instanceof Case3) {  //判断object 类型
               Case3 case3 = (Case3) object;
                CaseUtil.cases.add(case3);
            }else if(object instanceof Rest){
                Rest rest = (Rest) object;
               RestUtil.rests.add(rest);

            }

        }
        //获取行
        //获取列
    }

    public static void main(String[] args) throws Exception {

        ExcelUtil.load("F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase-v3.xls","用例",Case3.class);
        for (Case3 cs :CaseUtil.cases){
            System.out.print(cs);
            System.out.print("\n");
        }
        for (Rest cs :RestUtil.rests){
            System.out.print(cs);
            System.out.print("\n");
        }
    }


    /**
     * 回写数据
     * @param caseId
     * @param cellname  列名
     * @param result     结果
     */
    public static void writeAxtualResponseData(String caseId, String cellname, String result) {
        int rownum=row.get(caseId);
        int cellnum=cell.get(cellname);


    }
}
