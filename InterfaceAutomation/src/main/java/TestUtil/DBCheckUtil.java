package TestUtil;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class DBCheckUtil {

    public static String doQuert(String validtesql) {
        // 解析json数据
        List<DBCheck> list=JSONObject.parseArray(validtesql, DBCheck.class);


    return null;
    }



}
