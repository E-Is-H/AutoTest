package TestUtil.HttpClientUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;



public class HttpPostClient {

    public static void main(String[] args) throws Exception{
        String uri ="http://127.0.0.1:8899/postdemo";
        // 声明一个 client 对象，用于方法的执行
       CloseableHttpClient httpclient = HttpClients.createDefault();



        // 声明一个 POST方法
        HttpPost post = new HttpPost(uri);

        // 添加参数
        JSONObject param = new JSONObject();
        param.put("name", "huanhansan");
        param.put("age", "18");

        // 设置请求头信息
        post.setHeader("content-type","applicaton/json");
        // 将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        // 声明一个对象来进行响应结果存储
        String results;
        // 设置 cookies 信息

        // 执行 POST 方法
        HttpResponse response = httpclient.execute(post);
        // 获取响应结果
        results = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(results);



    }
}
