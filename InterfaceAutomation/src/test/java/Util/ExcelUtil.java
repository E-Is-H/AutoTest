package Util;


import Entit.Case3;
import Entit.Rest;
import Entit.Variable;
import Entit.WriteBackData;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExcelUtil {
    //根据caseId获取行数
    public  static Map<String,Integer> rowvaule= new HashMap<String, Integer>();
    // 保存列名列索引
    public  static Map<String,Integer> cellvalue= new HashMap<String, Integer>();
    //用来保存批量回写数据对象
    public static List<WriteBackData> writeBackDataList= new ArrayList<WriteBackData>();


    static {
        //映射数据加载
        loadRownumAndCellnumMapp(System.getProperty("user.dir")+"\\src\\test\\resources\\GetCase-v6.xls","用例");
    }

    private static void loadRownumAndCellnumMapp(String excelpath, String sheetname) {
        //传入输入流对象
        InputStream inputStream= null;
        try {
            inputStream = new FileInputStream(new File(excelpath));
            Workbook workbook=WorkbookFactory.create(inputStream);
            Sheet sheet=workbook.getSheet(sheetname);
            //获取第一行数据，标题
            Row titlerow=sheet.getRow(0);
           if (titlerow!=null){
               //获取所有的列
               int lastcell=titlerow.getLastCellNum();
               //循环处理标题行的每一列
               for (int i=0;i<lastcell;i++){
                   Cell cell=titlerow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                   //设置列为字符串
                   cell.setCellType(CellType.STRING);
                   // 获取标题
                  String value= cell.getStringCellValue();
                  value=value.substring(0,value.indexOf("("));
                  // 获取列索引
                  int cellnum=cell.getAddress().getColumn();
                  //把获取的列放入列数组中
                   cellvalue.put(value,cellnum);

               }
           }
        //从第二行开始获取所有数据
          int lastrow=sheet.getLastRowNum();
           //循环拿到每行数据
            for(int i =1;i<=lastrow;i++){
                Row datarow=sheet.getRow(i);

                Cell firstcell=datarow.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                firstcell.setCellType(CellType.STRING);
                String caseId=firstcell.getStringCellValue();
                int rownum =datarow.getRowNum();
                rowvaule.put(caseId, rownum);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {

                try {
                    if (inputStream!=null){
                    inputStream.close();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

        }


    }

    /**
     *
     * @param excelpath   excel路径
     * @param rows        行数
     * @param cells        列数
     * @return              表格中的数据
     */
   /*public  static Object[][] data(String excelpath,String sheetName,int [] rows ,int [] cells) {
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
   }*/

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
        } catch (Exception e) {
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

                }else if(object instanceof Variable){
                Variable variable = (Variable) object;
                VariableUtil.variableList.add(variable);

            }

        }
        //获取行
        //获取列
    }




    /**
     * 诙谐接口报文
     * @param excelpath  excel路径
     * @param sheetname
     * @param caseId
     * @param cellname
     * @param result
     */

    public static void writeAxtualResponseData(String excelpath,String sheetname,String caseId, String cellname, String result) {
        InputStream inputStream=null;
        OutputStream outputStream=null;

        try {
            inputStream=new FileInputStream(new File(excelpath));
            Workbook workbook=WorkbookFactory.create(inputStream);
            Sheet sheet=workbook.getSheet(sheetname);
            System.out.print("########"+rowvaule+"#########################3");
            int rownum=rowvaule.get(caseId);

            Row row=sheet.getRow(rownum);
            int cellnum=cellvalue.get(cellname);
            Cell cell=row.getCell(cellnum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(result);

          outputStream=new FileOutputStream(new File(excelpath));
            workbook.write(outputStream);



        } catch (Exception e) {
            e.printStackTrace();
        }finally {

                try {
                    if (outputStream!=null){
                        outputStream.close();
                    }
                    if(inputStream!=null) {
                        inputStream.close();
                    }


                } catch (IOException e) {
                    e.printStackTrace();

            }
        }


    }


    /**
     * Excel不浪费时间
     *  路径
     */
    public static void batchWriteBackDatas(String Path) {
        InputStream inputStream=null;
        OutputStream outputStream=null;
        File file=new File(Path);

        try {
            /* 读取文件*/
            inputStream=new FileInputStream(file);
            /* 获取整个excel表格*/
            Workbook workbook=WorkbookFactory.create(inputStream);
            /* 循环获取writeBackDataList对象数组中的数据*/
            for(WriteBackData writeBackData:writeBackDataList){
                /* 获取表格中页面名字*/
                String sheetName=writeBackData.getSheetName();
                /* 把表格名放入sheet中获取到整个表格,返回一个*/
               Sheet sheet= workbook.getSheet(sheetName);
                /* 获取行caseId*/
               String caseId =writeBackData.getCaseId();
                /* 获取行索引，跟句CaseId，获得这行的位置*/
                int rownum=rowvaule.get(caseId);
                /* 根据行索引获取这行数据 AxtualResponseData*/
                Row row=sheet.getRow(rownum);
                /* 获取列名*/
               String cellName= writeBackData.getCellName();
                /* 根据列名，获取列索引*/
                int  cellnum=cellvalue.get(cellName);
                /* 根据列索引获取这列*/
                Cell cell=row.getCell(cellnum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                /* 指定cell类型*/
                cell.setCellType(CellType.STRING);
                /* 获取实际数据结果*/
                String result=writeBackData.getResult();
                /* 数据已经放入表格中*/
                cell.setCellValue(result);
                 //inputStream.close();

                /* 写入数据*/
            }

                outputStream = new FileOutputStream(file);
                workbook.write(outputStream);
                //workbook.write(outputStream);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

                try {
                    if (outputStream!=null){
                        outputStream.close();
                    }
                    if (inputStream!=null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }


    }
}
