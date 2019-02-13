package DataStructureClasses;

/**
 * Class for the data structure for the auto data set on the MYSQL server
 */
public class Auto {

    /**
     * The Id.
     */
    int id;
    /**
     * The Start pos.
     */
    String startPos = "";
    /**
     * The Place pos.
     */
    String placePos = "";
    /**
     * The Starting obj.
     */
    char startingObj = ' ';
    /**
     * The Time.
     */
    float time;

    /**
     * Blank Constructor
     */
    public Auto() {
    }

    /**
     * Not a blank constructor
     *
     * @param id          the id
     * @param startPos    the start pos
     * @param placePos    the place pos
     * @param startingObj the starting obj
     * @param time        the time
     */
    public Auto(int id, String startPos, String placePos, char startingObj, float time) {
        this.id = id;
        this.startPos = startPos;
        this.placePos = placePos;
        this.startingObj = startingObj;
        this.time = time;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets start pos.
     *
     * @return the start pos
     */
    public String getStartPos() {
        return startPos;
    }

    /**
     * Sets start pos.
     *
     * @param startPos the start pos
     */
    public void setStartPos(String startPos) {
        this.startPos = startPos;
    }

    /**
     * Gets place pos.
     *
     * @return the place pos
     */
    public String getPlacePos() {
        return placePos;
    }

    /**
     * Sets place pos.
     *
     * @param placePos the place pos
     */
    public void setPlacePos(String placePos) {
        this.placePos = placePos;
    }

    /**
     * Gets starting obj.
     *
     * @return the starting obj
     */
    public char getStartingObj() {
        return startingObj;
    }

    /**
     * Sets starting obj.
     *
     * @param startingObj the starting obj
     */
    public void setStartingObj(char startingObj) {
        this.startingObj = startingObj;
    }

    /**
     * Get time float [ ].
     *
     * @return the float [ ]
     */
    public float getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(float time) {
        this.time = time;
    }
}
