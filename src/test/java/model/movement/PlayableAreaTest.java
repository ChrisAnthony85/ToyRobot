package model.movement;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PlayableAreaTest {

    @Test
    void contains() {
        Set<PlaySquare> playSquares = new HashSet<>();

        PlaySquare target = new PlaySquare(0,1);

        playSquares.add(new PlaySquare(0,0));
        playSquares.add(target);
        playSquares.add(new PlaySquare(1,1));
        PlayableArea area = new PlayableArea(playSquares);

        assertTrue(area.contains(target));
        assertFalse(area.contains(new PlaySquare(2,2)));
    }
}