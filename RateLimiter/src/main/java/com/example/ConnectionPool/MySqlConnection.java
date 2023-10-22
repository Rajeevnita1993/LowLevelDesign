package com.example.ConnectionPool;

public class MySqlConnection implements Connection{

    @Override
    public void connect() {
        System.out.println("Connected to MySql database");

    }

    @Override
    public void execute(String query) {
        System.out.println("Executing sql query: "+query);

    }

    @Override
    public void close() {
        System.out.println("Closing MySql connection");

    }
}
