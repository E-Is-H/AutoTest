package TestUtil.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

public class HttpClientToolsTest {
    public static void main(String[] args) throws Exception {
        HttpClientTools httpClientTools=new HttpClientTools();
        Map<String,String> map=new HashMap<String, String>();
        map.put("name","123456");
        map.put("password","123456");
        System.out.print(httpClientTools.doget("http://127.0.0.1:8899/getparameter",map));
    }
}
