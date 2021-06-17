package Entit;



public  class Case3 {
    private String CaseId;
    private String Desc;
    private String ApiId;
    private String TestData;
    private String ExpectedResponseData;
    private String AxtualResponseData;
    private String BeforeSql;
    private String AfterSql;
    private String BeforeResult;
    private String AfterResult;

    public String getCaseId() {
        return CaseId;
    }

    public void setCaseId(String caseId) {
        CaseId = caseId;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getApiId() {
        return ApiId;
    }

    public void setApiId(String apiId) {
        ApiId = apiId;
    }

    public String getTestData() {
        return TestData;
    }

    public void setTestData(String testData) {
        TestData = testData;
    }

    public String getExpectedResponseData() {
        return ExpectedResponseData;
    }

    public void setExpectedResponseData(String expectedResponseData) {
        ExpectedResponseData = expectedResponseData;
    }

    public String getAxtualResponseData() {
        return AxtualResponseData;
    }

    public void setAxtualResponseData(String axtualResponseData) {
        AxtualResponseData = axtualResponseData;
    }

    public String getBeforeSql() {
        return BeforeSql;
    }

    public void setBeforeSql(String beforeSql) {
        BeforeSql = beforeSql;
    }

    public String getAfterSql() {
        return AfterSql;
    }

    public void setAfterSql(String afterSql) {
        AfterSql = afterSql;
    }

    public String getBeforeResult() {
        return BeforeResult;
    }

    public void setBeforeResult(String beforeResult) {
        BeforeResult = beforeResult;
    }

    public String getAfterResult() {
        return AfterResult;
    }

    public void setAfterResult(String afterResult) {
        AfterResult = afterResult;
    }

    @Override
    public String toString() {

        return "CaseId=" +CaseId +",Desc=" + Desc + ", ApiId=" + ApiId + ", TestData=" +TestData+ ", ExpectedResponseData=" +ExpectedResponseData+ ", AxtualResponseData=" +AxtualResponseData+ ", BeforeSql=" +BeforeSql+ ", AfterSql=" +AfterSql+ ", BeforeResult=" +BeforeResult+ ", AfterResult=" +AfterResult;
    }

}

