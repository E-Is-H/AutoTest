package TestUtil.HttpClientUtil;



import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGetClient {
    public static void main(String[] args) throws Exception {
        // interface address
        String uri ="http://127.0.0.1:8899/getparameter";
        // Test Data
        String name ="123456";
        String password = "123456";
        // get带参数访问，可直接把请求参数以拼接字符串的形式进行访问，格式 IP:PORT/path?参数
        uri +="?name="+name+"&password="+password;
        // 指定请求方式
        HttpGet httpGet=new HttpGet(uri);
        //发送请求
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //开始法功请求并且接受服务器返回数据
        HttpResponse httpResponse =httpClient.execute(httpGet);
        String responsedata= EntityUtils.toString(httpResponse.getEntity());
        System.out.print(responsedata);

    }
}
