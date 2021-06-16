package Case;


import Util.CaseUtil;
import Util.HttpClientTools;
import Util.RestUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 注册测试组件
 */
public class ExcelUtilTest3 {
    public static void main(String[] args) throws Exception {


        String apiId="";
        String cellName[]={"ApiId","TestData"};
        Object[][]   datas= CaseUtil.getCaseDatasByapId("1", cellName);


        for (Object[] objects:datas) {
            apiId = objects[0].toString();
            Object object1 = objects[1].toString();
            Map<String, String>   pamar = (Map<String, String>) JSONObject.parse(object1.toString());
            String url = RestUtil.geturlByApiId(apiId);
            String type = RestUtil.geturlBytype(apiId);
            System.out.print(pamar);

           System.out.print(HttpClientTools.doService(url,type,pamar));


        }

    }
}

