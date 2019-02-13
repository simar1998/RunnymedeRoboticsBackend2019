package DataStructureClasses;

/**
 * The type End game.
 */
public class EndGame {

    /**
     * The Level one.
     */
    boolean levelOne;
    /**
     * The Level two.
     */
    boolean levelTwo;
    /**
     * The Level three.
     */
    boolean levelThree;
    /**
     * The Ramp.
     */
    boolean ramp;
    /**
     * The Time to climb.
     */
    float timeToClimb;
    /**
     * The Fail level.
     */
    char failLevel;

    /**
     * Instantiates a new End game.
     */
    public EndGame() {
    }

    /**
     * Instantiates a new End game.
     *
     * @param levelOne    the level one
     * @param levelTwo    the level two
     * @param levelThree  the level three
     * @param ramp        the ramp
     * @param timeToClimb the time to climb
     * @param failLevel   the fail level
     */
    public EndGame(boolean levelOne, boolean levelTwo, boolean levelThree, boolean ramp, float timeToClimb, char failLevel) {
        this.levelOne = levelOne;
        this.levelTwo = levelTwo;
        this.levelThree = levelThree;
        this.ramp = ramp;
        this.timeToClimb = timeToClimb;
        this.failLevel = failLevel;
    }

    /**
     * Is level one boolean.
     *
     * @return the boolean
     */
    public boolean isLevelOne() {
        return levelOne;
    }

    /**
     * Sets level one.
     *
     * @param levelOne the level one
     */
    public void setLevelOne(boolean levelOne) {
        this.levelOne = levelOne;
    }

    /**
     * Is level two boolean.
     *
     * @return the boolean
     */
    public boolean isLevelTwo() {
        return levelTwo;
    }

    /**
     * Sets level two.
     *
     * @param levelTwo the level two
     */
    public void setLevelTwo(boolean levelTwo) {
        this.levelTwo = levelTwo;
    }

    /**
     * Is level three boolean.
     *
     * @return the boolean
     */
    public boolean isLevelThree() {
        return levelThree;
    }

    /**
     * Sets level three.
     *
     * @param levelThree the level three
     */
    public void setLevelThree(boolean levelThree) {
        this.levelThree = levelThree;
    }

    /**
     * Is ramp boolean.
     *
     * @return the boolean
     */
    public boolean isRamp() {
        return ramp;
    }

    /**
     * Sets ramp.
     *
     * @param ramp the ramp
     */
    public void setRamp(boolean ramp) {
        this.ramp = ramp;
    }

    /**
     * Gets time to climb.
     *
     * @return the time to climb
     */
    public float getTimeToClimb() {
        return timeToClimb;
    }

    /**
     * Sets time to climb.
     *
     * @param timeToClimb the time to climb
     */
    public void setTimeToClimb(float timeToClimb) {
        this.timeToClimb = timeToClimb;
    }

    /**
     * Gets fail level.
     *
     * @return the fail level
     */
    public char getFailLevel() {
        return failLevel;
    }

    /**
     * Sets fail level.
     *
     * @param failLevel the fail level
     */
    public void setFailLevel(char failLevel) {
        this.failLevel = failLevel;
    }
}
