package database.dao;

import DataStructureClasses.InitInfo;
import database.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Init info dao.
 */
public class InitInfoDAO {

    /**
     * The constant INSERT_SQL_QUERRY.
     */
    public static final String INSERT_SQL_QUERRY = "INSERT INTO INIT_INFO(NAME,MATCH_NO,TEAM_NO,EVENT,YEAR_VAL,COLOUR) VALUES(?,?,?,?,?,?)";
    /**
     * The constant SELECT_SQL_QUERRY.
     */
    public static final String SELECT_SQL_QUERRY = "SELECT ID,MATCH_NO,TEAM_NO,EVENT,YEAR_VAL,COLOUR FROM INIT_INFO WHERE ID = ?";


    /**
     * Select  sql init info.
     *
     * @param id the id
     * @return the init info
     * @throws SQLException the sql exception
     */
    public static InitInfo selectInitInfo(int id) throws SQLException{
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        InitInfo initInfo = new InitInfo();

        try
        {
            con = JDBCHelper.getConnection();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");

            }
            ps = con.prepareStatement(SELECT_SQL_QUERRY);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            System.out.println( "retriveCommands => " + ps.toString() );
                initInfo.setId(rs.getInt("ID"));
                initInfo.setMatchNumber(rs.getInt("MATCH_NO"));
                initInfo.setTeamNumber(rs.getInt("TEAM_NO"));
                initInfo.setEvent(rs.getString("EVENT"));
                initInfo.setYear(rs.getInt("YEAR_VAL"));
                initInfo.setAllianceColour(rs.getString("COLOUR").charAt(0));

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
        return initInfo;
    }


    /**
     * Insert init info sql int.
     *
     * @param initInfo the init info
     * @return the int
     * @throws SQLException the sql exception
     */
    public static int insertInitInfoSQL(InitInfo initInfo) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCHelper.getConnection();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");
                return 0;
            }
            ps = con.prepareStatement(INSERT_SQL_QUERRY);
            ps.setString(1,initInfo.getName());
            ps.setInt(2,initInfo.getMatchNumber());
            ps.setInt(3,initInfo.getTeamNumber());
            ps.setString(4,initInfo.getEvent());
            ps.setInt(5,initInfo.getYear());
            ps.setString(6,initInfo.getAllianceColour() + "");

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
            ps = con.prepareStatement("SELECT MAX(ID) FROM INIT_INFO");
        ResultSet rs = ps.executeQuery();
        return  rs.getInt("id");

    }
}
