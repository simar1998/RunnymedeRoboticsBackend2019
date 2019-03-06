package database.CloudDB;

import DataStructureClasses.SubmitMatch;
import database.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CloudDAO{

    public static final String GET_MAX_ID = "SELECT MAX(ID) FROM INIT_INFO";

    public static int getMaxIdCloud(boolean cloud) {
        try {
        int id = 0;
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            JDBCHelper jdbcHelper = new JDBCHelper(cloud);
            con = jdbcHelper.getConnection();
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

    public static void checkCloudPresistantce(){

        int maxIDCloud = 0;
        int maxIDLocal = 0;
        try {
            maxIDCloud = getMaxIdCloud(true);
            maxIDLocal = getMaxIdCloud(false);
            if(maxIDCloud == -1 || maxIDLocal == -1){
                return;
            }
            if(maxIDCloud == maxIDLocal){
                return;
            }
            ArrayList<SubmitMatch> submitMatches = new ArrayList<>();
            for(int i = maxIDCloud; i <= maxIDLocal; i++){
                SubmitMatch submitMatch = new SubmitMatch();
                submitMatch.setAuto(database.dao.AutoDAO.selectAuto(i,false));
                submitMatch.setCycleArrayList(database.dao.CycleDAO.selectCycle(i,false));
                submitMatch.setEndGame(database.dao.EndGameDAO.selectEndgame(1,false));
                submitMatch.setInitInfo(database.dao.InitInfoDAO.selectInitInfo(i,false));
                submitMatch.setTeleopsList(database.dao.TeleopDAO.selectInitInfo(1,false));
            }
            for (int i = 0; i<submitMatches.size(); i++){
                submitMatches.get(i).insertSQL(true);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }



}
