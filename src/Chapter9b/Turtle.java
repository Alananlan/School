package Chapter9b;

import java.awt.*;
/*
Alan Ly
Prof. Iverson
CS211
11 January 2021
 */
public class Turtle implements Animal {
    private int counter;
    public Turtle() {
        super();
        counter = 0;
    }

    public int getMove() {
        counter++;
        counter = counter % 20;
        if (counter < 5)
            return SOUTH;
         else if (counter < 10)
            return WEST;
         else if (counter < 15)
            return NORTH;
         else if (counter < 20)
            return EAST;
         else {
            counter = 1;
            return SOUTH;
        }
    }

    public Color getColor() {
        return new Color (65, 194, 39, 255);
    }

    public String toString() {
        return "T";
    }

}
