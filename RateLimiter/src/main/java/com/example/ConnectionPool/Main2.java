package com.example.ConnectionPool;

public class Main2 {

    public static void main(String[] args) {
        ConnectionPool connectionPool = new MyConnectionPool(4);

        Connection conn1 = connectionPool.getConnection();
        conn1.connect();
        conn1.execute("SELECT * FROM table1");
        connectionPool.releaseConnection(conn1);

        Connection conn2 = connectionPool.getConnection();
        conn2.connect();
        conn2.execute("INSERT INTO table2 VALUES (1, 'data')");
        connectionPool.releaseConnection(conn2);
    }
}
