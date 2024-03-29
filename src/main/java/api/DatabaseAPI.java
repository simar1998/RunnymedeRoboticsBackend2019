package api;

import DataStructureClasses.*;
import com.google.gson.Gson;
import database.subroutine.IncommingDataCheck;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * The type Basic api.
 */
@Path("/Database")
public class DatabaseAPI {

    /**
     * The Gson.ss
     */
    Gson gson = new Gson();

    /**
     * Gets init info.
     *
     * @param id the id
     * @return the init info
     */
    @GET
    @Path("/initInfo")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public String getInitInfo(@QueryParam("id") int id){
        try {
           return gson.toJson(database.dao.InitInfoDAO.selectInitInfo(id,false));
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
    @Path("/initInfo")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public String postInitInfo(@FormParam("initInfo") String initInfo){
        try {
            database.dao.InitInfoDAO.insertInitInfoSQL(gson.fromJson(initInfo, InitInfo.class),false);
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
    @Path("/cycle")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public String getCycleFromDatabase(@QueryParam("id") int id){
        try {
            return gson.toJson(database.dao.CycleDAO.selectCycle(id,false));
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
    @Consumes("application/x-www-form-urlencoded")
    public String insertCycleData(@FormParam("cycle") String cycleString){
        try {
            database.dao.CycleDAO.insertAutoSQL(gson.fromJson(cycleString, Cycle.class),false);
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
    @Path("/endGame")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public String getEndGameFromDatabase(@QueryParam("id") int id){
        try {
            return gson.toJson(database.dao.EndGameDAO.selectEndgame(id,false));
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
    @Path("/endGame")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public String postEndgame(@FormParam("endGame") String endGame){
        try {
            database.dao.EndGameDAO.insertAutoSQL(gson.fromJson(endGame,EndGame.class),false);
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
    @Path("/auto")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public String getAuto(@QueryParam("id") int id){
        try {
            return gson.toJson(database.dao.AutoDAO.selectAuto(id,false));
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
    @Path("/auto")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public String postAuto(@FormParam("auto") String auto){
        try {
            database.dao.AutoDAO.insertAutoSQL(gson.fromJson(auto, Auto.class), false);
            return "API CALL COMPLETE";
        }
        catch (SQLException e){
            return e.toString();
        }
    }

    @POST
    @Path("/matchInfo")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public void submitInfo(@QueryParam("info") String submitInfo){
        SubmitMatch submitMatch = gson.fromJson(submitInfo, SubmitMatch.class);
        submitMatch.insertSQL(false);
    }

    @POST
    @Path("/addQueueWrapper")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public Response submitQueue(@FormParam("queue") String queue){
        System.out.println("Post Queue: "+queue);
        QueueWrapper queueWrapper = gson.fromJson(queue, QueueWrapper.class);
        System.out.println(gson.toJson(queueWrapper));

        try {
            IncommingDataCheck.incommingSubmitMatch(queueWrapper.getSubmitMatchArrayList());
        } catch (SQLException e) {
            e.printStackTrace();
            return Response
                    .status(Response.Status.SEE_OTHER)
                    .entity("SQL ERROR CHECK CODE OR CREDENTIALS PLEASE")
                    .build();
        }
        return Response
                .status(Response.Status.OK)
                .entity("POST DONE")
                .build();
    }

    @GET
    @Path("/test")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public String gettest(){
        database.subroutine.IncommingDataCheck.tablesChecl();
        return "Test api call";
    }

    @POST
    @Path("addMatch")
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public String addMatch(@FormParam("match") String match){
        SubmitMatch submitMatch = (new Gson()).fromJson(match,SubmitMatch.class);
        submitMatch.insertSQL(false);
        return "POST DONE";
    }








}
