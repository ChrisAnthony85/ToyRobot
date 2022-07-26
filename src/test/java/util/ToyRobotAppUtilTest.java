package util;

import model.movement.PlaySquare;
import model.movement.PlayableArea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyRobotAppUtilTest {

    @Test
    void getDefaultSquareArea() {
        PlayableArea playableArea = ToyRobotAppUtil.getDefaultSquareArea();
        assertEquals(25, playableArea.getSquares().size());

        assertTrue(playableArea.contains(new PlaySquare(0,0)));
        assertTrue(playableArea.contains(new PlaySquare(0,1)));
        assertTrue(playableArea.contains(new PlaySquare(0,2)));
        assertTrue(playableArea.contains(new PlaySquare(0,3)));
        assertTrue(playableArea.contains(new PlaySquare(0,4)));

        assertTrue(playableArea.contains(new PlaySquare(1,0)));
        assertTrue(playableArea.contains(new PlaySquare(1,1)));
        assertTrue(playableArea.contains(new PlaySquare(1,2)));
        assertTrue(playableArea.contains(new PlaySquare(1,3)));
        assertTrue(playableArea.contains(new PlaySquare(1,4)));

        assertTrue(playableArea.contains(new PlaySquare(2,0)));
        assertTrue(playableArea.contains(new PlaySquare(2,1)));
        assertTrue(playableArea.contains(new PlaySquare(2,2)));
        assertTrue(playableArea.contains(new PlaySquare(2,3)));
        assertTrue(playableArea.contains(new PlaySquare(2,4)));


        assertTrue(playableArea.contains(new PlaySquare(3,0)));
        assertTrue(playableArea.contains(new PlaySquare(3,1)));
        assertTrue(playableArea.contains(new PlaySquare(3,2)));
        assertTrue(playableArea.contains(new PlaySquare(3,3)));
        assertTrue(playableArea.contains(new PlaySquare(3,4)));

        assertTrue(playableArea.contains(new PlaySquare(4,0)));
        assertTrue(playableArea.contains(new PlaySquare(4,1)));
        assertTrue(playableArea.contains(new PlaySquare(4,2)));
        assertTrue(playableArea.contains(new PlaySquare(4,3)));
        assertTrue(playableArea.contains(new PlaySquare(4,4)));

        assertFalse(playableArea.contains(new PlaySquare(5, 0)));
        assertFalse(playableArea.contains(new PlaySquare(0, 5)));
    }

    @Test
    void makeCustomRectangularArea() {
        PlayableArea playableArea = ToyRobotAppUtil.makeCustomRectangularArea(3,2);

        assertEquals(6, playableArea.getSquares().size());
        assertTrue(playableArea.contains(new PlaySquare(0,0)));
        assertTrue(playableArea.contains(new PlaySquare(0,1)));
        assertTrue(playableArea.contains(new PlaySquare(1,0)));
        assertTrue(playableArea.contains(new PlaySquare(1,1)));
        assertTrue(playableArea.contains(new PlaySquare(2,0)));
        assertTrue(playableArea.contains(new PlaySquare(2,1)));
    }
}