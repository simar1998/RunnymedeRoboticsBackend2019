package database.dao;

import DataStructureClasses.Auto;
import database.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Auto dao.
 */
public class AutoDAO {

    /**
     * The constant INSERT_SQL_QUERRY.
     */
    public static final String INSERT_SQL_QUERRY = "INSERT INTO AUTO(ID,STRING_POS,PLACE_POS,STARTING_OBJ,TIME) VALUES (?,?,?,?,?)";
    /**
     * The constant SELECT_SQL_QUERRY.
     */
    public static final String SELECT_SQL_QUERRY = "SELECT * FROM AUTO";

    /**
     * Insert auto sql.
     *
     * @param auto the auto
     * @throws SQLException the sql exception
     */
    public static void insertAutoSQL(Auto auto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = JDBCHelper.getConnection();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");
                return;
            }
            ps = con.prepareStatement(INSERT_SQL_QUERRY);
            ps.setInt(1,auto.getId());
            ps.setString(2,auto.getStartPos());
            ps.setString(3,auto.getPlacePos());
            ps.setString(4,auto.getStartingObj() + "");
            ps.setFloat(5,auto.getTime());
            ps.execute();
            System.out.println("SQL QUERRY ===> " + ps.toString());
            con.commit();
        }
        catch (SQLException e){
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                throw e1;
            }
            throw e;
        }
        finally {
            try {
                JDBCHelper.closePrepaerdStatement(ps);
                JDBCHelper.closeConnection(con);
            } catch (SQLException e) {
                throw e;
            }
        }
    }


    /**
     * Select firmwares sql auto.
     *
     * @return the auto
     * @throws SQLException the sql exception
     */
    public static Auto selectFirmwaresSQL() throws SQLException{
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        Auto auto = new Auto();

        try
        {
            con = JDBCHelper.getConnection();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");

            }
            ps = con.prepareStatement(SELECT_SQL_QUERRY);
            rs = ps.executeQuery();
            System.out.println( "retriveCommands => " + ps.toString() );
            while (rs.next())
            {
                auto.setId(rs.getInt("ID"));
                auto.setStartPos(rs.getString("STRING_POS"));
                auto.setPlacePos(rs.getString("PLACE_POS"));
                auto.setStartingObj(rs.getString("STARTING_OBJ").charAt(0));
                auto.setTime(rs.getFloat("TIME"));
            }

        }
        catch (SQLException e)
        {
            throw e;
        }

        finally {
            try
            {
                JDBCHelper.closeResultSet( rs );
                JDBCHelper.closePrepaerdStatement( ps );
                JDBCHelper.closeConnection( con );
            }
            catch ( SQLException e )
            {
                throw e;
            }
        }
        return commands;
    }




}
