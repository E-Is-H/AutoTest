package Util;



import java.util.HashMap;
import java.util.Map;

public class HttpClientToolsTest {
    public static void main(String[] args) throws Exception {
        HttpClientTools httpClientTools=new HttpClientTools();
        Map<String,String> map=new HashMap<String, String>();
        map.put("name","huanhansan");
        map.put("age","18");
        //System.out.print(httpClientTools.doget("http://127.0.0.1:8899/getparameter",map));
        System.out.print(httpClientTools.doPost("http://127.0.0.1:8899/post/with/headers",map));
    }
}
