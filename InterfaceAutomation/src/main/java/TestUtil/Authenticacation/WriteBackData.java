package TestUtil.Authenticacation;


/***
 * 回写数据对象
 */
public class WriteBackData {
    // 表单名
    private String sheetName;
    // 用例编号
    private  String caseId;
    // 写到那列的列名，实际数据这列
    private  String cellName;
    // 实际数据
    private  String result;
    public WriteBackData(String sheetName, String caseId, String cellName, String result) {
        this.sheetName = sheetName;
        this.caseId = caseId;
        this.cellName = cellName;
        this.result = result;
    }

    public WriteBackData() {
       super();
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
