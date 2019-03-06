package DataStructureClasses;

public class Teleop {

    int id;
    int timeCrosses;

    public Teleop() {
    }

    /**
     *  
     * @param id
     * @param timeCrosses
     */
    public Teleop(int id, int timeCrosses) {
        this.id = id;
        this.timeCrosses = timeCrosses;
    }


    /**
     * Gets timeCrosses.
     *
     * @return Value of timeCrosses.
     */
    public int getTimeCrosses() {
        return timeCrosses;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new timeCrosses.
     *
     * @param timeCrosses New value of timeCrosses.
     */
    public void setTimeCrosses(int timeCrosses) {
        this.timeCrosses = timeCrosses;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(int id) {
        this.id = id;
    }
}
