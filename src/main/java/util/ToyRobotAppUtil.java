package util;

import model.movement.PlaySquare;
import model.movement.PlayableArea;
import model.toy.ToyRobot;

import java.util.HashSet;
import java.util.Set;

public class ToyRobotAppUtil {

    /**
     * Assembles the default 5x5 set of playable squares
     * @return default playable area with zero-indexed coordinates
     */
    public static PlayableArea getDefaultSquareArea() {
        return makeCustomRectangularArea(5,5);
    }

    /**
     *
     * @param width number of columns squares
     * @param height number of row squares
     * @return a rectangular play area sized width x height; zero-indexed coordinates
     */
    public static PlayableArea makeCustomRectangularArea(int width, int height) {
        Set<PlaySquare> squares = new HashSet<>();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                squares.add(new PlaySquare(x, y));
            }
        }
        return new PlayableArea(squares);
    }

}
