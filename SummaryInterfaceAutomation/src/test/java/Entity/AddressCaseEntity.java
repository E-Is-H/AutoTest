package Entity;

/**
 * 接口地址数据封装对象
 */
public class AddressCaseEntity {
    private String ApiId;
    private String ApiName;
    private String Type;

    public String getApiId() {
        return ApiId;
    }

    public void setApiId(String apiId) {
        ApiId = apiId;
    }

    public String getApiName() {
        return ApiName;
    }

    public void setApiName(String apiName) {
        ApiName = apiName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    private String Url;

    @Override
    public String toString() {
        return "AddressCase{" +
                "ApiId='" + ApiId + '\'' +
                ", ApiName='" + ApiName + '\'' +
                ", Type='" + Type + '\'' +
                ", Url='" + Url + '\'' +
                '}';
    }
}
