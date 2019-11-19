package com.smile.excelutils;

import java.sql.*;
import java.util.Random;

/**
 * 数据库测试数据创建
 */
public class TestDatabase {

    private final int DATA_MAX = 10000;
    private final int IN_NUM = 1000;

    private Random rand = new Random();
    private String[] word = new String[] { "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0" };

    private Connection getConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/excel?useSSL=false",
                        "root", "141211");
        Statement stmt = connect.createStatement();

        String sql =
                "INSERT INTO ttl_product_info VALUES (null, ?, 0, ?, ?, ?, ?, ?, ?, ?, ?, now(), now(), 0)";
        return connect;
    }

    private String SqlBuilder(int dataSum) {
        String sql = "INSERT INTO ttl_product_info " +
                "(id, product_name, category_id, category_name, branch_id, branch_name, " +
                "shop_id, shop_name, price, stock, sales_num, create_time, update_time, is_del) VALUES ";

        StringBuilder sqlBuff = new StringBuilder(sql);
        for (int i = 0; i < dataSum; i++) {
            StringBuilder name = new StringBuilder();
            for (int q = 0; q < rand.nextInt(5)+1; q++) {
                name.append(word[rand.nextInt(word.length)]);
            }
            String temp = name.toString();
            sqlBuff.append("(null, \"" + temp + "\", 0, \"" + temp + "\", " +
                    + i + ", " + i + ", " + i + ", " + i + ", " +
                    i + ", " + i + ", " + i + ", now(), now(), 0),");
        }

        return sqlBuff.substring(0, sqlBuff.length()-1);
    }

    private void insetData() throws SQLException, ClassNotFoundException {

        Connection conn = getConnect();
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();

        for (int i = 0; i < DATA_MAX/IN_NUM; i++) {
            stmt.addBatch(SqlBuilder(IN_NUM));
            System.out.println(i);
            if((i+1) % 10 == 0) {
                stmt.executeBatch();
                stmt.clearBatch();
            }
        }

        if(DATA_MAX % IN_NUM > 0) {
            stmt.addBatch(SqlBuilder(DATA_MAX % IN_NUM));
            stmt.executeBatch();
            stmt.clearBatch();
        }

        conn.commit();
        stmt.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        long start = System.currentTimeMillis();
        new TestDatabase().insetData();
        long end = System.currentTimeMillis();
        double t = (double)(end-start)/1000;
        System.out.println(t);
    }
}
