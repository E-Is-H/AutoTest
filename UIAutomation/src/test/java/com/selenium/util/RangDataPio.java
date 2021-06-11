package com.selenium.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import sun.rmi.log.LogInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RangDataPio {
    // 读取Excel测试数据，供testcase使用
    public static Object[] [] poiRangeData(String filepath) throws IOException{
        File file=new File(filepath);
        FileInputStream inputStream =new FileInputStream(file);
        Workbook workbook=null;
        Sheet sheet=null;
        String extensionName =filepath.substring(filepath.indexOf("."));

        if (extensionName.equals(".xls")){
            workbook=new HSSFWorkbook(inputStream);
        }else if (extensionName.equals(".xlsx")){
            //workbook=new
        }else{
            System.out.println("文件格式不正确");
        }

        //Sheet sheet=workbook.getSheetAt(0);
        //获取sheet页面
        for(int z=0; z<workbook.getNumberOfSheets(); z++){
            sheet=workbook.getSheetAt(z);
            if (sheet.getSheetName().contains("aaa")){
                break;
            }else {
                continue;
            }

        }
//        System.out.println("------------"+sheet.getRow(0).getCell(0).getStringCellValue());

        //获取整体行数,最后一行减去第一行
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();

        List<Object[]> records=new ArrayList<Object[]>();

        for(int i=1;i<rowCount+1;i++){
            Row row=sheet.getRow(i);
            String fields[]=new String[row.getLastCellNum()];
            for(int j=0;j<row.getLastCellNum();j++){
                fields[j]=row.getCell(j).getStringCellValue();

            }
            records.add(fields);
        }

        System.out.println(records.size());
        Object[] [] results=new Object[records.size()][];

        for (int i=0; i<records.size();i++){
            results[i]=records.get(i);
        }
        return results;

    }

    public static void main(String[] args) throws Exception {
        Object [] [] arrly=poiRangeData("D:\\test\\test_data.xls");
        System.out.println(arrly);
    }
}
