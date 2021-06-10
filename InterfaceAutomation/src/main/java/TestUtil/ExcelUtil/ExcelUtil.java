package TestUtil.ExcelUtil;


import org.apache.poi.ss.usermodel.*;
import java.io.File;


public class ExcelUtil {
   public  static Object[][] data() {
       //定义xls路径
       String datapath="F:\\AutoTest\\InterfaceAutomation\\src\\main\\java\\CaseData\\GetCase.xls";
       Object[][] datas=null;
       try {
           //获取WorkBook对像
           Workbook workbook=WorkbookFactory.create(new File(datapath));
           //获取sheet对象
           Sheet sheet=workbook.getSheet("用例");
           datas= new Object[6][2];
           //获取行，第一行是说明，所以从第二行开始,表示获取第一行sheet.getRow(1);
           for (int i =1;i<=6;i++){
              Row row= sheet.getRow(i);
               //获取列
               for (int j=5;j<=6;j++){
                   // Row.MissingCellPolicy.CREATE_NULL_AS_BLANK用来解决列值为空
                  Cell cell=row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                  // 设置类型
                   cell.setCellType(CellType.STRING);
                   String value=cell.getStringCellValue();
                   datas [i-1][j-5]=value;
               }
           }
           //获取列
       } catch (Exception e) {
           e.printStackTrace();
       }
       return datas;
   }




}
