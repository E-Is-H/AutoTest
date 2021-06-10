package TestUtil.HttpClientUtil;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.List;

public class HttpClientGetCookies {
    public static void main(String[] args) throws Exception {
        CookieStore store;
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 设置cookies信息
        store = new BasicCookieStore();
        httpclient = HttpClients.custom().setDefaultCookieStore(store).build();
        //创建一个Httpget的请求对象
        HttpGet httpget = new HttpGet("http://127.0.0.1:8899/getcookies");
        //执行请求,相当于postman上点击发送按钮，然后赋值给HttpResponse对象接收
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);

        // 读取cookie信息
        List<Cookie> cookielist = store.getCookies();
        for (Cookie cookie : cookielist) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie:name=" + name + ";value=" + value);
        }
    }
}
