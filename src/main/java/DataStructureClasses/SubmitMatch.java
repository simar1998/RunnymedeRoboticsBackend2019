package DataStructureClasses;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Submit match POJO
 */
public class SubmitMatch {

    Auto auto = new Auto();
    EndGame endGame = new EndGame();
    InitInfo initInfo = new InitInfo();
    ArrayList<Teleop> teleopsList = new ArrayList<>();
    ArrayList<Cycle> cycleArrayList = new ArrayList<>();

    /**
     * Blank Constructor
     */
    public SubmitMatch() {
    }

    /**
     * Constructor for all fields
     * @param auto
     * @param endGame
     * @param initInfo
     * @param teleopsList
     * @param cycleArrayList
     */
    public SubmitMatch(Auto auto, EndGame endGame, InitInfo initInfo, ArrayList<Teleop> teleopsList, ArrayList<Cycle> cycleArrayList) {
        this.auto = auto;
        this.endGame = endGame;
        this.initInfo = initInfo;
        this.teleopsList = teleopsList;
        this.cycleArrayList = cycleArrayList;
    }

    /**
     * Get Auto
     * @return
     */
    public Auto getAuto() {
        return auto;
    }

    /**
     * Set Auto
     * @param auto
     * @throws SQLException
     */
    public void setAuto(Auto auto) throws SQLException {
        try {
            database.dao.AutoDAO.insertAutoSQL(auto);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        this.auto = auto;
    }

    /**
     * Get End game object
     * @return
     */
    public EndGame getEndGame() {
        return endGame;
    }

    /**
     * Set End game
     * @param endGame
     * @throws SQLException
     */
    public void setEndGame(EndGame endGame) throws SQLException{
        try {
            database.dao.EndGameDAO.insertAutoSQL(endGame);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        this.endGame = endGame;
    }

    /**
     * Get Init Info
     * @return
     */
    public InitInfo getInitInfo() {
        return initInfo;
    }

    /**
     * Set init info
     * @param initInfo
     * @throws SQLException
     */
    public void setInitInfo(InitInfo initInfo) throws SQLException{
        try {
            database.dao.InitInfoDAO.insertInitInfoSQL(initInfo);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        this.initInfo = initInfo;
    }

    /**
     * Gtes cycle Arraylist
     * @return
     */
    public ArrayList<Cycle> getCycleArrayList() {
        return cycleArrayList;
    }

    /**
     * Set Cycle arraylist
     * @param cycleArrayList
     * @throws SQLException
     */
    public void setCycleArrayList(ArrayList<Cycle> cycleArrayList) throws SQLException{
        try {
           for (Cycle i: cycleArrayList){
               database.dao.CycleDAO.insertAutoSQL(i);
           }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        this.cycleArrayList = cycleArrayList;
    }

    /**
     * Inserts all the sql data
     */
    public void insertSQL(){
        try {
            int id = database.dao.InitInfoDAO.insertInitInfoSQL(initInfo);
            auto.setId(id);
            endGame.setId(id);
            database.dao.AutoDAO.insertAutoSQL(auto);
            database.dao.EndGameDAO.insertAutoSQL(endGame);
            for (int i = 0; i < cycleArrayList.size(); i++){
                cycleArrayList.get(i).setId(id);
                database.dao.CycleDAO.insertAutoSQL(cycleArrayList.get(i));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
