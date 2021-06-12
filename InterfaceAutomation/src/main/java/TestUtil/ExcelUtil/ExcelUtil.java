package TestUtil.ExcelUtil;


import org.apache.poi.ss.usermodel.*;
import java.io.File;


public class ExcelUtil {
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




}
