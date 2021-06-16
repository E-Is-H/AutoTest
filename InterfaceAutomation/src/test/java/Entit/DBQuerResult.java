package Entit;

import java.util.Map;

/**
 * 用来回写数据定义的类
 */
public class DBQuerResult {
    // 脚本编号
    private String no;
    // 脚本执行查到的数据，保存到map中，key：字段名，value：查询到的数据
    private Map<String,Object> columenLableAndValues;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Map<String, Object> getColumenLableAndValues() {
        return columenLableAndValues;
    }

    public void setColumenLableAndValues(Map<String, Object> columenLableAndValues) {
        this.columenLableAndValues = columenLableAndValues;
    }
}
