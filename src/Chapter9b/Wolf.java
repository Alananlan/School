package Chapter9b;

import java.awt.*;
/*
Alan Ly
Prof. Iverson
CS211
11 January 2021
 */
public class Wolf implements Animal {

    private int counter;

    public Wolf() {
        super();
        counter = 0;
    }

    public int getMove() {
        counter++;
        counter = counter % 40;
        if (counter < 10) {
            return SOUTH;
        } else if (counter < 20) {
            return WEST;
        } else if (counter < 30) {
            return NORTH;
        } else if (counter < 40) {
            return EAST;
        } else {
            counter = 1;
            return SOUTH;
        }
    }

    public Color getColor() {
        return Color.MAGENTA;
    }

    public String toString() {
        return "W";
    }
}
