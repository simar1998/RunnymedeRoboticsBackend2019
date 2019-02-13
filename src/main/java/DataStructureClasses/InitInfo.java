package DataStructureClasses;

/**
 * The type Init info.
 */
public class InitInfo {

    /**
     * The Id.
     */
    int id;
    /**
     * The Name.
     */
    String name = "";
    /**
     * The Match number.
     */
    int matchNumber;
    /**
     * The Team number.
     */
    int teamNumber;
    /**
     * The Event.
     */
    String event;
    /**
     * The Year.
     */
    int Year;

    /**
     * Instantiates a new Init info.
     */
    public InitInfo(){}

    /**
     * Instantiates a new Init info.
     *
     * @param id          the id
     * @param name        the name
     * @param matchNumber the match number
     * @param teamNumber  the team number
     * @param event       the event
     * @param year        the year
     */
    public InitInfo(int id, String name, int matchNumber, int teamNumber, String event, int year) {
        this.id = id;
        this.name = name;
        this.matchNumber = matchNumber;
        this.teamNumber = teamNumber;
        this.event = event;
        Year = year;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets match number.
     *
     * @return the match number
     */
    public int getMatchNumber() {
        return matchNumber;
    }

    /**
     * Sets match number.
     *
     * @param matchNumber the match number
     */
    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    /**
     * Gets team number.
     *
     * @return the team number
     */
    public int getTeamNumber() {
        return teamNumber;
    }

    /**
     * Sets team number.
     *
     * @param teamNumber the team number
     */
    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    /**
     * Gets event.
     *
     * @return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets event.
     *
     * @param event the event
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public int getYear() {
        return Year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(int year) {
        Year = year;
    }
}
