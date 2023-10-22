package com.example.ConnectionPool;

public class LoggingConnectionDecorator implements Connection{

    private Connection wrappedConnection;

    public LoggingConnectionDecorator(Connection connection) {
        this.wrappedConnection = connection;
    }

    @Override
    public void connect() {
        System.out.println("Logging: connection started");
        wrappedConnection.connect();

    }

    @Override
    public void execute(String query) {
        System.out.println("Logging query: "+query);
        wrappedConnection.execute(query);

    }

    @Override
    public void close() {
        System.out.println("Logging: connection closed");
        wrappedConnection.close();

    }
}
