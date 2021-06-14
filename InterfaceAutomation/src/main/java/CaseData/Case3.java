package CaseData;



public  class Case3 {
    private String CaseId;
    private String Desc;
    private String ApiId;
    private String TestData;
    private String ExpectedResponseData;
    private String AxtualResponseData;


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


    @Override
    public String toString() {

        return "CaseId=" +CaseId +",Desc=" + Desc + ", ApiId=" + ApiId + ", TestData=" +TestData+ ", ExpectedResponseData=" +ExpectedResponseData+ ", AxtualResponseData=" +AxtualResponseData;
    }

}

