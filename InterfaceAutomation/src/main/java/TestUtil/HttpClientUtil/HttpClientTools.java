package TestUtil.HttpClientUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.Map;
import java.util.Set;

public class HttpClientTools {

    public String doget(String url, Map<String ,String>params) throws Exception{
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
        HttpResponse httpResponse =httpClient.execute(httpGet);
        String responsedata= EntityUtils.toString(httpResponse.getEntity());
        return responsedata;
    }
    public String doPost(String url, Map<String ,String>params)throws Exception{
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
        // 设置 cookies 信息

        // 执行 POST 方法
        HttpResponse response = httpclient.execute(post);
        // 获取响应结果
        results = EntityUtils.toString(response.getEntity());
        return results;
    }
}
