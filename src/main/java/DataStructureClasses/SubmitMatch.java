package DataStructureClasses;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubmitMatch {

    Auto auto = new Auto();
    EndGame endGame = new EndGame();
    InitInfo initInfo = new InitInfo();
    ArrayList<Cycle> cycleArrayList = new ArrayList<>();

    public SubmitMatch() {
    }

    public SubmitMatch(Auto auto, EndGame endGame, InitInfo initInfo, ArrayList<Cycle> cycleArrayList) {
        this.auto = auto;
        this.endGame = endGame;
        this.initInfo = initInfo;
        this.cycleArrayList = cycleArrayList;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) throws SQLException {
        try {
            database.dao.AutoDAO.insertAutoSQL(auto);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        this.auto = auto;
    }

    public EndGame getEndGame() {
        return endGame;
    }

    public void setEndGame(EndGame endGame) throws SQLException{
        try {
            database.dao.EndGameDAO.insertAutoSQL(endGame);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        this.endGame = endGame;
    }

    public InitInfo getInitInfo() {
        return initInfo;
    }

    public void setInitInfo(InitInfo initInfo) throws SQLException{
        try {
            database.dao.InitInfoDAO.insertInitInfoSQL(initInfo);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        this.initInfo = initInfo;
    }

    public ArrayList<Cycle> getCycleArrayList() {
        return cycleArrayList;
    }

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

    public void insertSQL(){
        try {
            database.dao.AutoDAO.insertAutoSQL(auto);
            database.dao.EndGameDAO.insertAutoSQL(endGame);
            for (Cycle i: cycleArrayList){
                database.dao.CycleDAO.insertAutoSQL(i);
            }
            database.dao.InitInfoDAO.insertInitInfoSQL(initInfo);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
