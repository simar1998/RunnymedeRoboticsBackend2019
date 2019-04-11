package database.dao;

import DataStructureClasses.EndGame;
import database.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type End game dao.
 */
public class EndGameDAO {
    /**
     * The constant INSERT_SQL_QUERRY.
     */
    public static final String INSERT_SQL_QUERRY = "INSERT INTO END_GAME (ID,LEVEL_ONE,LEVEL_TWO,LEVEL_THREE,RAMP,TIME_TO_CLIMB,FAIL_LEVEL,CLIMB_START,CLIMB_END) VALUES(?,?,?,?,?,?,?,?,?)";
    /**
     * The constant SELECT_SQL_QUERRY.
     */
    public static final String SELECT_SQL_QUERRY = "SELECT ID,LEVEL_ONE,LEVEL_TWO,LEVEL_THREE,RAMPS,TIME_TO_CLIMB,FAIL_LEVEL,CLIMB_START,CLIMB_END FROM END_GAME WHERE ID=?";

    public static final String REMOVE_ENTRY = "DELETE FROM END_GAME WHERE ID = ?";
    /**
     * Insert auto sql.
     *
     * @param endGame the end game
     * @throws SQLException the sql exception
     */
    public static void insertAutoSQL(EndGame endGame, Boolean cloud) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DatabaseConfig.getLocalMySQLConn();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");
                return;
            }
            ps = con.prepareStatement(INSERT_SQL_QUERRY);
            ps.setInt(1,endGame.getId());
            ps.setBoolean(2,endGame.isLevelOne());
            ps.setBoolean(3,endGame.isLevelTwo());
            ps.setBoolean(4,endGame.isLevelThree());
            ps.setBoolean(5,endGame.isRamp());
            ps.setFloat(6,endGame.getTimeToClimb());
            ps.setString(7, endGame.getFailLevel() + "");
            ps.setInt(8,endGame.getCimbStart());
            ps.setInt(9,endGame.getClimbEnd());
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
                ps.close();
                con.close();
            } catch (SQLException e) {
                throw e;
            }
        }
    }


    /**
     * Select endgame
     *
     * @param id the id
     * @return the cycle
     * @throws SQLException the sql exception
     */
    public static EndGame selectEndgame(int id, boolean cloud) throws SQLException{
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        EndGame endGame = new EndGame();
        try
        {
            con = DatabaseConfig.getLocalMySQLConn();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");

            }
            ps = con.prepareStatement(SELECT_SQL_QUERRY);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            System.out.println( "retriveCommands => " + ps.toString() );

           endGame.setId(rs.getInt("ID"));
           endGame.setLevelOne(rs.getBoolean("LEVEL_ONE"));
           endGame.setLevelTwo(rs.getBoolean("LEVEL_TWO"));
           endGame.setLevelThree(rs.getBoolean("LEVEL_THREE"));
           endGame.setRamp(rs.getBoolean("RAMP"));
           endGame.setTimeToClimb(rs.getFloat("TIME_TO_CLIMB"));
           endGame.setFailLevel(rs.getString("FAIL_LEVEL").charAt(0));
           endGame.setCimbStart(rs.getInt("CLIMB_START"));
           endGame.setClimbEnd(rs.getInt("CLIMB_END"));


        }
        catch (SQLException e)
        {
            throw e;
        }

        finally {
            try
            {
                rs.close();
                ps.close();
                con.close();
            }
            catch ( SQLException e )
            {
                throw e;
            }
        }
        return endGame;
    }

    public static void deleteFromTable( int id) {
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = DatabaseConfig.getLocalMySQLConn();
            ps = con.prepareStatement(REMOVE_ENTRY);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            ps.close();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }



}


