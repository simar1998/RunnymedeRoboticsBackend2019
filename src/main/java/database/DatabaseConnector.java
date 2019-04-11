package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

/**
 * Stores database information and also establishes connection to the database
 */
public class DatabaseConnector {

    private Connection connection = null;

    private boolean isDriverLoaded = false;
    private boolean areCredentialsPresent = false;

    private String ip = "";
    private String databaseName = "";
    private String userName = "";
    private String userPassword = "";
    private String port = "3306";

    /**
     * Instantiates a new Database connector.
     */
    public DatabaseConnector() {
    }

    /**
     * Loads jdbc driver.
     */
    public void loadJDBCDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            isDriverLoaded = true;
            System.out.println("MySQL JDBC driver registered");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver Load error in JDBC Driver Class");
            e.printStackTrace();
            isDriverLoaded = false;
        }

    }

    /**
     * Gets connection and returns a connection object to be used to send MySQL queries.
     *
     * @return the connection
     */
    public Connection getConnection() {
        if(!isDriverLoaded){
            loadJDBCDriver();
        }
        checkCreds();
        if (areCredentialsPresent) {
            try {
                System.out.println("MYSQL URL : jdbc:mysql://"+ip+":"+port+"/"+databaseName +" "+userName+ " " +userPassword);
                connection = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+databaseName+"?autoReconnect=true&useSSL=false",userName,userPassword);
                if (connection != null){
                    System.out.println("Connection to database " + databaseName + " successful with user " + userName);
                }
                else {
                    System.out.println("Connection to database " + databaseName + " failed with user " + userName);
                }
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("JDBC Connection error, please check user credentials");
            }
        }
        else {
            System.out.println("MYSQL user credentials are not present, please register credentials first");
            return null;
        }
        return connection;
    }

    /**
     * Check creds boolean to see if the user credentials are present.
     *
     * @return the boolean
     */
    public boolean checkCreds(){
        if (userName.isEmpty()||ip.isEmpty()||userName.isEmpty()){
            areCredentialsPresent = false;
            return false;
        }
        else {
            areCredentialsPresent = true;
            return true;
        }
    }

    /**
     * Is driver loaded boolean.
     *
     * @return the boolean
     */
    public boolean isDriverLoaded() {
        return isDriverLoaded;
    }

    /**
     * Is are credentials present boolean.
     *
     * @return the boolean
     */
    public boolean isAreCredentialsPresent() {
        return areCredentialsPresent;
    }

    /**
     * Gets ip.
     *
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Gets database name.
     *
     * @return the database name
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets user password.
     *
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * Sets connection.
     *
     * @param connection the connection
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Sets ip.
     *
     * @param ip the ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Sets database name.
     *
     * @param databaseName the database name
     */
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Sets user password.
     *
     * @param userPassword the user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Sets port.
     *
     * @param port the port
     */
    public void setPort(String port) {
        this.port = port;
    }
}
