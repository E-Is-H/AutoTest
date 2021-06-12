package CaseData;



public class Case3 {
    private String CaseId;
    private String Desc;
    private String ApiId;
    private String TestData;

    public void setCaseId(String caseId) {
        CaseId = caseId;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void setApiId(String apiId) {
        ApiId = apiId;
    }


    public void setTestData(String testData) {
        TestData = testData;
    }

    public String getCaseId() {
        return CaseId;
    }

    public String getDesc() {
        return Desc;
    }

    public String getApiId() {
        return ApiId;
    }

    public String getTestData() {
        return TestData;

    }
    @Override
    public String toString() {
        return "CaseId=" +CaseId +",Desc=" + Desc + ", ApiId=" + ApiId + ", TestData=" +TestData;
    }

}

