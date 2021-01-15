package Chapter9b;
/*
Alan Ly
Prof. Iverson
CS211
11 January 2021
 */
import java.awt.*;

public class Frog implements Animal {

    private int stepCounter;
    private int direction;
    private double r;

    public Frog() {
        stepCounter = 0;
        direction = 0;
    }

    public int getMove() {
        stepCounter = stepCounter % 3;
        if (stepCounter == 0) {
            r = Math.random();
        }
        stepCounter++;

        if (r < 0.25) {
            r = 0.24;
            return NORTH;
        } else if (r < 0.5) {
            r = 0.49;
            return SOUTH;
        } else if (r < 0.75) {
            r = 0.74;
            return EAST;
        } else
            return WEST;
    }

    public Color getColor() {
        return new Color(0,255,0);
    }
    public String toString() {
        return "F";
    }

}
