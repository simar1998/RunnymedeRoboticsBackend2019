package database.dao;


import DataStructureClasses.Teleop;
import database.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;

public class TeleopDAO {

    public static final String INSERT_SQL_QUERRY = "INSERT INTO TELEOP (ID,TIME_CROSSES) VALUES(?,?)";
    public static final String SELECT_SQL_QUERRY = "SELECT TIME_CROSSES FROM TELEOP WHERE ID=?";
    public static final String DELETE_SQL_ENTRY = "DELETE FROM TIME_CROSSES WHERE ID=?";

    public static ArrayList<Teleop> selectInitInfo(int id, boolean cloud) throws SQLException {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        ArrayList<Teleop> teleopList = new ArrayList<>();


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
                rs.close();
                ps.close();
                con.close();
            }
            catch ( SQLException e )
            {
                throw e;
            }
        }
        return teleopList;
    }

    public static Teleop insertInitInfoSQL(Teleop teleop, boolean cloud) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DatabaseConfig.getLocalMySQLConn();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");
                return new Teleop();
            }
            ps = con.prepareStatement(INSERT_SQL_QUERRY);
            ps.setInt(1,teleop.getId());
            ps.setInt(2,teleop.getTimeCrosses());
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
        return  teleop;
    }

    public static void deleteFromTable( int id) {
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = DatabaseConfig.getLocalMySQLConn();
            ps = con.prepareStatement(DELETE_SQL_ENTRY);
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
