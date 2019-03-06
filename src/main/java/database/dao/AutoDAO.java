package database.dao;

import DataStructureClasses.Auto;
import database.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * The type Auto dao.
 */
public class AutoDAO {

    /**
     * The constant INSERT_SQL_QUERRY.
     */
    public static final String INSERT_SQL_QUERRY = "INSERT INTO AUTO(ID,STARTING_POS,PLACE_POS,STARTING_OBJ,TIME_VAL,AUTO_LVL,AUTO_ORDER,AUTO_PRELOAD) VALUES (?,?,?,?,?,?,?,?)";
    /**
     * The constant SELECT_SQL_QUERRY.
     */
    public static final String SELECT_SQL_QUERRY = "SELECT ID,STRING_POS,PLACE_POS,STARTING_OBJ,TIME FROM,AUTO_LVL,AUTO_ORDER,AUTO_PRELOAD FROM AUTO WHERE ID=?";

    /**
     * Insert auto sql.
     *
     * @param auto the auto
     * @throws SQLException the sql exception
     */
    public static void insertAutoSQL(Auto auto, boolean cloud) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        JDBCHelper jdbcHelper = null;
        try {
            if(cloud){
                jdbcHelper = new JDBCHelper(true);
                con = jdbcHelper.getConnection();
            }
            else {
                jdbcHelper = new JDBCHelper(false);
                con = jdbcHelper.getConnection();
            }
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
            ps.setInt(6,auto.getAutoLvl());
            ps.setInt(7,auto.getAutoOrder());
            ps.setString(8,auto.getAutoOrder() + "");
            con.setAutoCommit(false);
            ps.execute();
            System.out.println("SQL QUERRY ===> " + ps.toString());
            con.commit();
        }
        catch (SQLException e){
            throw e;
        }
        finally {
            try {
                jdbcHelper.closePrepaerdStatement(ps);
                jdbcHelper.closeConnection(con);
            } catch (SQLException e) {
                throw e;
            }
        }
    }


    /**
     * Select  sql auto.
     *
     * @return the auto
     * @throws SQLException the sql exception
     */
    public static Auto selectAuto(int id, boolean cloud) throws SQLException{
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        Auto auto = new Auto();
        JDBCHelper jdbcHelper = null;

            try {
                if(cloud){
                    jdbcHelper = new JDBCHelper(true);
                    con = jdbcHelper.getConnection();
                }
                else {
                    jdbcHelper = new JDBCHelper(false);
                    con = jdbcHelper.getConnection();
                }
                if (con == null) {
                    System.out.println("Error getting the connection. Please check if the DB server is running");
                    return new Auto();
                }
            ps = con.prepareStatement(SELECT_SQL_QUERRY);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            System.out.println( "retriveCommands => " + ps.toString() );
            while (rs.next())
            {
                auto.setId(rs.getInt("ID"));
                auto.setStartPos(rs.getString("STRING_POS"));
                auto.setPlacePos(rs.getString("PLACE_POS"));
                auto.setStartingObj(rs.getString("STARTING_OBJ").charAt(0));
                auto.setTime(rs.getFloat("TIME_VAL"));
                auto.setAutoLvl(rs.getInt("AUTO_LVL"));
                auto.setAutoOrder(rs.getInt("AUTO_ORDER"));
                auto.setAutoPreload(rs.getString("AUTO_PRELOAD").charAt(0));
            }

        }
        catch (SQLException e)
        {
            throw e;
        }

        finally {
            try
            {
                jdbcHelper.closeResultSet( rs );
                jdbcHelper.closePrepaerdStatement( ps );
                jdbcHelper.closeConnection( con );
            }
            catch ( SQLException e )
            {
                throw e;
            }
        }
        return auto;
    }









}
