package api;

import DataStructureClasses.Auto;
import DataStructureClasses.Cycle;
import DataStructureClasses.EndGame;
import DataStructureClasses.InitInfo;
import com.google.gson.Gson;

import javax.ws.rs.*;
import java.sql.SQLException;

/**
 * The type Basic api.
 */
@Path("/Database")
public class BasicAPI {

    /**
     * The Gson.
     */
    Gson gson = new Gson();

    /**
     * Gets init info.
     *
     * @param id the id
     * @return the init info
     */
    @GET
    @Path("/getInitInfo")
    @Produces("text/plain")
    @Consumes("application/x-xxx-form-urlencoded")
    public String getInitInfo(@QueryParam("id") int id){
        try {
           return gson.toJson(database.dao.InitInfoDAO.selectInitInfo(id));
        }
       catch (SQLException e){
            return e.toString();
       }
    }

    /**
     * Post init info string.
     *
     * @param initInfo the init info
     * @return the string
     */
    @POST
    @Path("/addInitInfo")
    @Produces("text/plain")
    @Consumes("application/x-xxx-form-urlencoded")
    public String postInitInfo(@FormParam("initInfo") String initInfo){
        try {
            database.dao.InitInfoDAO.insertInitInfoSQL(gson.fromJson(initInfo, InitInfo.class));
            return "API CALL COMPLETE";
        }
        catch (SQLException e){
            return e.toString();
        }
    }

    /**
     * Gets cycle from database.
     *
     * @param id the id
     * @return the cycle from database
     */
    @GET
    @Path("/getCycleInfo")
    @Produces("text/plain")
    @Consumes("application/x-xxx-form-urlencoded")
    public String getCycleFromDatabase(@QueryParam("id") int id){
        try {
            return gson.toJson(database.dao.CycleDAO.selectCycle(id));
        }
        catch (SQLException e){
            return e.toString();
        }
    }

    /**
     * Insert cycle data string.
     *
     * @param cycleString the cycle string
     * @return the string
     */
    @POST
    @Path("/addCycle")
    @Produces("text/plain")
    @Consumes("application/x-xxx-form-urlencoded")
    public String insertCycleData(@FormParam("cycle") String cycleString){
        try {
            database.dao.CycleDAO.insertAutoSQL(gson.fromJson(cycleString, Cycle.class));
            return "API CALL COMPLETE";
        }
        catch (SQLException e){
            return e.toString();
        }
    }

    /**
     * Gets end game from database.
     *
     * @param id the id
     * @return the end game from database
     */
    @GET
    @Path("/getEndgame")
    @Produces("text/plain")
    @Consumes("application/x-xxx-form-urlencoded")
    public String getEndGameFromDatabase(@QueryParam("id") int id){
        try {
            return gson.toJson(database.dao.EndGameDAO.selectEndgame(id));
        }
        catch (SQLException e){
            return e.toString();
        }
    }

    /**
     * Post endgame string.
     *
     * @param endGame the end game
     * @return the string
     */
    @POST
    @Path("/addEndGame")
    @Produces("text/plain")
    @Consumes("application/x-xxx-form-urlencoded")
    public String postEndgame(@FormParam("endGame") String endGame){
        try {
            database.dao.EndGameDAO.insertAutoSQL(gson.fromJson(endGame,EndGame.class));
            return "API CALL COMPLETE";
        }
        catch (SQLException e){
            return e.toString();
        }
    }

    /**
     * Gets auto.
     *
     * @param id the id
     * @return the auto
     */
    @GET
    @Path("/geAuto")
    @Produces("text/plain")
    @Consumes("application/x-xxx-form-urlencoded")
    public String getAuto(@QueryParam("id") int id){
        try {
            return gson.toJson(database.dao.AutoDAO.selectAuto(id));
        }
        catch (SQLException e){
            return e.toString();
        }
    }

    /**
     * Post auto string.
     *
     * @param auto the auto
     * @return the string
     */
    @POST
    @Path("/addAuto")
    @Produces("text/plain")
    @Consumes("application/x-xxx-form-urlencoded")
    public String postAuto(@FormParam("auto") String auto){
        try {
            database.dao.AutoDAO.insertAutoSQL(gson.fromJson(auto, Auto.class));
            return "API CALL COMPLETE";
        }
        catch (SQLException e){
            return e.toString();
        }
    }

}
