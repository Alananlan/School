package Chapter9b;
/*
Alan Ly
Prof. Iverson
CS211
11 January 2021
 */
import java.awt.*;

public class Snake implements Animal {

    private int moves;
    private int iteration;
    private int counter;

    public Snake() {
        super();
        moves = 0;
        iteration = 1;
    }
    public int getMove() {
       moves++;
       if (moves < iteration) {
           if (iteration % 2 == 0) {
               return EAST;
           } else {
               return WEST;
           }
       } else {
           iteration++;
           moves = 0;
           return SOUTH;
       }
    }
    public Color getColor() {
        return new Color( 0, 30, 0);
    }
    public String toString() {
        return "S";
    }
}
