package Entity;

public class CaseDataEntity {
    private String IsEegtive;
    private String Desc;
    private String Username;
    private String Password;
    private String ExpectedResponseData;
    private String AxtualResponseData;

    @Override
    public String toString() {
        return "CaseDataEntity{" +
                "IsEegtive='" + IsEegtive + '\'' +
                ", Desc='" + Desc + '\'' +
                ", username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", ExpectedResponseData='" + ExpectedResponseData + '\'' +
                ", AxtualResponseData='" + AxtualResponseData + '\'' +
                '}';
    }

    public String getIsEegtive() {
        return IsEegtive;
    }

    public void setIsEegtive(String isEegtive) {
        IsEegtive = isEegtive;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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
}
