package Entity;

public class CaseDataEntity {
    private String Name;
    private String Value;
    private String Remarks;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    @Override
    public String toString() {
        return "CaseDataEntity{" +
                "Name='" + Name + '\'' +
                ", Value='" + Value + '\'' +
                ", Remarks='" + Remarks + '\'' +
                '}';
    }
}
