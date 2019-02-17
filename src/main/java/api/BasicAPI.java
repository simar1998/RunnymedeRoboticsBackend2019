package api;

import DataStructureClasses.Auto;
import DataStructureClasses.Cycle;
import DataStructureClasses.EndGame;
import DataStructureClasses.InitInfo;
import com.google.gson.Gson;

import javax.ws.rs.*;
import java.sql.SQLException;

@Path("/Database")
public class BasicAPI {

    Gson gson = new Gson();

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
