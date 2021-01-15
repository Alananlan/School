package Chapter9b;
/*
Alan Ly
Prof. Iverson
CS211
11 January 2021
 */
import java.awt.*;

public class Rabbit implements Animal{
    public int move;

    public Rabbit() {
        super();
        move = 0;
    }

    public int getMove() {
        move = move % 6;

        if (move < 2) {
            move++;
            return NORTH;
        } else if (move < 4) {
            move++;
            return EAST;
        } else if (move < 6) {
            move++;
            return SOUTH;
        } else {
            move = 1;
            return NORTH;
        }

    }

    public Color getColor() {
        return new Color(255,0,0);
    }

    public String toString() {
        return "R";
    }

}
