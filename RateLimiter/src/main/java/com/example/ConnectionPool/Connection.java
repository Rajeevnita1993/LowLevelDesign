package com.example.ConnectionPool;

public interface Connection {
    void connect();
    void execute(String query);
    void close();
}
