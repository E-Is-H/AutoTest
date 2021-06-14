package TestUtil.HttpClientUtil;

import com.sun.deploy.net.HttpUtils;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpClientTools {

    /* 这个数组是给下面getAndStoreCookiesFromResponseHeader方法使用，用来保存cookies的值*/
    public static Map<String,String> cookies = new HashMap<String,String>();



    public static String doget(String url, Map<String ,String>params) throws Exception{
        Set<String> keys=params.keySet();
        int mark=1;
        for (String name:keys){
            if(mark==1){
                url +="?"+name+"="+params.get(name);
            }else {
                url +="&"+name+"="+params.get(name);
            }
            mark++;
        }
        HttpGet httpGet=new HttpGet(url);
        //发送请求
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //开始法功请求并且接受服务器返回数据

        /* 这个方法必须在请求之前，添加cookies,因为要把cookies放入post中去所有要传入post，方法在本类的下方*/
        addCookiesInRequestHeaderBeforRequest(httpGet);

        HttpResponse httpResponse =httpClient.execute(httpGet);

        /* 注意：执行这个方法，把相应的数据中包含cookies的数据存入map集合中*/
        getAndStoreCookiesFromResponseHeader(httpResponse);

        String responsedata= EntityUtils.toString(httpResponse.getEntity());
        return responsedata;
    }

    /**
     *
     * @param url       接口地址
     * @param params    参数数据
     * @return          服务器信息
     * @throws Exception
     */
    public static String doPost(String url, Map<String ,String>params)throws Exception{
        Set<String> keys=params.keySet();
        JSONObject param = new JSONObject();
        for (String name:keys){
          String value= params.get(name);
          param.put(name,value);
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 声明一个 POST方法
        HttpPost post = new HttpPost(url);
        // 将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString());
        post.setEntity(entity);
        // 声明一个对象来进行响应结果存储
        String results;

        /* 这个方法必须在请求之前，添加cookies,因为要把cookies放入post中去所有要传入post，方法在本类的下方*/
       addCookiesInRequestHeaderBeforRequest(post);


        // 执行 POST 方法，接受服务器返回信息
        HttpResponse response = httpclient.execute(post);


        /* 注意：执行这个方法，把相应的数据中包含cookies的数据存入map集合中*/
       getAndStoreCookiesFromResponseHeader(response);

        // 获取响应结果
        results = EntityUtils.toString(response.getEntity());
        return results;
    }


    /* 这个方法为doPost，doget所提供*/
    private static void addCookiesInRequestHeaderBeforRequest(HttpRequest httpRequest) {
        /*  获取map中login的值 */
        String jsessioninCookies=cookies.get("login");
        /*  判断是否为空 */
        if (jsessioninCookies!=null){
            /*  不为空添加到请求信息中 */
            httpRequest.addHeader("Cookies", jsessioninCookies);
        }

    }


    /* 这个方法为doPost，doget所提供*/
    private static void getAndStoreCookiesFromResponseHeader(HttpResponse response) {
        /* 从响应头中取到cookies*/
        Header headercookies=response.getFirstHeader("Set-Cookies");
        /* 如果不为空*/
        if (headercookies!=null){
            /* 取出响应头的值*/
            String cookiespairsString=headercookies.getValue();
            if (cookiespairsString!=null&&cookiespairsString.trim().length()>0){
                /* 以这个符号为分割*/
                String [] cookiespairs=cookiespairsString.split(";");
                /* 如果这个数据不为空*/
                if (cookiespairs!=null){
                    for (String cookiesapair:cookiespairs){
                        /* 如果获取的数据包含login字样*/
                        if(cookiesapair.contains("login")){
                            /* 保存到数组之中*/
                            cookies.put("login",cookiesapair);

                        }
                    }
                }
            }
        }
    }

    public static String doService(String Url, String type,Map<String ,String> params) throws Exception {
        String result;
        if("post".equalsIgnoreCase(type)){
            result=HttpClientTools.doPost(Url, params);
        }else {
            result=HttpClientTools.doget(Url, params);
        }
        return result;
    }

    public static void main(String[] args) {
        // 获取cookies
            Map<String,String> mapparems=new HashMap<String, String>();
            mapparems.put("name", "lisi");
            mapparems.put("password","123456");
        try {
           String httpResponse= doPost("http://127.0.0.1:8899/login",mapparems);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 调用cookies

        try {

            System.out.print(doPost("http://127.0.0.1:8899/index",mapparems));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
