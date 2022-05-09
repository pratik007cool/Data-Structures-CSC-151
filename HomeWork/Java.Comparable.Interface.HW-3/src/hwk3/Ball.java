package hwk3;

import java.awt.*;
/**
 *  models a ball used in sports. e.g. tennis ball, etc.
 *
 *  @author Chris Fernandes and <put your name here>!
 *  @version 5/4/2022
 */
public class Ball implements Comparable<Ball> {

    private final double DEFAULT_DIAM = 10.0;
    private final String DEFAULT_COLOR = "yellow";
    private final double DEFAULT_WEIGHT = 5.0;
    public static final double MAX_DIAM = 50.0;

    private double weight;
    private Color color;
    private double diameter;

    /**
     * default constructor
     */
    public Ball() {
        diameter = DEFAULT_DIAM;
        color = string2color(DEFAULT_COLOR);
        weight = DEFAULT_WEIGHT;
    }

    /**
     * non-default constructor
     */
    public Ball(double newWeight, String newColor) {
        weight = newWeight;
        color = string2color(newColor);
        diameter = DEFAULT_DIAM;
    }

    /**
     * non-default constructor
     */
    public Ball(double newDiam, double newWeight, String newColor) {
        diameter = newDiam;
        weight = newWeight;
        color = string2color(newColor);
    }

    private Object[] itemArray;
    /**
     * convert String color to Color object
     * @param someColor color of hwk3.Ball
     * @return hwk3.Ball color as a Color object
     */
    private Color string2color(String someColor){
        if (someColor.equals("yellow")){
            return Color.yellow;
        }
        else if (someColor.equals("orange")){
            return Color.orange;
        }
        else if (someColor.equals("white")){
            return Color.white;
        }
        else {
            return Color.yellow;
        }
    }



    public int compareTo(Ball compare){
        if (this.diameter > compare.diameter)
            return 1;
        else if (this.diameter < compare.diameter)
            return -1;
        else return 0;
    }


    /**
     * non-default constructor
     */
    public Ball(String color) {
        diameter = DEFAULT_DIAM;
        this.color = string2color(color);
        weight = DEFAULT_WEIGHT;
    }

    /**
     * put the given amount of air into the ball.
     * Do nothing if it overinflates the ball.
     * @param air amount in PSI; do nothing if negative
     */
    public void inflate(double air){
        if (air >= 0 && air+getDiameter() <= MAX_DIAM) {
            setDiameter(getDiameter() + air);
        }
    }

    /**
     * getter for diameter (cm)
     */
    public double getDiameter() { return diameter; }

    // getter for color
    public String getColor() {
        if (color.equals(Color.orange)){
            return "orange";
        }
        else if (color.equals(Color.yellow)){
            return "yellow";
        }
        else {
            return "white";
        }
    }

    /**
     * getter for weight (grams)
     */
    public double getWeight() { return weight; }

    /**
     * return the sport often used for this ball
     */
    public String getSport() {
        if (getColor().equals("yellow")){
            return "tennis";
        }
        else if (getColor().equals("orange")) {
            return "basketball";
        }
        else {
            return "catch";
        }
    }

    /**
     * setter for diameter
     * @param newDiam new diameter in cm
     */
    private void setDiameter(double newDiam) { diameter = newDiam; }

    /**
     * Two balls are equal if they have the same color and weight.
     * @param otherContainable other ball
     * @return true if balls equal, else false
     */
    public boolean equals(Object otherContainable) {

        // if the *pointers* are the same, then
        // by golly it must be the same object!
        if (this == otherContainable) {
            return true;
        }

        // if the parameter is null or the two
        // objects are not instances of the same class,
        // they can't be equal
        else if (otherContainable == null ||
                this.getClass() != otherContainable.getClass()) {
            return false;
        }

        //I now know otherContainable is a hwk3.Ball object.
        //If this hwk3.Ball and otherContainable have the same
        //weight and color, then that's my criteria for
        //them to be equal.
        else {
            Ball otherBall = (Ball)otherContainable;
            if (this.getColor().equals(otherBall.getColor()) &&
                    this.getWeight()==otherBall.getWeight()){
                return true;
            }
            else {
                return false;
            }
        }
    }

    /**
     * Return ball as a printable string
     * @return String version of this hwk3.Ball
     */
    public String toString() {
        return getColor() +
                " ball with " + getDiameter()  +
                "cm diameter and weighing " + getWeight() + " grams";
    }
}
