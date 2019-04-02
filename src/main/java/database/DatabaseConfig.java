package database;

import java.sql.Connection;

public class DatabaseConfig {

    public static Connection localMySQL;
    public static DatabaseConnector localConnector = new DatabaseConnector();

    public static Connection getLocalMySQLConn(){

        localConnector.setDatabaseName("robotics");
        localConnector.setIp("localhost");
        localConnector.setUserName("root");
        localConnector.setUserPassword("");

        localConnector.loadJDBCDriver();
        localMySQL = localConnector.getConnection();

        return localMySQL;
    }
}
