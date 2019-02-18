package database.dao;

import DataStructureClasses.Cycle;
import database.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Cycle dao.
 */
public class CycleDAO {

    /**
     * The constant INSERT_SQL_QUERRY.
     */
    public static final String INSERT_SQL_QUERRY = "INSERT INTO CYCLES (ID,CYCLE_NO,FIELD_ELEMENT,PICKUP,PLACE,DEFENSE,DROP_BOOL,PICKUP_TIME,DROP_TIME) VALUES(?,?,?,?,?,?,?,?,?)";
    /**
     * The constant SELECT_SQL_QUERRY.
     */
    public static final String SELECT_SQL_QUERRY = "SELECT ID,CYCLE_NO,FIELD_ELEMENT,PICKUP,PLACE,DEFENSE,DROP_BOOL,PICKUP_TIME,DROP_TIME FROM CYCLES WHERE ID=?";

    /**
     * Insert auto sql.
     *
     * @param cycle the cycle
     * @throws SQLException the sql exception
     */
    public static void insertAutoSQL(Cycle cycle) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = JDBCHelper.getConnection();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");
                return;
            }
            ps = con.prepareStatement(INSERT_SQL_QUERRY);
            ps.setInt(1, cycle.getId());
            ps.setInt(2, cycle.getCycleNumber());
            ps.setString(3, cycle.getFieldElement() + "");
            ps.setString(4, cycle.getPickUp());
            ps.setString(5, cycle.getPlace());
            ps.setBoolean(6, cycle.isDefense());
            ps.setBoolean(7, cycle.isDrop());
            ps.setTime(8,cycle.getPickupTime());
            ps.setTime(9,cycle.getDropoffTime());
            ps.execute();
            System.out.println("SQL QUERRY ===> " + ps.toString());
            con.commit();
        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                throw e1;
            }
            throw e;
        } finally {
            try {
                JDBCHelper.closePrepaerdStatement(ps);
                JDBCHelper.closeConnection(con);
            } catch (SQLException e) {
                throw e;
            }
        }
    }


    /**
     * Select sql cycle.
     *
     * @param id the id
     * @return the cycle
     * @throws SQLException the sql exception
     */
    public static ArrayList<Cycle> selectCycle(int id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cycle> cycleList = new ArrayList<>();

        try {
            con = JDBCHelper.getConnection();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");

            }
            ps = con.prepareStatement(SELECT_SQL_QUERRY);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            System.out.println("retriveCommands => " + ps.toString());

            while (rs.next()) {
                Cycle cycle = new Cycle();
                cycle.setId(rs.getInt("ID"));
                cycle.setCycleNumber(rs.getInt("CYCLE_NO"));
                cycle.setFieldElement(rs.getString("FIELD_ELEMENT").charAt(0));
                cycle.setPickUp(rs.getString("PICKUP"));
                cycle.setPlace(rs.getString("PLACE"));
                cycle.setDefense(rs.getBoolean("DEFENSE"));
                cycle.setDrop(rs.getBoolean("DROP_BOOL"));
                cycle.setDropoffTime(rs.getTime("DROP_TIME"));
                cycle.setPickupTime(rs.getTime("PICKUP_TIME"));
                cycleList.add(cycle);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                JDBCHelper.closeResultSet(rs);
                JDBCHelper.closePrepaerdStatement(ps);
                JDBCHelper.closeConnection(con);
            } catch (SQLException e) {
                throw e;
            }
        }
        return cycleList;
    }


}