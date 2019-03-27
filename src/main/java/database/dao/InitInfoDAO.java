package database.dao;

import DataStructureClasses.InitInfo;
import com.sun.org.apache.xml.internal.security.Init;
import database.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Init info dao.
 */
public class InitInfoDAO {

    /**
     * The constant INSERT_SQL_QUERRY.
     */
    public static final String INSERT_SQL_QUERRY = "INSERT INTO INIT_INFO (NAME,MATCH_NO,TEAM_NO,EVENT,YEAR_VAL,COLOUR) VALUES(?,?,?,?,?,?)";
    /**
     * The constant SELECT_SQL_QUERRY.
     */
    public static final String SELECT_SQL_QUERRY = "SELECT ID,MATCH_NO,TEAM_NO,EVENT,YEAR_VAL,COLOUR FROM INIT_INFO WHERE ID = ?";

    public static final String SELECT_SQL_QUERRY_ALL = "SELECT * FROM INIT_INFO";

    /**
     * Gets max id from database;
     */
    public static final String GET_MAX_ID = "SELECT MAX(ID) FROM INIT_INFO";


    /**
     * Select  sql init info.
     *
     * @param id the id
     * @return the init info
     * @throws SQLException the sql exception
     */
    public static InitInfo selectInitInfo(int id, boolean cloud) throws SQLException{
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        InitInfo initInfo = new InitInfo();

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
                rs.close();
                ps.close();
                con.close();
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
    public static int insertInitInfoSQL(InitInfo initInfo, boolean cloud) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DatabaseConfig.getLocalMySQLConn();
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
                con.close();;
            } catch (SQLException e) {
                throw e;
            }
        }
        int maxID = getMaxIdCloud();
        System.out.println(maxID);
        return maxID;

    }

    public static int getMaxIdCloud() {
        try {
            int id = 0;
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = DatabaseConfig.getLocalMySQLConn();
            ps = con.prepareStatement(GET_MAX_ID);
            rs = ps.executeQuery();
            System.out.println(rs.toString());
            while (rs.next()){
                id = rs.getInt(1);
            }
            System.out.print("ID ------->  " + id);
            return id;
        }
        catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static ArrayList<InitInfo> selectInitInfoAll() throws SQLException{
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        InitInfo initInfo = new InitInfo();
        ArrayList<InitInfo> initInfos = new ArrayList<>();
        try
        {
            con = DatabaseConfig.getLocalMySQLConn();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");

            }
            ps = con.prepareStatement(SELECT_SQL_QUERRY_ALL);
            rs = ps.executeQuery();
            System.out.println( "retriveCommands => " + ps.toString() );
            while (rs.next()) {
                initInfo.setId(rs.getInt("ID"));
                initInfo.setName(rs.getString("NAME"));
                System.out.println("Name : " + initInfo.getName());
                initInfo.setMatchNumber(rs.getInt("MATCH_NO"));
                initInfo.setTeamNumber(rs.getInt("TEAM_NO"));
                initInfo.setEvent(rs.getString("EVENT"));
                initInfo.setYear(rs.getInt("YEAR_VAL"));
                initInfo.setAllianceColour(rs.getString("COLOUR").charAt(0));
                initInfos.add(initInfo);
            }

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
        return initInfos;
    }


}
