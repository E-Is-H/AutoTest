package Util;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JdbcUtil {
    public static void main(String[] args) throws Exception {

            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
            String url = "jdbc:mysql://192.168.42.102:3306/Test?serverTimezone=UTC&useSSL=false";
            String user = "root";
            String password = "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM AutoMation";
            // 调用查询方法，执行方法，返回结果集
            ResultSet rs = stmt.executeQuery(sql);
            // 获取查询相关信息
        ResultSetMetaData resultSet=rs.getMetaData();
        // 获取查询字段的数目
       int  columncount=resultSet.getColumnCount();
       //从结果集取查询数据
        Map map=new HashMap<String, Object>();
            while(rs.next()) {
                // 循环取出每个查询字段


                for (int i =1;i<=columncount;i++){
                   String coiumnLable= resultSet.getColumnLabel(i);
                   String coiumnvalue=rs.getObject(coiumnLable).toString();
                    map.put(coiumnLable,coiumnvalue);

                }

            }
            // 回收资源
            rs.close();
            stmt.close();
            conn.close();

        System.out.println("=================="+ map.get("id"));
        System.out.println("=================="+ map.get("name"));
        System.out.println("=================="+ map.get("PASSWORD"));

        }


}
