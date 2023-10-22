package com.example.ConnectionPool;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public class MyConnectionPool implements ConnectionPool{

    private final Queue<Connection> connections;
    private final int poolSize;
    // If you don't want to use ConcurrentLinkedQueue instead of simple LinkedList<>() then use lock
    private final ReentrantLock lock = new ReentrantLock();

    public MyConnectionPool(int maxConnection) {
        connections = new ConcurrentLinkedQueue<>();
        this.poolSize = maxConnection;
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < poolSize; i++) {
            connections.offer(new MySqlConnection());
        }
    }

    @Override
    public Connection getConnection() {
        lock.lock();
        try {
            if (connections.isEmpty()) {
                System.out.println("No available connection. Please try again.");
                return null;
            }
            return connections.poll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void releaseConnection(Connection connection) {
        lock.lock();
        try {
            if (connections.size() < poolSize) {
                connections.offer(connection);
            } else {
                System.out.println("Connection pool is full. Cannot release connection anymore");
            }
        } finally {
            lock.unlock();
        }
    }
}
