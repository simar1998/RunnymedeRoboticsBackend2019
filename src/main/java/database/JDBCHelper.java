package database;

import java.sql.*;

/**
 * The type Jdbc helper.
 *
 * @author Simar
 */
public class JDBCHelper
{
   private static Connection connection;

   static
   {
      try
      {
         Class.forName( JDBCConstants.DRIVER_NAME );
      }
      catch ( ClassNotFoundException e )
      {
         System.out.println( "Driver class not found" );
      }
   }

   /**
    * Load driver.
    */
   public static void loadDriver(){
      try
      {
         Class.forName( JDBCConstants.DRIVER_NAME );
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
   public static Connection getConnection() throws SQLException
   {
      connection = DriverManager.getConnection( JDBCConstants.URL, JDBCConstants.USERNAME, JDBCConstants.PASSWORD );
      return connection;
   }

   /**
    * Close connection.
    *
    * @param con the con
    * @throws SQLException the sql exception
    */
   public static void closeConnection( Connection con ) throws SQLException
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
   public static void closePrepaerdStatement( PreparedStatement stmt ) throws SQLException
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
   public static void closeResultSet( ResultSet rs ) throws SQLException
   {
      if ( rs != null )
      {
         rs.close();
      }
   }

}
