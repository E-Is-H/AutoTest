package Util;

import Entit.Rest;

import java.util.ArrayList;
import java.util.List;

public class RestUtil {
    public  static List<Rest> rests= new ArrayList<Rest>();
    static{
        try {
            ExcelUtil.load(System.getProperty("user.dir")+"/src/test/resources/GetCase-v6.xls","接口地址",Rest.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String geturlByApiId(String apiId) {
        for (Rest rest : rests) {
            if(rest.getApiId().equals(apiId)){
                return rest.getUrl();
            }

        }
        return null;
    }


    public static String geturlBytype(String apiId) {
        for (Rest rest : rests) {
            if(rest.getApiId().equals(apiId)){
                return rest.getType();
            }

        }
        return null;
    }

    public static void main(String[] args) {
          for (Rest rest:rests){
              System.out.print(rest);
          }
    }
}
