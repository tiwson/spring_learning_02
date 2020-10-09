package com.tiwson.spring_learning_02.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.tiwson.spring_learning_02.bean.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    public List<Account> getAccount() {
        //使用jdbc的程序
        //创建连接池对象，设置4个参数
        DruidDataSource datasource = new DruidDataSource();
        //设置4个参数
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql:///spring_db?serverTimezone=UTC");
        datasource.setUsername("root");
        datasource.setPassword("root");

        //定义对象
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Account> list = new ArrayList<Account>();

        try {
            //获取连接
            conn = datasource.getConnection();
            //编写sql
            String sql = "select * from account";
            //预编译
            stmt = conn.prepareStatement(sql);
            //执行sql
            rs = stmt.executeQuery();
            //遍历结果集
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setMoney(rs.getDouble("money"));
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                stmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return list;
    }
}
