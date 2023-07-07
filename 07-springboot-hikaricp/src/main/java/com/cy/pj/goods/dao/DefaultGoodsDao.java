package com.cy.pj.goods.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DefaultGoodsDao implements  GoodsDao {
    //has a
    @Autowired
    private DataSource dataSource;

    @Override
    public List<Map<String, Object>> findGoods() {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        //1.获取连接对象
        try {
            conn = dataSource.getConnection();
            //2.创建Statement对象(负责发送sql-sql传送器)
            stmt = conn.createStatement();
            //3.发送sql
            String sql = "select id,name,remark,createdTime from tb_goods";
            rs = stmt.executeQuery(sql);
            //4.处理结果集
            List<Map<String,Object>> list=new ArrayList<>();
            //获取结果集中的元数据(描述数据的数据-例如表名,字段名,....)
            ResultSetMetaData  rsmd=rs.getMetaData();
            while (rs.next()) {//循环一次取一行,一行记录映射为一个map对象
                //方法1
//                Map<String,Object> map=new HashMap<>();
//                map.put("id", rs.getInt(1));
//                map.put("name", rs.getString(2));
//                map.put("remark", rs.getString(3));
//                map.put("createdTime",rs.getTimestamp(4));
                //方法2
//                Map<String,Object> map=new HashMap<>();
//                for(int i=1;i<=rsmd.getColumnCount();i++) {
//                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));
//                }
//                list.add(map);
                //方法3 对共性操作进行封装
                list.add(rowMap(rsmd, rs));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally{
            //5.释放资源
//            if(rs!=null)try{rs.close();}catch (SQLException e){}
//            if(stmt!=null)try{stmt.close();}catch (SQLException e){}
//            if(conn!=null)try{conn.close();}catch (SQLException e){}
            close(rs, stmt,conn);
        }
    }
    private void close(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null)try{rs.close();}catch(Exception e){e.printStackTrace();}
        if(stmt!=null)try{stmt.close();}catch(Exception e){e.printStackTrace();}
        //这里的连接是返回到了池中
        if(conn!=null)try{conn.close();}catch(Exception e){e.printStackTrace();}
    }
   private Map<String,Object> rowMap(ResultSetMetaData rsmd,ResultSet rs)throws SQLException{
        Map<String,Object> map=new HashMap<>();
        int count=rsmd.getColumnCount();
        for(int i=1;i<=count;i++) {
            map.put(rsmd.getColumnLabel(i), rs.getObject(i));
        }
        return map;
    }
}
