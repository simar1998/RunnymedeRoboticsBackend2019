package database.subroutine;

import DataStructureClasses.InitInfo;
import DataStructureClasses.SubmitMatch;
import DataStructureClasses.Teleop;
import com.google.gson.Gson;
import com.sun.org.apache.xml.internal.security.Init;
import database.DatabaseConfig;
import database.dao.InitInfoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IncommingDataCheck {

    public static void incommingSubmitMatch(ArrayList<SubmitMatch> submitMatches) throws SQLException {

       for(int i = 0; i< submitMatches.size() ; i++){
           if(InitInfoDAO.selectDuplicateEntry(submitMatches.get(i).getInitInfo()).isEmpty()){
               submitMatches.get(i).insertSQL(false);
           }
           else {
               if(submitMatches.get(i).getInitInfo().getIsReplayed() > 0){
                   int id = InitInfoDAO.selectDuplicateEntry(submitMatches.get(i).getInitInfo()).get(0).getId();
                   SubmitMatch.removeEntryFromDatabase(id);
                   InitInfoDAO.insertInitInfoSQL(submitMatches.get(i).getInitInfo(), true);
               }
               else {
                   submitMatches.remove(i);
               }
           }
       }

    }

    public static void tablesChecl(){
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
            ps = con.prepareStatement("SHOW TABLES");
            rs = ps.executeQuery();
            System.out.println( "retriveCommands => " + ps.toString() );
            while (rs.next()) {
               System.out.println(rs.getString(1));
            }

        }
        catch (SQLException e)
        {
            try {
                throw e;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
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

            }
        }

    }

}
