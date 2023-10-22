package com.example.ConnectionPool;

public class Main1 {

    public static void main(String[] args) {
        MySqlConnection mySqlConnection = new MySqlConnection();
        LoggingConnectionDecorator loggingConnectionDecorator = new LoggingConnectionDecorator(mySqlConnection);

        loggingConnectionDecorator.connect();
        loggingConnectionDecorator.execute("SELECT * FROM table1");
        loggingConnectionDecorator.close();
    }
}
