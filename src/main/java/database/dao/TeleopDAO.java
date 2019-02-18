package database.dao;


import DataStructureClasses.Teleop;
import database.JDBCHelper;

import java.sql.*;
import java.util.ArrayList;

public class TeleopDAO {

    public static final String INSERT_SQL_QUERRY = "INSERT INTO TELEOP (ID,TIME_CROSSED) VALUES(?,?)";
    public static final String SELECT_SQL_QUERRY = "SELECT TIME_CROSSED FROM TELEOP WHERE ID=?";

    public static ArrayList<Teleop> selectInitInfo(int id) throws SQLException {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        ArrayList<Teleop> teleopList = new ArrayList<>();

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
            while (rs.next()) {
                Teleop teleop = new Teleop();
                teleop.setId(rs.getInt("ID"));
                teleop.setTimeCrosses(rs.getInt("TIME_CROSSED"));
                teleopList.add(teleop);
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
        return teleopList;
    }

    public static Teleop insertInitInfoSQL(Teleop teleop) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCHelper.getConnection();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");
                return new Teleop();
            }
            ps = con.prepareStatement(INSERT_SQL_QUERRY);
            ps.setInt(1,teleop.getTimeCrosses());
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
        return  teleop;

    }



}
