package Util;

import Entit.DBCheck;
import Entit.DBQuerResult;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class DBCheckUtil {
    /**
     * 根据脚本执行的语句并返回结果
     * @param validtesql  需要执行的sql语句
     * @return
     */
    public static String doQuert(String validtesql) {
        // 将脚本数据封装成对象
        List<DBCheck> list=JSONObject.parseArray(validtesql, DBCheck.class);
        // 创建一个list数组用来存储dbQuerResultList对象
        List<DBQuerResult> dbQuerResultList =new ArrayList<DBQuerResult>();
        // 循环遍历取出sql脚本实体
        for (DBCheck dbCheck:list){
            // 拿到sql编号
            String no=dbCheck.getNo();
            String sql=dbCheck.getSql();
            // 执行查询，返回结果，这里使用jdbc完成
            /* Map<String,Object> columLabAnndValues = JDBCutil.query(sql)*/
            // 把查询结果封装到 DBQuerResult 实体类中,创建DBQuerResult对象
            DBQuerResult dbQuerResult=new DBQuerResult();
            // 调用set方法
            dbQuerResult.setNo(no);
            /* 因为这里并未使用JDBC链接数据库，所以就先注释掉*/
            // dbQuerResult.setColumenLableAndValues(columLabAnndValues);
            // 使用set方法把数据放到实体类中，保存到list中去
            dbQuerResultList.add(dbQuerResult);
        }
        //用来解析list数组的方法，直接返回String类型
    return JSONObject.toJSONString(dbQuerResultList);
    }



}
