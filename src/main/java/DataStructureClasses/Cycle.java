package DataStructureClasses;

/**
 * The type Cycle.
 */
public class Cycle {

    /**
     * The Id.
     */
    int id;
    /**
     * The Cycle number.
     */
    int cycleNumber;
    /**
     * The Field element.
     */
    char fieldElement = ' ';
    /**
     * The Pick up.
     */
    String pickUp = "";
    /**
     * The Place.
     */
    String place = "";
    /**
     * The Defense.
     */
    boolean defense;
    /**
     * The Drop.
     */
    boolean drop;



    /**
     * Instantiates a new Cycle.
     */
    public Cycle() {
    }

    /**
     * Instantiates a new Cycle.
     *
     * @param fieldElement the field element
     * @param pickUp       the pick up
     * @param place        the place
     * @param defense      the defense
     * @param drop         the drop
     * @param cycleNumber  the cycle number
     * @param id           the id
     */
    public Cycle(char fieldElement, String pickUp, String place, boolean defense, boolean drop, int cycleNumber, int id) {
        this.fieldElement = fieldElement;
        this.pickUp = pickUp;
        this.place = place;
        this.defense = defense;
        this.drop = drop;
    }

    /**
     * Gets field element.
     *
     * @return the field element
     */
    public char getFieldElement() {
        return fieldElement;
    }

    /**
     * Sets field element.
     *
     * @param fieldElement the field element
     */
    public void setFieldElement(char fieldElement) {
        this.fieldElement = fieldElement;
    }

    /**
     * Gets pick up.
     *
     * @return the pick up
     */
    public String getPickUp() {
        return pickUp;
    }

    /**
     * Sets pick up.
     *
     * @param pickUp the pick up
     */
    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    /**
     * Gets place.
     *
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * Sets place.
     *
     * @param place the place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * Is defense boolean.
     *
     * @return the boolean
     */
    public boolean isDefense() {
        return defense;
    }

    /**
     * Sets defense.
     *
     * @param defense the defense
     */
    public void setDefense(boolean defense) {
        this.defense = defense;
    }

    /**
     * Is drop boolean.
     *
     * @return the boolean
     */
    public boolean isDrop() {
        return drop;
    }

    /**
     * Sets drop.
     *
     * @param drop the drop
     */
    public void setDrop(boolean drop) {
        this.drop = drop;
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
     * Gets cycle number.
     *
     * @return the cycle number
     */
    public int getCycleNumber() {
        return cycleNumber;
    }

    /**
     * Sets cycle number.
     *
     * @param cycleNumber the cycle number
     */
    public void setCycleNumber(int cycleNumber) {
        this.cycleNumber = cycleNumber;
    }
}
