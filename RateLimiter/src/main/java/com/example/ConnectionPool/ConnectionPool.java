package com.example.ConnectionPool;

public interface ConnectionPool {
    Connection getConnection();
    void releaseConnection(Connection connection);
}
