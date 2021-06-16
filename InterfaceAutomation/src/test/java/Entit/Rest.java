package Entit;

public class Rest {

    private String ApiId;
    private String ApiName;
    private String Type;
    private String Url;

    public void setApiId(String apiId) {
        ApiId = apiId;
    }

    public void setApiName(String apiName) {
        ApiName = apiName;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getApiId() {
        return ApiId;
    }

    public String getApiName() {
        return ApiName;
    }

    public String getType() {
        return Type;
    }

    public String getUrl() {
        return Url;
    }
    @Override
    public String toString() {
        return "ApiId=" +ApiId +",ApiName=" + ApiName + ", Type=" + Type + ", Url=" +Url;
    }


}
