package Util;

import Entity.CaseEntity;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取excel
 */
public class ExcelReadWriteUtil {



    /* 读取excel表格文件 */
    // 思路：返回一个对象数据，传入对象实体类，excel ，表单

    public static  <T> List<T> ReadExcel(String excelpath, String sheetName, Class<T> calss) {
       List<T> list=new ArrayList<T>();
        excelpath = "F:\\AutoTest\\SummaryInterfaceAutomation\\src\\test\\resources\\GetCase-v6.xls";
        sheetName = "用例";


        // 获取工作表格
        InputStream inputStream = null;
        try {
            // 读取文件
            inputStream = new FileInputStream(new File(excelpath));
            // 穿件excel文件工作表格
            Workbook workbook = WorkbookFactory.create(inputStream);
            // 获取表单页面
            Sheet sheet = workbook.getSheet(sheetName);
            // 获取表单title标题给反射方法使用，title在第一行，所以先获取第一行数据
            Row tilteRow = sheet.getRow(0);
            // 获取第一行的最后一列,返回的是int类型
            int cellLastNum = tilteRow.getLastCellNum();
            /* 定义一个string数据用来存放title数据,这个数据的大小用列数来定义*/
            String[] titleData = new String[cellLastNum];
            // 使用for循环获取title数据
            for (int i = 0; i < cellLastNum; i++) {
                // 根据行获取对象的列
                Cell cell = tilteRow.getCell(i);
                // 定义cell返回类型未字符串
                cell.setCellType(CellType.STRING);
                // 获取cell的值
                String titleValue = cell.getStringCellValue();
                // 使用subStirng方法获取标题值
                String title = titleValue.substring(0, titleValue.indexOf("("));
                // 放入String数组中
                titleData[i] = title;
            }
            /*获取最后一行列数*/
            int rowLastNum = sheet.getLastRowNum();
            // 创建实例化对象,未for【j】循环提供使用
            T newInstanceObject = calss.newInstance();
            /* 循环处理每一行*/
            for (int i = 1; i < rowLastNum; i++) {
                /* 获取每一行*/
                Row row = sheet.getRow(i);
                /* 根据每一行数据，获取到每一列的数据*/
                for (int j = 0; j < cellLastNum; j++) {
                    /* 获取没一行，每一列数据,每一个单元格*/
                    Cell cell = row.getCell(j);
                    //判断一下未null跳过
                    if (cell!=null) {



                        /* 设置单元格的类型*/
                        cell.setCellType(CellType.STRING);
                        /* 获取每一个单元格的数据*/
                        String cellData = cell.getStringCellValue();
                        /* 使用反射的机制，把数据封装成对象，并返回*/

                    // 使用set方法
                    String mothername = "set" + titleData[j];
                    // 调用实例对象中的方法，调用上面的实例对象
                    Method method = calss.getMethod(mothername, String.class);
                    // 开始封装数据
                    method.invoke(newInstanceObject, cellData);
                    }
                }
                /**
                 * 直接把object对象返回，因为object已经存在数据，存在的数据取决与传过来的实例化对象是什么
                 */
                list.add(newInstanceObject);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

return  list;
    }

    public static void main(String[] args) {

        List<CaseEntity> list=ExcelReadWriteUtil.ReadExcel("F:\\AutoTest\\SummaryInterfaceAutomation\\src\\test\\resources\\GetCase-v6.xls", "用例",CaseEntity.class);
        for (CaseEntity list1:list){
            System.out.println(list1);
        }




    }
}
