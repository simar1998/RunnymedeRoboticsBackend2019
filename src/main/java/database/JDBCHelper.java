package database;

import java.sql.*;

/**
 * The type Jdbc helper.
 *
 * @author Simar
 */
public class JDBCHelper
{

   final String DRIVER_NAME = "com.mysql.jdbc.Driver";
   /**
    * The constant URL.
    */
  final String URL         = "jdbc:mysql://localhost:3306/dbName";
   /**
    * The constant USERNAME.
    */
   final String USERNAME    = "root";
   /**
    * The constant PASSWORD.
    */
   final String PASSWORD    = "";

   /**
    * The constant DRIVER_NAME FOR CLOUD SERVER.
    */
   final String DRIVER_NAME_CLOUD = "com.mysql.jdbc.Driver";
   /**
    * The constant URL.
    */
   final String URL_CLOUD         = "jdbc:mysql://localhost:3306/dbName";
   /**
    * The constant USERNAME.
    */
   final String USERNAME_CLOUD    = "root";
   /**
    * The constant PASSWORD.
    */
   final String PASSWORD_CLOUD    = "";


   private Connection connection;

   boolean isConnectionCloud = false;

   public JDBCHelper( Boolean isConnectionCloud) {
      try
      {
          this.isConnectionCloud = isConnectionCloud;
         if(isConnectionCloud) {
            Class.forName(DRIVER_NAME_CLOUD);
         }
         else {
            Class.forName(DRIVER_NAME);
         }
      }
      catch ( ClassNotFoundException e )
      {
         System.out.println( "Driver class not found" );
      }
   }


   /**
    * Load driver.
    */
   public  void loadDriver(){
      try
      {
         if(isConnectionCloud) {
            Class.forName(DRIVER_NAME_CLOUD);
         }
         else {
            Class.forName(DRIVER_NAME);
         }
      }
      catch ( ClassNotFoundException e )
      {
         System.out.println( "Driver class not found" );
      }
   }

   /**
    * Gets connection.
    *
    * @return the connection
    * @throws SQLException the sql exception
    */
   public Connection getConnection() throws SQLException
   {
      if(isConnectionCloud) {
         connection = DriverManager.getConnection( URL_CLOUD, USERNAME_CLOUD, PASSWORD_CLOUD );
      }
      else {

      }
      connection = DriverManager.getConnection( URL, USERNAME, PASSWORD );
      return connection;
   }

   /**
    * Close connection.
    *
    * @param con the con
    * @throws SQLException the sql exception
    */
   public void closeConnection( Connection con ) throws SQLException
   {
      if ( con != null )
      {
         con.close();
      }
   }

   /**
    * Close prepaerd statement.
    *
    * @param stmt the stmt
    * @throws SQLException the sql exception
    */
   public void closePrepaerdStatement( PreparedStatement stmt ) throws SQLException
   {
      if ( stmt != null )
      {
         stmt.close();
      }
   }

   /**
    * Close result set.
    *
    * @param rs the rs
    * @throws SQLException the sql exception
    */
   public void closeResultSet( ResultSet rs ) throws SQLException
   {
      if ( rs != null )
      {
         rs.close();
      }
   }


   /**
    * Gets isConnectionCloud.
    *
    * @return Value of isConnectionCloud.
    */
   public boolean isIsConnectionCloud() {
      return isConnectionCloud;
   }

   /**
    * Sets new isConnectionCloud.
    *
    * @param isConnectionCloud New value of isConnectionCloud.
    */
   public void setIsConnectionCloud(boolean isConnectionCloud) {
      this.isConnectionCloud = isConnectionCloud;
   }
}
